package com.natamus.erodingstoneentities;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.erodingstoneentities.events.ErodingEvent;
import com.natamus.erodingstoneentities.util.Reference;
import com.natamus.erodingstoneentities.util.Util;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		if (Util.populateArrays()) {
			ServerTickEvents.START_WORLD_TICK.register((ServerLevel world) -> {
				ErodingEvent.onWorldTick(world);
			});

			ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerLevel world) -> {
				ErodingEvent.onEntityJoin(world, entity);
			});
		}
	}

	private static void setGlobalConstants() {

	}
}
