package com.irontom10.freespawn.item.tool.Bertha;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.damagesource.DamageSource;

public class BerthaProjectileEntity extends Projectile {
    private final float damage;
    private final LivingEntity owner;

    public BerthaProjectileEntity(EntityType<? extends Projectile> type, Level level) {
        super(type, level);
        this.damage = 10.0F; // default, can be set
        this.owner = null;
    }

    public BerthaProjectileEntity(EntityType<? extends Projectile> type, Level level, LivingEntity owner, float damage) {
        super(type, level);
        this.owner = owner;
        this.damage = damage;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (!level().isClientSide && result.getEntity() instanceof LivingEntity target) {
            DamageSource source = (owner instanceof net.minecraft.world.entity.player.Player player)
                ? player.damageSources().playerAttack(player)
                : owner != null ? owner.damageSources().mobAttack(owner) : damageSources().magic();
            target.hurt(source, damage);
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if (!level().isClientSide) {
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData() {}
}
