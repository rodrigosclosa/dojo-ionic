'use strict';

/**
 * @ngdoc function
 * @name adminApp.controller:PredioCtrl
 * @description
 * # PredioCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
  .controller('PredioCtrl', function ($scope,api) {


    $scope.predios = [];
        // New item
    $scope.predio = {
        'nome' : '',
        'icone' : 'teste',
        'idBase' : ''
    };

    $scope.bases = [];

    var loadPredios = function(){
        api.get('predio/v1/get')
        .success(function(response){
            console.log(response)
            $scope.predios = response.items;
        })
        .error(function(err){
            console.log(err)
        });
    }

    //
    $scope.editar = function(item) {
        console.log(item);
        $scope.predio = item;
        $scope.base = item.base;
    };

    $scope.excluir = function(item) {
        var predio = $scope.predios.splice($scope.predios.indexOf(item), 1);
        console.log(predio);
        api.delete('predio/v1/delete/' + predio[0].id);
    };

    // Post data to api
    $scope.submit = function () {
        if($scope.predio.id != undefined){
          var predio = $scope.predio;
          predio.idBase = $scope.base.id;
          console.log(predio);
          api.put('predio/v1/update', predio)
              .success(function(response){
                  console.log(response);
              })
              .error(function(response){
                  console.log(response);
              });
        } else {
          var newPredio = $scope.predio;
          newPredio.idBase = $scope.base.id;
          console.log(newPredio);
          api.post('predio/v1/new', newPredio)
              .success(function(response){
                  response = {};
                  response.nome = $scope.predio.nome;
                  response.base = $scope.base;
                  $scope.bases.push(response);
              })
              .error(function(err){
                  alert('Erro ao cadastrar...');
              });
        }


    };

    $scope.load = function() {
       loadPredios();

        api.get('base/v1/get')
        .success(function(response){
            console.log(response)
            $scope.bases = response.items;
        })
        .error(function(err){
            console.log(err)
        });
    }


    $scope.load();

  });
