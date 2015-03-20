require.config({
  paths: {
    'angular': 'lib/angular/angular',
    'angular-animate': 'lib/angular-animate/angular-animate.min',
    'angular-ui-router': 'lib/angular-ui-router/release/angular-ui-router',
    'angular-resource': 'lib/angular-resource/angular-resource.min',
    'angular-ngtable': 'lib/ng-table/dist/ng-table.min',
    'toaster': 'lib/angularjs-toaster/toaster',
    'bootstrap': 'lib/bootstrap/dist/js/bootstrap',
    'x2js': 'lib/x2js/xml2json.min',
    'angular-x2js': 'lib/angular-x2js/dist/x2js.min',
    'jquery': 'lib/jquery/jquery'
  },
  shim: {
    'angular': {
      exports: 'angular',
      deps: ['jquery']
    },
    'angular-resource': {
      deps: ['angular']
    },
    'angular-ui-router': {
      deps: ['angular']
    },
    'angular-animate': {
      deps: ['angular']
    },
    'angular-ngtable': {
      deps: ['angular']
    },
    'angular-x2js': {
      deps: ['angular', 'x2js']
    },
    'toaster': {
      deps: ['angular']
    },
  }
});

require([
    'angular',
    'angular-resource',
    'angular-animate',
    'angular-ngtable',
    'toaster',
    'angular-ui-router',
    'bootstrap',
    'angular-x2js',
    'splash/splash.module.js',
    'taxis/taxis.module.js'
  ], function (angular) {
  angular.element().ready(function () {
    angular.bootstrap(document, [
      'ui.router',
      'ngResource',
      'ngAnimate',
      'ngTable',
      'toaster',
      'cb.x2js',
      'splash.module',
      'taxis.module'
    ]);
  });
});