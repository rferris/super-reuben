
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.goferris.super_reuben.init;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class SuperReubenItems {
	public static Item SUPER_REUBEN_SPAWN_EGG;

	public static void load() {
		SUPER_REUBEN_SPAWN_EGG = Registry.register(Registry.ITEM, new ResourceLocation(net.goferris.super_reuben.SuperReuben.MODID, "super_reuben_spawn_egg"),
				new SpawnEggItem(SuperReubenEntities.SUPER_REUBEN, -26215, -13421569, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	}
}
