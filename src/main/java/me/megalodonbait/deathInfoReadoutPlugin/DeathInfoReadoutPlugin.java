package me.megalodonbait.deathInfoReadoutPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class DeathInfoReadoutPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }
}
