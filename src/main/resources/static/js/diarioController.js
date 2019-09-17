app.controller('configuracionController', function ($scope, $http) {

    //INIT Diario
    $scope.init = function(){
        $scope.getAllDiario();

        $scope.ngDiario={};

    }

    //Obtener todas los diarios
    $scope.getAllDiario = function() {
        $http.get("/rest/diario").then(function (response) {
            $scope.diarios = response.data;
            loadComplete();
        });
    };

    //Alta diario
    $scope.addDiario = function() {
        $http.post('/rest/diario/alta', $scope.ngDiario)
            .then(function successCallback(response) {
                $scope.diarios.push(response.data);
                $scope.ngDiario={};
                $scope.messageDiario='';
              }, function errorCallback(response) {
                $scope.messageDiario=response.data.message;
            });
    };

    //Actualizar diario
    $scope.updateDiario = function() {
        $http.put('/rest/diario/actualizar/'+ $scope.ngDiario.id)
            .then(function successCallback(response) {
                $scope.getAllDiario();
                $scope.ngDiario={};
                $scope.messageDiario='';
            }, function errorCallback(response) {
                $scope.messageDiario=response.data.message;
            });
    };
    

});	