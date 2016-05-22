/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.minecoin;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Joel
 */
public class Main extends JavaPlugin {
    
    private Connection connection;
    private String host, database, username, password;
    private int port;
    
    @Override
    public void onEnable() {
        getLogger().info("MineCoin plugin enabled correctly!");
        createConfig();
        FileConfiguration config = this.getConfig();
        host = config.getString("MySQL.Host");
        database = config.getString("MySQL.DataBase");
        username = config.getString("MySQL.Username");
        password = config.getString("MySQL.Password");
        
        try {
            openConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
        }
        synchronized(this) {
            if (connection != null && connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.host+ ":" + this.port + "/" + this.database, this.username, this.password);
        }
    }
}
