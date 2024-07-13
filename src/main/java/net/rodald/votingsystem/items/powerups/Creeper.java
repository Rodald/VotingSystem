package net.rodald.votingsystem.items.powerups;

import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class Creeper {
    private static ItemStack item = new ItemStack(Material.CREEPER_SPAWN_EGG);
    private static final String itemName = "Creeper Spawn Egg";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList("Spawns a creeper"));
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
