angular.module('app.services', [])

.factory('BlankFactory', [function(){

}])

.service('BlankService', [function(){

}])

.service('UsuarioService', [function(){
    return {
        getId: function() {
            return 5639445604728832;
        }
    }
}]);