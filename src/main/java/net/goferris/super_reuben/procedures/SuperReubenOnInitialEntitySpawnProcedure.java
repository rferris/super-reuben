package net.goferris.super_reuben.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.goferris.super_reuben.init.SuperReubenSounds;

import java.util.Map;

public class SuperReubenOnInitialEntitySpawnProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency world for procedure SuperReubenOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency x for procedure SuperReubenOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency y for procedure SuperReubenOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				net.goferris.super_reuben.SuperReuben.LOGGER.warn("Failed to load dependency z for procedure SuperReubenOnInitialEntitySpawn!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 5, 3, 3, 3, 1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), SuperReubenSounds.SHORT_FANFARE, SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, SuperReubenSounds.SHORT_FANFARE, SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
