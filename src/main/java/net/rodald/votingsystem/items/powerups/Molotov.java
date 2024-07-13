package net.rodald.votingsystem.items.powerups;

import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class Molotov implements Listener {
    private static ItemStack item = new ItemStack(Material.FIRE_CHARGE);
    private static final String itemName = "Molotov";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList(ChatColor.RESET + "Right click a mini-game", ChatColor.RESET + "to set it on fire"));

    private static final Set<Material> CONCRETE_BLOCKS = EnumSet.of(
            Material.ORANGE_CONCRETE,
            Material.LIGHT_BLUE_CONCRETE,
            Material.YELLOW_CONCRETE,
            Material.LIME_CONCRETE,
            Material.PINK_CONCRETE,
            Material.PURPLE_CONCRETE,
            Material.BLUE_CONCRETE,
            Material.RED_CONCRETE
    );

    public static boolean isConcrete(Material material) {
        return CONCRETE_BLOCKS.contains(material);
    }
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

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if the action is a right-click on a block
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // Get the item in the player's main hand
            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
            Player player = event.getPlayer();
            World world = player.getWorld();

            // Check if the item is the Molotov
            if (item != null && item.isSimilar(Molotov.getItem())) {
                // Check if the block clicked is concrete
                Material clickedBlock = event.getClickedBlock().getType();
                Location location = event.getClickedBlock().getLocation();
                if (!isConcrete(clickedBlock)) {
                    // Cancel the event if the block is not concrete
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ChatColor.RED + "You can only place the Molotov on concrete blocks!");
                    return;
                }
                floodFire(world, location.add(0, 1, 0));
            }
        }
    }

    private void floodFire(World world, Location location) {
        Block block = world.getBlockAt(location.clone().subtract(0, 1, 0));

        if (isConcrete(block.getType()) && world.getBlockAt(location).getType() == Material.AIR) {
            world.getBlockAt(location).setType(Material.FIRE);

            floodFire(world, location.clone().add(1, 0, 0));
            floodFire(world, location.clone().subtract(1, 0, 0));
            floodFire(world, location.clone().add(0, 0, 1));
            floodFire(world, location.clone().subtract(0, 0, 1));
        }
    }
}
