
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.goferris.super_reuben.init;

import net.goferris.super_reuben.procedures.SuperReubenTameProcedure;
import net.goferris.super_reuben.procedures.SuperReubenOnInitialEntitySpawnProcedure;
import net.goferris.super_reuben.procedures.NeedReubenProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SuperReubenProcedures {
	public static void load() {
		new NeedReubenProcedure();
		new SuperReubenOnInitialEntitySpawnProcedure();
		new SuperReubenTameProcedure();
	}
}
