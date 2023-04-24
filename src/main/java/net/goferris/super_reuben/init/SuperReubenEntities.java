
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.goferris.super_reuben.init;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.goferris.super_reuben.entity.SuperReubenEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class SuperReubenEntities {
	public static EntityType<SuperReubenEntity> SUPER_REUBEN;

	public static void load() {
		SUPER_REUBEN = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(net.goferris.super_reuben.SuperReuben.MODID, "super_reuben"),
				FabricEntityTypeBuilder.create(MobCategory.CREATURE, SuperReubenEntity::new).dimensions(new EntityDimensions(0.6f, 1.8f, true)).trackRangeBlocks(64).forceTrackedVelocityUpdates(true).trackedUpdateRate(3).build());
		SuperReubenEntity.init();
		FabricDefaultAttributeRegistry.register(SUPER_REUBEN, SuperReubenEntity.createAttributes());
	}

	private static <T extends Entity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
		return FabricEntityTypeBuilder.create(MobCategory.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(1).trackedUpdateRate(64).build();
	}
}
