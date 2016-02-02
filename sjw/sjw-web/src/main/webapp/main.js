require.config({
  paths: {
    'angular': 'https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min',
    'angular-animate': 'https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.18/angular-animate.min',
    'angular-ui-router': 'lib/angular-ui-router/release/angular-ui-router',
    'angular-resource': 'https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.18/angular-resource.min',
    'angular-ngtable': 'lib/ng-table/dist/ng-table.min',
    'toaster': 'lib/angularjs-toaster/toaster',
    'bootstrap': 'lib/bootstrap/dist/js/bootstrap',
    'x2js': 'lib/x2js/xml2json.min',
    'angular-x2js': 'lib/angular-x2js/dist/x2js.min',
    'jquery': 'lib/jquery/jquery',
    'tab': 'http://192.168.242.49/javascripts/api/tableau-2.0.0'
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
    'tab',
    'splash/splash.module.js',
    'taxis/taxis.module.js',
    'tableau/tableau.module.js'
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
      'taxis.module',
      'tableau.module'
    ]);
  });
});