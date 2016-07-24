'use strict';

(function (app){

  var config = app.config(function($stateProvider, $urlRouterProvider) {

    $stateProvider.state('market', {
      url: "/market",
        templateUrl: "templates/public/welcome.html",
        controller: 'WelcomeCtrl'
    });

    $stateProvider.state('market.authentication', {
      url: "/public/authentication",
      views: {
        'main-content': {
          templateUrl: "templates/public/authentication.html",
          controller: 'AuthenticationCtrl'
        }
      }
    });

    $stateProvider.state('market.home', {
      url: "/private/home",
      views: {
        'menu-content': {
          templateUrl: "templates/private/menu.html",
          controller: 'MainCtrl'
        }
      }
    });

    $stateProvider.state('market.profile', {
      url: "/private/profile",
      views: {
        'menu-content': {
          templateUrl: "templates/private/profile-settings.html",
          controller: 'ProfileSettingsCtrl'
        }
      }
    });

    $urlRouterProvider.otherwise('/market');

  });


})(market);
