/**
 * @author Ben Siebert
 * @copyright 2018-2021 Ben Siebert. All rights reserved.
 */
const mysql = require('mysql');

const connection = mysql.createConnection({
    host: process.env.DB_HOST       || "localhost",
    port: process.env.DB_PORT       || 3306,
    user: process.env.DB_USER       || "root",
    password: process.env.DB_PASS   || "password",
    database: process.env.DB_NAME   || "database"
})

connection.connect((err) => {})

function getCoins(uuid, callback) {
    connection.query("SELECT * FROM `coins` WHERE `uuid` = '" + uuid + "';", callback);
}

module.exports = { getCoins };
