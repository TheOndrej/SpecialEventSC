package me.TheOndraCZ.SpecialEvent;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Skull implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("skull")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                if (args.length == 0){
                    p.sendMessage("§cChybí argument");
                    return true;
                }

                if (args.length > 1){
                    p.sendMessage("§cPříliš mnoho argumentů");
                }

                ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                SkullMeta itememeta = (SkullMeta) item.getItemMeta();
                itememeta.setDisplayName(args[0]);
                itememeta.setOwner(args[0]);
                item.setItemMeta(itememeta);

                p.getInventory().addItem(item);
            }
        }
        return true;
    }
}
