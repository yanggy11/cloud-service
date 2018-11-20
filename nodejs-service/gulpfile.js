/**
 * @Author derrick.yang
 * @Date 11/20/18
 */

var gulp = require('gulp');

var browserSync = require('browser-sync');

let reload = browserSync.reload;

let nodemon = require('gulp-nodemon');

//这个可以让express启动
gulp.task("node", function () {
    nodemon({
        script: './bin/www',
        ext: 'js html',
        env: {
            'NODE_ENV': 'development'
        }

    })
});

gulp.task('server', ["node"], function () {
//此处的files为你所需要跟踪的文件，根据实际项目需要配置即可
    let files = [
        'conf/*.js',
        'dao/*.js',
        'sql-map/*.js',
        'routes/*.*',
    ];
    //gulp.run(["node"]);
    browserSync.init(files, {
        proxy: 'http://localhost:1983',
        browser: 'chrome',
        notify: false,
        port: 4001 //这个是browserSync对http://localhost:3000实现的代理端口
    });

    gulp.watch(files).on("change", reload);
});
