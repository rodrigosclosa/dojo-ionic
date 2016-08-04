'use strict';
angular.module('app.controllers')
    .controller('principalCtrl', function($scope, api, $http) {

     $scope.load = function() {
       api.get('produto/v1/Produto')
        .success(function(response){
            console.log(response)
            $scope.produtos = response.items;
        })
        .error(function(err){
            console.log(err)
        });

        api.get('base/v1/base/5629499534213120/predios')
        .success(function(response){
            console.log(response)
            $scope.predios = response.items;
        })
        .error(function(err){
            console.log(err)
        });
    }

    
    
    $scope.produtos = [];
    $scope.predios = [];
    $scope.load();
})
 