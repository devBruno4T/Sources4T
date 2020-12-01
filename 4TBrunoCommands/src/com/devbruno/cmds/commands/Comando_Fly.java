package com.devbruno.cmds.commands;

import org.bukkit.Bukkit;
import com.devbruno.cmds.api.ActionBar;
import org.bukkit.Sound;
import com.devbruno.cmds.util.CommandsManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Comando_Fly implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            CommandsManager.onlyConsole(sender);
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("4tplugins.fly")) {
            p.sendMessage("");
            p.sendMessage("§c§lFLY!");
            p.sendMessage("§cVocê necessita ser vip no servidor");
            p.sendMessage("§cpara poder usar este comando.");
            p.sendMessage("");
            p.sendMessage("§cAdquira vip em §eloja.seuservidor.com");
            p.sendMessage("");
            p.playSound(p.getLocation(), Sound.CAT_MEOW, 1.0f, 0.5f);
            return true;
        }
        if (args.length > 1) {
            p.sendMessage("");
            p.sendMessage("§c§lFLY! §cUtilize /fly <jogador>");
            p.sendMessage("");
            ActionBar.sendActionBarMessage(p, "§cUutilize /fly  <jogador>");
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0f, 4.0f);
        }
        if (args.length == 0) {
            if (!p.getAllowFlight()) {
                p.setAllowFlight(true);
                p.sendMessage("");
                p.sendMessage("§a§lFLY! §aModo voar ativado com sucesso.");
                p.sendMessage("");
                ActionBar.sendActionBarMessage(p, "§aVoc\u00ea est\u00e1 agora no modo Fly");
                p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10.0f, 4.0f);
            }
            else {
                p.setAllowFlight(false);
                p.sendMessage("");
                p.sendMessage("§c§lFLY! §cModo voar desligado com sucesso.");
                p.sendMessage("");
                ActionBar.sendActionBarMessage(p, "§cSeu modo fly foi desligado");
                p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10.0f, 4.0f);
            }
        }
        if (args.length == 1) {
            final Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                CommandsManager.notOnline(p);
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0f, 4.0f);
            }
            else if (target.getAllowFlight()) {
                target.setAllowFlight(false);
                p.sendMessage("§a A habilidade de vo\u00f4 de " + args[0] + "foi desabilitada com sucesso.");
                ActionBar.sendActionBarMessage(p, "§aA habilidade de vo\u00f4 de " + args[0] + " foi desabilitada com sucesso.");
                p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10.0f, 4.0f);
            }
            else {
                target.setAllowFlight(true);
                p.sendMessage("§a A habilidade de vo\u00f4 de " + args[0] + "foi habilitada com sucesso.");
                ActionBar.sendActionBarMessage(p, "§a A habilidade de vo\u00f4 de " + args[0] + " foi habilitada com sucesso.");
                p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10.0f, 4.0f);
            }
        }
        return false;
    }
}
