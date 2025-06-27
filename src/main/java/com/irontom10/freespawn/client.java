package com.irontom10.freespawn;

import com.irontom10.freespawn.entity.Bee.BeeModel;
import com.irontom10.freespawn.entity.Bee.BeeRenderer;
import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.entity.girlfriend.GirlfriendModel;
import com.irontom10.freespawn.entity.shoe.ShoeEntityRenderer;
import com.irontom10.freespawn.entity.AppleCow.AppleCowRenderer;
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
        evt.registerEntityRenderer(ModEntities.SHOE.get(), ShoeEntityRenderer::new);
        evt.registerEntityRenderer(ModEntities.APPLE_COW.get(), AppleCowRenderer::new);
        evt.registerEntityRenderer(ModEntities.BEE.get(), BeeRenderer::new);

    }

    /**
     * If you have custom blockbench model layers, register them here too:
     */
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(BeeModel.LAYER_LOCATION, BeeModel::createBodyLayer);
    }
}
