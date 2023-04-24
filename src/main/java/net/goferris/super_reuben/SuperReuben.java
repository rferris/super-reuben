/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */

package net.goferris.super_reuben;

import software.bernie.geckolib3.GeckoLib;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.goferris.super_reuben.init.SuperReubenSounds;
import net.goferris.super_reuben.init.SuperReubenProcedures;
import net.goferris.super_reuben.init.SuperReubenItems;

import net.fabricmc.api.ModInitializer;

public class SuperReuben implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "super_reuben";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing super_reuben");

		net.goferris.super_reuben.init.SuperReubenEntities.load();

		SuperReubenItems.load();

		SuperReubenProcedures.load();

		SuperReubenSounds.load();

		GeckoLib.initialize();
	}
}
