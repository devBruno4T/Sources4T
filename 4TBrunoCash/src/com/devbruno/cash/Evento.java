package com.devbruno.cash;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class Evento implements Listener
{
    @EventHandler
    void evento(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (!Metodos.contains(p.getName())) {
            Metodos.setPlayer(p.getName());
            Metodos.add(p.getName(), 0.0);
        }
    }
}
