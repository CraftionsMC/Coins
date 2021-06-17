/**
 * @author Ben Siebert
 * @copyright 2018-2021 Ben Siebert. All rights reserved.
 */
require('dotenv').config();

const url = require('url');
const http = require('http');
const database = require('./database');

http.createServer((req, res) => {
    try{
        let u = url.parse(req.url);
        if(u.pathname.split("/").length >= 1){
            database.getCoins(u.pathname.split("/")[1], (err, result) => {
                let coins = 0;
                if(result[0]) coins = result[0].coins;
                res.end(JSON.stringify({
                    code: 200,
                    coins: coins
                }))
            })
        }else {
            throw new Error("You need to specify an uuid");
        }
    }catch (err) {
        res.end(JSON.stringify({
            code: 502,
            error: err.message
        }))
    }
}).listen(process.env.PORT || 8084, "0.0.0.0");
