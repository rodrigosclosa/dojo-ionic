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
    .controller('SocialController', function($scope, SocialButtons){
        console.log($scope.produto);
        $scope.like = function(){
            SocialButtons.teste(1);
            console.log("Like",$scope.produto);
        }

        $scope.bookmark = function(){
            console.log("bookmark",$scope.produto);
        }

        $scope.sendEmail = function(){
            console.log("sendemail",$scope.produto);
        }
    })
    .service('SocialButtons', function(){
        return {
            teste :function(a){
                console.log(a);
            }
        }
    })


    /**
     * Like para produtos / usaurios, usuario podem usar o like para avaliar os produtos
     * Favorite para usuarios favoritar outros usuario para quando o mesmo publicar produtos ser notificado
     */