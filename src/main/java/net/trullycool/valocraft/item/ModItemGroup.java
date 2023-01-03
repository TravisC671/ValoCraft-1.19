package net.trullycool.valocraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.trullycool.valocraft.ValoCraft;

public class ModItemGroup {

    public static final ItemGroup ValocraftGroup = FabricItemGroup.builder(new Identifier(ValoCraft.MOD_ID))
            .icon(() -> new ItemStack(ModItems.CLASSIC_GUN))
            .build();
}
