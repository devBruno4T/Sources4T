package com.devbruno.reinicio.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;
import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.configuration.file.FileConfiguration;
import com.devbruno.reinicio.Main;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.Listener;

public class General implements Listener
{
    @EventHandler
    public void onComand(final PlayerCommandPreprocessEvent e) {
        final FileConfiguration Mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean executarcomando = Mainconfig.getBoolean("ExecutarComandos");
        if (Main.isReiniciando() && !executarcomando) {
            for (final String k : Mainconfig.getStringList("ComandosBloqueados")) {
                if (e.getMessage().startsWith(k)) {
                    if (e.getMessage().equalsIgnoreCase("/cofre sair")) {
                        e.setCancelled(false);
                        return;
                    }
                    e.setCancelled(true);
                    e.getPlayer().sendMessage("§cVocê não pode executar este comando durante o reinicio.");
                }
            }
        }
    }
    
    @EventHandler
    public void onChat(final ChatMessageEvent e) {
        final FileConfiguration Mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean f = Mainconfig.getBoolean("UtilizarChat");
        if (Main.isReiniciando() && !f) {
            e.setCancelled(true);
            e.getSender().sendMessage("§cServidor está em modo de reinicio, o chat foi desativado.");
        }
    }
    
    @EventHandler
    public void blockbreak(final BlockBreakEvent e) {
        final FileConfiguration Mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean retirarblocos = Mainconfig.getBoolean("RetirarBlocos");
        if (Main.isReiniciando() && !retirarblocos) {
            e.getPlayer().sendMessage("§cVocê não pode quebrar blocos durante um reinicio.");
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void blockplace(final BlockPlaceEvent e) {
        final FileConfiguration Mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean colocarblocos = Mainconfig.getBoolean("ColocarBlocos");
        if (Main.isReiniciando() && !colocarblocos) {
            e.getPlayer().sendMessage("§cVocê não pode colocar blocos durante um reinicio.");
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        final FileConfiguration Mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean droparitens = Mainconfig.getBoolean("DroparItens");
        if (Main.isReiniciando() && !droparitens) {
            e.getPlayer().sendMessage("§cVocê não pode dropar itens em um reinicio.");
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void shit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
    }
    
    @EventHandler
    public void onOpen(final PlayerInteractEvent e) {
        final FileConfiguration Mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean utilizarenderpearl = Mainconfig.getBoolean("UtilizarEnderPearl");
        if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals((Object)Material.ENDER_PEARL) && Main.isReiniciando() && !utilizarenderpearl) {
            e.setCancelled(true);
        }
        if (e.getClickedBlock() == null) {
            return;
        }
        final Player p = e.getPlayer();
        final Boolean abrirbau = Mainconfig.getBoolean("AbrirBaus");
        final Boolean abrirbeacon = Mainconfig.getBoolean("AbrirBeacon");
        final Boolean abrirechest = Mainconfig.getBoolean("AbrirBauDoFim");
        final Boolean mesadetrabalho = Mainconfig.getBoolean("AbrirMesaDeTrabalho");
        final Boolean abrirDroppers = Mainconfig.getBoolean("AbrirDroppers");
        final Boolean abrirfornalhas = Mainconfig.getBoolean("AbrirFornalhas");
        final Boolean abrirbigornas = Mainconfig.getBoolean("AbrirBigornas");
        final Boolean AbrirDispensers = Mainconfig.getBoolean("AbrirDispensers");
        if (e.getClickedBlock().getType().equals((Object)Material.ENDER_CHEST) && !abrirechest && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir ba\u00fas do fim durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.CHEST) && !abrirbau && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir ba\u00fas durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.DROPPER) && !abrirDroppers && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir droppers durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.DISPENSER) && !AbrirDispensers && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir dispenser durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.FURNACE) && !abrirfornalhas && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir fornalha durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.ANVIL) && !abrirbigornas && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir bigornas durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.WORKBENCH) && !mesadetrabalho && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir mesas de trabalho durante um reinicio.");
            e.setCancelled(true);
        }
        if (e.getClickedBlock().getType().equals((Object)Material.BEACON) && !abrirbeacon && Main.isReiniciando()) {
            p.sendMessage("§cVoc\u00ea n\u00e3o pode abrir sinalizadores durante um reinicio.");
            e.setCancelled(true);
        }
    }
}
