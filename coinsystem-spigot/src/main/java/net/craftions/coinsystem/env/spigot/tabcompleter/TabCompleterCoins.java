/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.coinsystem.env.spigot.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class TabCompleterCoins implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
