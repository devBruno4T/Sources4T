package com.devbruno.reinicio.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.event.EventHandler;
import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import java.util.Iterator;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.Plugin;
import com.devbruno.reinicio.listener.General;
import org.bukkit.Bukkit;
import com.devbruno.reinicio.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class LoadPanel implements Listener
{
    public static int taskid;
    public static int taskid2;
    public static int taskid3;
    public static int taskid4;
    
    @EventHandler
    public void onCLick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase("Painel de controle - reinicio")) {
            e.setCancelled(true);
            if (e.getRawSlot() == 10) {
                if (Main.isReiniciando()) {
                    p.sendMessage("§c[R] §cO servidor já está reiniciando.");
                    return;
                }
                Bukkit.getServer().getPluginManager().registerEvents((Listener)new General(), (Plugin)Main.getPlugin((Class)Main.class));
                Main.setReiniciando(true);
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§c[R] Um reinicio foi iniciado por um administrador!");
                Bukkit.broadcastMessage("");
                new BukkitRunnable() {
                    public void run() {
                        LoadPanel.taskid = this.getTaskId();
                        for (final Player p : Bukkit.getOnlinePlayers()) {
                            p.kickPlayer("\n§c§l4T - PLUGINS | REINICIO\n\n§cO servidor está reiniciando.\n\n§3Para mais informa\u00e7\u00f5es acesse nosso discord.");
                        }
                        Bukkit.getServer().spigot().restart();
                    }
                }.runTaskLater((Plugin)Main.getPlugin((Class)Main.class), 1800L);
                new BukkitRunnable() {
                    public void run() {
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§c[R] O servidor ser\u00e1 reiniciado em 1s");
                        Bukkit.broadcastMessage("");
                        LoadPanel.taskid2 = this.getTaskId();
                    }
                }.runTaskLaterAsynchronously((Plugin)Main.getPlugin((Class)Main.class), 1780L);
                new BukkitRunnable() {
                    public void run() {
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§c[R] O servidor ser\u00e1 reiniciado em 2s");
                        Bukkit.broadcastMessage("");
                    }
                }.runTaskLaterAsynchronously((Plugin)Main.getPlugin((Class)Main.class), 1760L);
                new BukkitRunnable() {
                    public void run() {
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§c[R] O servidor ser\u00e1 reiniciado em 3s");
                        Bukkit.broadcastMessage("");
                    }
                }.runTaskLaterAsynchronously((Plugin)Main.getPlugin((Class)Main.class), 1740L);
            }
            else {
                if (e.getRawSlot() == 16) {
                    if (Main.isReiniciando()) {
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§c[R] O reinicio foi cancelado por um administrador.");
                        Bukkit.broadcastMessage("");
                        Bukkit.getScheduler().cancelTasks((Plugin)Main.getPlugin((Class)Main.class));
                        PlayerCommandPreprocessEvent.getHandlerList().unregister((Plugin)Main.getPlugin((Class)Main.class));
                        PlayerInteractEvent.getHandlerList().unregister((Plugin)Main.getPlugin((Class)Main.class));
                        BlockPlaceEvent.getHandlerList().unregister((Plugin)Main.getPlugin((Class)Main.class));
                        BlockBreakEvent.getHandlerList().unregister((Plugin)Main.getPlugin((Class)Main.class));
                        PlayerDropItemEvent.getHandlerList().unregister((Plugin)Main.getPlugin((Class)Main.class));
                        ChatMessageEvent.getHandlerList().unregister((Plugin)Main.getPlugin((Class)Main.class));
                        Main.setReiniciando(false);
                    }
                    else {
                        p.sendMessage("§cO servidor n\u00e3o tem nenhum reinicio ativo.");
                    }
                    return;
                }
                if (e.getRawSlot() == 13) {
                    p.sendMessage("§cAltere na config, ele atualiza direto :)");
                }
            }
        }
    }
    
    public static void openPanel(final Player p) {
        final Inventory panel = Bukkit.createInventory((InventoryHolder)null, 27, "Painel de controle - Reinicio");
        final ItemStack start = new ItemBuilder(Material.INK_SACK).setDurability((short)10).setName("§eIniciar reinicio").setLore("§7Clique aqui para reiniciar o servidor em 3 minutos.").toItemStack();
        final ItemStack stop = new ItemBuilder(Material.INK_SACK).setDurability((short)1).setName("§eParar reinicio").setLore("§7Clique aqui para cancelar o reinicio").toItemStack();
        final FileConfiguration mainconfig = ((Main)Main.getPlugin((Class)Main.class)).getConfig();
        final Boolean abrirbau = mainconfig.getBoolean("AbrirBaus");
        final Boolean executarcomandos = mainconfig.getBoolean("ExecutarComandos");
        final Boolean abrirbeacon = mainconfig.getBoolean("AbrirBeacon");
        final Boolean abrirechest = mainconfig.getBoolean("AbrirBauDoFim");
        final Boolean mesadetrabalho = mainconfig.getBoolean("AbrirMesaDeTrabalho");
        final Boolean UsarDispenser = mainconfig.getBoolean("UtilizarDispenser");
        final Boolean utilizarenderpearl = mainconfig.getBoolean("UtilizarEnderPearl");
        final Boolean utilizarchat = mainconfig.getBoolean("UtilizarChat");
        final Boolean colocarblocos = mainconfig.getBoolean("ColocarBlocos");
        final Boolean retirarblocos = mainconfig.getBoolean("RetirarBlocos");
        final Boolean abrirDroppers = mainconfig.getBoolean("AbrirDroppers");
        final Boolean abrirfornalhas = mainconfig.getBoolean("AbrirFornalhas");
        final Boolean abrirbigornas = mainconfig.getBoolean("AbrirBigornas");
        final Boolean droparitens = mainconfig.getBoolean("DroparItens");
        final Boolean utilizarredstone = mainconfig.getBoolean("UtilizarRedstone");
        final ItemStack informa\u00e7\u00e3o = new ItemBuilder(Material.PAPER).setName("§eInforma\u00e7\u00f5es do reinicio").setLore("§aA\u00e7\u00f5es do reinicio: ", "§7Executar comandos: " + booleantranslater(executarcomandos), "§7Abrir ba\u00fas: " + booleantranslater(abrirbau), "§7Abrir beacon: " + booleantranslater(abrirbeacon), "§7Abrir Ba\u00fa do Fim: " + booleantranslater(abrirechest), "§7Abrir mesa de trabalho: " + booleantranslater(mesadetrabalho), "§7Abrir dispenser: " + booleantranslater(UsarDispenser), "§7Utilizar P\u00e9rola do Fim: " + booleantranslater(utilizarenderpearl), "§7Utilizar chat: " + booleantranslater(utilizarchat), "§7Colocar blocos: " + booleantranslater(colocarblocos), "§7Retirar blocos: " + booleantranslater(retirarblocos), "§7Abrir droppers: " + booleantranslater(abrirDroppers), "§7Abrir fornalhas: " + booleantranslater(abrirfornalhas), "§7Abrir bigornas: " + booleantranslater(abrirbigornas), "§7Dropar itens: " + booleantranslater(droparitens), "§7Utilizar redstone: " + booleantranslater(utilizarredstone), "", "§ePara alterar alguma configura\u00e7\u00e3o clique.").toItemStack();
        panel.setItem(10, start);
        panel.setItem(16, stop);
        panel.setItem(13, informa\u00e7\u00e3o);
        p.openInventory(panel);
    }
    
    public static String booleantranslater(final Boolean f) {
        if (f) {
            return "§aHabilitado";
        }
        return "§cDesabilitado";
    }
}
