package net.rodald.votingsystem;

import net.rodald.votingsystem.items.ItemRegister;
import net.rodald.votingsystem.items.powerups.Molotov;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class VotingSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new ItemRegister();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().addItem(ItemRegister.getRandomItem());
            player.getInventory().addItem(ItemRegister.getRandomItem());
            player.getInventory().addItem(ItemRegister.getRandomItem());
            player.getInventory().addItem(ItemRegister.getRandomItem());
            player.getInventory().addItem(ItemRegister.getRandomItem());
            player.getInventory().addItem(ItemRegister.getRandomItem());
        }

        getServer().getPluginManager().registerEvents(new Molotov(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
