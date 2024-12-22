package com.aetherteam.aetherii.client.renderer.entity.model;

import com.aetherteam.aetherii.client.renderer.entity.state.WingEntityRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class QuadrupedWingsModel<T extends WingEntityRenderState> extends EntityModel<T> {
    public final ModelPart leftWingInner;
    public final ModelPart leftWingOuter;
    public final ModelPart rightWingInner;
    public final ModelPart rightWingOuter;

    public QuadrupedWingsModel(ModelPart root) {
        super(root);
        this.leftWingInner = root.getChild("left_wing_inner");
        this.leftWingOuter = this.leftWingInner.getChild("left_wing_outer");
        this.rightWingInner = root.getChild("right_wing_inner");
        this.rightWingOuter = this.rightWingInner.getChild("right_wing_outer");
    }

    public static LayerDefinition createMainLayer(float offset) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition leftWingInnerDef = partDefinition.addOrReplaceChild("left_wing_inner", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -16.0F, 0.0F, 2.0F, 16.0F, 8.0F), PartPose.offset(-4.0F, 2.0F + offset, -4.0F));
        leftWingInnerDef.addOrReplaceChild("left_wing_outer", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-1.0F, -16.0F, 0.0005F, 2.0F, 16.0F, 7.999F), PartPose.offset(0.0F, -16.0F, 0.0F));
        PartDefinition rightWingInnerDef = partDefinition.addOrReplaceChild("right_wing_inner", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -16.0F, 0.0F, 2.0F, 16.0F, 8.0F), PartPose.offset(4.0F, 2.0F + offset, -4.0F));
        rightWingInnerDef.addOrReplaceChild("right_wing_outer", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -16.0F, 0.0005F, 2.0F, 16.0F, 7.999F), PartPose.offset(0.0F, -16.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity) {
        super.setupAnim(entity);
        float wingBend = -((float) Math.acos(entity.wingHold));
        this.leftWingInner.zRot = -(entity.wingAngle + wingBend + Mth.HALF_PI);
        this.leftWingOuter.zRot = -(entity.wingAngle - wingBend + Mth.HALF_PI) - this.leftWingInner.zRot;
        this.rightWingInner.zRot = -this.leftWingInner.zRot;
        this.rightWingOuter.zRot = -this.leftWingOuter.zRot;
    }
}
