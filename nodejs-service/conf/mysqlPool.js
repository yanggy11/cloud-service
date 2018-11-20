/**
 * @Author derrick.yang
 * @Date 11/20/18
 */

let mysql = require('mysql');
let $mysqlConf = require('./db');

module.exports = mysql.createPool($mysqlConf);
