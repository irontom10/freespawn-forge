package com.irontom10.freespawn.entity.Bee;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BeeRenderer extends MobRenderer<BeeEntity, BeeModel<BeeEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("freespawn", "textures/entity/bee.png");

    public BeeRenderer(EntityRendererProvider.Context context) {
        super(context, new BeeModel<>(context.bakeLayer(BeeModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(BeeEntity entity) {
        return TEXTURE;
    }
}
