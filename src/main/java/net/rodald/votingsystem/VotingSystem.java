package net.rodald.votingsystem;

import net.rodald.votingsystem.items.ItemRegister;
import net.rodald.votingsystem.items.powerups.ExtraVote;
import net.rodald.votingsystem.items.powerups.Life;
import net.rodald.votingsystem.items.powerups.Molotov;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class VotingSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new ItemRegister();

        for (ItemStack item : ItemRegister.availableItems) {
            Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().addItem(item));
        }
        getServer().getPluginManager().registerEvents(new ExtraVote(), this);
        getServer().getPluginManager().registerEvents(new Life(), this);
        getServer().getPluginManager().registerEvents(new Molotov(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
