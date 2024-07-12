package net.rodald.votingsystem.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class YeetStick {
    private static ItemStack item = new ItemStack(Material.WOODEN_SWORD);
    private static final String itemName = "Yeet Stick";
    private static final String itemLore = "Launch your opponents\noff and onto another mini-game";

    public static void initItem() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + itemName);
        meta.setLore(Collections.singletonList(ChatColor.RESET +    itemLore));
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        item.setItemMeta(meta);
        ItemRegister.availableItems.add(item);
    }

    public static ItemStack getItem() {
        return item;
    }
}
