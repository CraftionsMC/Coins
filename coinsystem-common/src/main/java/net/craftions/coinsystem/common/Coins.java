/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.coinsystem.common;

import de.mctzock.javamysql.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coins {

    private final String host;
    private final String port;
    private final String username;
    private final String password;
    private final String database;
    private final String connectionParameters = "useSSL=false";

    public Coins(String host, String port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public void addCoins(String playerUUID, int coins){
        int current = getCoins(playerUUID);
        MySQL con = new MySQL(
                "UPDATE `coins` WHERE `uuid` = '" + playerUUID + "' SET coins=" + (current + coins),
                this.host, this.port, this.username, this.password, this.database, this.connectionParameters
        );
        con.executeUpdate();
        con.close();
    }

    public void removeCoins(String playerUUID, int coins){
        int current = getCoins(playerUUID);
        MySQL con = new MySQL(
                "UPDATE `coins` WHERE `uuid` = '" + playerUUID + "' SET coins=" + (current - coins),
                this.host, this.port, this.username, this.password, this.database, this.connectionParameters
        );
        con.executeUpdate();
        con.close();
    }

    public void setCoins(String playerUUID, int coins){
        MySQL con = new MySQL(
                "INSERT INTO `coins` (uuid, coins) values (\"" + playerUUID + "\", " + coins + ")",
                this.host, this.port, this.username, this.password, this.database, this.connectionParameters
        );
        con.executeUpdate();
        con.close();
    }

    public int getCoins(String playerUUID){
        int coins = 0;
        MySQL con = new MySQL(
                "SELECT * FROM `coins` WHERE `uuid` = '" + playerUUID + "';",
                this.host, this.port, this.username, this.password, this.database, this.connectionParameters
        );
        ResultSet rs = con.executeQuery();
        try {
            while(rs.next()){
                coins = rs.getInt("coins");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        con.close();
        return coins;
    }

    public String getDatabase() {
        return database;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}
