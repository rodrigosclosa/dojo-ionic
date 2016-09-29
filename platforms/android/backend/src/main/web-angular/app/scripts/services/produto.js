angular.module('app.services', [])

.factory('Produto', function(retornoChamada, api) {
  // Might use a resource here that returns a JSON array

  // TODO: fazer a instancia do google para o endpoint produto




  return {
    all: function() {
      return produtos;
    },
    remove: function(plant) {
      plants.splice(plants.indexOf(plant), 1);
    },
    get: function(plantId) {
      for (var i = 0; i < plants.length; i++) {
        if (plants[i].id === parseInt(plantId)) {
          return plants[i];
        }
      }
      return null;
    }
  };
});
