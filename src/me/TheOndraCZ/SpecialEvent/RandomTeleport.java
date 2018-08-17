package me.TheOndraCZ.SpecialEvent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RandomTeleport implements CommandExecutor{

    private void onTeleport(Player p){
        Random random = new Random();
        int  rx = random.nextInt(3000);
        int y = random.nextInt(256);
        int rz = random.nextInt(3000);

        int  ox = random.nextInt(3000);
        int oz = random.nextInt(3000);

        boolean checkX = random.nextBoolean();
        boolean checkY = random.nextBoolean();
        int x = 0;
        int z = 0;
        if (checkX){
            x = rx-ox;
        }
        else{
            x = rx;
        }
        if (checkY){
            z = rz-oz;
        }
        else {
            z=rz;
        }


        Location loc = new Location(Bukkit.getWorld("world"), x,y,z);
        Location check = new Location(Bukkit.getWorld("world"), x,y + 1,z);
        Location check2 = new Location(Bukkit.getWorld("world"), x,y - 1,z);
        Block block = check.getBlock();
        Block block2 = check2.getBlock();

        ItemStack item = new ItemStack(block.getType());
        ItemStack item2 = new ItemStack(block2.getType());

        if (item.getType() != Material.AIR){
            onTeleport(p);
        } else if (item2.getType() == Material.AIR){
            onTeleport(p);
        }else {
            p.teleport(loc);
            p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aByl jsi teleportován na náhodné souřadnice: §6" + x + "§7, §6" + y + "§7, §6" + z);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("teleport")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                onTeleport(p);
            }
        }
        return true;
    }
}
