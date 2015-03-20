define(
    [
     'angular',
     'taxis/controller/TaxisController',
     'taxis/controller/TaxiController',
     'taxis/service/TaxiSearchService',
     'taxis/service/TaxiService'
    ],
    function (angular, TaxisController, TaxiController, TaxiSearchService, TaxiService) {
      console.debug('Configuring taxis.module');
      angular.module('taxis.module', [])

        .service('TaxiSearchService', TaxiSearchService)
        .service('TaxiService', TaxiService)
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

          $urlRouterProvider
            .when('', '/');

          $stateProvider.state('default.taxis', {
            url: 'taxis',
            templateUrl: 'taxis/view/taxis.html',
            controller: TaxisController
          })
          .state('default.taxi', {
            url: 'taxi/{uri}/{plateNo}',
            templateUrl: 'taxis/view/taxi.html',
            controller: TaxiController
          });

        }]);

    });