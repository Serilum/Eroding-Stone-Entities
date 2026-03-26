package com.natamus.erodingstoneentities.forge.events;

import com.natamus.erodingstoneentities.events.ErodingEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeErodingEvent {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeErodingEvent.class);
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post e) {
		Level level = e.level();
		if (level.isClientSide()) {
			return;
		}

		ErodingEvent.onWorldTick((ServerLevel)level);
	}
	
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		ErodingEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
}
