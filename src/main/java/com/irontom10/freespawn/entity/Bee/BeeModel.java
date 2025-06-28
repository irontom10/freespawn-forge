package com.irontom10.freespawn.entity.Bee;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BeeModel<T extends BeeEntity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("freespawn", "modelbee"), "main");
    private final ModelPart root;
    private final ModelPart Sting, Abdomnem1, Abdomnem2, Abdomnem3, Abdomnem4, Abdomnem5, MainBody, Neck, Head;
    private final ModelPart WingRight, WingLeft, RA1, LA1, LA2, RA2, RA3, LA3, LeftPom, RightPom;
    private final ModelPart LeftPincerExtra, LeftPincerMain, RightPincerMain, RightPincerExtra;

    public BeeModel(ModelPart root) {
        this.root = root;
        this.Sting = root.getChild("Sting");
        this.Abdomnem1 = root.getChild("Abdomnem1");
        this.Abdomnem2 = root.getChild("Abdomnem2");
        this.Abdomnem3 = root.getChild("Abdomnem3");
        this.Abdomnem4 = root.getChild("Abdomnem4");
        this.Abdomnem5 = root.getChild("Abdomnem5");
        this.MainBody = root.getChild("MainBody");
        this.Neck = root.getChild("Neck");
        this.Head = root.getChild("Head");
        this.WingRight = root.getChild("WingRight");
        this.WingLeft = root.getChild("WingLeft");
        this.RA1 = root.getChild("RA1");
        this.LA1 = root.getChild("LA1");
        this.LA2 = root.getChild("LA2");
        this.RA2 = root.getChild("RA2");
        this.RA3 = root.getChild("RA3");
        this.LA3 = root.getChild("LA3");
        this.LeftPom = root.getChild("LeftPom");
        this.RightPom = root.getChild("RightPom");
        this.LeftPincerExtra = root.getChild("LeftPincerExtra");
        this.LeftPincerMain = root.getChild("LeftPincerMain");
        this.RightPincerMain = root.getChild("RightPincerMain");
        this.RightPincerExtra = root.getChild("RightPincerExtra");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition Sting = root.addOrReplaceChild("Sting", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, 1.0F));

        PartDefinition Abdomnem1 = root.addOrReplaceChild("Abdomnem1", CubeListBuilder.create().texOffs(64, 12).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, 2.0F));

        PartDefinition Abdomnem2 = root.addOrReplaceChild("Abdomnem2", CubeListBuilder.create().texOffs(61, 24).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition Abdomnem3 = root.addOrReplaceChild("Abdomnem3", CubeListBuilder.create().texOffs(56, 36).mirror().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, -2.0F));

        PartDefinition Abdomnem4 = root.addOrReplaceChild("Abdomnem4", CubeListBuilder.create().texOffs(53, 51).mirror().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -6.0F, -8.0F));

        PartDefinition Abdomnem5 = root.addOrReplaceChild("Abdomnem5", CubeListBuilder.create().texOffs(49, 73).mirror().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -6.0F, -15.0F));

        PartDefinition MainBody = root.addOrReplaceChild("MainBody", CubeListBuilder.create().texOffs(48, 97).mirror().addBox(-6.0F, 0.0F, -6.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -12.0F, -24.0F));

        PartDefinition Neck = root.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(55, 123).mirror().addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -12.0F, -23.0F));

        PartDefinition Head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(51, 139).mirror().addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -13.0F, -28.0F));

        PartDefinition WingRight = root.addOrReplaceChild("WingRight", CubeListBuilder.create().texOffs(0, 91).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -14.0F, -15.0F));

        PartDefinition WingLeft = root.addOrReplaceChild("WingLeft", CubeListBuilder.create().texOffs(96, 91).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -14.0F, -15.0F));

        PartDefinition RA1 = root.addOrReplaceChild("RA1", CubeListBuilder.create().texOffs(91, 138).mirror().addBox(0.0F, -6.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -17.0F, -31.0F));

        PartDefinition LA1 = root.addOrReplaceChild("LA1", CubeListBuilder.create().texOffs(47, 152).mirror().addBox(0.0F, -6.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -17.0F, -32.0F));

        PartDefinition LA2 = root.addOrReplaceChild("LA2", CubeListBuilder.create().texOffs(47, 145).mirror().addBox(0.0F, -11.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -17.0F, -32.0F));

        PartDefinition RA2 = root.addOrReplaceChild("RA2", CubeListBuilder.create().texOffs(91, 145).mirror().addBox(0.0F, -11.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -17.0F, -31.0F));

        PartDefinition RA3 = root.addOrReplaceChild("RA3", CubeListBuilder.create().texOffs(91, 152).mirror().addBox(0.0F, -16.0F, 2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -17.0F, -31.0F));

        PartDefinition LA3 = root.addOrReplaceChild("LA3", CubeListBuilder.create().texOffs(47, 138).mirror().addBox(0.0F, -16.0F, 2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -17.0F, -32.0F));

        PartDefinition LeftPom = root.addOrReplaceChild("LeftPom", CubeListBuilder.create().texOffs(89, 134).mirror().addBox(4.0F, -16.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -17.0F, -32.0F));

        PartDefinition RightPom = root.addOrReplaceChild("RightPom", CubeListBuilder.create().texOffs(45, 134).mirror().addBox(-5.0F, -16.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -17.0F, -31.0F));

        PartDefinition LeftPincerExtra = root.addOrReplaceChild("LeftPincerExtra", CubeListBuilder.create().texOffs(71, 166).mirror().addBox(-2.0F, 0.0F, -6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -8.0F, -36.0F));

        PartDefinition LeftPincerMain = root.addOrReplaceChild("LeftPincerMain", CubeListBuilder.create().texOffs(71, 159).mirror().addBox(0.0F, 0.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -8.0F, -36.0F));

        PartDefinition RightPincerMain = root.addOrReplaceChild("RightPincerMain", CubeListBuilder.create().texOffs(55, 159).mirror().addBox(0.0F, 0.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -8.0F, -36.0F));

        PartDefinition RightPincerExtra = root.addOrReplaceChild("RightPincerExtra", CubeListBuilder.create().texOffs(63, 166).mirror().addBox(2.0F, 0.0F, -6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -8.0F, -36.0F));

        return LayerDefinition.create(mesh, 256, 256);

    }

    @Override
    public void setupAnim(BeeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float wing = Mth.cos(ageInTicks * 1.1F) * Mth.PI * 0.3F;
        this.WingLeft.zRot = -1.745F - wing;
        this.WingRight.zRot = 1.754F + wing;

        float pinch = Mth.cos(ageInTicks * 0.3F) * Mth.PI * 0.1F;
        this.LeftPincerMain.yRot = -0.274F + pinch;
        this.LeftPincerExtra.yRot = -0.274F + pinch;
        this.RightPincerMain.yRot = 0.274F - pinch;
        this.RightPincerExtra.yRot = 0.274F - pinch;

        float armX = Mth.cos(ageInTicks * 0.27f) * Mth.PI * 0.06f;
        float armZ = Mth.cos(ageInTicks * 0.37f) * Mth.PI * 0.06f;

        this.LA1.xRot = 0.261f + armX;
        this.LA2.xRot = 0.436f + armX;
        this.LA3.xRot = 0.611f + armX;
        this.LeftPom.xRot = armX;
        this.LA1.zRot = armZ;
        this.LA2.zRot = armZ;
        this.LA3.zRot = armZ;
        this.LeftPom.zRot = armZ;

        this.RA1.xRot = 0.261f + armX;
        this.RA2.xRot = 0.436f + armX;
        this.RA3.xRot = 0.611f + armX;
        this.RightPom.xRot = armX;
        this.RA1.zRot = armZ;
        this.RA2.zRot = armZ;
        this.RA3.zRot = armZ;
        this.RightPom.zRot = armZ;

        float tailMotion = entity.isAttacking() ? Mth.cos(ageInTicks * 0.11f) * Mth.PI * 0.055f : Mth.cos(ageInTicks * 0.021f) * Mth.PI * 0.023f;
        this.Abdomnem5.xRot = 1.099f + tailMotion;
        this.Abdomnem4.xRot = this.Abdomnem5.xRot + tailMotion - 0.35f;
        this.Abdomnem3.xRot = this.Abdomnem4.xRot + tailMotion - 0.35f;
        this.Abdomnem2.xRot = this.Abdomnem3.xRot + tailMotion - 0.35f;
        this.Abdomnem1.xRot = this.Abdomnem2.xRot + tailMotion - 0.35f;
        this.Sting.xRot = this.Abdomnem1.xRot + tailMotion - 0.35f;
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
