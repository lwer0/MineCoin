/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.minecoin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Joel
 */
public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("MineCoin plugin enabled correctly!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("MineCoin plugin disabled correctly!");
    }
    
    
}
