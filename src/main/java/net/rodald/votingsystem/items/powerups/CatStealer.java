package net.rodald.votingsystem.items.powerups;

import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CatStealer {
    private static ItemStack item = new ItemStack(Material.COD);
    private static final String itemName = "Cat Stealer";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList("Hold this in your hand to", "to lure cats to your mini-game", "for extra points"));
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
