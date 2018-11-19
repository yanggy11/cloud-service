/**
 * @Author derrick.yang
 * @Date 28/10/2018
 */

let pool = require('../conf/mysqlPool');
let bookSql = require('../sql-map/bookSqlMap');

let bookDao = {
    getAllbooks: function(req, res, next) {
        var param = req.query | req.param;
        pool.getConnection(function(err, connection) {
            connection.query(bookSql.queryBooks,[], function(error, result){
                res.json(result);
            });
        });
    }
};

module.exports = bookDao;