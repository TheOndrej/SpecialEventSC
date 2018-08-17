package me.TheOndraCZ.SpecialEvent.Warps;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetWarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setwarp")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                if (args.length == 1){
                    if (p.hasPermission("specialevent.admin")){

                        File file = new File(Main.getPl().getDataFolder(), File.separator + "Warps");
                        String ar = args[0].toLowerCase();
                        File f = new File(file, File.separator + ar + ".yml");
                        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

                        Location loc = p.getLocation();

                        if (!f.exists()){
                            p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aWarp úspěšně vytvořen. Pokud chceš změnit lokaci warpu, napiš příkaz znovu.");
                            try {

                                config.createSection("Hrac");
                                config.set("Hrac", p.getName());

                                config.createSection("Location");
                                config.set("Location", loc);

                                config.save(f);
                            } catch (IOException exception){
                                exception.printStackTrace();
                            }
                        } else {
                            p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aLokace warpu úspěšně změněna.");

                            try {
                                config.set("Location", loc);

                                config.save(f);
                            } catch (IOException expcetion){
                                expcetion.printStackTrace();
                            }
                        }

                    } else {
                        p.sendMessage("§7[§9§lSpecial§3§lEvent§7] Na toto nemáš oprávnění!");
                    }

                    return true;
                }

                if (args.length > 1){
                    p.sendMessage("§cZadal jsi příliš mnoho argumentů");
                }

                File file = new File(Main.getPl().getDataFolder(), File.separator + "Warps");
                String ar = p.getName().toLowerCase();
                File f = new File(file, File.separator + ar + ".yml");
                YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

                Location loc = p.getLocation();

                if (!f.exists()){
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aWarp úspěšně vytvořen. Pokud chceš změnit lokaci warpu, napiš příkaz znovu.");
                    try {

                        config.createSection("Hrac");
                        config.set("Hrac", p.getName());

                        config.createSection("Location");
                        config.set("Location", loc);

                        config.save(f);
                    } catch (IOException exception){
                        exception.printStackTrace();
                    }
                } else {
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aLokace warpu úspěšně změněna.");

                    try {
                        config.set("Location", loc);

                        config.save(f);
                    } catch (IOException expcetion){
                        expcetion.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}
