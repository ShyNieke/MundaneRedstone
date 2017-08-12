package com.svennieke.MundaneRedstone.handler;

import com.svennieke.MundaneRedstone.config.MundaneConfigGen;

import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MundaneGenerationHandler {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public void onEvent(OreGenEvent.GenerateMinable event)
	{
		if (MundaneConfigGen.generation.RemoveVanillaRedstone && event.getType() == OreGenEvent.GenerateMinable.EventType.REDSTONE)
			event.setResult(Event.Result.DENY);
	}
}
