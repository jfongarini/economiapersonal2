app.controller('configuracionController', function ($scope, $http) {

    //INIT CONFIGURACION
    $scope.init = function(){
        $scope.activeConfiguracion=true;
        $scope.getAllCategoriasIngreso();
        $scope.getAllCategoriasGasto();
        $scope.getAllInversiones();
        $scope.getAllPersonas();
        $scope.getAllTarjetas();

        $scope.ngCategoriaingreso={};
        $scope.ngCategoriaGasto={};
        $scope.ngInversion={};
        $scope.ngPersona={};
        $scope.ngTarjeta={};
    }

    //Obtener todas las categorias Ingreso
    $scope.getAllCategoriasIngreso = function() {
        $http.get("/rest/configuracion/categoriasIngreso").then(function (response) {
            $scope.categoriasI = response.data;
            loadComplete();
        });        
    };

    //Obtener todas las categorias Gasto
    $scope.getAllCategoriasGasto = function() {
        $http.get("/rest/configuracion/categoriasGasto").then(function (response) {
            $scope.categoriasG = response.data;
            loadComplete();
        });        
    };

    //Obtener categoria
    $scope.getCategoria = function(event) {
        $scope.categoriaId = event.currentTarget.getAttribute("data-id");
        $http.get('/rest/configuracion/categoria/'+ $scope.categoriaId)
            .then(function successCallback(response) {
                $scope.ngCategoria=response.data;
                loadComplete();
            });
    };

    //Alta categoria ingreso
    $scope.addCategoriaIngreso = function() {
        $http.post('/rest/configuracion/categoria/alta', $scope.ngCategoriaingreso)
            .then(function successCallback(response) {
                $scope.categoriasI.push(response.data);
                $scope.categoriasI.isGasto="false"
                $scope.ngCategoriaingreso={};
                $scope.messageCategoria='';
              }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };

    //Alta categoria gasto
    $scope.addCategoriaGasto = function() {
        $http.post('/rest/configuracion/categoria/alta', $scope.ngCategoriaGasto)
            .then(function successCallback(response) {
                $scope.categoriasG.push(response.data);
                $scope.categoriasG.isGasto="true"
                $scope.ngCategoriaGasto={};
                $scope.messageCategoria='';
              }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };

    //Actualizar categoria Ingreso
    $scope.updateCategoriaIngreso = function(event) {
        $http.put('/rest/configuracion/categoria/actualizar/'+ $scope.ngCategoriaingreso.id)
            .then(function successCallback(response) {
                $scope.getAllCategoriasIngreso();
                $scope.ngCategoriaingreso={};
                $scope.messageCategoria='';
            }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };
    
    //Actualizar categoria Gasto
    $scope.updateCategoriaGasto = function(event) {
        $scope.categoriaGastoId = event.currentTarget.getAttribute("data-id");
        $http.put('/rest/configuracion/categoria/actualizar/'+ $scope.categoriaGastoId)
            .then(function successCallback(response) {
                $scope.getAllCategoriasGasto();
                $scope.ngCategoriaGasto={};
                $scope.messageCategoria='';
            }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };

    //Eliminar categoria
    $scope.deleteCategoria = function(event) {
        $scope.ngCategoria={};
        $scope.ngCategoria.id = event.currentTarget.getAttribute("data-id");
        $http.put('/rest/configuracion/categoria/baja/'+ $scope.ngCategoria.id,$scope.ngCategoria)
            .then(function successCallback(response) {
                $scope.getAllCategoriasIngreso();
                $scope.getAllCategoriasGasto();
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
    $scope.updateTarjeta = function(event) {
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