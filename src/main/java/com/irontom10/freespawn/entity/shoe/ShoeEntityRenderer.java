package com.irontom10.freespawn.entity.shoe;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ShoeEntityRenderer extends ThrownItemRenderer<ShoeEntity> {
    public ShoeEntityRenderer(EntityRendererProvider.Context context) {
        super(context, 1.0f, false);
    }

    @Override
    public void render(ShoeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        // Apply Y rotation from entity
        poseStack.pushPose();
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(entity.getYRot()));
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
}
