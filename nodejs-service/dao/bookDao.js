/**
 * @Author derrick.yang
 * @Date 28/10/2018
 */

let pool = require('../conf/mysqlPool');
let bookSql = require('../sql-map/bookSqlMap');

let jsonWrite = function (res, ret) {
    if(typeof ret === 'undefined') {
        res.json({
            code:'1',
            msg: '操作失败'
        });
    } else {
        res.json(ret);
    }
};

let bookDao = {
    getAllbooks: function (req, res, next) {
        pool.getConnection(function (err, connection) {
            connection.query(bookSql.queryBooks, function (err, result) {
                jsonWrite(res, result);
                connection.release();
            });
        });
    },

    addNewBook: (req, res, next) => {
        pool.getConnection((err, connection) => {
            let param = req.query || req.params;
            connection.query(bookSql.add,[param.bookName, param.authorId], (err, result) => {
                if(result) {
                    result = {
                        code: 200,
                        msg:'增加成功'
                    };
                }

                jsonWrite(res, result)
                connection.release();
            });
        })
    },
    deleteBook: (req, res, next) => {
        pool.getConnection((err, connection) => {
            let param = req.query || req.params;
            connection.query(bookSql.deleteBook, [param.id], (error, result) => {

                if(result && result.affectedRows > 0) {
                    result = {
                        code: 200,
                        msg:'删除成功'
                    }
                }
                jsonWrite(res, result);
                connection.release();
            })
        });
    },
    updateBook: (req, res, next) => {
        pool.getConnection((err, connection) => {
            let param = req.query || req.params;
            console.log(param);
            connection.query(bookSql.updateBook, [param.authorId, param.id], (error, result) => {

                jsonWrite(res, result);
                connection.release();
            })
        });
    }
};

module.exports = bookDao;