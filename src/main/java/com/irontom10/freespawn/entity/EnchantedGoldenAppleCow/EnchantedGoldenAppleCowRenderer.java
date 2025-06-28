package com.irontom10.freespawn.entity.EnchantedGoldenAppleCow;

import com.irontom10.freespawn.main;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.Nonnull;

public class EnchantedGoldenAppleCowRenderer extends CowRenderer {
    private static final ResourceLocation APPLE_COW_TEXTURE =
            new ResourceLocation(main.MOD_ID, "textures/entity/golden_apple_cow.png");

    public EnchantedGoldenAppleCowRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.addLayer(new EnchantmentGlintLayer(this));
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull Cow entity) {
        return APPLE_COW_TEXTURE;
    }

    // Glint layer for enchanted effect
    private static class EnchantmentGlintLayer extends RenderLayer<Cow, CowModel<Cow>> {
        public EnchantmentGlintLayer(RenderLayerParent<Cow, CowModel<Cow>> parent) {
            super(parent);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight,
                           Cow entity, float limbSwing, float limbSwingAmount, float partialTick,
                           float ageInTicks, float netHeadYaw, float headPitch) {
            RenderType glintType = RenderType.entityGlint(); // Use the default glint, not a custom texture
            this.getParentModel().renderToBuffer(
                poseStack,
                bufferSource.getBuffer(glintType),
                packedLight,
                OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F
            );
        }
    }

}
