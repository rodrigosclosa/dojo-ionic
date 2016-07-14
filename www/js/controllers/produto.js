angular.module('app.controllers', [])
  
.controller('produtoCtrl', function($scope, api, $http, $stateParams) {
    $scope.produto = {};
    //Load product
     $scope.load = function() {
       api.get('produto/v1/Produto/' + $stateParams.id)
        .success(function(response){
            $scope.produto = response;
        })
        .error(function(err){
            console.log(err)
        });
    }
    
    $scope.produtos = [];
    $scope.load();
})
 