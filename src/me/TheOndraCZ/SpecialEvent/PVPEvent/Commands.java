package me.TheOndraCZ.SpecialEvent.PVPEvent;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;

public class Commands implements CommandExecutor{

    private void onKolo(Player p, Player teleport){
        File file = new File(Main.getPl().getServer().getPluginManager().getPlugin("SpecialEvent").getDataFolder(), "PvPEvent");
        File f = new File(file, "Config.yml");
        YamlConfiguration fconfig = YamlConfiguration.loadConfiguration(f);

        if (fconfig.getInt("Kolo") == 1){
            PlayerInventory pinv = teleport.getInventory();
            pinv.clear();

            ItemStack helma = new ItemStack(Material.LEATHER_HELMET);
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemStack kalhoty = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemStack boty = new ItemStack(Material.LEATHER_BOOTS);
            ItemStack mec = new ItemStack(Material.STONE_SWORD);
            ItemStack luk = new ItemStack(Material.BOW);
            ItemStack sipy = new ItemStack(Material.ARROW, 10);

            pinv.setHelmet(helma);
            pinv.setChestplate(chestplate);
            pinv.setLeggings(kalhoty);
            pinv.setBoots(boty);
            pinv.addItem(mec);
            pinv.addItem(luk);
            pinv.addItem(sipy);

        } else if (fconfig.getInt("Kolo") == 2){
            PlayerInventory pinv = teleport.getInventory();
            pinv.clear();

            ItemStack helma = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemStack kalhoty = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemStack boty = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemStack mec = new ItemStack(Material.STONE_SWORD);
            mec.addEnchantment(Enchantment.DAMAGE_ALL, 1);
            ItemStack luk = new ItemStack(Material.BOW);
            luk.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
            ItemStack sipy = new ItemStack(Material.ARROW, 10);

            pinv.setHelmet(helma);
            pinv.setChestplate(chestplate);
            pinv.setLeggings(kalhoty);
            pinv.setBoots(boty);
            pinv.addItem(mec);
            pinv.addItem(luk);
            pinv.addItem(sipy);
        } else if (fconfig.getInt("Kolo") == 3){
            PlayerInventory pinv = teleport.getInventory();
            pinv.clear();

            ItemStack helma = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemStack kalhoty = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemStack boty = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemStack mec = new ItemStack(Material.IRON_SWORD);
            ItemStack luk = new ItemStack(Material.BOW);
            luk.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
            ItemStack sipy = new ItemStack(Material.ARROW, 10);

            pinv.setHelmet(helma);
            pinv.setChestplate(chestplate);
            pinv.setLeggings(kalhoty);
            pinv.setBoots(boty);
            pinv.addItem(mec);
            pinv.addItem(luk);
            pinv.addItem(sipy);
        } else if (fconfig.getInt("Kolo") == 4){
            PlayerInventory pinv = teleport.getInventory();
            pinv.clear();

            ItemStack helma = new ItemStack(Material.IRON_HELMET);
            ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack kalhoty = new ItemStack(Material.IRON_LEGGINGS);
            ItemStack boty = new ItemStack(Material.IRON_BOOTS);
            ItemStack mec = new ItemStack(Material.IRON_SWORD);
            mec.addEnchantment(Enchantment.DAMAGE_ALL, 2);
            ItemStack luk = new ItemStack(Material.BOW);
            luk.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
            ItemStack sipy = new ItemStack(Material.ARROW, 15);

            pinv.setHelmet(helma);
            pinv.setChestplate(chestplate);
            pinv.setLeggings(kalhoty);
            pinv.setBoots(boty);
            pinv.addItem(mec);
            pinv.addItem(luk);
            pinv.addItem(sipy);
        } else if (fconfig.getInt("Kolo") == 5){
            PlayerInventory pinv = teleport.getInventory();
            pinv.clear();

            ItemStack helma = new ItemStack(Material.DIAMOND_HELMET);
            helma.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack kalhoty = new ItemStack(Material.DIAMOND_LEGGINGS);
            kalhoty.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack boty = new ItemStack(Material.DIAMOND_BOOTS);
            boty.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack mec = new ItemStack(Material.DIAMOND_SWORD);
            mec.addEnchantment(Enchantment.DAMAGE_ALL, 2);
            ItemStack luk = new ItemStack(Material.BOW);
            luk.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
            luk.addEnchantment(Enchantment.ARROW_INFINITE,1);
            luk.addEnchantment(Enchantment.ARROW_FIRE, 1);
            ItemStack sipy = new ItemStack(Material.ARROW, 1);
            ItemStack jablko = new ItemStack(Material.GOLDEN_APPLE,1, (short) 1);

            pinv.setHelmet(helma);
            pinv.setChestplate(chestplate);
            pinv.setLeggings(kalhoty);
            pinv.setBoots(boty);
            pinv.addItem(mec);
            pinv.addItem(luk);
            pinv.addItem(sipy);
            pinv.addItem(jablko);
        }


    }

