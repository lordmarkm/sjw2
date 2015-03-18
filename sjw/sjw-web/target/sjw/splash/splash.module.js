define(
    [
     'angular',
     'splash/controller/SplashController'
    ],
    function (angular, SplashController) {
      console.debug('Configuring splash.module');
      angular.module('splash.module', [])

        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

          $urlRouterProvider
            .when('', '/');

          $stateProvider.state('default', {
            url: '/',
            template: '<ui-view></ui-view>',
            abstract: true
          })
          $stateProvider.state('default.splash', {
            url: '',
            templateUrl: 'splash/view/splash.html',
            controller: SplashController
          });

        }]);

    });