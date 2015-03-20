define(function () {
    return ['$scope', '$http', '$state', 'x2js', 'toaster', 'config', 'ngTableParams', 'TaxiSearchService', 'TaxiService',
      function ($scope, $http, $state, x2js, toaster, config, ngTableParams, TaxiSearchService, TaxiService) {
        $scope.controllerName = "Taxis Controller";

        //Taxis table
        $scope.tableParams = new ngTableParams({
          page: 1,
          count: 5,
          sorting: {
            trackingNo: 'asc'
          }
        }, {
          total: 0,
          counts: [5,10,15],
          getData: function($defer, params) {
            //Translate ngTable params to MarkLogic params
            var mlParams = {
                q: $scope.query || '*',
                start: ((params.$params.page - 1) * params.$params.count) + 1,
                pageLength: params.$params.count
            };

            //Ajax request to backend resource
            TaxiSearchService.get(mlParams, function(response) {
              params.total(response.total);
              $defer.resolve(response.results);
            });
          }
        });

        $scope.viewTaxi = function (uri) {
          console.debug('Trying to view by uri=' + uri);
          TaxiService.findAndTransform({uri: uri}, function (data) {
            $state.go('default.taxi', {plateNo: data.plateNo || data._plateNo, uri: uri});
          });
        };
      }
    ];
  }
);
