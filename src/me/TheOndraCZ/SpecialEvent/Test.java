package me.TheOndraCZ.SpecialEvent;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("konzoleprikaz")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                if (p.isOp()){
                    String arg = args[0].replaceAll(",", " ");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), arg);
                    p.sendMessage("hotovo");
                } else {
                    p.sendMessage("Na toto nemáš práva!");
                }
            }
        }
        return true;
    }
}
