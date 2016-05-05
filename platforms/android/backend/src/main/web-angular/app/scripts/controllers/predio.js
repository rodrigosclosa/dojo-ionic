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
      
      
    $scope.list = [];
    api.get('https://mercado-cit.appspot.com/_ah/api/predio/v1/predio')
        .success(function(response){
            var items = response.items;
            var size  = items.length;
            console.log(response.items);
            for(var i=0; i<size; i++){
                $scope.list.push({name:items[i].nome});
            }
        })
        .error(function(err){
            console.log(err)
        })
        
        $scope.submit = function () {
            $scope.list.push($scope.predio);
            $scope.predio = {};
        };
    
  });
