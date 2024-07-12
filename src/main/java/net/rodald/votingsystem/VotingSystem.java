package net.rodald.votingsystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class VotingSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.broadcastMessage("test");
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("testy");
        }
        }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
