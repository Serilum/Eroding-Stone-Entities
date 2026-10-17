package com.serilum.erodingstoneentities.util;

import com.natamus.collective.functions.ConfigFunctions;
import com.serilum.erodingstoneentities.config.ConfigHandler;
import net.minecraft.core.registries.BuiltInRegistries;
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
import java.util.List;

public class Util {
	private static final List<Block> iceblocks = new ArrayList<Block>(Arrays.asList(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE));
	
	public static Item getErodeIntoItem(Item item) {
		String itemId = BuiltInRegistries.ITEM.getKey(item).toString();
		if (ConfigFunctions.isInIdList(ConfigHandler.itemsWhichErodeIntoClay, itemId)) {
			if (ConfigHandler.erodeIntoClayBlockInsteadOfClayBall) {
				return Items.CLAY;
			}
			return Items.CLAY_BALL;
		}
		if (ConfigFunctions.isInIdList(ConfigHandler.itemsWhichErodeIntoRedSand, itemId)) {
			return Items.RED_SAND;
		}
		if (ConfigFunctions.isInIdList(ConfigHandler.itemsWhichErodeIntoSand, itemId)) {
			return Items.SAND;
		}
		return null;
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
		
		Item toitem = getErodeIntoItem(item);
		if (toitem == null) {
			return;
		}
		
		ItemEntity newie = new ItemEntity(world, ie.getX(), ie.getY(), ie.getZ(), new ItemStack(toitem, stack.getCount()));
		ie.remove(RemovalReason.DISCARDED);
		world.addFreshEntity(newie);
	}
	
	public static boolean isIceBlock(Block block) {
		return iceblocks.contains(block);
	}
}
