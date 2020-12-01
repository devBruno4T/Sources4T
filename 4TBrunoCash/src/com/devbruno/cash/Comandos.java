package com.devbruno.cash;

import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import java.text.DecimalFormat;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Comandos extends Metodos implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lb, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("cash")) {
            if (args.length == 0) {
                if (sender instanceof Player) {
                    final Player p = (Player)sender;
                    final DecimalFormat formatador = new DecimalFormat(",###.##");
                    final String valorFormatado = formatador.format(Metodos.get(p.getName()));
                    p.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fVoc\u00ea tem §e" + valorFormatado + " §fde cash.");
                    return true;
                }
                sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cApenas jogadores!");
            }
            if (!sender.hasPermission("bruno.cash.admin")) {
                sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§aVoc\u00ea n\u00e3o tem permiss\u00e3o para isso.");
                return true;
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args.length < 3) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cUse: §f/cash set §7<player, quantia>");
                        return true;
                    }
                    final String target = String.valueOf(args[1]);
                    Double quantia;
                    try {
                        quantia = Double.parseDouble(args[2]);
                    }
                    catch (NumberFormatException e) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cDigite um numero valido!");
                        return true;
                    }
                    Metodos.set(target, quantia);
                    sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§aVoce setou o cash do jogador §f" + target + "§a para §f" + quantia);
                    return true;
                }
                else if (args[0].equalsIgnoreCase("add")) {
                    if (args.length < 3) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cUse: §f/cash add §7<player, quantia>");
                        return true;
                    }
                    final String target = String.valueOf(args[1]);
                    Double quantia;
                    try {
                        quantia = Double.parseDouble(args[2]);
                    }
                    catch (NumberFormatException e) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cDigite um numero valido!");
                        return true;
                    }
                    Metodos.add(target, quantia);
                    sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§aVoce adicionou §f" + quantia + "§a de cash na conta §f" + target);
                    return true;
                }
                else if (args[0].equalsIgnoreCase("remove")) {
                    if (args.length < 3) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cUse: §f/cash remove §7<player, quantia>");
                        return true;
                    }
                    final String target = String.valueOf(args[1]);
                    Double quantia;
                    try {
                        quantia = Double.parseDouble(args[2]);
                    }
                    catch (NumberFormatException e) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cDigite um numero valido!");
                        return true;
                    }
                    Metodos.remove(target, quantia);
                    sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§aVoce removeu §f" + quantia + "§a de cash da conta §f" + target);
                    return true;
                }
            }
            if (args[0].equalsIgnoreCase("pay") || args[0].equalsIgnoreCase("enviar")) {
                if (sender instanceof Player) {
                    final Player p = (Player)sender;
                    if (args.length < 3) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fUse /cash pay <player> <quantia>");
                        return true;
                    }
                    final String target2 = String.valueOf(args[1]);
                    if (!Metodos.contains(target2)) {
                        p.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fEsse jogador n\u00e3o se encontra em nosso banco de dados.");
                        return true;
                    }
                    Double quantia2;
                    try {
                        quantia2 = Double.parseDouble(args[2]);
                    }
                    catch (NumberFormatException e2) {
                        sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cDigite um numero valido!");
                        return true;
                    }
                    final double total = Metodos.get(p.getName()) - quantia2;
                    if (total < 0.0) {
                        p.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cVoc\u00ea n\u00e3o tem cashs suficientes!");
                        return true;
                    }
                    if (quantia2 <= 0.0) {
                        p.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cDigite um n\u00famero acima de 0.");
                        return true;
                    }
                    Metodos.add(target2, quantia2);
                    Metodos.remove(p.getName(), quantia2);
                    p.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fVoc\u00ea enviou §e" + quantia2 + "§f de cash para o jogador §e" + target2);
                    final Player recebidor = Bukkit.getPlayerExact(target2);
                    if (recebidor != null && recebidor.isOnline()) {
                        recebidor.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fVoc\u00ea recebeu §e" + quantia2 + "§f de cash do jogador §e" + p.getName());
                    }
                }
                else {
                    sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§cApenas para jogadores!");
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("top")) {
                final List<String> top = Metodos.getTops();
                sender.sendMessage("   §6§lTOP CASH §f- Jogadores com mais cash");
                sender.sendMessage("             §7(Atualiza a cada 5 minutos)");
                sender.sendMessage("");
                for (final String mensagens : top) {
                    sender.sendMessage(mensagens);
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("?")) {
            	sender.sendMessage("");
            	sender.sendMessage("§6§lCOMANDOS - CASH");
            	sender.sendMessage("");
            	sender.sendMessage("§e/cash set §f<jogador> <quantia>");
            	sender.sendMessage("§e/cash add §f<jogador> <quantia>");
            	sender.sendMessage("§e/cash remove §f<jogador> <quantia>");
            	sender.sendMessage("§e/cash pay §f<jogador> <quantia>");
            	sender.sendMessage("§e/cash top §ftop jogadores com mais cash");
            	sender.sendMessage("");
                return true;
            }
            final String target = String.valueOf(args[0]);
            if (!Metodos.contains(target)) {
                sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fEsse jogador n\u00e3o se encontra em nosso banco de dados.");
                return true;
            }
            sender.sendMessage(String.valueOf(String.valueOf(Comandos.prefix)) + "§fO jogador §e" + target + "§f tem §e" + Metodos.get(target) + "§f de cash.");
        }
        return false;
    }
}
