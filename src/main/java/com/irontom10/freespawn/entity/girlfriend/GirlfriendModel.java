package com.irontom10.freespawn.entity.girlfriend;

// package com.irontom10.freespawn.client.renderer;
import com.irontom10.freespawn.main;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GirlfriendModel
        extends MobRenderer<GirlfriendEntity, HumanoidModel<GirlfriendEntity>>
{
    public GirlfriendModel(EntityRendererProvider.Context ctx) {
        super(ctx,
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER)),
                0.5f
        );

        // 1) Armor layer: draws helmet/chestplate/leggings/boots from the armor slots
        this.addLayer(new HumanoidArmorLayer<>(
                this,
                // inner armor (leggings layer)
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                // outer armor (chestplate + boots)
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
                ctx.getModelManager()
        ));

        // 2) Held‐item layer: draws whatever is in MAINHAND or OFFHAND
        this.addLayer(new ItemInHandLayer<>(this, ctx.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(GirlfriendEntity entity) {
        String prefix   = entity.isInWater() ? "bikini"    : "girlfriend";
        int    maxIndex = entity.isInWater() ? 17          : 40;
        int    idx      = Mth.clamp(
                entity.isInWater()
                        ? entity.getWhichWetGirl()
                        : entity.getWhichGirl(),
                0, maxIndex
        );
        // matches src/main/resources/assets/freespawn/textures/entity/girlfriend/
        String path = String.format("textures/entity/girlfriend/%s%d.png", prefix, idx);
        return new ResourceLocation(main.MOD_ID, path);
    }

    @Override
    protected void scale(GirlfriendEntity entity, PoseStack stack, float partialTick) {
        super.scale(entity, stack, partialTick);
        // mirror your old preRenderCallback scaling

    }
}
