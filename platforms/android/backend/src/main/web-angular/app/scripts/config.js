'use strict';


angular.module('app.config',[])
//Arquivo de configurações padrões do Projeto
.factory('ProdutoConfig', function($http) {

  return {
    urlServicos: function() {
      return "https://mercado-cit.appspot.com/_ah/api/";
    }
  };
});