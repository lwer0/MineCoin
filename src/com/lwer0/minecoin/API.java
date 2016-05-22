/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.minecoin;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author Joel
 */
public class API {
    private final Main plugin;
    
    public API (Main instance) {
        plugin = instance;
    }
    
    public static void CreateProfile(Player p) throws SQLException {
        if (Main.getConnection() != null) {
            try {
                Connection c = Main.getConnection();
                Statement check = (Statement) c.createStatement();
                
                check.executeUpdate("INSERT INTO PlayerData (PLAYER_UUID, PLAYERNAME, BALANCE) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', " + Main.getInCoins() + ");");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
