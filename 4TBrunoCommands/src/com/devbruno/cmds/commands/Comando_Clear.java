package com.devbruno.cmds.commands;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import com.devbruno.cmds.api.ActionBar;
import com.devbruno.cmds.util.CommandsManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.devbruno.cmds.Main;
import org.bukkit.command.CommandExecutor;

public class Comando_Clear implements CommandExecutor
{
    private Main plugin;
    
    public Comando_Clear() {
        this.plugin = Main.getInstance();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            CommandsManager.onlyConsole(sender);
            return true;
        }
        if (command.getName().equalsIgnoreCase("clear")) {
            if (!CommandsManager.canDo(p, "clear")) {
                CommandsManager.noPerm(p);
            }
            else if (args.length > 1) {
                p.sendMessage("");
                p.sendMessage("§a§lCLEAR §aUtilize /clear <jogador>");
                p.sendMessage("");
                ActionBar.sendActionBarMessage(p, "§aUtilize /clear <jogador>");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 9.0f, 4.0f);
            }
            else {
                Player target = p;
                if (args.length == 1) {
                    target = Bukkit.getPlayer(args[0]);
                }
                if (target == null) {
                    CommandsManager.notOnline(p);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0f, 4.0f);
                    return true;
                }
                target.getInventory().clear();
                target.getEquipment().setArmorContents((ItemStack[])null);
                target.sendMessage("");
                target.sendMessage("§a§lCLEAR! §aInvent\u00e1rio limpo com sucesso.");
                target.sendMessage("");
                ActionBar.sendActionBarMessage(target, "§aInvent\u00e1rio limpo com sucesso.");
                target.playSound(target.getLocation(), Sound.ITEM_PICKUP, 9.0f, 10.0f);
                if (!target.getName().equalsIgnoreCase(p.getName())) {
                    target.sendMessage("§a O invent\u00e1rio do " + target.getName() + " foi limpo com sucesso.");
                    ActionBar.sendActionBarMessage(target, "§aO invent\u00e1rio do " + target.getName() + " foi limpo com sucesso.");
                    target.playSound(target.getLocation(), Sound.ITEM_PICKUP, 9.0f, 10.0f);
                }
            }
        }
        return true;
    }
}
