'use strict';

/**
 * @ngdoc function
 * @name adminApp.controller:HeaderCtrl
 * @description
 * # HeaderCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
  .controller('HeaderCtrl', function($scope, api, $location, $window) {
    console.log("Ola");

    $scope.isActive = function (viewLocation) {
       var active = (viewLocation === $location.path());
       return active;
    };
  });
