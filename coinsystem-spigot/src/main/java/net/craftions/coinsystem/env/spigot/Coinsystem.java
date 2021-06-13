package net.craftions.coinsystem.env.spigot;

import net.craftions.api.config.Config;
import net.craftions.coinsystem.common.Coins;
import net.craftions.coinsystem.env.spigot.commands.CommandCoins;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public final class Coinsystem extends JavaPlugin {

    public static String prefix = "§7[§eCoins§7] ";
    public static Coins coins = null;

    @Override
    public void onEnable() {
        File configFile = new File("plugins/coins.yml");
        if(!configFile.exists()){
            try {
                configFile.createNewFile();
                Files.write(configFile.toPath(), "host: 'localhost'\nport: 3306\nusername: 'my_cool_username'\npassword: 'my_secure_password'\ndatabase: 'my_db_name'\n".getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Config config = new Config(configFile, "coinsys_dbconf");
        coins = new Coins(
                config.get("host").toString(),
                config.get("port").toString(),
                config.get("username").toString(),
                config.get("password").toString(),
                config.get("database").toString()
                );
        getCommand("coins").setExecutor(new CommandCoins());
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
