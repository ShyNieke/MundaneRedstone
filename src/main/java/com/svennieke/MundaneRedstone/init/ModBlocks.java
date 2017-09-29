package com.svennieke.MundaneRedstone.init;

import com.svennieke.MundaneRedstone.blocks.BlockMundaneRedstone;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	public static Block Mundane_Redstone_Ore;
	
	public static void init()
	{
		Mundane_Redstone_Ore = new BlockMundaneRedstone("redstone_ore", "oreRedstone");
	}
	
	public static void register()
	{
		registerBlock(Mundane_Redstone_Ore);
	}
	
	public static void registerBlock(Block block) 
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	public static void registerBlock(Block block, ItemBlock item) 
	{
		ForgeRegistries.BLOCKS.register(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(Mundane_Redstone_Ore);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
}
}
