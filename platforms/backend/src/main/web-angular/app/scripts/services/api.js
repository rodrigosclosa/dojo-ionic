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
    
    var api = {};
    
    api.get = function(route,params){
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
        return $http.get(route,params);
    }
    
    api.post = function(route,params){
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
       return $http.post(route,params);
    }
    
    api.delete = function(route,params){
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
        return $http.delete(route,params);
    }
    
    api.put = function(route,params){
        route = 'https://mercado-cit.appspot.com/_ah/api/' + route;
       return $http.put(route,params);
    }
    
    return api;
    
  });
