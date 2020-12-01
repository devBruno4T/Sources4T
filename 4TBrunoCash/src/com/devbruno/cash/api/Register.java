package com.devbruno.cash.api;

import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import com.devbruno.cash.Main;
import org.bukkit.event.Listener;
import com.devbruno.cash.Evento;
import com.devbruno.cash.ComprarItem;
import org.bukkit.command.CommandExecutor;
import com.devbruno.cash.Comandos;

public class Register
{
    public Register() {
        this.Comandos("cash", (CommandExecutor)new Comandos());
        this.Comandos("compraritem", (CommandExecutor)new ComprarItem());
        this.Eventos((Listener)new Evento());
    }
    
    void Comandos(final String comando, final CommandExecutor classe) {
        final Main pl = Main.getPlugin();
        pl.getCommand(comando).setExecutor(classe);
    }
    
    void Eventos(final Listener classe) {
        final Main pl = Main.getPlugin();
        Bukkit.getPluginManager().registerEvents(classe, (Plugin)pl);
    }
}
