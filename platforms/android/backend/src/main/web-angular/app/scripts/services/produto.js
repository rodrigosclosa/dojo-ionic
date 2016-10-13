angular.module('app.services', [])

.factory('ProdutoService', function(RetornoServicos, api) {
  // Might use a resource here that returns a JSON array

  // TODO: fazer a instancia do google para o endpoint produto

    //Retorna a URL padrão dos serviços do Google App Engine
    var urlBase = ProdutoConfig.urlServicos();

    

  return {
    all: function(parametros, callback) {
        var retorno = RetornoServicos.retorno();

        RetornoServicos.setCallback(callback);

        $http.get(urlBase + 'produto/v1/list', parametros)
          .success(RetornoServicos.sucessoRetorno)
          .error(sucessoRetorno.erroRetorno);
      },
      //Função para inserir ou atualizar uma planta
      addOrUpdate: function (item, callback) {
        var retorno = RetornoServicos.retorno();

        if (item.id != null) {
          $http.put(urlBase + 'produto/v1/update', item)
            .success(function (response) {
              retorno.success = true;
              retorno.items = response;

              if (typeof (callback) === "function") {
                callback(retorno);
              }
            })
            .error(function (data, status) {
              retorno.success = false;
              retorno.erro = {
                codigo: status,
                mensagem: data
              };

              if (typeof (callback) === "function") {
                callback(retorno);
              }
            });
        } else {
          $http.post(urlBase + 'produto/v1/new', item)
            .success(function (response) {
              retorno.success = true;
              retorno.items = response;

              if (typeof (callback) === "function") {
                callback(retorno);
              }
            })
            .error(function (data, status) {
              retorno.success = false;
              retorno.erro = {
                codigo: status,
                mensagem: data
              };

              if (typeof (callback) === "function") {
                callback(retorno);
              }
            });
        }
      },
    remove: function (produtoId, callback) {
        var retorno = RetornoServicos.retorno();

        $http.delete(urlBase + 'produto/v1/delete/' + produtoId)
          .success(function (response) {
            retorno.success = true;
            if (typeof (callback) === "function") {
              callback(retorno);
            }
          })
          .error(function (data, status) {
            retorno.success = false;
            retorno.erro = {
              codigo: status,
              mensagem: data
            };

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          });
      },
    get: function (produtoId, callback) {
        var retorno = RetornoServicos.retorno();

        $http.get(urlBase + 'produto/v1/get/' + produtoId)
          .success(function (response) {
            retorno.success = true;
            retorno.items = response;

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          })
          .error(function (data, status) {
            retorno.success = false;
            retorno.erro = {
              codigo: status,
              mensagem: data
            };

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          });
      },
    getByUsuario: function (usuarioId, callback) {
        var retorno = RetornoServicos.retorno();

        $http.get(urlBase + 'produto/v1/getbyusuario/' + usuarioId)
          .success(function (response) {
            retorno.success = true;
            retorno.items = response;

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          })
          .error(function (data, status) {
            retorno.success = false;
            retorno.erro = {
              codigo: status,
              mensagem: data
            };

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          });
      },
    getByOffset: function (offset, callback) {
        var retorno = RetornoServicos.retorno();

        $http.get(urlBase + 'produto/v1/getByOffset/' + offset)
          .success(function (response) {
            retorno.success = true;
            retorno.items = response;

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          })
          .error(function (data, status) {
            retorno.success = false;
            retorno.erro = {
              codigo: status,
              mensagem: data
            };

            if (typeof (callback) === "function") {
              callback(retorno);
            }
          });
      }
  };
});
