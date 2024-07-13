package net.rodald.votingsystem.items.powerups;

import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class YeetStick {
    private static ItemStack item = new ItemStack(Material.WOODEN_SWORD);
    private static final String itemName = "Yeet Stick";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList("Launch your opponents", "off and onto another mini-game"));

    public static void initItem() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + itemName);
        meta.setLore(itemLore);
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        item.setItemMeta(meta);
        item.setDurability((short) 43);
        ItemRegister.availableItems.add(item);
    }

    public static ItemStack getItem() {
        return item;
    }
}
