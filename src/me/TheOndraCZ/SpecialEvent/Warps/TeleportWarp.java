package me.TheOndraCZ.SpecialEvent.Warps;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class TeleportWarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warp")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                    if (args.length == 0) {
                        File file = new File(Main.getPl().getDataFolder(), "Warps");
                        String ar = p.getName().toLowerCase();
                        File f = new File(file, ar + ".yml");
                        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

                        if (!f.exists()){
                            p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cMusíš si nejdříve warp vytvořit!");
                        } else {
                            Location loc = (Location) config.get("Location");
                            p.teleport(loc);
                        }

                        return true;
                    } else if (args.length > 1) {
                        p.sendMessage("§cZadal jsi příliš mnoho argumentů");
                    } else {

                        if (p.hasPermission("specialevent.admin")) {

                            File file = new File(Main.getPl().getDataFolder(), File.separator + "Warps");
                            String ar = args[0].toLowerCase();
                            File file1 = new File(file, ar + ".yml");

                            if (file1.exists()) {
                                YamlConfiguration config = YamlConfiguration.loadConfiguration(file1);
                                Location loc = (Location) config.get("Location");

                                p.teleport(loc);
                                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aByl jsi teleportován!");
                            } else {
                                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cTento warp neexistuje");
                            }
                        } else {
                            p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cNa toto nemáš oprávnění!");
                        }
                    }
            }
        }
        return true;
    }
}
