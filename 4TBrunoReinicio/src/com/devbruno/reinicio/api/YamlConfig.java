package com.devbruno.reinicio.api;

import org.bukkit.configuration.ConfigurationOptions;
import org.bukkit.configuration.MemoryConfigurationOptions;
import java.util.List;
import org.bukkit.configuration.InvalidConfigurationException;
import java.io.IOException;
import org.bukkit.plugin.Plugin;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class YamlConfig extends YamlConfiguration
{
    private File bruteFile;
    private Plugin plugin;
    
    public YamlConfig(final String name, final Plugin plugin) {
        this.plugin = plugin;
        this.bruteFile = new File(plugin.getDataFolder(), name.matches(".*(?i).yml$") ? name : name.concat(".yml"));
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
                plugin.saveResource(this.bruteFile.getName(), true);
            }
            if (!this.bruteFile.exists()) {
                this.bruteFile.createNewFile();
            }
            this.load(this.bruteFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InvalidConfigurationException e2) {
            e2.printStackTrace();
        }
    }
    
    public void saveDefault() {
        if (this.plugin.getResource(this.bruteFile.getName()) == null) {
            System.err.println("[" + this.plugin.getName() + "] Nao foi possivel salvar o arquivo");
            System.err.println("[" + this.plugin.getName() + "] default da config " + this.bruteFile.getName() + " pois o jar nao");
            System.err.println("[" + this.plugin.getName() + "] contem um arquivo com teste nome.");
        }
        else {
            if (this.bruteFile.exists()) {
                return;
            }
            this.plugin.saveResource(this.bruteFile.getName(), true);
        }
    }
    
    public void set(final String path, final Object obj) {
        super.set(path, obj);
        this.save();
    }
    
    public Object get(final String path) {
        return super.get(path);
    }
    
    public String getString(final String path) {
        return super.getString(path);
    }
    
    public int getInt(final String path) {
        return super.getInt(path);
    }
    
    public boolean getBoolean(final String path) {
        return super.getBoolean(path);
    }
    
    public List<String> getStringList(final String path) {
        return (List<String>)super.getStringList(path);
    }
    
    public void save() {
        try {
            super.save(this.bruteFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void reload() {
        try {
            this.load(this.bruteFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InvalidConfigurationException e2) {
            e2.printStackTrace();
        }
    }
}
