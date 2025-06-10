package com.irontom10.freespawn.block;

import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, main.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE))
    );
    public static final RegistryObject<Block> AMETHYST_BLOCK = registerBlock("amethyst_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );
    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE))
    );
    public static final RegistryObject<Block> URANIUM_ORE = registerBlock("uranium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE))
    );
    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE))
    );
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );

    public static final RegistryObject<Block> CRYSTAL_STONE = registerBlock("crystal_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 2.0f)
                    .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> EXTREME_TORCH = registerBlock("extreme_torch",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel(state -> 15)
                    .sound(SoundType.WOOD))
    );

    public static final RegistryObject<Block> CRYSTAL_TORCH = registerBlock("crystal_torch",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel(state -> 15)
                    .sound(SoundType.STONE))
    );
    public static final RegistryObject<Block> ENDER_PEARL_BLOCK = registerBlock("ender_pearl_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );
    public static final RegistryObject<Block> ENDER_EYE_BLOCK = registerBlock("ender_eye_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );
    public static final RegistryObject<Block> MOBZILLA_SCALE_BLOCK = registerBlock("mobzilla_scale_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );
    public static final RegistryObject<Block> PINK_TOURMALINE_BLOCK = registerBlock("pink_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );
    public static final RegistryObject<Block> TIGERSEYE_BLOCK = registerBlock("tigerseye_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .sound(SoundType.METAL))
    );


    public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new com.irontom10.block.custom.AppleLeavesBlock()
    );

    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of()
                    .noLootTable()
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

    public static final RegistryObject<Block> PEACH_LEAVES = registerBlock("peach_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of()
                    .noLootTable()
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


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
