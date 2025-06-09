package com.irontom10.freespawn.block;

import com.irontom10.freespawn.main;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, main.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );

    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> CRYSTAL_STONE = BLOCKS.register("crystal_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 2.0f)
                    .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> EXTREME_TORCH = BLOCKS.register("extreme_torch",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel(state -> 15)
                    .sound(SoundType.WOOD))
    );

    public static final RegistryObject<Block> CRYSTAL_TORCH = BLOCKS.register("crystal_torch",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel(state -> 15)
                    .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> APPLE_LEAVES = BLOCKS.register("apple_leaves",
            () -> new com.irontom10.block.custom.AppleLeavesBlock()
    );

    public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of()
                    .strength(0.2F)
                    .sound(SoundType.GRASS)
                    .lightLevel(state -> 0)
                    .noOcclusion()
                    .isValidSpawn((state, world, pos, type) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isViewBlocking((state, world, pos) -> false)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .dynamicShape()
                    .friction(0.8F))
    );

    public static final RegistryObject<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of()
                    .strength(0.2F)
                    .sound(SoundType.GRASS)
                    .lightLevel(state -> 0)
                    .noOcclusion()
                    .isValidSpawn((state, world, pos, type) -> false)
                    .isSuffocating((state, world, pos) -> false)
                    .isViewBlocking((state, world, pos) -> false)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .dynamicShape()
                    .friction(0.8F))
    );

    /** Call this from your main mod constructor: */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
