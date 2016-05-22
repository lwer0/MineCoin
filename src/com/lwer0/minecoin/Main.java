/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.minecoin;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Joel
 */
public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("MineCoin plugin enabled correctly!");
        createConfig();
    }
    
    @Override
    public void onDisable() {
        getLogger().info("MineCoin plugin disabled correctly!");
    }
    
    public void createConfig() {
        File config = new File(getDataFolder(), "config.yml");
        
        if(!getDataFolder().exists()) {
            saveDefaultConfig();
        } else {
            if (!config.exists()) {
                saveDefaultConfig();
            }
        }
    }
}
