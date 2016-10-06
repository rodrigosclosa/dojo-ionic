'use strict';
/**
 * @ngdoc function
 * @name adminApp.controller:ProdutosCtrl
 * @description
 * # ProdutosCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
    .controller('ProdutosCtrl',function($scope, api) {

    //created an array to avoid the page load waiting for an array
    $scope.produtos = [];

    $scope.load = function() {
      api.get('produto/v1/get')
        .success(function(response){
          console.log(response);
          $scope.produtos = response.items;
        })
        .catch(function(error){
          console.log(error.data);
          $scope.error = error.data;
        });
    };

    //to call the Load function on Load the Page.
    $scope.load();
  });
