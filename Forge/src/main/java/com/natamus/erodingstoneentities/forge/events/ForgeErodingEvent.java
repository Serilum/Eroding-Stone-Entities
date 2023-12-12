package com.natamus.erodingstoneentities.forge.events;

import com.natamus.erodingstoneentities.events.ErodingEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeErodingEvent {
	@SubscribeEvent
	public void onWorldTick(WorldTickEvent e) {
		Level level = e.world;
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}

		ErodingEvent.onWorldTick((ServerLevel)level);
	}
	
	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent e) {
		ErodingEvent.onEntityJoin(e.getWorld(), e.getEntity());
	}
}
