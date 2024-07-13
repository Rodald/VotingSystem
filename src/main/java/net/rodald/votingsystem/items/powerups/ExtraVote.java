package net.rodald.votingsystem.items.powerups;

import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ExtraVote {
    private static ItemStack item = new ItemStack(Material.CAT_SPAWN_EGG);
    private static final String itemName = "Extra Vote";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList("Spawns a cat for an extra vote", "on the mini-game you want to play"));
    public static void initItem() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + itemName);
        meta.setLore(itemLore);
        item.setItemMeta(meta);
        ItemRegister.availableItems.add(item);
    }

    public static ItemStack getItem() {
        return item;
    }

}
