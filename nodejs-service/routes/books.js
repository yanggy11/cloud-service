let express = require('express');
let router = express.Router();
let bookDao = require('../dao/bookDao');


/* GET users listing. */
router.get('/', function(req, res, next) {
    bookDao.getAllbooks(req, res, next)
});
router.get('/newBook', function(req, res, next) {
    bookDao.addNewBook(req, res, next)
});

router.get('/deleteBook', (req, res, next) => {
    bookDao.deleteBook(req, res, next);
});

module.exports = router;
