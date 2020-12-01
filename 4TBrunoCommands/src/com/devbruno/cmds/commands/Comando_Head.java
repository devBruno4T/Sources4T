package com.devbruno.cmds.commands;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.SkullType;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Comando_Head implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lb, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("cabeca")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            final Player p = (Player)sender;
            if (!p.hasPermission("4tplugins.head")) {
                p.sendMessage("");
                p.sendMessage("§c§lOPS! §cVoc\u00ea n\u00e3o tem permiss\u00f5es suficientes.");
                p.sendMessage("");
                p.playSound(p.getLocation(), Sound.CAT_MEOW, 1.0f, 0.5f);
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage(" §c§lSKULLS §cUtilize /cabeca <jogador>.");
                p.sendMessage("");
                return true;
            }
            if (args.length == 1) {
                final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
                final SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(args[0]);
                skull.setItemMeta((ItemMeta)meta);
                p.getInventory().addItem(new ItemStack[] { skull });
                p.sendMessage("");
                p.sendMessage("§a§lSKULLS! §aCabe\u00e7a de §f" + args[0] + " §arecebida com sucesso!");
                p.sendMessage("");
                return true;
            }
        }
        return true;
    }
}
