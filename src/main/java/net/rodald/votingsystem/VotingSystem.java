package net.rodald.votingsystem;

import net.rodald.votingsystem.items.ItemRegister;
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
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
