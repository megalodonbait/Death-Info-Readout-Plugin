package me.megalodonbait.deathInfoReadoutPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
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

    @EventHandler
    public void onItemDeath(EntityDamageEvent event) {
        if (event.getEntity() instanceof Item item) {
            item.setInvulnerable(true);
            Location itemlocation = item.getLocation();
            String itemname = item.getName();
            item.remove();
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                Location playerlocation = p.getLocation();
                if(p.isDead()){
                    if(Math.pow((itemlocation.getBlockX() - playerlocation.getBlockX()), 2) + Math.pow((itemlocation.getBlockZ() - playerlocation.getBlockZ()), 2) < 30) {
                        p.sendMessage(itemname + " was destroyed");
                    }
                }
            }
        }
    }
}