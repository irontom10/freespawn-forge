package com.irontom10.freespawn.entity.Bee;

import com.mojang.blaze3d.vertex.PoseStack;
import com.irontom10.freespawn.entity.Bee.BeeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

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
