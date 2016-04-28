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
        return $http.get(route,params);
    }
    
    api.post = function(route,params){
       return $http.post(route,params);
    }
    
    api.delete = function(route,params){
        return $http.delete(route,params);
    }
    
    api.put = function(route,params){
       return $http.put(route,params);
    }
    
    return api;
    
  });
