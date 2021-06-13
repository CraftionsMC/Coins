package net.craftions.coinsystem.env.waterfall;

import net.craftions.coinsystem.common.Coins;
import net.md_5.bungee.api.plugin.Plugin;

public final class Coinsystem extends Plugin {

    public static Coins coins = null;

    @Override
    public void onEnable() {
        coins = new Coins("direct.craftions.net", "3306", "coinsys", "+zvUlNn$?;m&J9e:pTZH7&Py8e2radR;#EEtJ:@CHsfXd1duR+8aX$leaOoA?#8L", "coins");
    }
}
