app.controller('diarioController', function ($scope, $http) {

    //INIT Diario
    $scope.init = function(){
        $scope.activeDiario=true;
        $scope.getAllDiario();
        $scope.getAllCategoriasIngreso();
        $scope.getAllCategoriasGasto();
        $scope.ngDiario={};
        

    }

    //Obtener todas los diarios
    $scope.getAllDiario = function() {
        $http.get("/rest/diario").then(function (response) {
            $scope.diarios = response.data;
            loadComplete();
        });
    };

    //Obtener todas las categorias Ingreso
    $scope.getAllCategoriasIngreso = function() {
        $http.get("/rest/configuracion/categoriasIngreso").then(function (response) {
            $scope.categoriasI = response.data;
        });        
    };

    //Obtener todas las categorias Gasto
    $scope.getAllCategoriasGasto = function() {
        $http.get("/rest/configuracion/categoriasGasto").then(function (response) {
            $scope.categoriasG = response.data;
            $scope.categorias = $scope.categoriasG; 
        });        
    };

    $scope.cambiarCategorias = function() {
        if($scope.categorias == $scope.categoriasG){
            $scope.categorias = $scope.categoriasI; 
        } else {
            $scope.categorias = $scope.categoriasG; 
        }
             
    };

    //MOSTRAR O NO MOSTRAR DIV DE nuevo diario y update
    $scope.IsHiddenNuevo = true;
    $scope.IsHiddenUpdate = true;
    $scope.IsHiddenBoton = false;

    //Click nuevo diario
    $scope.newDiario = function() {        
        $scope.ngDiario = {};
    };

    $scope.sendDiario = function() {                    
            if($scope.isNuevoDiario === true){
                $scope.ngDiario.personaId = personaId;
                $http.post('/rest/diario/alta', $scope.ngDiario).then(function (response) {
                    $scope.diarios.push(response.data);
                });
                $scope.ngDiario={};
            }else{
                $http.put('/rest/diario/actualizar/'+ $scope.ngDiario.id).then(function successCallback(response) {
                    $scope.getAllDiario();
                });
            }
        };


    
    $scope.habilitaFormInsert = function() {
        $scope.IsHiddenNuevo = false;
        $scope.IsHiddenBoton = true;
        $scope.isNuevoDiario = true;
    };

    $scope.habilitaFormUpdate = function() {
        $scope.IsHiddenNuevo = false;
        $scope.IsHiddenBoton = true;
        $scope.isNuevoDiario = false;
    };

    $scope.closeDiario = function() {
        $scope.IsHiddenNuevo = true;
        $scope.IsHiddenBoton = false;
        $scope.ngDiario = {};
    };

});	