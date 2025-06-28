package com.irontom10.freespawn.entity;

import com.irontom10.freespawn.entity.AppleCow.AppleCow;
import com.irontom10.freespawn.entity.Bee.BeeEntity;
import com.irontom10.freespawn.entity.EnchantedGoldenAppleCow.EnchantedGoldenAppleCow;
import com.irontom10.freespawn.entity.GoldenAppleCow.GoldenAppleCow;
import com.irontom10.freespawn.entity.girlfriend.GirlfriendEntity;
import com.irontom10.freespawn.entity.shoe.ShoeEntity;
import com.irontom10.freespawn.main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// In your QueenEntities (or OreSpawnEntities) class:
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, main.MOD_ID);

    public static final RegistryObject<EntityType<GirlfriendEntity>> GIRLFRIEND =
            ENTITIES.register("girlfriend",
                    () -> EntityType.Builder
                            .of(GirlfriendEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 1.6f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(main.MOD_ID, "girlfriend").toString())
            );
    public static final RegistryObject<EntityType<ShoeEntity>> SHOE =
            ENTITIES.register("shoe",
                    () -> EntityType.Builder
                            .<ShoeEntity>of(ShoeEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(main.MOD_ID, "shoe").toString())
            );
    public static final RegistryObject<EntityType<AppleCow>> APPLE_COW =
            ENTITIES.register("apple_cow",
                    () -> EntityType.Builder
                            .of(AppleCow::new, MobCategory.CREATURE)
                            .sized(0.9f, 1.4f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(main.MOD_ID, "apple_cow").toString())
            );
    public static final RegistryObject<EntityType<GoldenAppleCow>> GOLDEN_APPLE_COW =
            ENTITIES.register("golden_apple_cow",
                    () -> EntityType.Builder
                            .of(GoldenAppleCow::new, MobCategory.CREATURE)
                            .sized(0.9f, 1.4f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(main.MOD_ID, "golden_apple_cow").toString())
            );
    public static final RegistryObject<EntityType<EnchantedGoldenAppleCow>> ENCHANTED_GOLDEN_APPLE_COW =
            ENTITIES.register("enchanted_golden_apple_cow",
                    () -> EntityType.Builder
                            .of(EnchantedGoldenAppleCow::new, MobCategory.CREATURE)
                            .sized(0.9f, 1.4f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(main.MOD_ID, "enchanted_golden_apple_cow").toString())
            );
    public static final RegistryObject<EntityType<BeeEntity>> BEE =
            ENTITIES.register("bee",
                    () -> EntityType.Builder
                            .of(BeeEntity::new, MobCategory.MONSTER)
                            .sized(0.9f, 1.4f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(main.MOD_ID, "bee").toString())
            );
    public static final RegistryObject<EntityType<com.irontom10.freespawn.item.tool.Bertha.BerthaProjectileEntity>> BERTHA_PROJECTILE =
            ENTITIES.register("bertha_projectile",
                    () -> EntityType.Builder
                            .<com.irontom10.freespawn.item.tool.Bertha.BerthaProjectileEntity>of(
                                    (type, world) -> new com.irontom10.freespawn.item.tool.Bertha.BerthaProjectileEntity(type, world),
                                    MobCategory.MISC)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(4)
                            .updateInterval(1)
                            .build(new ResourceLocation(main.MOD_ID, "bertha_projectile").toString())
            );


    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
