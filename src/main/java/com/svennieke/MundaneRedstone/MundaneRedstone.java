package com.svennieke.MundaneRedstone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.svennieke.MundaneRedstone.config.MundaneConfigGen;
import com.svennieke.MundaneRedstone.handler.MundaneGenerationHandler;
import com.svennieke.MundaneRedstone.init.ModBlocks;
import com.svennieke.MundaneRedstone.init.ModRecipes;
import com.svennieke.MundaneRedstone.proxy.CommonProxy;
import com.svennieke.MundaneRedstone.world.MundaneGeneration;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, 
	name = Reference.MOD_NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
	dependencies = "after:*")

public class MundaneRedstone {
	
	@Instance(Reference.MOD_ID)
	public static MundaneRedstone instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new MundaneConfigGen());
		
		logger.info("Initializing Mundane Redstone Ore Block");
		ModBlocks.init();
		
		logger.info("Registering Mundane Redstone Ore Block");
		ModBlocks.register();

		logger.info("Register Furnace Recipe Mundane Redstone Ore Block");
		ModRecipes.Init();
		
		proxy.Preinit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.ORE_GEN_BUS.register(new MundaneGenerationHandler());
		
		logger.info("Registering World Generation Mundane Redstone Ore");
		GameRegistry.registerWorldGenerator(new MundaneGeneration(), 1);
		proxy.Init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
