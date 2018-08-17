package me.TheOndraCZ.SpecialEvent.Listeners;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class Join implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        e.setJoinMessage("§7Hráč §9" + p.getName() + " §7se připojil.");

        File file = new File(Main.getPl().getDataFolder(), "Test");
        File file1 = new File(file, "Players");
        File f = new File(file1, p.getName() + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()){
            try {
                config.createSection("Body");
                config.set("Body", 0);

                config.save(f);
            } catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage("§7Hráč §9" + p.getName() + " §7se odpojil.");
    }
}
