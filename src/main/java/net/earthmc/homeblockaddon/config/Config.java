package net.earthmc.homeblockaddon.config;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public static void registerConfig(FileConfiguration config) {
        config.addDefault("homeblock_cooldown_millis", 86400000);

        config.options().copyDefaults(true);
    }
}
