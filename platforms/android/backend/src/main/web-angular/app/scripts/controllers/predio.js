'use strict';

/**
 * @ngdoc function
 * @name adminApp.controller:PredioCtrl
 * @description
 * # PredioCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
  .controller('PredioCtrl', function ($scope) {
    $scope.prediosLista = [
      { name : "Predio1"},
      { name : " predio2"}
    ];
    
    
    
  });
