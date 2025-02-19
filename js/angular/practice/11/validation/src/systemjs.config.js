/**
* System configuration for Angular samples
* Adjust as necessary for your application needs.
*/
(function (global) {
    System.config({
      paths: {
        // paths serve as alias
        'npm:': 'node_modules/'
      },
      // map tells the System loader where to look for things
      map: {
        // our app is within the app folder
        app: 'src',
        // angular bundles
        '@angular/core': 'npm:@angular/core/bundles/core.umd.js',
        '@angular/common': 'npm:@angular/common/bundles/common.umd.js',
        '@angular/compiler': 'npm:@angular/compiler/bundles/compiler.umd.js',
        '@angular/platform-browser': 'npm:@angular/platform-browser/bundles/platform-browser.umd.js',
        '@angular/platform-browser-dynamic': 'npm:@angular/platform-browser-dynamic/bundles/platform-browser-dynamic.umd.js',
        '@angular/http': 'npm:@angular/http/bundles/http.umd.js',
        '@angular/router': 'npm:@angular/router/bundles/router.umd.js',
        '@angular/forms': 'npm:@angular/forms/bundles/forms.umd.js',
        // other libraries
        'ng2-validation': 'npm:ng2-validation/bundles/ng2-validation.umd.js',
        'rxjs': 'npm:rxjs',
        'angular2-in-memory-web-api': 'npm:angular2-in-memory-web-api',
        'jquery': 'npm:jquery/dist/jquery.min.js',
        'jsrender': 'npm:jsrender/jsrender.min.js',
        'jquery-validation': 'npm:jquery-validation/dist/jquery.validate.min.js',
        'syncfusion-javascript': 'npm:syncfusion-javascript',
        'ej-angular2': 'npm:ej-angular2'
      },
      // packages tells the System loader how to load when no filename and/or no extension
      packages: {
        app: {
          main: './main.js',
          defaultExtension: 'js'
        },
        rxjs: {
          defaultExtension: 'js'
        },
        'angular2-in-memory-web-api': {
          main: './index.js',
          defaultExtension: 'js'
        },
        'ej-angular2': {
          main: './src/index.js'
        },
        'syncfusion-javascript': {
          defaultExtension: 'js'
        }
      }
    });
  })(this);
