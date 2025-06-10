package com.irontom10.freespawn.client;

import com.irontom10.freespawn.main;
import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.entity.girlfriend.GirlfriendModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = main.MOD_ID,
        bus   = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class client {
    /**
     * Called during mod‐loading on the client, after all EntityTypes are registered
     */
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers evt) {
        // bind the renderer to your entity type:
        evt.registerEntityRenderer(ModEntities.GIRLFRIEND.get(), GirlfriendModel::new);
    }

    /**
     * If you have custom blockbench model layers, register them here too:
     */
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        // evt.registerLayerDefinition(MyCustomModel.LAYER_LOCATION, MyCustomModel::createBodyLayer);
    }
}
