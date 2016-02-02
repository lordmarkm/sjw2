define(function () {
  return {
    ticket: ['$http', '$q', function ($http, $q) {
      var defer = $q.defer();
      $http.get('/tableau').success(function (response) {
        console.debug('got ticket. ticket=' + response.message);
        defer.resolve(response.message);
      });
      return defer;
    }],
    workbooks: ['$http', function ($http) {
      return $http.get('/tableau/workbooks').success(function (response) {
        console.debug('got workbooks. wbs=' + JSON.stringify(response));
      });
    }]
  };
});
