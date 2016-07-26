
/**
 * Controller used to perform google platform authentication.
 * @param {obejct|angular} app - The Angular object
 *                               that referenciate this app.
 */
(function (app){
  app.controller('AuthenticationCtrl', function ($scope, $state, UserService, $ionicLoading){

    $scope.googleSignIn = function() {

      if (!window.plugins) {
        $state.go('private.home');
        return;
      }

      $ionicLoading.show({
        template: 'Logging in...'
      });

      window.plugins.googleplus.login(
        {},
        function (user_data) {
          UserService.setUser({
            userID: user_data.userId,
            name: user_data.displayName,
            email: user_data.email,
            picture: user_data.imageUrl,
            accessToken: user_data.accessToken,
            idToken: user_data.idToken
          });
          $ionicLoading.hide();
          $state.go('app.home');

        },
        function (msg) {
          $ionicLoading.hide();
        }
      );
    };

    $scope.introducao = function () {
      $state.go("introduction");
    };

  });
})(market);
