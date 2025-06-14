package com.irontom10.freespawn.entity;

import com.irontom10.freespawn.entity.girlfriend.GirlfriendEntity;
import com.irontom10.freespawn.main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
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


    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
