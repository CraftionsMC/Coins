/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.coinsystem.env.spigot.commands;

import net.craftions.coinsystem.common.Coins;
import net.craftions.coinsystem.env.spigot.Coinsystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCoins implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("craftions.admin.coins")){
            sender.sendMessage(Coinsystem.prefix + "You have §c" + Coinsystem.coins.getCoins(((Player) sender).getUniqueId().toString()) + " §7coins");
            return true;
        }
        if (args.length == 0) {
            if(sender instanceof Player){
                sender.sendMessage(Coinsystem.prefix + "You have §c" + Coinsystem.coins.getCoins(((Player) sender).getUniqueId().toString()) + " §7coins");
            }else {
                sender.sendMessage(Coinsystem.prefix + "§cUsage: §6" + command.getUsage());
            }
        } else {
            if(args.length > 1){
                Player p = Bukkit.getPlayer(args[1]);
                if(p == null){
                    sender.sendMessage(Coinsystem.prefix + "The player §c" + args[1] + " §7cloud not be found.");
                    return true;
                }
                switch (args[0].toLowerCase()){
                    case "set":
                        sender.sendMessage(Coinsystem.prefix + "§cPlease wait...");
                        Coinsystem.coins.setCoins(p.getUniqueId().toString(), Integer.parseInt(args[2]));
                        sender.sendMessage(Coinsystem.prefix + "§aSuccessfully §7set the coins of §c" + p.getName());
                        break;
                    case "get":
                        sender.sendMessage(Coinsystem.prefix + "§cPlease wait...");
                        int gotCoins = Coinsystem.coins.getCoins(p.getUniqueId().toString());
                        sender.sendMessage(Coinsystem.prefix + "The player §c" + args[1] + " §7has §c" + gotCoins + " §7coins");
                        break;
                    case "add":
                        sender.sendMessage(Coinsystem.prefix + "§cPlease wait...");
                        Coinsystem.coins.addCoins(p.getUniqueId().toString(), Integer.parseInt(args[2]));
                        sender.sendMessage(Coinsystem.prefix + "§aSuccessfully §7add coins to §c" + p.getName());
                        break;
                    case "remove":
                        sender.sendMessage(Coinsystem.prefix + "§cPlease wait...");
                        Coinsystem.coins.removeCoins(p.getUniqueId().toString(), Integer.parseInt(args[2]));
                        sender.sendMessage(Coinsystem.prefix + "§aSuccessfully §7removed coins from §c" + p.getName());
                        break;
                    default:
                        sender.sendMessage(Coinsystem.prefix + "§cUsage: §6" + command.getUsage());
                }
            }else {
                sender.sendMessage(Coinsystem.prefix + "§cUsage: §6" + command.getUsage());
            }
        }
        return true;
    }
}
