package net.rodald.votingsystem.items.powerups;

import net.rodald.votingsystem.items.ItemRegister;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;
import java.util.function.Consumer;

public class Life implements Listener {
    private static ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
    private static final String itemName = "2nd Life";
    private static final ArrayList<String> itemLore = new ArrayList<>(
            Arrays.asList(ChatColor.RESET + "Right click to survive a dead player"));

    private final Map<UUID, Consumer<Player>> playerSelectionCallbacks = new HashMap<>();
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
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item != null &&
                item.hasItemMeta() && item.getItemMeta().getDisplayName().equals(itemName) &&
                event.getAction().toString().contains("RIGHT_CLICK")) {
            openInventory(player);
            event.setCancelled(true);
        }
    }

    public void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 36, ChatColor.DARK_GRAY + "Revive GUI");

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RESET + (ChatColor.RED + "Close"));
        close.setItemMeta(closeMeta);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
            assert meta != null;
            meta.setOwningPlayer(onlinePlayer);
            meta.setDisplayName(net.md_5.bungee.api.ChatColor.RESET + onlinePlayer.getName());
            playerHead.setItemMeta(meta);
            inventory.addItem(playerHead);
        }

        inventory.setItem(inventory.getSize() - 5, close);

        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(ChatColor.DARK_GRAY + "Revive GUI")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || !clickedItem.hasItemMeta()) {
                return;
            }

            String itemName = clickedItem.getItemMeta().getDisplayName();

            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                SkullMeta meta = (SkullMeta) event.getCurrentItem().getItemMeta();
                if (meta != null && meta.getOwningPlayer() != null) {
                    Player selectedPlayer = meta.getOwningPlayer().getPlayer();
                    Player clicker = (Player) event.getWhoClicked();

                    UUID clickerUUID = clicker.getUniqueId();
                    clicker.sendMessage("Searching callback for UUID: " + clickerUUID);

                    clicker.sendMessage("Available UUIDs in playerSelectionCallbacks: " + playerSelectionCallbacks.keySet());

                    Consumer<Player> callback = playerSelectionCallbacks.remove(clickerUUID);
                    if (callback != null) {
                        clicker.sendMessage("Callback found, executing...");
                        if (selectedPlayer != null) {
                            callback.accept(selectedPlayer);
                        } else {
                            clicker.sendMessage("Selected player is null!");
                        }
                    } else {
                        clicker.sendMessage("No callback found for this player.");
                    }

                    clicker.closeInventory();
                } else {
                    ((Player) event.getWhoClicked()).sendMessage("Meta or OwningPlayer is null.");
                }
            } else if (itemName.equals(ChatColor.RED + "Close")) {
                player.closeInventory();
            }
        }
    }
}
