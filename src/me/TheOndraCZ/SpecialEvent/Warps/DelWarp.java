package me.TheOndraCZ.SpecialEvent.Warps;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class DelWarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("delwarp")){
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (args.length == 0) {
                    File file = new File(Main.getPl().getDataFolder(), File.separator + "Warps");
                    String ar = p.getName().toLowerCase();
                    File file1 = new File(file, ar + ".yml");

                    if (!file1.exists()) {
                        p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cTento warp neexistuje");
                    } else {
                        p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně jsi smazal warp!");

                        file1.delete();
                    }
                    return true;
                }

                if (args.length > 1) {
                    p.sendMessage("§cZadal jsi mnoho argumentů");
                }

                if (p.hasPermission("specialevent.admin")){
                    File file = new File(Main.getPl().getDataFolder(), File.separator + "Warps");
                String ar = args[0].toLowerCase();
                File file1 = new File(file, ar + ".yml");

                if (!file1.exists()) {
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cTento warp neexistuje");
                } else {
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně jsi smazal warp!");

                    file1.delete();
                }
            } else {
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cNa toto nemáš oprávnění!");
                }
            }
        }
        return true;
    }
}
