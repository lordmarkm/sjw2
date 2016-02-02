define(
    [
     'angular',
     'tableau/controller/TableauController',
     'tableau/resolve/TicketResolve'
    ],
    function (angular, TableauController, TicketResolve) {
      console.debug('Configuring taxis.module');
      angular.module('tableau.module', [])
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
          $stateProvider.state('default.tableau', {
            url: 'tableau?viewUrl',
            templateUrl: 'tableau/view/demo.html',
            controller: TableauController,
            resolve: TicketResolve
          });

        }]);

    });