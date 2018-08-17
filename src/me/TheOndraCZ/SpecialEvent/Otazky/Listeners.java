package me.TheOndraCZ.SpecialEvent.Otazky;

import me.TheOndraCZ.SpecialEvent.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class Listeners implements Listener{

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        File file = new File(Main.getPl().getDataFolder(), "Test");
        File f = new File(file, "Otazky.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        if (e.getInventory().getTitle().equals("§4§lOtázky §7strana 1")){
            e.setCancelled(true);

            if (e.getSlot() == 53){
                Main.getOtazky().onGuia(p);
            } else if (e.getSlot() == 45){
                p.closeInventory();
            }

                int click = e.getSlot();

                    if (click == 45){
                        p.closeInventory();
                    }else if (click == 53){
                        Main.getOtazky().onGuia(p);
                    }else if (click == 8 || click == 9 || click == 17 || click == 18 || click == 26 || click == 27 || click == 35 || click == 36 || click == 44){
                        return;
                    } else {
                    if (e.isRightClick()){
                        p.closeInventory();
                        p.sendMessage("§7--- §6§lOtázka č."+ config.getInt(click + ".Cislo") + " §7---");
                        p.sendMessage("   §4§4(viditelné jen pro Tebe)");
                        p.sendMessage(config.getString(click + ".Otazka"));
                        p.sendMessage("§9A) §2§l" + config.getString(click + ".OdpovedA"));
                        p.sendMessage("§9B) §2§l" + config.getString(click + ".OdpovedB"));
                        p.sendMessage("§9C) §2§l" + config.getString(click + ".OdpovedC"));
                        p.sendMessage("§9D) §2§l" + config.getString(click + ".OdpovedD"));
                        p.sendMessage("§7Otázka za §6"+ config.getInt(click + ".Body") + "body");
                    } else if (e.isLeftClick()){
                        p.closeInventory();

                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§7--- §6§lOtázka č." + config.getInt(click + ".Cislo") + "§7---");
                            players.sendMessage(config.getString(click + ".Otazka"));
                            players.sendMessage("§9A) §2§l" + config.getString(click + ".OdpovedA"));
                            players.sendMessage("§9B) §2§l" + config.getString(click + ".OdpovedB"));
                            players.sendMessage("§9C) §2§l" + config.getString(click + ".OdpovedC"));
                            players.sendMessage("§9D) §2§l" + config.getString(click + ".OdpovedD"));
                            players.sendMessage("§7Otázka za §6" + config.getInt(click + ".Body") + " body");
                        }
                    }
                }
        } else if (e.getInventory().getTitle().equals("§4§lOtázky §7strana 2")){
            e.setCancelled(true);

            if (e.getSlot() == 53){
                p.closeInventory();
            } else if (e.getSlot() == 45){
                Main.getOtazky().onGui(p);
            }
        } else if (e.getInventory().getTitle().equals("§4§lOdpovědi na otázky §7strana 1")){
            e.setCancelled(true);


            int click = e.getSlot();

            if (click == 45){
                p.closeInventory();
            } else if (click == 53){
                Main.getOtazky().onGuia(p);
            } else if (click == 8 || click == 9 || click == 17 || click == 18 || click == 26 || click == 27 || click == 35 || click == 36 || click == 44){
                return;
            } else {

                    p.closeInventory();
                    if (config.getString(click + ".SpravnaOdpoved").equals("A")){
                        int i = config.getInt(click + ".Body");

                        for (Player players : Bukkit.getOnlinePlayers()){

                Location loc = new Location(players.getLocation().getWorld(), players.getLocation().getBlockX(), players.getLocation().getBlockY() - 1, players.getLocation().getBlockZ());

                Block block = loc.getBlock();

                ItemStack item = new ItemStack(block.getType(),1,block.getData());

                if (item.getType() == Material.CONCRETE && item.getData().getData() == 13){
                    File fil = new File(Main.getPl().getDataFolder(), "Test");
                    File file1 = new File(fil, "Players");
                    File f1 = new File(file1, players.getName() + ".yml");
                    YamlConfiguration config1 = YamlConfiguration.loadConfiguration(f1);

                    int in = config1.getInt("Body") + i;
                    try {

                        config1.set("Body", in);

                        config1.save(f1);
                    } catch (IOException exception){
                        exception.printStackTrace();
                    }
                }

                        }
                    } else if (config.getString(click + ".SpravnaOdpoved").equals("B")){
                        int i = config.getInt(click + ".Body");

                        for (Player players : Bukkit.getOnlinePlayers()){

                            Location loc = new Location(players.getLocation().getWorld(), players.getLocation().getBlockX(), players.getLocation().getBlockY() - 1, players.getLocation().getBlockZ());

                            Block block = loc.getBlock();

                            ItemStack item = new ItemStack(block.getType(),1,block.getData());

                            if (item.getType() == Material.CONCRETE && item.getData().getData() == 4){
                                File fil = new File(Main.getPl().getDataFolder(), "Test");
                                File file1 = new File(fil, "Players");
                                File f1 = new File(file1, players.getName() + ".yml");
                                YamlConfiguration config1 = YamlConfiguration.loadConfiguration(f1);

                                int in = config1.getInt("Body") + i;
                                try {

                                    config1.set("Body", in);

                                    config1.save(f1);
                                } catch (IOException exception){
                                    exception.printStackTrace();
                                }
                            }

                        }
                    } else if (config.getString(click + ".SpravnaOdpoved").equals("C")){
                        int i = config.getInt(click + ".Body");

                        for (Player players : Bukkit.getOnlinePlayers()){

                            Location loc = new Location(players.getLocation().getWorld(), players.getLocation().getBlockX(), players.getLocation().getBlockY() - 1, players.getLocation().getBlockZ());

                            Block block = loc.getBlock();

                            ItemStack item = new ItemStack(block.getType(),1,block.getData());

                            if (item.getType() == Material.CONCRETE && item.getData().getData() == 11){
                                File fil = new File(Main.getPl().getDataFolder(), "Test");
                                File file1 = new File(fil, "Players");
                                File f1 = new File(file1, players.getName() + ".yml");
                                YamlConfiguration config1 = YamlConfiguration.loadConfiguration(f1);

                                int in = config1.getInt("Body") + i;
                                try {

                                    config1.set("Body", in);

                                    config1.save(f1);
                                } catch (IOException exception){
                                    exception.printStackTrace();
                                }
                            }

                        }
                    } else if (config.getString(click + ".SpravnaOdpoved").equals("D")){
                        int i = config.getInt(click + ".Body");

                        for (Player players : Bukkit.getOnlinePlayers()){

                            Location loc = new Location(players.getLocation().getWorld(), players.getLocation().getBlockX(), players.getLocation().getBlockY() - 1, players.getLocation().getBlockZ());

                            Block block = loc.getBlock();

                            ItemStack item = new ItemStack(block.getType(),1,block.getData());

                            if (item.getType() == Material.CONCRETE && item.getData().getData() == 11){
                                File fil = new File(Main.getPl().getDataFolder(), "Test");
                                File file1 = new File(fil, "Players");
                                File f1 = new File(file1, players.getName() + ".yml");
                                YamlConfiguration config1 = YamlConfiguration.loadConfiguration(f1);

                                int in = config1.getInt("Body") + i;
                                try {

                                    config1.set("Body", in);

                                    config1.save(f1);
                                } catch (IOException exception){
                                    exception.printStackTrace();
                                }
                            }

                        }
                    }
            }
        }
    }
}
