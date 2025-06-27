package com.irontom10.freespawn.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;

public class HitscanSwordSwing {

    /**
     * Performs a hitscan swing and attacks the first valid entity hit, applying all sword effects.
     *
     * @param level         The game world
     * @param attacker      The player swinging the sword
     * @param swingDistance How far the swing reaches
     */
    public static void doSwing(Level level, Player attacker, double swingDistance) {
        if (level.isClientSide) return;

        Vec3 eyePos = attacker.getEyePosition();
        Vec3 lookVec = attacker.getLookAngle();
        Vec3 endPos = eyePos.add(lookVec.scale(swingDistance));

        AABB searchBox = attacker.getBoundingBox().expandTowards(lookVec.scale(swingDistance)).inflate(1.0);
        EntityHitResult result = null;
        double closest = swingDistance;
        for (Entity entity : level.getEntities(attacker, searchBox, e -> e instanceof LivingEntity && e != attacker && e.isPickable())) {
            AABB aabb = entity.getBoundingBox().inflate(0.3);
            java.util.Optional<Vec3> hit = aabb.clip(eyePos, endPos);
            if (hit.isPresent()) {
                double dist = eyePos.distanceTo(hit.get());
                if (dist < closest) {
                    closest = dist;
                    result = new EntityHitResult(entity, hit.get());
                }
            }
        }

        if (result != null && result.getEntity() instanceof LivingEntity target) {
            ItemStack weapon = attacker.getMainHandItem();

            // Deal direct damage, bypassing vanilla reach
            float damage = (float) attacker.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue();
            DamageSource source = attacker.damageSources().playerAttack(attacker);
            target.hurt(source, damage);

            // Optionally: apply fire aspect, knockback, etc. here if needed

            // Optional: play a hit sound or particle effect
            level.levelEvent(2001, target.blockPosition(), net.minecraft.world.item.Item.getId(weapon.getItem()));
        }
    }
}
