define(function () {
  return ['$resource', function ($resource) {
    return $resource('marklogic/v1/search', {
      directory: 'taxis',
      format: 'json'
    }, {
    });
  }];
});