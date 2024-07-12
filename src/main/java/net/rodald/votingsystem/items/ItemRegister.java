package net.rodald.votingsystem.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemRegister {

    public static List<ItemStack> availableItems = new ArrayList<>();

    public ItemRegister() {
        ExtraVote.initItem();
        YeetStick.initItem();
    }

    public static ItemStack getRandomItem() {
        Random random = new Random();
        int randomNumber = random.nextInt(availableItems.size());
        Bukkit.broadcastMessage(String.valueOf(randomNumber));

        return availableItems.get(randomNumber);
    }
}
