package net.earthmc.homeblockaddon.listener;

import com.palmergames.bukkit.towny.event.town.TownPreSetHomeBlockEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class TownPreSetHomeBlockListener implements Listener {
    private final FileConfiguration config;

    public TownPreSetHomeBlockListener(FileConfiguration config) {

        this.config = config;
    }

    @EventHandler
    public void onTownPreSetHomeBlock(TownPreSetHomeBlockEvent event) {
        if (System.currentTimeMillis() - event.getTownBlock().getClaimedAt() < config.getLong("homeblock_cooldown_millis")) {
            long age = System.currentTimeMillis() - event.getTownBlock().getClaimedAt();
            long millisRemaining = config.getLong("homeblock_cooldown_millis") - age;
            event.setCancelMessage("You must wait " + millisRemaining / 3600000 + " hours to set your homeblock here. Try somewhere else.");
            event.setCancelled(true);
        }
    }
}