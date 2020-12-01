package com.devbruno.cash.api;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import com.devbruno.cash.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.plugin.Plugin;

public class Config
{
    public static Config cnf;
    private Plugin plugin;
    private String name;
    private File file;
    private YamlConfiguration config;
    
    static {
        Config.cnf = new Config("configuracao");
    }
    
    public Config(final String nome) {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
        this.setName(String.valueOf(String.valueOf(nome)) + ".yml");
        this.reloadConfig();
    }
    
    public Plugin getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(final Plugin plugin) {
        this.plugin = plugin;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public File getFile() {
        return this.file;
    }
    
    public YamlConfiguration getConfig() {
        return this.config;
    }
    
    public void saveConfig() {
        try {
            this.getConfig().save(this.getFile());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveDefault() {
        this.getConfig().options().copyDefaults(true);
    }
    
    public void saveDefaultConfig() {
        if (!this.existeConfig()) {
            this.getPlugin().saveResource(this.getName(), false);
            this.reloadConfig();
        }
    }
    
    public void reloadConfig() {
        this.file = new File(((Main)Main.getPlugin((Class)Main.class)).getDataFolder(), this.getName());
        this.config = YamlConfiguration.loadConfiguration(this.getFile());
    }
    
    public void deleteConfig() {
        this.getFile().delete();
    }
    
    public boolean existeConfig() {
        return this.getFile().exists();
    }
    
    public String getString(final String path) {
        return this.getConfig().getString(path);
    }
    
    public int getInt(final String path) {
        return this.getConfig().getInt(path);
    }
    
    public boolean getBoolean(final String path) {
        return this.getConfig().getBoolean(path);
    }
    
    public double getDouble(final String path) {
        return this.getConfig().getDouble(path);
    }
    
    public List<?> getList(final String path) {
        return (List<?>)this.getConfig().getList(path);
    }
    
    public long getLong(final String path) {
        return this.getConfig().getLong(path);
    }
    
    public float getFloat(final String path) {
        return this.getConfig().getInt(path);
    }
    
    public Object get(final String path) {
        return this.getConfig().get(path);
    }
    
    public List<Map<?, ?>> getMapList(final String path) {
        return (List<Map<?, ?>>)this.getConfig().getMapList(path);
    }
    
    public List<String> getStringList(final String path) {
        return (List<String>)this.getConfig().getStringList(path);
    }
    
    public List<Integer> getIntegerList(final String path) {
        return (List<Integer>)this.getConfig().getIntegerList(path);
    }
    
    public boolean contains(final String path) {
        return this.getConfig().contains(path);
    }
    
    public void set(final String path, final Object value) {
        this.getConfig().set(path, value);
    }
    
    public void setString(final String path, final String value) {
        this.getConfig().set(path, (Object)value);
    }
}
