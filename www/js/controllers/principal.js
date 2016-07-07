angular.module('app.controllers', [])
  
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

        api.get('base/v1/base')
        .success(function(response){
            console.log(response)
            $scope.bases = response.items;
        })
        .error(function(err){
            console.log(err)
        });
    }
    
    
    $scope.produtos = [];
    $scope.bases = [];
    $scope.load();


})
 