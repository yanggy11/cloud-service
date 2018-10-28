/**
 * @Author derrick.yang
 * @Date 28/10/2018
 */

let mysql = require("mysql");
let mysqlConf = require("db");

let pool = mysql.createPool(mysqlConf);

moudule.exports = pool;
