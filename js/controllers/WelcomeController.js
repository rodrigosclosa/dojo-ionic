
/**
 * Controller used to perform welcome intro flow.
 * @param {obejct|angular} app - The Angular object
 *                               that referenciate this app.
 */
(function (app){

  app.controller('WelcomeCtrl', function ($scope, $state){

    $scope.options = {
      loop: false,
      effect: 'slide',
      speed: 500
    };

    $scope.data = {};
    $scope.activeIndex = 0;

    $scope.autenticate = function() {
      $state.go('market.authentication');
    };

    $scope.next = function() {
      $scope.data.slider.slideNext();
    };

    $scope.previous = function() {
      $scope.data.slider.slidePrev();
    };


  });

})(market);
