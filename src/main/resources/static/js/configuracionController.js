app.controller('configuracionController', function ($scope, $http) {

    //INIT CONFIGURACION
    $scope.init = function(){
        $scope.activeConfiguracion=true;
        $scope.getAllCategoriasIngreso();
        $scope.getAllCategoriasGasto();
        $scope.getAllInversiones();
        $scope.getAllPersonas();
        $scope.getAllTarjetas();

        $scope.ngCategoriaIngreso={};
        $scope.ngCategoriaGasto={};
        $scope.ngInversion={};
        $scope.ngPersona={};
        $scope.ngTarjeta={};
    }

    //Get ALL

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
        });        
    };

    //Obtener todas las inversiones
    $scope.getAllInversiones = function() {
        $http.get("/rest/configuracion/inversion").then(function (response) {
            $scope.inversiones = response.data;
        });
    };

    //Obtener todas las personas
    $scope.getAllPersonas = function() {
        $http.get("/rest/configuracion/persona").then(function (response) {
            $scope.personas = response.data;
        });
    };

    //Obtener todas las tarjetas
    $scope.getAllTarjetas = function() {
        $http.get("/rest/configuracion/tarjeta").then(function (response) {
            $scope.tarjetas = response.data;
        });
    };


    // Get individual

    //Obtener categoria
    $scope.getCategoriaIngreso = function(event) {
        $scope.CategoriaIngresoId = event.currentTarget.getAttribute("data-id");
        $http.get('/rest/configuracion/categoria/'+ $scope.CategoriaIngresoId)
            .then(function successCallback(response) {
                $scope.ngCategoriaIngreso=response.data;
            });
    };

    $scope.getCategoriaGasto = function(event) {
        $scope.CategoriaGastoId = event.currentTarget.getAttribute("data-id");
        $http.get('/rest/configuracion/categoria/'+ $scope.CategoriaGastoId)
            .then(function successCallback(response) {
                $scope.ngCategoriaGasto=response.data;
            });
    };

    $scope.getInversion = function(event) {
        $scope.InversionId = event.currentTarget.getAttribute("data-id");
        $http.get('/rest/configuracion/inversion/'+ $scope.InversionId)
            .then(function successCallback(response) {
                $scope.ngInversion=response.data;
            });
    };

    $scope.getTarjeta = function(event) {
        $scope.TarjetaId = event.currentTarget.getAttribute("data-id");
        $http.get('/rest/configuracion/tarjeta/'+ $scope.TarjetaId)
            .then(function successCallback(response) {
                $scope.ngTarjeta=response.data;
            });
    };

    $scope.getPersona = function(event) {
        $scope.PersonaId = event.currentTarget.getAttribute("data-id");
        $http.get('/rest/configuracion/persona/'+ $scope.PersonaId)
            .then(function successCallback(response) {
                $scope.ngPersona=response.data;
            });
    };


    // Alta

    //Alta categoria ingreso
    $scope.addCategoriaIngreso = function() {
        if($scope.ngCategoriaIngreso.id  === undefined){
            $scope.ngCategoriaIngreso.personaId=personaId;
            $scope.ngCategoriaIngreso.isGasto="false";
            $scope.ngCategoriaIngreso.vigente="true";
            $http.post('/rest/configuracion/categoria/alta', $scope.ngCategoriaIngreso)
                .then(function successCallback(response) {
                    $scope.categoriasI.push(response.data);
                    
                    $scope.ngCategoriaIngreso={};
                    $scope.messageCategoria='';
                  }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }else{
            $http.put('/rest/configuracion/categoria/actualizar/'+ $scope.ngCategoriaIngreso.id,$scope.ngCategoriaIngreso)
                .then(function successCallback(response) {
                    $scope.getAllCategoriasIngreso();
                    $scope.ngCategoriaIngreso={};
                    $scope.messageCategoria='';
                }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }
    };


    //Alta categoria gasto
    $scope.addCategoriaGasto = function() {
        if($scope.ngCategoriaGasto.id  === undefined){
            $scope.ngCategoriaGasto.personaId=personaId;
            $scope.ngCategoriaGasto.isGasto="true";
            $scope.ngCategoriaGasto.vigente="true";
            $http.post('/rest/configuracion/categoria/alta', $scope.ngCategoriaGasto)
                .then(function successCallback(response) {
                    $scope.categoriasG.push(response.data);                    
                    $scope.ngCategoriaGasto={};
                    $scope.messageCategoria='';
                  }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }else{
            $http.put('/rest/configuracion/categoria/actualizar/'+ $scope.ngCategoriaGasto.id,$scope.ngCategoriaGasto)
                .then(function successCallback(response) {
                    $scope.getAllCategoriasGasto();
                    $scope.ngCategoriaGasto={};
                    $scope.messageCategoria='';
                }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }
    };

    //Alta inversion
    $scope.addInversion = function() {
        if($scope.ngInversion.id  === undefined){
            $scope.ngInversion.personaId=personaId;
            $scope.ngInversion.vigente="true";
            $http.post('/rest/configuracion/inversion/alta', $scope.ngInversion)
                .then(function successCallback(response) {
                    $scope.inversiones.push(response.data);                    
                    $scope.ngInversion={};
                    $scope.messageCategoria='';
                  }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }else{
            $http.put('/rest/configuracion/inversion/actualizar/'+ $scope.ngInversion.id,$scope.ngInversion)
                .then(function successCallback(response) {
                    $scope.getAllInversiones();
                    $scope.ngInversion={};
                    $scope.messageCategoria='';
                }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }
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

    //Alta tarjeta
    $scope.addTarjeta = function() {
        if($scope.ngTarjeta.id  === undefined){
            $scope.ngTarjeta.personaId=personaId;
            $scope.ngTarjeta.vigente="true";
            $http.post('/rest/configuracion/tarjeta/alta', $scope.ngTarjeta)
                .then(function successCallback(response) {
                    $scope.tarjetas.push(response.data);                    
                    $scope.ngTarjeta={};
                    $scope.messageCategoria='';
                  }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }else{
            $http.put('/rest/configuracion/tarjeta/actualizar/'+ $scope.ngTarjeta.id,$scope.ngTarjeta)
                .then(function successCallback(response) {
                    $scope.getAllTarjetas();
                    $scope.ngTarjeta={};
                    $scope.messageCategoria='';
                }, function errorCallback(response) {
                    $scope.messageCategoria=response.data.message;
                });
        }
    };



    // Actualizar

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



    // Baja

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

    //Eliminar inversion
    $scope.deleteInversion = function(event) {
        $scope.ngInversion={};
        $scope.ngInversion.id = event.currentTarget.getAttribute("data-id");
        $http.put('/rest/configuracion/inversion/baja/'+ $scope.ngInversion.id,$scope.ngInversion)
            .then(function successCallback(response) {
                $scope.getAllInversiones();
                $scope.ngInversion={};
                $scope.messageCategoria='';
            }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };

    //Eliminar tarjeta
    $scope.deleteTarjeta = function(event) {
        $scope.ngTarjeta={};
        $scope.ngTarjeta.id = event.currentTarget.getAttribute("data-id");
        $http.put('/rest/configuracion/tarjeta/baja/'+ $scope.ngTarjeta.id,$scope.ngTarjeta)
            .then(function successCallback(response) {
                $scope.getAllTarjetas();
                $scope.ngTarjeta={};
                $scope.messageCategoria='';
            }, function errorCallback(response) {
                $scope.messageCategoria=response.data.message;
            });
    };


});