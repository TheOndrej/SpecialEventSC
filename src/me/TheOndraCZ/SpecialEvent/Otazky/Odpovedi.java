package me.TheOndraCZ.SpecialEvent.Otazky;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Odpovedi implements CommandExecutor{

    public void onGui(Player p){

        ArrayList<ItemStack> meta = new ArrayList<>();
        Inventory inv = Bukkit.createInventory(null, 54, "§4§lOdpovědi na otázky §7strana 1");
        ItemStack stackl = new ItemStack(Material.STAINED_GLASS_PANE);
        inv.setItem(0,stackl);
        inv.setItem(8, stackl);
        inv.setItem(9, stackl);
        inv.setItem(17, stackl);
        inv.setItem(18, stackl);
        inv.setItem(26, stackl);
        inv.setItem(27, stackl);
        inv.setItem(35, stackl);
        inv.setItem(36, stackl);
        inv.setItem(44, stackl);
        ItemStack stack3 = new ItemStack(Material.BARRIER);
        ItemMeta stack3meta = stack3.getItemMeta();
        stack3meta.setDisplayName("§4§lZavřít menu");
        stack3meta.setLore(Arrays.asList("§7Kliknutím zavřete menu"));
        stack3.setItemMeta(stack3meta);
        inv.setItem(45, stack3);
        ItemStack stack2 = new ItemStack(Material.FEATHER);
        ItemMeta stack2meta = stack2.getItemMeta();
        stack2meta.setDisplayName("§4§lDalší strana");
        stack2meta.setLore(Arrays.asList("§7Klikni pro přejití na druhou stranu."));
        stack2.setItemMeta(stack2meta);
        inv.setItem(53, stack2);

        for (int in = 0; in <= 42; in++){

            if (in%2 == 0){
                if (in <= 12){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §61 bod");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else if (in <= 23 && in >= 13){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §62 body");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else if (in <= 32 && in >= 24){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §63 body");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else if (in <= 41 && in >= 33){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §64 body");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else {
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §65 bodů");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                }

            } else {

                if (in <= 12){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §61 bod");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else if (in <= 23 && in >= 13){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §62 body");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else if (in <= 32 && in >= 24){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §63 body");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else if (in <= 41 && in >= 33){
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §64 body");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                } else {
                    ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
                    ItemMeta stackmeta = stack.getItemMeta();
                    stackmeta.setDisplayName("§6§lOtázka č." + in);
                    ArrayList<String> stacklore = new ArrayList<>();
                    stacklore.add("§7Otázka za: §65 bodů");
                    stackmeta.setLore(stacklore);
                    stack.setItemMeta(stackmeta);

                    meta.add(stack);
                }
            }
        }

        for (int i = 1; i <= 42; i++){
            ItemStack stack = meta.get(i);

            inv.addItem(stack);
        }

        p.openInventory(inv);

    }

    public void onGuia(Player p){
        ArrayList<ItemStack> meta = new ArrayList<>();

        ItemStack stackl = new ItemStack(Material.STAINED_GLASS_PANE);
        Inventory inv2 = Bukkit.createInventory(null, 54, "§4§lOdpovědi na otázky §7strana 2");
        inv2.setItem(0,stackl);
        inv2.setItem(8, stackl);
        inv2.setItem(9, stackl);
        inv2.setItem(17, stackl);
        inv2.setItem(18, stackl);
        inv2.setItem(26, stackl);
        inv2.setItem(27, stackl);
        inv2.setItem(35, stackl);
        inv2.setItem(36, stackl);
        inv2.setItem(44, stackl);
        ItemStack stack2 = new ItemStack(Material.FEATHER);
        ItemMeta stack2meta = stack2.getItemMeta();
        stack2meta.setDisplayName("§4§lPředchozí strana");
        stack2meta.setLore(Arrays.asList("§7Klikni pro přejití na předchozí stranu."));
        stack2.setItemMeta(stack2meta);
        inv2.setItem(45, stack2);
        ItemStack stack3 = new ItemStack(Material.BARRIER);
        ItemMeta stack3meta = stack3.getItemMeta();
        stack3meta.setDisplayName("§4§lZavřít menu");
        stack3meta.setLore(Arrays.asList("§7Kliknutím zavřete menu"));
        stack3.setItemMeta(stack3meta);
        inv2.setItem(53, stack3);

        for (int im = 0; im <= 42; im++){
            ItemStack shrek = new ItemStack(Material.AIR);
            meta.add(shrek);
        }

        for (int in = 43; in <= 47; in++){
            if (in%2 == 0){
                ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                ItemMeta stackmeta = stack.getItemMeta();
                stackmeta.setDisplayName("§6§lOtázka č." + in);
                ArrayList<String> stacklore = new ArrayList<>();
                stacklore.add("§7Otázka za: §65 bodů");
                stackmeta.setLore(stacklore);
                stack.setItemMeta(stackmeta);

                meta.add(stack);
            } else {
                ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
                ItemMeta stackmeta = stack.getItemMeta();
                stackmeta.setDisplayName("§6§lOtázka č." + in);
                ArrayList<String> stacklore = new ArrayList<>();
                stacklore.add("§7Otázka za: §65 bodů");
                stackmeta.setLore(stacklore);
                stack.setItemMeta(stackmeta);

                meta.add(stack);
            }
        }

        for (int i = 43; i <= 47; i++){
            ItemStack stack = meta.get(i);

            inv2.addItem(stack);
        }

        p.openInventory(inv2);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("odpoved")){
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (p.hasPermission("specialevent.admin")){

                    onGui(p);
            } else {
                    p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §cNa toto nemáš oprávnění!");
                }
            }
        }
        return true;
    }
}
