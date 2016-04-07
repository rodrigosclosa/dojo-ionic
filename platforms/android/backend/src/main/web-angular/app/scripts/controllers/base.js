'use strict';

/**
 * @ngdoc function
 * @name adminApp.controller:BaseCtrl
 * @description
 * # BaseCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
  .controller('BaseCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.base = {};
    
    $scope.list = [
        {name: 'Campinas'},
        {name: 'São Paulo'},
        {name: 'Belo Horizonte'}
    ];
    
    $scope.submit = function () {
        $scope.list.push($scope.base);
        $scope.base = {};
    };
    
  });
