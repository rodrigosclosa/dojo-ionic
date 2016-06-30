
angular.module('adminApp')
    .controller('ProdutosCtrl',function($scope, api){
        
        api.get('produto/v1/Produto')
            .success(function(produtos){
                console.log(produtos);
                $scope.list = produtos.items;
            })
            .error(function(err){
                console.log(err);
            });

    });