package com.devbruno.cash;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.bukkit.plugin.Plugin;
import java.sql.DriverManager;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import java.sql.Connection;

public class Conexao
{
    protected static Connection con;
    public static ConsoleCommandSender sc;
    
    static {
        Conexao.con = null;
        Conexao.sc = Bukkit.getConsoleSender();
    }
    
    protected static void open() {
        final String usuario = Main.getPlugin().getConfig().getString("MySQL.Usuario");
        final String senha = Main.getPlugin().getConfig().getString("MySQL.Senha");
        final String database = Main.getPlugin().getConfig().getString("MySQL.Database");
        final String host = Main.getPlugin().getConfig().getString("MySQL.Host");
        final String urlmysql = "jdbc:mysql://" + host + "/" + database;
        try {
            Conexao.con = DriverManager.getConnection(urlmysql, usuario, senha);
            Conexao.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§aConex\u00e3o com MySQL aberta!");
        }
        catch (SQLException e) {
            Conexao.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cConex\u00e3o com MySQL n\u00e3o foi possivel!");
            e.printStackTrace();
            Main.getPlugin().getPluginLoader().disablePlugin((Plugin)Main.getPlugin());
        }
    }
    
    protected static void close() {
        if (Conexao.con != null) {
            try {
                Conexao.con.close();
                Conexao.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§aConex\u00e3o fechada com sucesso!");
            }
            catch (SQLException e) {
                Conexao.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel fechar a conex\u00e3o!");
            }
        }
    }
    
    protected static void createTable() {
        if (Conexao.con != null) {
            PreparedStatement stm = null;
            try {
                stm = Conexao.con.prepareStatement("CREATE TABLE IF NOT EXISTS `cash` (`id` INT NOT NULL AUTO_INCREMENT,`player` VARCHAR(24) NULL,`quantia` DOUBLE NULL,PRIMARY KEY (`id`));");
                stm.executeUpdate();
                Conexao.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§aTabela carregada");
            }
            catch (SQLException e) {
                Conexao.sc.sendMessage(String.valueOf(String.valueOf(Metodos.prefix)) + "§cN\u00e3o foi possivel carregar a tabela");
            }
        }
    }
}
