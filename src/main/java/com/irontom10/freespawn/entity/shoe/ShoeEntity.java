package com.irontom10.freespawn.entity.shoe;


import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class ShoeEntity extends ThrowableItemProjectile {
    public ShoeEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ShoeEntity( Level pLevel) {
        super(ModEntities.SHOE.get(), pLevel);
    }

    public ShoeEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SHOE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.RED_HEELS.get();
    }
    @Override
    public void tick() {
        super.tick();
        this.setYRot(this.getYRot() + 6.0F);
    }
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(!this.level().isClientSide()){
            if (pResult.getEntity() instanceof LivingEntity target) {
                target.hurt(damageSources().thrown(this, this.getOwner()), 4.0F);
            }
            if (getOwner() instanceof LivingEntity livingEntity) {
                this.remove(RemovalReason.DISCARDED);

            }
        }
    }
}
