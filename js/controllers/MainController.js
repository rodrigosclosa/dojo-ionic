
/**
 * Controller used to perform google platform authentication.
 * @param {obejct|angular} app - The Angular object
 *                               that referenciate this app.
 */
(function (app){
  app.controller('MainCtrl', function ($scope, $state, UserService, $ionicLoading){

    $scope.user = UserService.getUser();

  	$scope.showLogOutMenu = function() {

      if (!window.plugins) {
        $state.go('introduction');
        return;
      }

  		var hideSheet = $ionicActionSheet.show({
  			destructiveText: 'Logout',
  			titleText: 'Are you sure you want to logout? This app is awsome so I recommend you to stay.',
  			cancelText: 'Cancel',
  			cancel: function() {},
  			buttonClicked: function(index) {
  				return true;
  			},
  			destructiveButtonClicked: function(){
  				$ionicLoading.show({
  					template: 'Logging out...'
  				});
  				// Google logout
  				window.plugins.googleplus.logout(
  					function (msg) {
  						console.log(msg);
  						$ionicLoading.hide();
  						$state.go('introduction');
  					},
  					function(fail){
  						console.log(fail);
  					}
  				);
  			}
  		});
  	};
  });

})(market);
