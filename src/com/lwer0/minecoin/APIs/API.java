package com.lwer0.minecoin.APIs;

import com.lwer0.minecoin.Main;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

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
    
    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    
    public static String prefix() {
        return color("&6[&aMinecoin&6] &e");
    }
    
    public static String noPerm() {
        return "&4You don't have permission to do that!";
    }
    
    public static String coins() {
        return "&aHello";
    }
    
}
