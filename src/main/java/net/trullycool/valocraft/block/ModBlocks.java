package net.trullycool.valocraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.trullycool.valocraft.ValoCraft;
import net.trullycool.valocraft.block.custom.RadianiteBoxBlock;
import net.trullycool.valocraft.block.custom.RadianiteBoxBlock2x2;
import net.trullycool.valocraft.item.ModItemGroup;

public class ModBlocks {
    public static final Block RADIANITE_BLOCK = registerBlock("radianite_block",
            new RadianiteBoxBlock(FabricBlockSettings.of(Material.BARRIER)), ModItemGroup.ValocraftGroup);

    public static final Block RADIANITE_BLOCK_2X2 = registerBlock("radianite_block_2x2",
            new RadianiteBoxBlock2x2(FabricBlockSettings.of(Material.BARRIER)), ModItemGroup.ValocraftGroup);

    public static final Block DIAGONAL_BRICK = registerBlock("diagonal_brick", new Block(FabricBlockSettings.of(Material.STONE)), ModItemGroup.ValocraftGroup);
    public static final Block SMALL_TILE = registerBlock("small_tile", new Block(FabricBlockSettings.of(Material.STONE)), ModItemGroup.ValocraftGroup);

    public static final Block WALL_PILLAR = registerBlock("wall_pillar", new Block(FabricBlockSettings.of(Material.STONE)), ModItemGroup.ValocraftGroup);

    public static final Block WALL_PILLAR_BASE = registerBlock("wall_pillar_base", new Block(FabricBlockSettings.of(Material.STONE)), ModItemGroup.ValocraftGroup);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(ValoCraft.MOD_ID, name), block);
    }

    private static Block registerGhostBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ValoCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(ValoCraft.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ValoCraft.LOGGER.debug("Registering ModBlocks for " + ValoCraft.MOD_ID);
    }
}
