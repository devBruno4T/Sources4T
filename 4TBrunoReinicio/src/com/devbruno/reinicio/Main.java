package com.devbruno.reinicio;

import com.devbruno.reinicio.api.LoadPanel;
import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import com.devbruno.reinicio.listener.General;
import java.util.Date;
import org.bukkit.scheduler.BukkitRunnable;
import com.google.common.io.Resources;
import java.nio.charset.StandardCharsets;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import com.devbruno.reinicio.commands.ComandoReiniciar;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static boolean reiniciando;
    
    public static boolean isReiniciando() {
        return Main.reiniciando;
    }
    
    public static void setReiniciando(final boolean reiniciando) {
        Main.reiniciando = reiniciando;
    }
    
    public void onEnable() {
    	Bukkit.getConsoleSender().sendMessage("");
    	Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7| §4 4T PLUGINS");
        Bukkit.getConsoleSender().sendMessage("§7| §eDesenvolvedor: §fdevBruno4T ");
        Bukkit.getConsoleSender().sendMessage("§7|");
        Bukkit.getConsoleSender().sendMessage("§7| §eProjeto: §a4TBrunoReinicio");
        Bukkit.getConsoleSender().sendMessage("§7| §eVersão: §av1.0");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§aPlugin ligado!");
        Bukkit.getConsoleSender().sendMessage("");
        this.getCommand("reiniciar").setExecutor((CommandExecutor)new ComandoReiniciar());
        HookDependencies();
        this.saveDefaultConfig();
        try {
            final File file = new File(this.getDataFolder() + File.separator, "config.yml");
            final String allText = Resources.toString(file.toURI().toURL(), StandardCharsets.UTF_8);
            this.getConfig().loadFromString(allText);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        final Boolean reinicioautomatico = this.getConfig().getBoolean("ReiniciarAutomatico");
        if (reinicioautomatico) {
            new BukkitRunnable() {
                public void run() {
                    if (!Main.isReiniciando()) {
                        final Date date = new Date();
                        date.setTime(System.currentTimeMillis());
                        final ConfigurationSection kk = Main.this.getConfig().getConfigurationSection("Horarios");
                        for (final String keys : kk.getKeys(false)) {
                            final ConfigurationSection section = Main.this.getConfig().getConfigurationSection("Horarios." + keys);
                            final Object tempogeral = section.get("Time");
                            final String[] tempo = tempogeral.toString().split(":");
                            final int hour = Integer.parseInt(tempo[0]);
                            final int minutes = Integer.parseInt(tempo[1]);
                            if (hour == date.getHours() && minutes == date.getMinutes()) {
                                Main.this.getServer().getPluginManager().registerEvents((Listener)new General(), (Plugin)Main.getPlugin((Class)Main.class));
                                Main.setReiniciando(true);
                                Bukkit.broadcastMessage("");
                                Bukkit.broadcastMessage("§c[R] Um reinicio foi iniciado automaticamente.");
                                Bukkit.broadcastMessage("");
                                new BukkitRunnable() {
                                    public void run() {
                                        for (final Player p : Bukkit.getOnlinePlayers()) {
                                            p.kickPlayer("\n§c§l4T - PLUGINS | REINICIO\n\n§cO servidor está reiniciando.\n\n§3Para mais informa\u00e7\u00f5es acesse nosso discord.");
                                        }
                                        Bukkit.getServer().spigot().restart();
                                    }
                                }.runTaskLater((Plugin)Main.getPlugin((Class)Main.class), 1800L);
                                new BukkitRunnable() {
                                    public void run() {
                                        Bukkit.broadcastMessage("");
                                        Bukkit.broadcastMessage("§c[R] O servidor será reiniciado em 1s");
                                        Bukkit.broadcastMessage("");
                                    }
                                }.runTaskLaterAsynchronously((Plugin)Main.getPlugin((Class)Main.class), 1780L);
                                new BukkitRunnable() {
                                    public void run() {
                                        Bukkit.broadcastMessage("");
                                        Bukkit.broadcastMessage("§c[R] O servidor será reiniciado em 2s");
                                        Bukkit.broadcastMessage("");
                                    }
                                }.runTaskLaterAsynchronously((Plugin)Main.getPlugin((Class)Main.class), 1760L);
                                new BukkitRunnable() {
                                    public void run() {
                                        Bukkit.broadcastMessage("");
                                        Bukkit.broadcastMessage("§c[R] O servidor será reiniciado em 3s");
                                        Bukkit.broadcastMessage("");
                                    }
                                }.runTaskLaterAsynchronously((Plugin)Main.getPlugin((Class)Main.class), 1740L);
                            }
                        }
                    }
                    else {
                        this.cancel();
                    }
                }
            }.runTaskTimerAsynchronously((Plugin)getPlugin((Class)Main.class), 0L, 20L);
        }
        this.getServer().getPluginManager().registerEvents((Listener)new LoadPanel(), (Plugin)this);
    }
    
    public static void HookDependencies() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Legendchat") == null) {
            Bukkit.getConsoleSender().sendMessage("§cErro, não foi possível localizar o LegendChat.");
            ((Main)getPlugin((Class)Main.class)).onDisable();
        }
    }
    
    public void onDisable() {
    	Bukkit.getConsoleSender().sendMessage("");
    	Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7| §4 4T PLUGINS");
        Bukkit.getConsoleSender().sendMessage("§7| §eDesenvolvedor: §fdevBruno4T ");
        Bukkit.getConsoleSender().sendMessage("§7|");
        Bukkit.getConsoleSender().sendMessage("§7| §eProjeto: §a4TBrunoReinicio");
        Bukkit.getConsoleSender().sendMessage("§7| §eVersão: §av1.0");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§aPlugin desligado!");
        Bukkit.getConsoleSender().sendMessage("");
    }
    
    static {
        Main.reiniciando = false;
    }
}
