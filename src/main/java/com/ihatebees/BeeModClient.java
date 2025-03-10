package com.ihatebees;

import com.ihatebees.entity.ModEntities;
import com.ihatebees.item.ModItems;
import com.ihatebees.particle.ModParticles;
import com.ihatebees.particle.custom.StarParticle;
import com.ihatebees.particle.custom.StarSweepParticle;
import com.ihatebees.particle.custom.TriangleParticle;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.util.math.RotationAxis;

public class BeeModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering

		ParticleFactoryRegistry.getInstance().register(ModParticles.STARSWEEP_PARTICLE, StarSweepParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.TRIANGLE_PARTICLE, TriangleParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.STAR_PARTICLE, StarParticle.Factory::new);
		EntityRendererRegistry.register(ModEntities.COMBO_COCONUT, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.GUMMY_BALL, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHOWER_STAR, FlyingItemEntityRenderer::new);
		// trinkets
		TrinketRendererRegistry.registerRenderer(ModItems.CoconutBelt,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					net.minecraft.world.World world = MinecraftClient.getInstance().world;
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToChest(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);

						// tweak position rotation, remove item frame scaling
						matrices.translate(0, .25, .1);
						matrices.scale(1.3F, 1.3F, 1.3F);

						// rotate 180 horizontally around the character and 180 vertically around
						matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
						matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));

						MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 0);



					}
				}
		);
		TrinketRendererRegistry.registerRenderer(ModItems.HoneyBelt,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					net.minecraft.world.World world = MinecraftClient.getInstance().world;
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToChest(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);

						// tweak position rotation, remove item frame scaling
						matrices.translate(0, .25, .1);
						matrices.scale(1.3F, 1.3F, 1.3F);

						// rotate 180 horizontally around the character and 180 vertically around
						matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
						matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));

						MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 0);



					}
				}
		);
	}

}