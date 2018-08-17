package me.TheOndraCZ.SpecialEvent;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class God implements CommandExecutor, Listener{

    private ArrayList<Player> god = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                if (god.contains(p)){
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aVypl sis god");
                    god.remove(p);
                } else {
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aZapl sis god");
                    god.add(p);
                }
            }
        }
        return true;
    }

    public ArrayList<Player> getGod() {
        return god;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Entity entity = e.getEntity();

        if (entity instanceof Player){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDam(EntityDamageEvent e){
        Entity entity = e.getEntity();

        if (entity instanceof Player){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDa(EntityDamageByBlockEvent e){
        Entity entity = e.getEntity();

        if (entity instanceof Player){
            e.setCancelled(true);
        }
    }
}
