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

    // New item
    $scope.base = {
        'nome' : '',
        'icone' : 'teste'
    };

    $scope.list = []

    //
    $scope.editar = function(item) {
        $scope.base = item;
    };

    $scope.excluir = function(item) {
        var base = $scope.list.splice($scope.list.indexOf(item), 1);
        console.log(base);
        api.delete('base/v1/delete/' + base[0].id);
    };

    // Post data to api
    $scope.submit = function () {
       var newBase = $scope.base;
       if(newBase.id != undefined){
           api.put('base/v1/update', newBase)
            .success(function(response){

            })
            .error(function(err){
                console.log(err);
            })
       } else{
           api.post('base/v1/new', newBase)
                .success(function(response){
                    response = {};
                    response.nome = $scope.base.nome;
                    response.id = 10;
                    $scope.list.push(response);
                })
                .error(function(err){
                    console.log(err);
                })
       }
    };

    $scope.load = function() {
       api.get('base/v1/get')
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

  });
