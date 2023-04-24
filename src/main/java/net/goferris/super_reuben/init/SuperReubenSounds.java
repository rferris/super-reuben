
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.goferris.super_reuben.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class SuperReubenSounds {
	public static SoundEvent SHORT_FANFARE = new SoundEvent(new ResourceLocation("super_reuben", "short_fanfare"));

	public static void load() {
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation("super_reuben", "short_fanfare"), SHORT_FANFARE);
	}
}
