package me.TheOndraCZ.SpecialEvent.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener{

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();

        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("Hrac")){
            String zprava = ChatColor.stripColor(e.getMessage());
            String newzprava = "§7" + zprava;
            e.setMessage(newzprava);
        } else if (user.inGroup("Admin")){
            String zprava = e.getMessage();
            String newzprava = "§7" + zprava;
            e.setMessage(newzprava);
        } else if (user.inGroup("Poradatel")){
            String zprava = e.getMessage();
            String newzprava = "§e§l" + zprava;
            e.setMessage(newzprava);
        }
    }
}
