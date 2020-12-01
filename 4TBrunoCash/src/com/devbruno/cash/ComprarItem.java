package com.devbruno.cash;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ComprarItem implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lb, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("compraritem")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cComando bloqueado via console.");
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "Use: /compraritem (Nome do Item)");
                return true;
            }
            final String ITEM = args[0];
            if (Main.getPlugin().getConfig().contains("Itens." + ITEM)) {
                final Double cash = Main.getPlugin().getConfig().getDouble("Itens." + ITEM + ".Custo");
                if (!p.hasPermission("bruno.cash.item." + ITEM)) {
                    p.sendMessage("§cVocê não possui permissão para comprar este item!");
                    return true;
                }
                if (Metodos.get(p.getName()) >= cash) {
                    for (final String s : Main.getPlugin().getConfig().getStringList("Itens." + ITEM + ".Comandos")) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), s.replace("<player>", p.getName()));
                    }
                    Metodos.remove(p.getName(), cash);
                    p.sendMessage(Main.getPlugin().getConfig().getString("Itens." + ITEM + ".Mensagem").replace("&", "§"));
                }
                else {
                    p.sendMessage("§cVocê não tem cash suficiente!");
                }
            }
            else {
                p.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§aItem Inexistente.");
            }
        }
        return false;
    }
}
