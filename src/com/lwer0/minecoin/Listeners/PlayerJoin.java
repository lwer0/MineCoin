/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwer0.minecoin.Listeners;

import com.lwer0.minecoin.API;
import com.lwer0.minecoin.Main;
import java.sql.SQLException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    
    private final Main plugin;

    public PlayerJoin(Main instance) {
        plugin = instance;
    }
    
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) throws SQLException {
        Player p = (Player) e.getPlayer();
        API.CreateProfile(p);
    }
}
