package com.irontom10.freespawn.entity.EnchantedGoldenAppleCow;

import com.irontom10.freespawn.main;
import com.mojang.blaze3d.vertex.PoseStack;
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
            // Use a more intense glint: direct, max light, high color/alpha
            RenderType glintType = RenderType.entityGlint();
            int fullBright = 0xF000F0; // Maximum light for full brightness (day or night)
            this.getParentModel().renderToBuffer(
                poseStack,
                bufferSource.getBuffer(glintType),
                fullBright,
                OverlayTexture.NO_OVERLAY,
                1.0F, 2.0F, 2.0F, 0.85F
            );
        }
    }

}
