package net.goferris.super_reuben.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.goferris.super_reuben.entity.model.SuperReubenModel;
import net.goferris.super_reuben.entity.SuperReubenEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SuperReubenRenderer extends GeoEntityRenderer<SuperReubenEntity> {
	public SuperReubenRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SuperReubenModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(SuperReubenEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(SuperReubenEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
