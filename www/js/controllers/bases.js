'use strict';
  angular.module('app.controllers')
  .controller('BaseCtrl', function ($scope, api, $http) {

    //created an array to avoid the page load waiting for an array
    $scope.list = [];

    //load all the Base itens on Load Page
    $scope.load = function() {
      api.get('base/v1/get')
        .success(function(response){
          console.log("Loading all Data...");
          $scope.list = response.items;
        }).catch(function(response){
          console.log(response.data);
          $scope.error = response.data;
        });
    };

    //to call the Load function on Load the Page.
    $scope.load();
  });

