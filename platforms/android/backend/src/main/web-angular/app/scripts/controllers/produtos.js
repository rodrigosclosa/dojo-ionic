'use strict';
/**
 * @ngdoc function
 * @name adminApp.controller:ProdutosCtrl
 * @description
 * # ProdutosCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
    .controller('ProdutosCtrl',function($scope, api){

        api.get('produto/v1/get')
            .success(function(produtos){
                console.log(produtos);
                $scope.list = produtos.items;
            })
            .error(function(err){
                console.log(err);
            });

    });
