/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamkrafter;

import java.util.Set;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.bukkit.util.permissions.*;
import org.bukkit.inventory.*;
/**
 *
 * @author Adam
 */
public class EShelper extends JavaPlugin{


   public static final Logger LOG = Logger.getLogger("Minecraft1");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments){
        if (label.equalsIgnoreCase("calc")) {
            return handleCalc(sender, arguments);
        }
        else if(label.equalsIgnoreCase("pomoc")) {
            return handlePomoc(sender, arguments);
        }
        return false;
    }
    
    boolean handleCalc(CommandSender sender, String[] arguments) {
        if (arguments.length > 0) {
            Calculator calculator = new Calculator();
            String cislo1 = arguments[0];
            String cislo2 = arguments[2];
            String operacia = arguments[1];
            String result = calculator.calculate(cislo1, cislo2, operacia);
            sender.sendMessage("Výsledok je " + result);
        }
        return false;
    }
    boolean handlePomoc(CommandSender sender, String[] arguments) {
        if(sender instanceof Player){
            if (arguments.length>0){
                if (arguments[0].equalsIgnoreCase("bazina"))
                    sender.sendMessage("Mínusova suradnica sa ma zmensovat, plusova zvecovat");
                    return true;
                }
                else{
                    sender.sendMessage("NEznamy commmad");
                    return true;               
                } 

            }
            return true;
    }
    @Override
    public void onEnable() {
        ItemStack cryobsidian = new ItemStack(Material.CRYING_OBSIDIAN, 8);
        ShapedRecipe cobsid = new ShapedRecipe(cryobsidian);
        cobsid.shape("***","*B*","***");
        cobsid.setIngredient('*', Material.OBSIDIAN);
        cobsid.setIngredient('B', Material.LAPIS_LAZULI);
        getServer().addRecipe(cobsid);
    }
}