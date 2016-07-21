angular.module('app.routes', [])

  .config(function($stateProvider, $urlRouterProvider) {

    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
    $stateProvider

    .state('app', {
      url: '/app',
      abstract: true,
      templateUrl: 'templates/menu.html',
      controller: 'AppCtrl'
    })
    
    .state('app.principal', {
      url: '/principal',
      views: {
        'menuContent': {
          templateUrl: 'templates/principal.html',
          controller: 'principalCtrl'
        }
      }
    })
    
    .state('app.detalhesProduto', {
      url: '/produto/:id',
      views: {
        'menuContent': {
          templateUrl: 'templates/produto.html',
          controller: 'produtoCtrl'
        }
      }
    });

  //Default page
  $urlRouterProvider.otherwise('/app/principal');
});