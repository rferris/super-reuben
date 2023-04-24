package net.goferris.super_reuben.procedures;

import net.goferris.super_reuben.init.SuperReubenProcedures;
import net.minecraft.world.entity.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;

import net.goferris.super_reuben.entity.SuperReubenEntity;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

import java.util.Map;
import java.util.HashMap;

public class NeedReubenProcedure {
	public NeedReubenProcedure() {
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, damageSource, amount) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("entity", entity);
			dependencies.put("x", entity.getX());
			dependencies.put("y", entity.getY());
			dependencies.put("z", entity.getZ());
			dependencies.put("world", entity.level);
			dependencies.put("sourceentity", damageSource.getEntity());
			dependencies.put("immediatesourceentity", damageSource.getDirectEntity());
			dependencies.put("amount", amount);
			execute(dependencies);
			return true;
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency world for procedure NeedReuben!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency x for procedure NeedReuben!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency y for procedure NeedReuben!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency z for procedure NeedReuben!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency entity for procedure NeedReuben!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency sourceentity for procedure NeedReuben!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (entity instanceof Player _player) {
			double maxHealth = (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.6;
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= maxHealth) {
				if (!(!world.getEntitiesOfClass(SuperReubenEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).isEmpty())) {
					if (world instanceof ServerLevel _level) {
						net.goferris.super_reuben.SuperReuben.LOGGER.info("Need Reuben!");
						Entity entityToSpawn = new SuperReubenEntity(net.goferris.super_reuben.init.SuperReubenEntities.SUPER_REUBEN, _level);
						entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof SuperReubenEntity _mobToSpawn) {
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							_mobToSpawn.tame(_player);
						}

						world.addFreshEntity(entityToSpawn);

						SuperReubenTameProcedure.run(entityToSpawn, entity);
					}
				}
			}
		}
	}
}
