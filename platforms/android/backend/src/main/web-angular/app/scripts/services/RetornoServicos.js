angular.module('app.services')

    //Objeto padrão de retorno dos serviços
    .factory('RetornoServicos', function () {
        var objeto = {
            success: false,
            items: {},
            erro: {
                codigo: "",
                mensagem: ""
            }
        };
        var successCallbackDefault = function (response) {
            var retorno = objeto;
            retorno.success = true;
            retorno.items = response.items;

            if (typeof (callback) === "function") {
                callback(retorno);
            }
        };
        var errorCallbackDefault = function (data, status) {
            var retorno = objeto;
            retorno.success = false;
            retorno.erro = {
                codigo: status,
                mensagem: data
            };

            if (typeof (callback) === "function") {
                callback(retorno);
            }
        };
        return {
            retorno: function () {
                return objeto;
            },
            sucessoRetorno: function (response) {
                return successCallbackDefault (response);
            },
            erroRetorno: function (data, status) {
                return errorCallbackDefault (data, status);
            }
        };
    });