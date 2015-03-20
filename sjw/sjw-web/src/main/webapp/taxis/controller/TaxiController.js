define(function () {
  return ['$scope', '$stateParams', 'ngTableParams', 'TaxiService',
    function ($scope, $stateParams, ngTableParams, TaxiService) {
      $scope.plateNo = $stateParams.plateNo;
      $scope.uri = $stateParams.uri;
      $scope.taxi = TaxiService.findAndTransform({uri: $scope.uri});
    }
  ];
});
