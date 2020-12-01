package com.devbruno.cmds;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherChangeEvent;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import com.devbruno.cmds.commands.Comando_Clear;
import com.devbruno.cmds.commands.Comando_Fly;
import com.devbruno.cmds.commands.Comando_Head;

import org.bukkit.command.CommandExecutor;
import com.devbruno.cmds.commands.Comando_Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    int count;
    
    public Main() {
        this.count = 1;
    }
    
    public void onEnable() {
    	Bukkit.getConsoleSender().sendMessage("");
    	Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7| §4 4T PLUGINS");
        Bukkit.getConsoleSender().sendMessage("§7| §eDesenvolvedor: §fdevBruno4T ");
        Bukkit.getConsoleSender().sendMessage("§7|");
        Bukkit.getConsoleSender().sendMessage("§7| §eProjeto: §a4TBrunoCommands");
        Bukkit.getConsoleSender().sendMessage("§7| §eVersão: §av1.0");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§aPlugin ligado!");
        Bukkit.getConsoleSender().sendMessage("");
        this.getCommand("gamemode").setExecutor((CommandExecutor)new Comando_Gamemode());
        this.getCommand("gm").setExecutor((CommandExecutor)new Comando_Gamemode());
        this.getCommand("cabeca").setExecutor((CommandExecutor)new Comando_Head());
        this.getCommand("fly").setExecutor((CommandExecutor)new Comando_Fly());
        this.getCommand("clear").setExecutor((CommandExecutor)new Comando_Clear());
    }
    
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks((Plugin)this);
        HandlerList.unregisterAll((Plugin)this);
        for (final Player tds : Bukkit.getOnlinePlayers()) {
        	Bukkit.getConsoleSender().sendMessage("");
        	Bukkit.getConsoleSender().sendMessage("");
            Bukkit.getConsoleSender().sendMessage("§7| §4 4T PLUGINS");
            Bukkit.getConsoleSender().sendMessage("§7| §eDesenvolvedor: §fdevBruno4T ");
            Bukkit.getConsoleSender().sendMessage("§7|");
            Bukkit.getConsoleSender().sendMessage("§7| §eProjeto: §a4TBrunoCommands");
            Bukkit.getConsoleSender().sendMessage("§7| §eVersão: §av1.0.0");
            Bukkit.getConsoleSender().sendMessage("");
            Bukkit.getConsoleSender().sendMessage("§cPlugin desligado!");
            Bukkit.getConsoleSender().sendMessage("");
        }
    }
    
    public static final Main get() {
        return (Main)JavaPlugin.getPlugin((Class)Main.class);
    }
    
    public void onPluginMessageReceived1(final String channel, final Player receiver, final byte[] msg) {
        if (channel.equals("WDL|INIT")) {
            receiver.kickPlayer("§c§l4T PLUGINS \n \n §cVoc\u00ea foi kikado! \n \n §cModifica\u00e7ao detectada: World Donwloader");
        }
    }
    
    @EventHandler
    public void SemChuva(final WeatherChangeEvent e) {
        if (this.getConfig().getBoolean("nao_chover." + e.getWorld().getName()) && e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00e9 s\u00f3 pode utilizar este comando dentro do jogo.");
            return false;
        }
        final Player jogador = (Player)sender;
        if (cmd.equalsIgnoreCase("s") || cmd.equalsIgnoreCase("staff")) {
            if (args.length == 0) {
                if (jogador.hasPermission("magic.staff")) {
                    jogador.sendMessage("");
                    jogador.sendMessage("§c§lSTAFF CHAT! §cUtilize /staff <mensagem> para enviar uma mensagem.");
                    jogador.sendMessage("");
                    return true;
                }
                SemPermissaoAJD(jogador);
            }
            if (jogador.hasPermission("magic.staff")) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < args.length; ++i) {
                    sb.append(args[i]);
                    if (i < args.length) {
                        sb.append(" ");
                    }
                }
                final PermissionUser User = PermissionsEx.getUser(jogador);
                for (final Player staff : Bukkit.getOnlinePlayers()) {
                    if (staff.hasPermission("magic.staff")) {
                        staff.sendMessage("§d§l[STAFF]§7 (R.Farm) §f" + User.getPrefix().replace("&", "§") + jogador.getName() + ": §f" + sb.toString());
                    }
                }
            }
            else {
                SemPermissaoAJD(jogador);
            }
        }
        return false;
    }
    
    public static void SemPermissaoAJD(final Player jogador) {
        jogador.sendMessage("");
        jogador.sendMessage("§cVoc\u00ea precisa ser do grupo §e[Ajudante] §cou superior para executar este comando.");
        jogador.sendMessage("");
    }
    
    public static Main getInstance() {
        return null;
    }
}
