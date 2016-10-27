'use strict';
/**
 * @ngdoc function
 * @name adminApp.controller:ProdutosCtrl
 * @description
 * # ProdutosCtrl
 * Controller of the adminApp
 */
angular.module('adminApp')
  .controller('ProdutosCtrl', function ($scope, ProdutoService) {

    //created an array to avoid the page load waiting for an array
    $scope.produtos = [];

    $scope.load = function () {

      ProdutoService.all(null, function (retorno) {
        if (retorno.success) {
          $scope.produtos = retorno.items;
        } else {
          $ionicPopup.alert({
            title: 'Erro ao listar os produtos',
            template: 'Desculpe, mas ocorreu um erro ao tentar listar os produtos. Mensagem: ' + retorno.erro.mensagem
          });
        }
      });

    };

    $scope.excluir = function (produto) {
      var confirmPopup = $ionicPopup.confirm({
        title: 'Excluir',
        template: 'Tem certeza que deseja excluir o produto ' + produto.nome + '?'
      });

      confirmPopup.then(function (res) {
        if (res) {

          ProdutoService.remove(produto.id, function (retorno) {
            if (retorno.success) {
              console.log(retorno);
              $scope.load();
            } else {
              $ionicPopup.alert({
                title: 'Erro ao excluir',
                template: 'Desculpe, mas ocorreu um erro ao tentar excluir o produto. Mensagem: ' + retorno.erro.mensagem
              });
            }
          });
        }
      });
    };

    //to call the Load function on Load the Page.
    $scope.load();
  });
