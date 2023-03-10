package net.trullycool.valocraft;

import net.fabricmc.api.ModInitializer;
import net.trullycool.valocraft.block.ModBlocks;
import net.trullycool.valocraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValoCraft implements ModInitializer {
	public static final String MOD_ID = "valocraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
