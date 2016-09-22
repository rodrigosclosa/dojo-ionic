angular.module('app.directives')
    .directive('socialButtons', function(){
        return {
            restrict: 'E',
            templateUrl: 'js/directives/social-buttons.html',
            scope : {
                produto : '@'
            },
            controller : 'SocialController'
        };
    })
    .controller('SocialController', function($scope, SocialButtons, api){
        var usuario = JSON.parse($scope.produto);

        $scope.like = function(){
            $scope.produto = JSON.parse($scope.produto);
            SocialButtons.like(parseInt($scope.produto.id));
        }

        $scope.bookmark = function(id){
            SocialButtons.bookmark(usuario.id)
                .then((response)=>{
                    console.log(response);
                })
                .catch((err)=>{
                    console.log(err);
                })
        }

        $scope.sendEmail = function(){
            console.log("sendemail",$scope.produto);
        }
    })
    .service('SocialButtons', function(api){
        return {
            bookmark :function(id){
                return api.post('usuarioFavorito/v1/new', {
                    idUsuario : 5639445604728832,
                    idUsuarioFavorito : 5664902681198592
                })

            },

            like : function(id){
                return api.post('usuarioLike/v1/like', {
                    idUsuario : 5639445604728832,
                    idProduto : id
                })
            }
        }
    })


    /**
     * Like para produtos / usaurios, usuario podem usar o like para avaliar os produtos
     * Favorite para usuarios favoritar outros usuario para quando o mesmo publicar produtos ser notificado
     */