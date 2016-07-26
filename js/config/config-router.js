
/**
 * Used to define the application routes for this mobile application.
 * @param {obejct|angular} app - The Angular object
 *                               that referenciate this app.
 */
(function (app){

  var config = app.config(function($stateProvider, $urlRouterProvider) {

    $stateProvider.state('introduction', {
      url: "/market/intro",
        templateUrl: "templates/public/welcome.html",
        controller: 'WelcomeCtrl'
    });

    $stateProvider.state('authentication', {
      url: "/market/auth",
      templateUrl: "templates/public/authentication.html",
      controller: 'AuthenticationCtrl'
    });

    $stateProvider.state('private', {
      url: "/market/private",
      templateUrl: "templates/private/menu.html",
      controller: 'MainCtrl'
    });

    $stateProvider.state('private.home', {
      url: "/home",
      views : {
        'main-content': {
          templateUrl: "templates/private/home.html",
          controller: 'HomeCtrl'
        }
      }
    });

    $urlRouterProvider.otherwise('/market/intro');

  });


})(market);
