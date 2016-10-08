package com.gildedgames.aether.client.models.entities.attachments;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBombRightHand extends ModelBase
{
	//fields
	ModelRenderer bomb_hand_right_main;
	ModelRenderer bomb_hand_right_sub;

	public ModelBombRightHand()
	{
		textureWidth = 128;
		textureHeight = 64;

		bomb_hand_right_main = new ModelRenderer(this, 0, 0);
		bomb_hand_right_main.addBox(-17.5F, 8F, -23F, 7, 5, 5);
		bomb_hand_right_main.setRotationPoint(-14F, -10F, 2F);
		bomb_hand_right_main.setTextureSize(64, 32);
		bomb_hand_right_main.mirror = true;
		setRotation(bomb_hand_right_main, 0F, 0.1745329F, 0F);
		bomb_hand_right_sub = new ModelRenderer(this, 0, 0);
		bomb_hand_right_sub.addBox(-19.5F, 8.5F, -22.5F, 11, 4, 4);
		bomb_hand_right_sub.setRotationPoint(-14F, -10F, 2F);
		bomb_hand_right_sub.setTextureSize(64, 32);
		bomb_hand_right_sub.mirror = true;
		setRotation(bomb_hand_right_sub, 0F, 0.1745329F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bomb_hand_right_main.render(f5);
		bomb_hand_right_sub.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}

