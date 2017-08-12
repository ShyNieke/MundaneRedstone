package com.svennieke.MundaneRedstone.config;

import com.svennieke.MundaneRedstone.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID, category = "")
@Config.LangKey("mundaneredstone.config.title")
public class MundaneConfigGen {
	
	@Config.Comment({"World Generation"})
	public static WorldGen generation = new WorldGen();
	
	@Config.Comment({"Mundane Redstone Ore Generation"})
	public static MundaneWorldGen mundanegen = new MundaneWorldGen();
	
	@Config.Comment({"Other Configurative Stuff"})
	public static OtherStuff otherconfigurations = new OtherStuff();
	
	public static class WorldGen{
		@Config.RequiresMcRestart
		@Config.Comment("Remove vanilla Redstone Ore generation (default: true)")
		public boolean RemoveVanillaRedstone = true;
		
		@Config.RequiresMcRestart
		@Config.Comment("Enable Mundane Redstone generation [Why do you have the mod if you are gonna disable this] (default: true)")
		public boolean MundaneGenerate = true;
	}
	
	public static class MundaneWorldGen{
		@Config.Comment("The minimum vein size of the Mundane Redstone Ore (default: 2)")
		public int MundaneMinVeinSize = 2;
		
		@Config.Comment("The maximum vein size of the Mundane Redstone Ore (default: 8)")
		public int MundaneMaxVeinSize = 8;
		
		@Config.Comment("The maximum height in which the Mundane Redstone Ore can generate (default: 16)")
		public int MundaneMaxHeight = 16;
		
		@Config.Comment("The chance that the Mundane Redstone Ore generates (default: 8)")
		public int MundaneChance = 8;
	}
	
	public static class OtherStuff{
		@Config.Comment("If this value is true the Mundane Redstone Ore will drop a Vanilla Ore block when mined with silk touch (default: false)")
		public boolean SilkVanilla = false;
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler {
		
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) {
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}
