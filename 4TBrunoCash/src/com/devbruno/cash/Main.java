package com.devbruno.cash;

import com.devbruno.cash.api.Register;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public void onEnable() {
    	Bukkit.getConsoleSender().sendMessage("");
    	Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7| §4 4T PLUGINS");
        Bukkit.getConsoleSender().sendMessage("§7| §eDesenvolvedor: §fdevBruno4T ");
        Bukkit.getConsoleSender().sendMessage("§7|");
        Bukkit.getConsoleSender().sendMessage("§7| §eProjeto: §a4TBrunoCash");
        Bukkit.getConsoleSender().sendMessage("§7| §eVersão: §av1.0");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§aPlugin ligado!");
        Bukkit.getConsoleSender().sendMessage("");
        this.saveDefaultConfig();
        new Register();
        Conexao.open();
        Conexao.createTable();
    }
    
    public void onDisable() {
    	Bukkit.getConsoleSender().sendMessage("");
    	Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7| §4 4T PLUGINS");
        Bukkit.getConsoleSender().sendMessage("§7| §eDesenvolvedor: §fdevBruno4T ");
        Bukkit.getConsoleSender().sendMessage("§7|");
        Bukkit.getConsoleSender().sendMessage("§7| §eProjeto: §a4TBrunoCash");
        Bukkit.getConsoleSender().sendMessage("§7| §eVersão: §av1.0.0");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§cPlugin desligado!");
        Bukkit.getConsoleSender().sendMessage("");
    }
    
    public static Main getPlugin() {
        return (Main)getPlugin((Class)Main.class);
    }
}
