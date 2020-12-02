package com.devbruno.reinicio.commands;

import com.devbruno.reinicio.api.LoadPanel;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ComandoReiniciar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("reiniciar")) {
            final Player p = (Player)sender;
            if (p.hasPermission("4treiniciar.reinicio")) {
                if (args.length == 0) {
                    LoadPanel.openPanel(p);
                    return true;
                }
                if (args.length == 1) {
                    p.sendMessage("§cUtilize /reiniciar");
                }
            }
            else {
                p.sendMessage("§cVocê precisa do cargo §cAdmin §cpara executar este comando.");
            }
            return true;
        }
        return false;
    }
}
