// com.irontom10.freespawn.client.render.BerthaItemRenderer.java
package com.irontom10.freespawn.item.tool.Bertha;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class BerthaRenderer extends BlockEntityWithoutLevelRenderer {

    public BerthaRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack poseStack,
                             MultiBufferSource buffer, int light, int overlay) {
        poseStack.pushPose();
        poseStack.scale(8.0F, 8.0F, 8.0F); // scale to 5x size
        Minecraft.getInstance().getItemRenderer().renderStatic(
                stack, context, light, overlay, poseStack, buffer, null, 0);
        poseStack.popPose();
    }
}
