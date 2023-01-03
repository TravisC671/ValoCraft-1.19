package net.trullycool.valocraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trullycool.valocraft.ValoCraft;
import net.trullycool.valocraft.item.custom.ClassicGunItem;

public class ModItems {

    public static final Item CLASSIC_GUN = registerItem("classic_gun", new ClassicGunItem(new FabricItemSettings().maxCount(1)), ModItemGroup.ValocraftGroup);
    public static final Item GHOST_GUN = registerItem("ghost_gun", new Item(new FabricItemSettings()), ModItemGroup.ValocraftGroup);

    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(ValoCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ValoCraft.LOGGER.debug("Registering Mod Items for " + ValoCraft.MOD_ID);
    }
}
