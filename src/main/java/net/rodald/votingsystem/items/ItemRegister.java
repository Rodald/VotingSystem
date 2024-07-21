package net.rodald.votingsystem.items;

import net.rodald.votingsystem.items.powerups.*;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemRegister {

    public static List<ItemStack> availableItems = new ArrayList<>();

    public ItemRegister() {
        ExtraVote.initItem();
        YeetStick.initItem();
        CatStealer.initItem();
        Reset.initItem();
        Knife.initItem();
        Molotov.initItem();
        BigBoy.initItem();
        Creeper.initItem();
        FatMan.initItem();
        YeetStick.initItem();
    }

    public static ItemStack getRandomItem() {
        Random random = new Random();
        int randomNumber = random.nextInt(availableItems.size());
        Bukkit.broadcastMessage(String.valueOf(randomNumber));

        return availableItems.get(randomNumber);
    }
}
