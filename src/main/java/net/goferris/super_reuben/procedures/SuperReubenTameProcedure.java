package net.goferris.super_reuben.procedures;

import net.goferris.super_reuben.SuperReuben;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.goferris.super_reuben.entity.SuperReubenEntity;

import java.util.Map;
import java.util.Comparator;

public class SuperReubenTameProcedure {

	public static void run(Entity animal, Entity player) {
		if (animal instanceof TamableAnimal _tamable && player instanceof Player _player)
			_tamable.tame(_player);
	}
	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SuperReuben.LOGGER.warn("Failed to load dependency world for procedure SuperReubenTame!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SuperReuben.LOGGER.warn("Failed to load dependency x for procedure SuperReubenTame!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SuperReuben.LOGGER.warn("Failed to load dependency y for procedure SuperReubenTame!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SuperReuben.LOGGER.warn("Failed to load dependency z for procedure SuperReubenTame!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SuperReuben.LOGGER.warn("Failed to load dependency sourceentity for procedure SuperReubenTame!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((Entity) world.getEntitiesOfClass(SuperReubenEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
			_toTame.tame(_owner);
	}
}
