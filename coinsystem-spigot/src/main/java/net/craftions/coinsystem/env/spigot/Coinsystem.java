package net.craftions.coinsystem.env.spigot;

import net.craftions.coinsystem.common.Coins;
import net.craftions.coinsystem.env.spigot.commands.CommandCoins;
import org.bukkit.plugin.java.JavaPlugin;

public final class Coinsystem extends JavaPlugin {

    public static String prefix = "§7[§eCoins§7] ";
    public static Coins coins = null;

    @Override
    public void onEnable() {
        coins = new Coins("direct.craftions.net", "3306", "coinsys", "+zvUlNn$?;m&J9e:pTZH7&Py8e2radR;#EEtJ:@CHsfXd1duR+8aX$leaOoA?#8L", "coins");
        getCommand("coins").setExecutor(new CommandCoins());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
