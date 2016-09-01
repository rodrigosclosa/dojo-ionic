'use strict';

/**
 * @ngdoc function
 * @name adminApp.controller:BaseCtrl
 * @description
 * # BaseCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
  .controller('BaseCtrl', function ($scope,api) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    // New item
    $scope.base = {
        'nome' : '',
        'icone' : 'teste'
    };

    //
    $scope.editar = function(item) {
        $scope.base = item;
    };
    
    $scope.excluir = function(item) {
        var base = $scope.list.splice($scope.list.indexOf(item), 1);
        console.log(base);
        api.delete('base/v1/delete/' + base[0].id);
        // o retorno será true ou false + mensagem de erro - caso exista
    };

    // Post data to api
    $scope.submit = function () {
       var newBase = $scope.base;

       if(newBase.id !== undefined){
          console.log("Updating...");
           api.put('base/v1/update', newBase);
           //o retorno será true ou false + mensagem de erro - caso exista
       } else {
           api.post('base/v1/new', newBase)
           .success(function(response){
              console.log(response);
           });
       }
    };

    $scope.load = function() {
       api.get('base/v1/get')
        .success(function(response){
          console.log(response);
          $scope.list = response.items;
        })
        .error(function(err){
          console.log(err);
        });
    };
    
    
    $scope.list = [];
    $scope.load();
    
  });
