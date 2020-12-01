package com.devbruno.cash.api;

import java.util.ArrayList;
import org.bukkit.entity.EntityType;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.List;
import java.util.Arrays;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class Criar
{
    public static ItemStack add(final Material m) {
        return new ItemStack(m);
    }
    
    public static ItemStack add(final Material m, final int quantidade) {
        return new ItemStack(m, quantidade);
    }
    
    public static ItemStack add(final Material m, final int quantidade, final int durabilidade) {
        final ItemStack item = new ItemStack(m, quantidade);
        item.setDurability((short)durabilidade);
        final ItemMeta meta = item.getItemMeta();
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome) {
        final ItemStack item = new ItemStack(m);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add1(final Material m, final String nome, final int quantidade) {
        final ItemStack item = new ItemStack(m, quantidade);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add1(final Material m, final String nome, final int quantidade, final int durabilidade) {
        final ItemStack item = new ItemStack(m, quantidade);
        item.setDurability((short)durabilidade);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final Enchantment ench, final int level) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(ench, level);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final Enchantment ench, final int level, final int quantidade) {
        final ItemStack item = new ItemStack(m, quantidade);
        item.addUnsafeEnchantment(ench, level);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final int durability) {
        final ItemStack item = new ItemStack(m);
        item.setDurability((short)durability);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final int durability, final String[] lore) {
        final ItemStack item = new ItemStack(m);
        item.setDurability((short)durability);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final int durability, final List<String> lore) {
        final ItemStack item = new ItemStack(m);
        item.setDurability((short)durability);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)lore);
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final int quantidade, final String nada) {
        final ItemStack item = new ItemStack(m);
        item.setAmount(quantidade);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final String nome, final String dono, final String[] lore) {
        final ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
        item.setDurability((short)3);
        final SkullMeta skull = (SkullMeta)item.getItemMeta();
        skull.setDisplayName(nome);
        skull.setOwner(dono);
        skull.setLore((List)Arrays.asList(lore));
        item.setItemMeta((ItemMeta)skull);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final String[] lore, final int durability) {
        final ItemStack item = new ItemStack(m);
        item.setDurability((short)durability);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        meta.setLore((List)Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final String[] lore) {
        final ItemStack item = new ItemStack(m);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final String[] lore, final Enchantment enchant, final int lvl) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant, lvl);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final String[] lore, final Enchantment enchant1, final int lvl1, final Enchantment enchant2, final int lvl2) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final Enchantment enchant1, final int lvl1, final Enchantment enchant2, final int lvl2) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack add(final Material m, final String nome, final String[] lore, final Enchantment enchant1, final int lvl1, final Enchantment enchant2, final int lvl2, final Enchantment enchant3, final int lvl3) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        item.addUnsafeEnchantment(enchant3, lvl3);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack potion(final PotionEffectType efeito, final String nome, final String[] lore) {
        final ItemStack item = new ItemStack(Material.POTION);
        final PotionMeta eta = (PotionMeta)item.getItemMeta();
        eta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 3600, 9), true);
        eta.setLore((List)Arrays.asList(lore));
        eta.setDisplayName(nome);
        item.setItemMeta((ItemMeta)eta);
        return item;
    }
    
    public static ItemStack couro() {
        final ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        final LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(Color.BLUE);
        meta.setDisplayName("\u00ef¿½bArmadura de Couro");
        item.setItemMeta((ItemMeta)meta);
        return item;
    }
    
    public static ItemStack couroHelment(final Color cor, final String nome) {
        final ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        final LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(cor);
        meta.setDisplayName(nome);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }
    
    public static ItemStack couroChestplate(final Color cor, final String nome) {
        final ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(cor);
        meta.setDisplayName(nome);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }
    
    public static ItemStack couroLeggings(final Color cor, final String nome) {
        final ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        final LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(cor);
        meta.setDisplayName(nome);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }
    
    public static ItemStack couroBoots(final Color cor, final String nome) {
        final ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(cor);
        meta.setDisplayName(nome);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }
    
    public static ItemStack getNamedSkull(final String nick, final String nome, final String[] lore, final Enchantment enchant, final Integer level) {
        final ItemStack skull = new ItemStack(397, 1, (short)3);
        skull.addUnsafeEnchantment(enchant, (int)level);
        final SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setDisplayName(nome);
        meta.setLore((List)Arrays.asList(lore));
        meta.setOwner(nick);
        skull.setItemMeta((ItemMeta)meta);
        return skull;
    }
    
    public static ItemStack getNamedSkull(final String nick, final String nome, final String[] lore) {
        final ItemStack skull = new ItemStack(397, 1, (short)3);
        final SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setDisplayName(nome);
        meta.setLore((List)Arrays.asList(lore));
        meta.setOwner(nick);
        skull.setItemMeta((ItemMeta)meta);
        return skull;
    }
    
    public static ItemStack outro(final Material m, final String nome, final Enchantment enchant, final int lvl) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant, lvl);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack outro(final Material m, final String nome, final Enchantment enchant1, final int lvl1, final Enchantment enchant2, final int lvl2) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack outro(final Material m, final String nome, final Enchantment enchant1, final int lvl1, final Enchantment enchant2, final int lvl2, final Enchantment enchant3, final int lvl3) {
        final ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        item.addUnsafeEnchantment(enchant3, lvl3);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack getSpawner(final String nome, final int amount, final EntityType type) {
        final ItemStack item = new ItemStack(Material.MOB_SPAWNER, amount);
        final List<String> lore = new ArrayList<String>();
        String loreString = type.toString();
        loreString = String.valueOf(String.valueOf(loreString.substring(0, 1).toUpperCase())) + loreString.substring(1).toLowerCase();
        loreString = String.valueOf(String.valueOf(loreString)) + " Spawner";
        lore.add(loreString);
        final ItemMeta meta = item.getItemMeta();
        meta.setLore((List)lore);
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack cap(final Material m, final int durabilidade) {
        final ItemStack item = new ItemStack(m);
        item.setDurability((short)durabilidade);
        return item;
    }
}
