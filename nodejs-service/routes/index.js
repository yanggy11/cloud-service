var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
    res.send('index');
});
router.get('/health', function (req, res, next) {
    res.json({'status': 'UP'});
});

module.exports = router;
