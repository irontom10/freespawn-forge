package com.irontom10.freespawn.entity.AppleCow;

import com.irontom10.freespawn.main;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

public class AppleCowRenderer extends CowRenderer {
    private static final ResourceLocation APPLE_COW_TEXTURE =
            new ResourceLocation(main.MOD_ID, "textures/entity/apple_cow.png");

    public AppleCowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Cow entity) {
        return APPLE_COW_TEXTURE;
    }
}
