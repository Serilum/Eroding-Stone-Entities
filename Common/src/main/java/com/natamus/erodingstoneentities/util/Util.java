package com.natamus.erodingstoneentities.util;

import com.natamus.erodingstoneentities.config.ConfigHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Util {
	private static final List<Block> iceblocks = new ArrayList<Block>(Arrays.asList(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE));
	
	public static HashMap<Item, Item> erodeinto = new HashMap<Item, Item>();
	
	public static boolean populateArrays() {
		String tosandstring = ConfigHandler.itemsWhichErodeIntoSand;
		String toredsandstring = ConfigHandler.itemsWhichErodeIntoRedSand;
		String toclaystring = ConfigHandler.itemsWhichErodeIntoClay;
		
		for (String itemstring : tosandstring.split(",")) {
			ResourceLocation rl = new ResourceLocation(itemstring.trim().replaceAll("[^a-z0-9_.-:]", ""));
			if (!Registry.ITEM.keySet().contains(rl)) {
				System.out.println("[Eroding Stone Entities] Unable to find item for input '" + itemstring.trim() + "' to erode into sand in the Forge item registry. Ignoring it.");
				continue;
			}
			
			Item item = Registry.ITEM.get(rl);
			erodeinto.put(item, Items.SAND);
		}
		
		for (String itemstring : toredsandstring.split(",")) {
			ResourceLocation rl = new ResourceLocation(itemstring.trim().replaceAll("[^a-z0-9_.-:]", ""));
			if (!Registry.ITEM.keySet().contains(rl)) {
				System.out.println("[Eroding Stone Entities] Unable to find item for input '" + itemstring.trim() + "' to erode into red sand in the Forge item registry. Ignoring it.");
				continue;
			}
			
			Item item = Registry.ITEM.get(rl);
			erodeinto.put(item, Items.RED_SAND);
		}
		
		for (String itemstring : toclaystring.split(",")) {
			ResourceLocation rl = new ResourceLocation(itemstring.trim().replaceAll("[^a-z0-9_.-:]", ""));
			if (!Registry.ITEM.keySet().contains(rl)) {
				System.out.println("[Eroding Stone Entities] Unable to find item for input '" + itemstring.trim() + "' to erode into clay in the Forge item registry. Ignoring it.");
				continue;
			}
			
			Item item = Registry.ITEM.get(rl);
			if (ConfigHandler.erodeIntoClayBlockInsteadOfClayBall) {
				erodeinto.put(item, Items.CLAY);
			}
			else {
				erodeinto.put(item, Items.CLAY_BALL);
			}
		}
		
		if (erodeinto.size() == 0) {
			System.out.println("[Eroding Stone Entities] The erode into hashmap is empty. Something went wrong while parsing your config file. Mod disabled.");
			return false;
		}
		return true;
	}
	
	public static void transformItemEntity(Level world, ItemEntity ie) {
		ItemStack stack = ie.getItem();
		if (stack == null) {
			return;
		}
		
		Item item = stack.getItem();
		if (item == null) {
			return;
		}
		
		if (!erodeinto.containsKey(item)) {
			return;
		}
		
		Item toitem = erodeinto.get(item);
		
		ItemEntity newie = new ItemEntity(world, ie.getX(), ie.getY(), ie.getZ(), new ItemStack(toitem, stack.getCount()));
		ie.remove(RemovalReason.DISCARDED);
		world.addFreshEntity(newie);
	}
	
	public static boolean isIceBlock(Block block) {
		return iceblocks.contains(block);
	}
}
