'use strict';

describe('Controller: PredioCtrl', function () {

  // load the controller's module
  beforeEach(module('adminApp'));

  var PredioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PredioCtrl = $controller('PredioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
