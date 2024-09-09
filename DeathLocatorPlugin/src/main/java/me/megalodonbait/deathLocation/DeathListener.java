package me.megalodonbait.deathLocation;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location location = player.getLocation();
        String world;
        if (location.getWorld().getEnvironment().toString().equalsIgnoreCase("normal")) {
            world = "overworld";
        } else if (location.getWorld().getEnvironment().toString().equalsIgnoreCase("the_end")) {
            world = "end";
        } else {
            world = location.getWorld().getEnvironment().toString().toLowerCase();
        }
        player.sendMessage("you died at: " + location.getBlockX() + "x " + location.getBlockY() + "y " + location.getBlockZ() + "z, in the " + world);
    }
}
