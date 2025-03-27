package com.natamus.erodingstoneentities.forge.events;

import com.natamus.erodingstoneentities.events.ErodingEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeErodingEvent {
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
