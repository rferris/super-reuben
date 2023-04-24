
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.goferris.super_reuben.init;

import net.goferris.super_reuben.client.renderer.SuperReubenRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class SuperReubenEntityRenderers {
	public static void load() {
		EntityRendererRegistry.register(SuperReubenEntities.SUPER_REUBEN, SuperReubenRenderer::new);
	}
}
