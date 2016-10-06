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
            var produto = JSON.parse($scope.produto);
            SocialButtons.like(parseInt(produto.id));
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

    .service('SocialButtons', function(api, UsuarioService){
        return {
            bookmark :function(id){
                return api.post('usuarioFavorito/v1/new', {
                    idUsuario : UsuarioService.getId(),
                    idUsuarioFavorito : id
                })

            },

            like : function(id){
                return api.post('usuarioLike/v1/like', {
                    idUsuario : UsuarioService.getId(),
                    idProduto : id
                })
            }
        }
    })


    /**
     * Like para produtos / usaurios, usuario podem usar o like para avaliar os produtos
     * Favorite para usuarios favoritar outros usuario para quando o mesmo publicar produtos ser notificado
     */