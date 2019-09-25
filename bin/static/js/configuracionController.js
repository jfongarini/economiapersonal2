app.controller('configuracionController', function ($scope, $http) {

    //INIT CONFIGURACION
    $scope.init = function(){
        $scope.activeConfiguracion=true;
        $scope.getAllCategorias();
        $scope.getAllInversiones();
        $scope.getAllPersonas();
        $scope.getAllTarjetas();

        $scope.ngCategoria={};
        $scope.ngInversion={};
        $scope.ngPersona={};
        $scope.ngTarjeta={};
    }

    //Obtener todas las categorias
    $scope.getAllCategorias = function() {
        $http.get("/rest/configuracion/categoria").then(function (response) {
            $scope.categorias = response.data;
            loadComplete();
        });
    };


    //Alta categoria ingreso
    $scope.addCategoriaIngreso = function() {
        $http.post('/rest/configuracion/categoria/alta', $scope.ngCategoria)
            .then(function successCallback(response) {
                $scope.categorias.push(response.data);
                $scope.categorias.isGasto="false"
                $scope.ngCategoria={};
                $scope.messageCategoria='';
              }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };

    //Alta categoria gasto
    $scope.addCategoriaGasto = function() {
        $http.post('/rest/configuracion/categoria/alta', $scope.ngCategoria)
            .then(function successCallback(response) {
                $scope.categorias.push(response.data);
                $scope.categorias.isGasto="true"
                $scope.ngCategoria={};
                $scope.messageCategoria='';
              }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };

    //Actualizar categoria
    $scope.updateCategoria = function() {
        $http.put('/rest/configuracion/categoria/actualizar/'+ $scope.ngCategoria.id)
            .then(function successCallback(response) {
                $scope.getAllCategorias();
                $scope.ngCategoria={};
                $scope.messageCategoria='';
            }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };
    

    //Obtener todas las inversiones
    $scope.getAllInversiones = function() {
        $http.get("/rest/configuracion/inversion").then(function (response) {
            $scope.inversiones = response.data;
            loadComplete();
        });
    };

    //Alta inversion
    $scope.addInversion = function() {
        $http.post('/rest/configuracion/inversion/alta', $scope.ngInversion)
            .then(function successCallback(response) {
                $scope.inversiones.push(response.data);
                $scope.ngInversion={};
                $scope.messageInversion='';
              }, function errorCallback(response) {
                $scope.messageInversion=response.data.message;
            });
    };

    //Actualizar inversion
    $scope.updateInversion = function() {
        $http.put('/rest/configuracion/inversion/actualizar/'+ $scope.ngInversion.id)
            .then(function successCallback(response) {
                $scope.getAllInversiones();
                $scope.ngInversion={};
                $scope.messageInversion='';
            }, function errorCallback(response) {
                $scope.messageInversion=response.data.message;
            });
    };


    //Obtener todas las personas
    $scope.getAllPersonas = function() {
        $http.get("/rest/configuracion/persona").then(function (response) {
            $scope.personas = response.data;
            loadComplete();
        });
    };

    //Alta persona
    $scope.addPersona = function() {
        $http.post('/rest/configuracion/persona/alta', $scope.ngPersona)
            .then(function successCallback(response) {
                $scope.personas.push(response.data);
                $scope.ngPersona={};
                $scope.messagePersona='';
              }, function errorCallback(response) {
                $scope.messagePersona=response.data.message;
            });
    };

    //Actualizar persona
    $scope.updatePersona = function() {
        $http.put('/rest/configuracion/persona/actualizar/'+ $scope.ngPersona.id)
            .then(function successCallback(response) {
                $scope.getAllPersonas();
                $scope.ngPersona={};
                $scope.messagePersona='';
            }, function errorCallback(response) {
                $scope.messagePersona=response.data.message;
            });
    };


    //Obtener todas las tarjetas
    $scope.getAllTarjetas = function() {
        $http.get("/rest/configuracion/tarjeta").then(function (response) {
            $scope.tarjetas = response.data;
            loadComplete();
        });
    };

    //Alta tarjeta
    $scope.addTarjeta = function() {
        $http.post('/rest/configuracion/tarjeta/alta', $scope.ngTarjeta)
            .then(function successCallback(response) {
                $scope.tarjetas.push(response.data);
                $scope.ngTarjeta={};
                $scope.messageTarjeta='';
              }, function errorCallback(response) {
                $scope.messageTarjeta=response.data.message;
            });
    };

    //Actualizar tarjeta
    $scope.updateTarjeta = function() {
        $http.put('/rest/configuracion/tarjeta/actualizar/'+ $scope.ngTarjeta.id)
            .then(function successCallback(response) {
                $scope.getAllTarjetas();
                $scope.ngTarjeta={};
                $scope.messageTarjeta='';
            }, function errorCallback(response) {
                $scope.messageTarjeta=response.data.message;
            });
    };

});