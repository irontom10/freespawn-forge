package com.irontom10.freespawn.entity.GoldenAppleCow;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GoldenAppleCow extends Cow {

    public GoldenAppleCow(EntityType<? extends Cow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);

        if (this.level().isClientSide) return;

        // Define drops: item, base count, random count logic, cooked (conditional), fire-sensitive
        Object[][] drops = {
                {Items.LEATHER, this.random.nextInt(3) + this.random.nextInt(1 + looting)},
                {this.isOnFire() ? Items.COOKED_BEEF : Items.BEEF, 1 + this.random.nextInt(3 + looting)},
                {Items.APPLE, 2 + this.random.nextInt(2 + looting)},
                {Items.GOLDEN_APPLE, 1 + this.random.nextInt(2 + looting)}
        };

        for (Object[] drop : drops) {
            Item item = (Item) drop[0];
            int count = (int) drop[1];

            if (count > 0) {
                this.spawnAtLocation(new ItemStack(item, count));
            }
        }
    }
}
