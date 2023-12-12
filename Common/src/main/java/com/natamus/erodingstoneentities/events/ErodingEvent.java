package com.natamus.erodingstoneentities.events;

import com.natamus.erodingstoneentities.config.ConfigHandler;
import com.natamus.erodingstoneentities.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ErodingEvent {
	private static final HashMap<Level, Integer> worldtickcount = new HashMap<Level, Integer>();
	private static final HashMap<Level, CopyOnWriteArrayList<ItemEntity>> perworldentities = new HashMap<Level, CopyOnWriteArrayList<ItemEntity>>();
	private static final HashMap<ItemEntity, Integer> iecount = new HashMap<ItemEntity, Integer>();
	
	public static void onWorldTick(ServerLevel world) {
		if (!worldtickcount.containsKey(world)) {
			worldtickcount.put(world, 1);
			return;
		}
		
		int currenttick = worldtickcount.get(world);
		if (currenttick % 20 != 0) {
			worldtickcount.put(world, currenttick+1);
			return;
		}
		worldtickcount.put(world, 1);
		
		if (!perworldentities.containsKey(world)) {
			return;
		}
		
		if (perworldentities.get(world).size() > 0) {
			for (ItemEntity ie : perworldentities.get(world)) {
				if (!ie.isAlive()) {
					perworldentities.get(world).remove(ie);
					iecount.remove(ie);
					continue;
				}
				
				int timeleft = iecount.get(ie);
				BlockPos iepos = ie.blockPosition();
				BlockState ieposstate = world.getBlockState(iepos);
				if (ieposstate.getBlock().equals(Blocks.WATER)) {
					int level = ieposstate.getValue(LiquidBlock.LEVEL);
					if (level > 0) { // flowing
						if (ConfigHandler.preventErosionIfAboveIceBlock) {
							Block belowblock = world.getBlockState(iepos.below()).getBlock();
							if (Util.isIceBlock(belowblock)) {
								continue;
							}
						}
						
						timeleft-=1;
						if (timeleft == 0) {
							perworldentities.get(world).remove(ie);
							iecount.remove(ie);
							Util.transformItemEntity(world, ie);
							continue;
						}

						iecount.put(ie, timeleft);
					}
				}
			}
		}
	}
	
	public static void onEntityJoin(Level world, Entity entity) {
		if (world.isClientSide) {
			return;
		}
		
		if (!(entity instanceof ItemEntity)) {
			return;
		}
		
		ItemEntity ie = (ItemEntity)entity;
		ItemStack stack = ie.getItem();
		if (!Util.erodeinto.containsKey(stack.getItem())) {
			return;
		}
		
		if (!perworldentities.containsKey(world)) {
			perworldentities.put(world, new CopyOnWriteArrayList<ItemEntity>(Arrays.asList(ie)));
		}
		else {
			perworldentities.get(world).add(ie);
		}
		
		iecount.put(ie, ConfigHandler.durationInSecondsStoneErodes);
	}
}
