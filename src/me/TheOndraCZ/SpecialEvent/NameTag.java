package me.TheOndraCZ.SpecialEvent;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class NameTag implements CommandExecutor{

    private HashMap<String, Integer> nametag = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("nametag")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                if (nametag.get(p.getName()) != null){
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cBohužel musíš čekat ještě §9" + nametag.get(p.getName()) + " §csekund!");
                } else {
                    ItemStack nametags = new ItemStack(Material.NAME_TAG, 3);
                    p.getInventory().addItem(nametags);
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cDo inventáře Ti byly přidány 3 nametagy.");

                    nametag.put(p.getName(), 1800);

                    Main.getPl().getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPl(), ()->{
                        int vypocet = nametag.get(p.getName()) - 1;

                        nametag.put(p.getName(), vypocet);
                    },0,20);
                }
            }
        }
        return true;
    }

    public HashMap<String, Integer> getNametag() {
        return nametag;
    }
}
