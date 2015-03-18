define(
    [
     'angular',
     'taxis/controller/TaxisController',
     'taxis/service/TaxiService'
    ],
    function (angular, TaxisController, TaxiService) {
      console.debug('Configuring taxis.module');
      angular.module('taxis.module', [])

        .service('TaxiService', TaxiService)
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

          $urlRouterProvider
            .when('', '/');

          $stateProvider.state('default.taxis', {
            url: 'taxis',
            templateUrl: 'taxis/view/taxis.html',
            controller: TaxisController
          });

        }]);

    });