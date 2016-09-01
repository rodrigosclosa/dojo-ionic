angular.module('adminApp')
  .controller('ProdutoNewCtrl', function ($scope) {
    
    $scope.previewFile = function() {
      var preview = document.querySelector('img');
      var file    = document.querySelector('input[type=file]').files[0];
      var reader  = new FileReader();

      reader.addEventListener("load", function () {
        preview.src = reader.result;
      }, false);

      if (file) {
        reader.readAsDataURL(file);
      }
    }
  });
