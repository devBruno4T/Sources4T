package com.devbruno.cmds.util;

import org.bukkit.command.CommandSender;
import org.bukkit.Sound;
import com.devbruno.cmds.api.ActionBar;
import org.bukkit.entity.Player;

public class CommandsManager
{
    public static boolean canDo(final Player player, final String name) {
        return player.hasPermission("4tplugins.comando." + name.toLowerCase()) || player.isOp() || player.hasPermission("4tplugins.comando.*");
    }
    
    public static void noPerm(final Player p) {
        p.sendMessage("§c Voc\u00ea n\u00e3o tem acesso a esse comando.");
        ActionBar.sendActionBarMessage(p, "§cVoc\u00ea n\u00e3o tem acesso a esse comando.");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 9.0f, 7.0f);
    }
    
    public static void onlyConsole(final CommandSender sender) {
        sender.sendMessage("§c Este comando \u00e9 apenas para jogadores in-game.");
    }
    
    public static void notOnline(final Player p) {
        p.sendMessage("§c Procuramos por todo o lado, mas n\u00e3o encontramos esse jogador.");
        ActionBar.sendActionBarMessage(p, "§cProcuramos por todo o lado, mas n\u00e3o encontramos esse jogador.");
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 9.0f, 7.0f);
    }
    
    public static void notOnline(final CommandSender sender) {
        sender.sendMessage("§c Procuramos por todo o lado mas n\u00e3o encontramos esse jogador.");
    }
}
