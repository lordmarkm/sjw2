define(function () {
  return ['$resource', 'x2js', function ($resource, x2js) {
    return $resource('marklogic/v1/documents', {}, {
      findAndTransform : {
        method: 'GET',
        transformResponse: function(data, headers) {
          var json = undefined;
          try {
            json = JSON.parse(data);
          } catch (err) {
          }
          if (json && json.plateNo) {
            return json;
          } else {
            return x2js.xml_str2json(data).taxi;
          }
        },
        isArray: false
      }
    });
  }];
});