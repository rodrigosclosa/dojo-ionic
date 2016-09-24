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

    //created an array to avoid the page load waiting for an array
    $scope.list = [];

    //load all the Base itens on Load Page
    $scope.load = function() {
      api.get('base/v1/get')
        .success(function(response){
          console.log("Loading all Data...");
          $scope.list = response.items;//get the Object Items data

        }).catch(function(response){
          console.log(response.data);
          $scope.error = response.data;
        });
    };

    //On editar click button will be load the content on the input field
    $scope.editar = function(item) {
      $scope.base = item;
    };

    //on excluir click button will delete the content
    $scope.excluir = function(item) {
      var base = $scope.list.splice($scope.list.indexOf(item), 1);
      console.log(base);
      api.delete('base/v1/delete/' + base[0].id);
      $scope.error = "A Base foi deletada corretamente";
    };

    // Insert New or Edit Data (Base) on API
    $scope.submit = function () {
       var newBase = $scope.base;
       if(newBase.id !== undefined) {
         api.put('base/v1/update/', newBase)
          .success(function(response){
            console.log(response);
          })
          .catch(function(error) {
            console.log(error.data);
            if(error.data === "Not Found"){
              $scope.error = "Não foi possível efetuar o procedimento.";  
            } else {
              $scope.error = error.data;
            }
          });
       } else {
        api.post('base/v1/new', newBase)
          .success(function(response) {
            response = {};
            response.nome = $scope.base.nome;
            response.id = 10;
            $scope.list.push(response);

          })
          .catch(function(error){
            console.log(error.data);
            if(error.data === "Not Found"){
              $scope.error = "Não foi possível efetuar o procedimento.";  
            } else {
              $scope.error = error.data.error.message;
            }
          });
       }
    };

    //to call the Load function on Load the Page.
    $scope.load();
  });

