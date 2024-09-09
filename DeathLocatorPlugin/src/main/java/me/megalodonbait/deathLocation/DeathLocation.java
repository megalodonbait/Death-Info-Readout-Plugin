package me.megalodonbait.deathLocation;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocation extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }
}
