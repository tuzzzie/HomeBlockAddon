package net.earthmc.homeblockaddon;

import net.earthmc.homeblockaddon.config.Config;
import net.earthmc.homeblockaddon.listener.TownPreSetHomeBlockListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomeBlockAddon extends JavaPlugin {
    private final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        Config.registerConfig(config);
        saveConfig();
        
        registerListeners();

    }
    
    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new TownPreSetHomeBlockListener(config), this);
    }
}
