package net.craftions.coinsystem.env.waterfall;

import net.craftions.coinsystem.common.Coins;
import net.md_5.bungee.api.plugin.Plugin;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public final class Coinsystem extends Plugin {

    public static Coins coins = null;

    @Override
    public void onEnable() {
        File configFile = new File("plugins/coins.ini");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                Files.write(configFile.toPath(), "[con]\nhost=null\nport=0\nusername=null\npassword=null\ndatabase=null\n".getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Ini ini = null;
        try {
            ini = new Ini(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        coins = new Coins(
                ini.get("con", "host"),
                ini.get("con", "port"),
                ini.get("con", "username"),
                ini.get("con", "password"),
                ini.get("con", "database")
        );
    }
}
