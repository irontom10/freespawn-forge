package com.irontom10.freespawn.entity.GoldenAppleCow;

import com.irontom10.freespawn.main;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

public class GoldenAppleCowRenderer extends CowRenderer {
    private static final ResourceLocation APPLE_COW_TEXTURE =
            new ResourceLocation(main.MOD_ID, "textures/entity/golden_apple_cow.png");

    public GoldenAppleCowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Cow entity) {
        return APPLE_COW_TEXTURE;
    }
}
