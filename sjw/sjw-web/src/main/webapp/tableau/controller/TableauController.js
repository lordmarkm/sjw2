define(function () {
  return ['$scope', '$stateParams', 'ticket', 'workbooks',
    function ($scope, $stateParams, ticket, wbResponse) {

      ticket.promise.then(function (t) {
        $scope.ticket = t;
        initializeViz();
      });

      $scope.workbooks = wbResponse.data;

      function initializeViz() {
        var placeholderDiv = document.getElementById("tableaudemo");
        //var url = "http://public.tableau.com/views/WorldIndicators/GDPpercapita";
        if ($stateParams.viewUrl) {
          var url="http://192.168.242.49/trusted/" + $scope.ticket + "/views/" + $stateParams.viewUrl;
        } else {
          var url="http://192.168.242.49/trusted/" + $scope.ticket + "/views/Restaurantdemo-version5/Timeofdayvsincome";
        }
        var options = {
          width: 800,
          height: 600,
          hideTabs: false,
          hideToolbar: false,
          onFirstInteractive: function () {
            workbook = viz.getWorkbook();
            activeSheet = workbook.getActiveSheet();
            var infos = workbook.getPublishedSheetsInfo();
            for (var i in infos) {
              console.debug(infos[i].getName());
            }
          }
        };
        viz = new tableau.Viz(placeholderDiv, url, options);
      }
  }];
});