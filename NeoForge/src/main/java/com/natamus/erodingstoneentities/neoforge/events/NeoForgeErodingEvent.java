package com.natamus.erodingstoneentities.neoforge.events;

import com.natamus.erodingstoneentities.events.ErodingEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.TickEvent.LevelTickEvent;
import net.neoforged.neoforge.event.TickEvent.Phase;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeErodingEvent {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent e) {
		Level level = e.level;
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}

		ErodingEvent.onWorldTick((ServerLevel)level);
	}
	
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		ErodingEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
}
