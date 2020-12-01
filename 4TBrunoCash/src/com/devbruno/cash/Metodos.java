package com.devbruno.cash;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class Metodos extends Conexao
{
    public static String prefix;
    public static ConsoleCommandSender sc;
    
    static {
        Metodos.prefix = "§6§lCASH §f> ";
        Metodos.sc = Bukkit.getConsoleSender();
    }
    
    public static boolean contains(final String player) {
        PreparedStatement stm = null;
        try {
            stm = Metodos.con.prepareStatement("SELECT * FROM `cash` WHERE `player` = ?");
            stm.setString(1, player.toLowerCase());
            final ResultSet rs = stm.executeQuery();
            return rs.next();
        }
        catch (SQLException e) {
            return false;
        }
    }
    
    public static void setPlayer(final String player) {
        PreparedStatement stm = null;
        try {
            stm = Metodos.con.prepareStatement("INSERT INTO `cash`(`player`, `quantia`) VALUES (?,?)");
            stm.setString(1, player.toLowerCase());
            stm.setDouble(2, 0.0);
            stm.executeUpdate();
            Metodos.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§aPlayer §f" + player + "§a criado com sucesso!");
        }
        catch (SQLException e) {
            Metodos.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel inserir o player: §f" + player + "§a no banco de dados!");
        }
    }
    
    public static void set(final String player, final Double quantia) {
        if (contains(player)) {
            PreparedStatement stm = null;
            try {
                stm = Metodos.con.prepareStatement("UPDATE `cash` SET `quantia` = ? WHERE `player` = ?");
                stm.setDouble(1, quantia);
                stm.setString(2, player.toLowerCase());
                stm.executeUpdate();
            }
            catch (SQLException e) {
                Metodos.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel setar o cash do jogador");
            }
        }
        else {
            setPlayer(player);
            PreparedStatement stm = null;
            try {
                stm = Metodos.con.prepareStatement("UPDATE `cash` SET `quantia` = ? WHERE `player` = ?");
                stm.setDouble(1, quantia);
                stm.setString(2, player.toLowerCase());
                stm.executeUpdate();
            }
            catch (SQLException e) {
                Metodos.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel setar o cash do jogador");
            }
        }
    }
    
    public static Double get(final String player) {
        if (contains(player)) {
            PreparedStatement stm = null;
            try {
                stm = Metodos.con.prepareStatement("SELECT * FROM `cash` WHERE `player` = ?");
                stm.setString(1, player.toLowerCase());
                final ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    new BukkitRunnable() {
                        public void run() {
                        }
                    }.runTaskLater((Plugin)Main.getPlugin(), 40L);
                    return rs.getDouble("quantia");
                }
                return 0.0;
            }
            catch (SQLException e) {
                return 0.0;
            }
        }
        setPlayer(player);
        return 0.0;
    }
    
    public static void add(final String player, final Double quantia) {
        if (contains(player)) {
            set(player, get(player) + quantia);
        }
        else {
            setPlayer(player);
            set(player, get(player) + quantia);
        }
    }
    
    public static void remove(final String player, final Double quantia) {
        if (contains(player)) {
            set(player, get(player) - quantia);
        }
        else {
            setPlayer(player);
        }
    }
    
    public static void delete(final String player) {
        if (contains(player)) {
            PreparedStatement stm = null;
            try {
                stm = Metodos.con.prepareStatement("DELETE FROM `cash` WHERE `player` = ?");
                stm.setString(1, player.toLowerCase());
                stm.executeUpdate();
            }
            catch (SQLException e) {
                Metodos.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel remover o jogador §f" + player + "§c do banco de dados!");
            }
        }
    }
    
    public static List<String> getTops() {
        PreparedStatement stm = null;
        final List<String> tops = new ArrayList<String>();
        try {
            stm = Metodos.con.prepareStatement("SELECT * FROM `cash` ORDER BY `quantia` DESC");
            final ResultSet rs = stm.executeQuery();
            int i = 0;
            while (rs.next()) {
                if (i <= 5) {
                    ++i;
                    final DecimalFormat formatador = new DecimalFormat(",###.##");
                    final String valorFormatado = formatador.format(rs.getDouble("quantia"));
                    tops.add("   §6" + i + "º §f" + rs.getString("player") + " §7(" + valorFormatado + " CASH)");
                }
            }
        }
        catch (SQLException e) {
            Metodos.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel carregar o top cashs");
        }
        new BukkitRunnable() {
            public void run() {
            }
        }.runTaskLater((Plugin)Main.getPlugin(), 20L);
        return tops;
    }
}
