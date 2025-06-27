package com.irontom10.freespawn.item.tool.Bertha;

import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.item.tool.Bertha.BerthaProjectileEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;

public class Bertha extends SwordItem {

    public Bertha() {
        super(
                Tiers.NETHERITE, // Or a custom Tier if you have one
                3,              // Base damage bonus
                -2.4F,           // Attack speed (vanilla sword default)
                new Properties().fireResistant().durability(9000)
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            // Spawn invisible projectile
            EntityType<BerthaProjectileEntity> type = (EntityType<BerthaProjectileEntity>) ModEntities.BERTHA_PROJECTILE.get();
            BerthaProjectileEntity proj = new BerthaProjectileEntity(type, level, player, (float)player.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
            Vec3 look = player.getLookAngle();
            proj.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            proj.setDeltaMovement(look.scale(2.5)); // speed
            level.addFreshEntity(proj);
            player.getCooldowns().addCooldown(this, 10);
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(e.getUsedItemHand()));
        return true;
    }
}