    private boolean onA(Player p, String[] args){
        if (args.length == 1){
            p.sendMessage("§cMusíš zadat nick hráče!");
            return true;
        }

        Player teleport = Main.getPl().getServer().getPlayer(args[1]);
        if (teleport == null){
            p.sendMessage("§cTento hráč není online!");
        }

        Location loc = new Location(Bukkit.getWorld("bigevent"), 226, 64, 360, -130,0);
        teleport.teleport(loc);

        onKolo(p, teleport);

        return true;
    }

    private boolean onB(Player p, String[] args){
        if (args.length == 1){
            p.sendMessage("§cMusíš zadat nick hráče!");
            return true;
        }

        Player teleport = Main.getPl().getServer().getPlayer(args[1]);
        if (teleport == null){
            p.sendMessage("§cTento hráč není online!");
        }

        Location loc = new Location(Bukkit.getWorld("bigevent"), 250, 64, 327,42,0);
        teleport.teleport(loc);

        onKolo(p, teleport);

        return true;

    }

    private boolean onC(Player p, String[] args){
        File file = new File(Main.getPl().getServer().getPluginManager().getPlugin("SpecialEvent").getDataFolder(), "PvPEvent");
        File f = new File(file, "Config.yml");
        YamlConfiguration fconfig = YamlConfiguration.loadConfiguration(f);

        if (args.length == 1){
            p.sendMessage("§cMusíš zadat číslo!");
            return true;
        }

        String cislo = args[1];
        if (cislo.equals("1") || cislo.equals("2") || cislo.equals("3") || cislo.equals("4") || cislo.equals("5")){
            if (args[1].equalsIgnoreCase("1")){
                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně změněno!");

                try {

                    fconfig.set("Kolo", 1);

                    fconfig.save(f);
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            } else if (args[1].equalsIgnoreCase("2")){
                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně změněno!");

                try {

                    fconfig.set("Kolo", 2);

                    fconfig.save(f);
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            } else if (args[1].equalsIgnoreCase("3")){
                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně změněno!");

                try {

                    fconfig.set("Kolo", 3);

                    fconfig.save(f);
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            } else if (args[1].equalsIgnoreCase("4")){
                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně změněno!");

                try {

                    fconfig.set("Kolo", 4);

                    fconfig.save(f);
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            } else if (args[1].equalsIgnoreCase("5")){
                p.sendMessage("§7[§9§lSpecial§3§lEvent§7] §aÚspěšně změněno!");

                try {

                    fconfig.set("Kolo", 5);

                    fconfig.save(f);
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            }
        } else {
            p.sendMessage("§cChybné zadání!");
        }
        return true;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pvpevent")){
            if (sender instanceof Player){
             Player p = (Player) sender;

             if (p.hasPermission("specialevent.admin")){
                 if (args.length == 0){
                     p.sendMessage("§cChybí argument: /pvpevent A/B nick");
                     return true;
                 }

                 if (args.length > 2){
                     p.sendMessage("§cChybí argument: /pvpevent A/B nick");
                 }

                 String ab = args[0];
                 if (ab.toLowerCase().equals("a") || ab.toLowerCase().equals("b") || ab.toLowerCase().equals("kolo")){

                     if (args[0].equalsIgnoreCase("a")){
                         onA(p, args);
                     } else if (args[0].equalsIgnoreCase("b")){
                         onB(p, args);
                     } else if (args[0].equalsIgnoreCase("kolo")){
                         onC(p, args);
                     }
                 } else {
                     p.sendMessage("§cChybí argument: /pvpevent A/B nick");
                 }

             } else {
                 p.sendMessage("§7[§9§lSpecial§3§lEvent§7]§cNa toto nemáš oprávnění!");
             }
            }
        }
        return true;
    }
}
