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

    var loadPredios = function() {
      api.get('predio/v1/predio')
      .success(function(response){
          //console.log(response)
          $scope.predios = response.items;
      })
      .error(function(err){
          console.log(err)
      });
    }

    //
    $scope.editar = function(item) {
      $scope.predio = item;
    };

    $scope.excluir = function(item) {
      var predio = $scope.predios.splice($scope.predios.indexOf(item), 1);
      console.log(predio);
      api.delete('predio/v1/predio/' + predio[0].id);
    };

    // Post data to api
    $scope.submit = function () {
      var newPredio = $scope.predio;
      newPredio.idBase = $scope.base.id;
      console.log(newPredio);
       //api.post('predio/v1/predio', newPredio).then(loadPredios);

    };

    $scope.load = function() {
       loadPredios();

        api.get('base/v1/base')
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
