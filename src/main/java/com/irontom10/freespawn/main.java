package com.irontom10.freespawn;



import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.entity.girlfriend.GirlfriendEntity;
import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.item.ModCreativeTabs;
import com.irontom10.freespawn.sound.ModSounds;
import com.irontom10.freespawn.util.ModAutoEnchants;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(main.MOD_ID)
public class main {
    public static final String MOD_ID = "freespawn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public main(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        ModEntities.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::onEntityAttributeCreation);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);


    }
    private void onEntityAttributeCreation(EntityAttributeCreationEvent event){
        event.put(
                ModEntities.GIRLFRIEND.get(),
                GirlfriendEntity.createAttributes().build()
        );
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.SHARPNESS, 5);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.SMITE, 5);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.BANE_OF_ARTHROPODS, 5);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.KNOCKBACK, 3);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.FIRE_ASPECT, 2);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.MOB_LOOTING, 3);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SWORD.get(), Enchantments.UNBREAKING, 3);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_PICKAXE.get(), Enchantments.BLOCK_EFFICIENCY, 5);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_PICKAXE.get(), Enchantments.BLOCK_FORTUNE, 5);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_SHOVEL.get(), Enchantments.BLOCK_EFFICIENCY, 5);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_HOE.get(), Enchantments.BLOCK_EFFICIENCY, 2);
            ModAutoEnchants.enchant(ModItems.ULTIMATE_AXE.get(), Enchantments.BLOCK_EFFICIENCY, 5);
            ModAutoEnchants.enchant(ModItems.EMERALD_PICKAXE.get(), Enchantments.SILK_TOUCH, 1);
        });
    }



    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {


        }
    }
}
//