package net.rodald.votingsystem.items.powerups;

import com.google.common.collect.Multimap;
import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Knife {
    private static ItemStack item = new ItemStack(Material.STONE_SWORD);
    private static final String itemName = "Knife";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList("One-shot a player", "to prevent him voting"));
    public static void initItem() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + itemName);
        meta.setLore(itemLore);

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 20.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);

        item.setItemMeta(meta);
        item.setDurability((short) 131);
        ItemRegister.availableItems.add(item);
    }

    public static ItemStack getItem() {
        return item;
    }
}
