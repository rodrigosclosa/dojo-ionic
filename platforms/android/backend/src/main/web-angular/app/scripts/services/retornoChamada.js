angular.module('app.services', [])

.factory('retornoChamada', function() {
  // Might use a resource here that returns a JSON array

  // TODO: fazer a instancia do google para o endpoint produto
  var retorno = {
      items: [],
      error: {
          codigo: "",
          mensagem: ""
      }
  };

  return {
    objeto: function() {
      return retorno;
    }
  };
});
