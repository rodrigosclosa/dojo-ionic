'use strict';

    /**
     * @ngdoc function
     * @name adminApp.controller:MainCtrl
     * @description
     * # MainCtrl
     * Controller of the adminApp
     */
  angular.module('adminApp').controller('MainCtrl', function ($scope) {
    var apiRoot = '//' + window.location.host + '/_ah/api';
    var google = google || {};
    google.appengine = google.appengine || {};
    google.appengine.mercadocit = google.appengine.mercadocit || {};
    google.appengine.mercadocit.admin = google.appengine.mercadocit.admin || {};

    google.appengine.mercadocit.admin.CLIENT_ID = '1070033295282-3da3me5q9o8dbir6il7998lsf0d4sj5t.apps.googleusercontent.com';
    google.appengine.mercadocit.admin.SCOPES = 'https://www.googleapis.com/auth/userinfo.email';

    google.appengine.mercadocit.admin.signedIn = false;

    $scope.userAuthed = function() {
      var request = gapi.client.oauth2.userinfo.get().execute(function(resp) {
        if (!resp.code) {
          google.appengine.mercadocit.admin.signedIn = true;
          document.querySelector('#signinButton').textContent = 'Sign out';
          // document.querySelector('#authedGreeting').disabled = false;
        }
      });
    };

    $scope.signin = function(mode, callback) {
      gapi.auth.authorize({client_id: google.appengine.mercadocit.admin.CLIENT_ID,
          scope: google.appengine.mercadocit.admin.SCOPES, immediate: mode},
          callback);
    };

    $scope.auth = function() {
      if (!google.appengine.mercadocit.admin.signedIn) {
        $scope.signin(false, $scope.userAuthed);
      } else {
        google.appengine.mercadocit.admin.signedIn = false;
        document.querySelector('#signinButton').textContent = 'Google Login';
        // document.querySelector('#authedGreeting').disabled = true;
      }
    };

    $scope.init = function() {
      var apisToLoad;
      var callback = function() {
        if (--apisToLoad === 0) {
          //google.appengine.samples.hello.enableButtons();
          $scope.signin(true, $scope.userAuthed);
        }
      };

      apisToLoad = 9; // must match number of calls to gapi.client.load()
      gapi.client.load('base', 'v1', callback, apiRoot);
      gapi.client.load('predio', 'v1', callback, apiRoot);
      gapi.client.load('produto', 'v1', callback, apiRoot);
      gapi.client.load('produtoComentario', 'v1', callback, apiRoot);
      gapi.client.load('produtoFoto', 'v1', callback, apiRoot);
      gapi.client.load('usuario', 'v1', callback, apiRoot);
      gapi.client.load('usuarioFavorito', 'v1', callback, apiRoot);
      gapi.client.load('usuarioLike', 'v1', callback, apiRoot);
      gapi.client.load('oauth2', 'v2', callback);
    };

    var signinButton = document.querySelector('#signinButton');
    signinButton.addEventListener('click', $scope.auth);

  });
