package me.TheOndraCZ.SpecialEvent.Warps;

import me.TheOndraCZ.SpecialEvent.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class ListWarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warplist")){
            if (sender instanceof Player){
                Player p = (Player) sender;

                File f = new File(Main.getPl().getDataFolder(), "Warps");
                String[] list = f.list();

                for (String sring : list){
                    TextComponent msg = new TextComponent("§9/warp §7" + sring.replaceAll(".yml", ""));
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ChatColor.stripColor(msg.getText())));
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(msg.getText()).create()));
                    msg.setColor(ChatColor.BLUE);
                    p.spigot().sendMessage(msg);
                }

            }
        }
        return true;
    }
}
