package net.trullycool.valocraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ClassicGunItem extends Item {
    public ClassicGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            //server
            outputRandomNumber(user);

            user.getItemCooldownManager().set(this, 10);
        }

        return super.use(world, user, hand);
    }

    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(Text.literal("" + getRandomNumber()));
    }
    private int getRandomNumber() {
        return Random.createLocal().nextInt(10);
    }
}
