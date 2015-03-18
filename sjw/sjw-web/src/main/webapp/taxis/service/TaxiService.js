define(function () {
  return ['$resource', 'config', function ($resource, config) {
    return $resource('http://' + config.marklogic.host + ':' + config.marklogic.port + '/v1/search', {
      directory: 'taxis',
      format: 'json'
    }, {
    });
  }];
});