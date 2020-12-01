package com.devbruno.cmds.commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import com.devbruno.cmds.api.ActionBar;
import com.devbruno.cmds.util.CommandsManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.devbruno.cmds.Main;
import org.bukkit.command.CommandExecutor;

public class Comando_Gamemode implements CommandExecutor
{
    private Main plugin;
    
    public Comando_Gamemode() {
        this.plugin = Main.getInstance();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            CommandsManager.onlyConsole(sender);
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
            if (!CommandsManager.canDo(p, "gm") || !CommandsManager.canDo(p, "gamemode")) {
                CommandsManager.noPerm(p);
            }
            else {
                if (args.length > 2) {
                    p.sendMessage("");
                    p.sendMessage("§cUtilize §c/gamemode <modo>");
                    p.sendMessage("");
                    ActionBar.sendActionBarMessage(p, "§c Utilize /gamemode <modo> <jogador>");
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0f, 9.0f);
                    return true;
                }
                if (args.length == 0) {
                    if (p.getGameMode() == GameMode.SURVIVAL) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lCRIATIVO!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eCriativo");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lNORMAL");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eNormal");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                }
                if (args.length == 1) {
                    final String modo = args[0].toLowerCase();
                    if (modo.equals("s") || modo.equals("survival") || modo.equals("sobrevivencia") || modo.equals("0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lNORMAL!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eNormal");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else if (modo.equals("c") || modo.equals("creative") || modo.equals("creativo") || modo.equals("1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lCRIATIVO!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eCriativo");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else if (modo.equals("a") || modo.equals("adventure") || modo.equals("aventura") || modo.equals("2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lAVENTURA!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eAventura");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else if (modo.equals("spc") || modo.equals("spectator") || modo.equals("spectador") || modo.equals("3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lESPECTADOR!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eEspectador");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else {
                        p.sendMessage("");
                        p.sendMessage("§cUtilize §c/gamemode <modo>");
                        p.sendMessage("");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0f, 8.0f);
                    }
                }
                if (args.length == 2) {
                    final String modo = args[0].toLowerCase();
                    if (modo.equals("s") || modo.equals("survival") || modo.equals("sobrevivencia") || modo.equals("0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lNORMAL!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eNORMAL");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else if (modo.equals("c") || modo.equals("creative") || modo.equals("creativo") || modo.equals("1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lCRIATIVO!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eCriativo");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else if (modo.equals("a") || modo.equals("adventure") || modo.equals("aventura") || modo.equals("2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lAVENTURA!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eAventura");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else if (modo.equals("spc") || modo.equals("spectator") || modo.equals("spectador") || modo.equals("3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage("");
                        p.sendMessage("§a§lMODO! §aSeu modo de jogo foi alterado para §e§lESPECTADOR!");
                        p.sendMessage("");
                        ActionBar.sendActionBarMessage(p, "§a Voc\u00ea est\u00e1 agora no modo §eEspectador");
                        p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 59.0f);
                    }
                    else {
                        p.sendMessage("");
                        p.sendMessage("§cUtilize /gamemode <modo>");
                        p.sendMessage("");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0f, 8.0f);
                    }
                }
            }
        }
        return false;
    }
}
