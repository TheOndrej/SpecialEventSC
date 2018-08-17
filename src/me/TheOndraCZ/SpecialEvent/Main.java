package me.TheOndraCZ.SpecialEvent;

import me.TheOndraCZ.SpecialEvent.Listeners.Chat;
import me.TheOndraCZ.SpecialEvent.Listeners.Join;
import me.TheOndraCZ.SpecialEvent.Otazky.Listeners;
import me.TheOndraCZ.SpecialEvent.Otazky.Odpovedi;
import me.TheOndraCZ.SpecialEvent.Otazky.Otazky;
import me.TheOndraCZ.SpecialEvent.PVPEvent.Commands;
import me.TheOndraCZ.SpecialEvent.Warps.DelWarp;
import me.TheOndraCZ.SpecialEvent.Warps.SetWarp;
import me.TheOndraCZ.SpecialEvent.Warps.TeleportWarp;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin{

    private static Main pl;
    private static Otazky otazky;
    private static Odpovedi odpovedi;

    @Override
    public void onEnable(){
        getLogger().info("Plugin byl zapnut");
        pl = this;
        otazky = new Otazky();
        odpovedi = new Odpovedi();
        onCommands();
        onListeners();
        onBroadcast();
        onBroadcast2();
        onLoadPvPConfig();
        onLoadTestConfig();
        onHash();
    }

    @Override
    public void onDisable(){
        getLogger().info("Plugin vyl vypnut");
    }

    private void onCommands(){
        getCommand("pvpevent").setExecutor(new Commands());
        getCommand("otazky").setExecutor(new Otazky());
        getCommand("odpoved").setExecutor(new Odpovedi());
        getCommand("setwarp").setExecutor(new SetWarp());
        getCommand("warp").setExecutor(new TeleportWarp());
        getCommand("delwarp").setExecutor(new DelWarp());
        getCommand("konzoleprikaz").setExecutor(new Test());
        getCommand("teleport").setExecutor(new RandomTeleport());
    }

    private void onListeners(){
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getServer().getPluginManager().registerEvents(new Chat(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);
    }

    private void onLoadPvPConfig(){
        File file = new File(Main.pl.getServer().getPluginManager().getPlugin("SpecialEvent").getDataFolder(), "PvPEvent");
        File f = new File(file, "Config.yml");
        YamlConfiguration fconfig = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()){
            try {

                fconfig.createSection("Kolo");
                fconfig.set("Kolo", 1);

                fconfig.save(f);
            } catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }

    private void onLoadTestConfig(){
        File file = new File(getDataFolder(), "Test");
        File f = new File(file, "Otazky.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()){
            try {

                for (int i = 1; i <= 47; i++){
                    String sec = String.valueOf(i);

                    ConfigurationSection section = config.createSection(sec);
                    section.createSection("Otazka");
                    section.createSection("Cislo");
                    section.createSection("Body");
                    section.createSection("OdpovedA");
                    section.createSection("OdpovedB");
                    section.createSection("OdpovedC");
                    section.createSection("OdpovedD");
                    section.createSection("SpravnaOdpoved");
                }

                config.save(f);
            } catch (IOException exception){
                exception.printStackTrace();
            }
        } else {

        }
    }

    private void onBroadcast(){
        getServer().getScheduler().scheduleSyncRepeatingTask(this, ()->{
            Bukkit.broadcastMessage("§c§lVarování! §7Nezapoměňte si vytvořit residenci jako pojištění proti škodám na stavbě!");
            Bukkit.broadcastMessage("§c§lVarování! §7Pokud nechcete svou stavbu ztratit, vytvořte si warp! (§c/setwarp§7)");
            Bukkit.broadcastMessage("§c§lTIP §7Nemůžeš najít volné místo k stavění? Vyzkoušej příkaz §c/res rt");
            Bukkit.broadcastMessage("§c§lTIP §7Své body si můžeš prohlédnout na této stránce:§c https://1url.cz/2Mzaa");
        },0,20*60*5);
    }

    private void onBroadcast2(){
        getServer().getScheduler().scheduleSyncRepeatingTask(this, ()->{
            Bukkit.broadcastMessage("§f§lPříkazy:");
            Bukkit.broadcastMessage(" §7§l/god - §8nesmrtelnost");
            Bukkit.broadcastMessage(" §7§l/skull nick - §8hlava hráče");
            Bukkit.broadcastMessage(" §7§l/hdb - §8databáze hlav");
            Bukkit.broadcastMessage(" §7§l/teleport - §8random teleport");
            Bukkit.broadcastMessage(" §7§l/setwarp - §8Vytvoří warp");
            Bukkit.broadcastMessage(" §7§l/warp  §8Teleportuje na Váš warp");
            Bukkit.broadcastMessage(" §7§l/res - §8Residence");
            Bukkit.broadcastMessage(" §7Armor stand editor lze využít pomocí flintu!");
        },0,20*60*10);
    }

    private void onHash(){
        for (int i = 0; i <= 47; i++){
            otazky.getPouziti().put(i, false);
        }
    }

    public static Main getPl(){
        return pl;
    }

    public static Otazky getOtazky(){
        return otazky;
    }

    public static Odpovedi getOdpovedi(){
        return odpovedi;
    }

}
