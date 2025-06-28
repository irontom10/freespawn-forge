package com.irontom10.freespawn.entity.EnchantedGoldenAppleCow;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EnchantedGoldenAppleCow extends Cow {

    public EnchantedGoldenAppleCow(EntityType<? extends Cow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitByPlayer) {
        // ----- LEATHER drop -----
        int leatherCount = this.random.nextInt(3) + this.random.nextInt(1 + looting); // 0–2 + 0–looting
        for (int i = 0; i < leatherCount; ++i) {
            this.spawnAtLocation(Items.LEATHER);
        }

        // ----- BEEF drop -----
        int beefCount = this.random.nextInt(1) + 1 + this.random.nextInt(3 + looting); // 1–3 + 0–looting
        for (int i = 0; i < beefCount; ++i) {
            if (this.isOnFire()) {
                this.spawnAtLocation(Items.COOKED_BEEF);
            } else {
                this.spawnAtLocation(Items.BEEF);
            }
        }

        // ----- APPLE drop -----
        int base = 2;
        int extra = this.random.nextInt(2 + looting); // range: 0 to (1 + looting)
        int total = base + extra;
        this.spawnAtLocation(new ItemStack(Items.APPLE, total));
    }


}
