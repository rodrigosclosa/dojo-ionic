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

    //created an array to avoid the page load waiting for an array
    $scope.bases = [];

    //load all the Predios itens on Load Page
    var loadPredios = function(){
      api.get('predio/v1/get')
      .success(function(response) {
        console.log(response);
        $scope.predios = response.items;
      })
      .catch(function(error) {
        console.log(error.data);
        $scope.error = error.data;
      });
    };

    //load all the Bases to fullfield the Base Select
    $scope.load = function() {
      loadPredios();
      api.get('base/v1/get')
      .success(function(response) {
        console.log(response);
        $scope.bases = response.items;
      })
      .catch(function(error) {
        console.log(error.data);
        $scope.error = error.data;
      });
    };

    //On editar click button will be load the content on the input field
    $scope.editar = function(item) {
      console.log(item);
      $scope.predio = item;
      $scope.base = item.base;
    };

    //on excluir click button will delete the content
    $scope.excluir = function(item) {
      var predio = $scope.predios.splice($scope.predios.indexOf(item), 1);
      console.log(predio);
      api.delete('predio/v1/delete/' + predio[0].id);
      $scope.error = 'A Base foi deletada corretamente';
      $scope.load();
    };

    // Insert New or Edit Data (Predio) on API
    $scope.submit = function () {
      if($scope.predio.id !== undefined) {
        var predio = $scope.predio;
        predio.idBase = $scope.base.id;
        console.log(predio);
        api.put('predio/v1/update', predio)
          .success(function(response){
              console.log(response);
          })
          .catch(function(error){
              console.log(error.data);
              $scope.error = error.data;
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
            $scope.load();
          })
          .catch(function(error){
            console.log('Erro ao cadastrar...');
            $scope.error = 'Erro ao Cadastrar - ' + error.data;
          });
        }
    };

    //to call the Load function on Load the Page.
    $scope.load();
  });
