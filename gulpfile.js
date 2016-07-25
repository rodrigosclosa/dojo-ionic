var gulp = require('gulp');
var gutil = require('gulp-util');
var bower = require('bower');
var concat = require('gulp-concat');
var sass = require('gulp-sass');
var minifyCss = require('gulp-minify-css');
var rename = require('gulp-rename');
var sh = require('shelljs');
var uglify = require('gulp-uglify');
var gutil = require('gulp-util');

var paths = {
    sass: ['./scss/**/*.scss']
  , js: {
      src: {
          base: ['./js/**/*.js']
        , all: [
            './js/config/config-base.js'
          , './js/config/config-router.js'
          , './js/controllers/*.js'
          , './js/services/*.js'
          , './js/filters/*.js'
          , './js/directives/*.js'
        ]
      },
      dist : {
        filename: 'market.min.js'
        , dir: './www/js'
      }
    }
};

gulp.task('default', ['sass', 'js', 'watch']);

gulp.task('sass', function(done) {
  gulp.src('./scss/ionic.app.scss')
    .pipe(sass())
    .on('error', sass.logError)
    .pipe(gulp.dest('./www/css/'))
    .pipe(minifyCss({
      keepSpecialComments: 0
    }))
    .pipe(rename({ extname: '.min.css' }))
    .pipe(gulp.dest('./www/css/'))
    .on('end', done);
});

gulp.task('watch', function() {
  gulp.watch(paths.sass, ['sass']);
  gulp.watch(paths.js.src.base, ['js']);
});

gulp.task('install', ['git-check'], function() {
  return bower.commands.install()
    .on('log', function(data) {
      gutil.log('bower', gutil.colors.cyan(data.id), data.message);
    });
});

gulp.task('git-check', function(done) {
  if (!sh.which('git')) {
    console.log(
      '  ' + gutil.colors.red('Git is not installed.'),
      '\n  Git, the version control system, is required to download Ionic.',
      '\n  Download git here:', gutil.colors.cyan('http://git-scm.com/downloads') + '.',
      '\n  Once git is installed, run \'' + gutil.colors.cyan('gulp install') + '\' again.'
    );
    process.exit(1);
  }
  done();
});

gulp.task('js', function() {
  gulp.src(paths.js.src.all)
  .pipe(uglify({mangle: false})).on('error', gutil.log)
  .pipe(concat(paths.js.dist.filename))
  .pipe(gulp.dest(paths.js.dist.dir));
});
