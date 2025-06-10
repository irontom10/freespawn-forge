package com.irontom10.freespawn;



import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.entity.girlfriend.GirlfriendEntity;
import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.item.ModCreativeTabs;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEntities.register(FMLJavaModLoadingContext.get().getModEventBus());

        modEventBus.addListener(this::onEntityAttributeCreation);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }
    private void onEntityAttributeCreation(EntityAttributeCreationEvent event){
        event.put(
                ModEntities.GIRLFRIEND.get(),
                GirlfriendEntity.createAttributes().build()
        );
    }
    private void commonSetup(final FMLClientSetupEvent event)
    {


    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

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
