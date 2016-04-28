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
    console.log(api)
    $scope.base = {};
    
    $scope.editar = function(item) {
        $scope.base = item;
    };
    
    $scope.excluir = function(item) {
        
        $scope.list.splice($scope.list.indexOf(item), 1)
        //$scope.list.splice(1, 1)
        
        
    };
    $scope.list = [];
    api.get('https://mercado-cit.appspot.com/_ah/api/base/v1/base')
        .success(function(response){
            var items = response.items;
            var size  = items.length;
            for(var i=0; i<size; i++){
                $scope.list.push({name:items[i].nome});
            }
        })
        .error(function(err){
            console.log(err)
        })
    
    $scope.submit = function () {
        $scope.list.push($scope.base);
        $scope.base = {};
    };
    
  });
