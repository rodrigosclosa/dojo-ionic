(function() {
'use strict';

/**
 * @ngdoc service
 * @name adminApp.api
 * @description
 * # api
 * Service in the adminApp.
 */
angular.module('adminApp')
  .service('api', function ($http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    //var api = {};
    return {
      get: function(route,params) {
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
        return $http.get(route,params);
      },

      post: function(route,params) {
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
        return $http.post(route,params);
      },

      delete: function(route,params) {
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
        return $http.delete(route,params);
      },

      put: function(route,params) {
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
       return $http.put(route,params);
      }
    };
    //return api;
  });
})();
