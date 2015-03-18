define(function () {
    return ['$scope', 'TaxiService',
      function ($scope, TaxiService) {
        $scope.controllerName = "Taxis Controller";
        $scope.taxis = TaxiService.get();
      }
    ];
  }
);
