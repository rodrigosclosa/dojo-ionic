angular.module('app.controllers', [])
  
.controller('principalCtrl', function($scope, api, $http) {

     route = 'https://mercado-cit.appspot.com/_ah/api/produto/v1/Produto';
     params = null;
     $http.get(route,params)
            .success(function(produtos){
                console.log(produtos);
                $scope.list = produtos.items;
            })
            .error(function(err){
                console.log(err);
            });


     $scope.load = function() {
       api.get('produto/v1/Produto')
        .success(function(response){
            console.log(response)
            $scope.list = response.items;
        })
        .error(function(err){
            console.log(err)
        });
    }
    
    
    $scope.list = [];
    $scope.load();


})
 