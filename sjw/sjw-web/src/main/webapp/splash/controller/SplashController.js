define(function () {
    return ['$scope', 'config',
      function ($scope, config) {
        $scope.controllerName = "Splash Controller";
        $scope.config = config;
      }
    ];
  }
);
