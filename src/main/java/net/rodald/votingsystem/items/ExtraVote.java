package net.rodald.votingsystem.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class ExtraVote {
    private static ItemStack item = new ItemStack(Material.CAT_SPAWN_EGG);
    private static final String itemName = "Extra Vote";
    private static final String itemLore = "Spawns a cat for an extra vote\non the mini-game you want to play";

    public static void initItem() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + itemName);
        meta.setLore(Collections.singletonList(ChatColor.RESET + itemLore));
        item.setItemMeta(meta);
        ItemRegister.availableItems.add(item);
    }

    public static ItemStack getItem() {
        return item;
    }

}
