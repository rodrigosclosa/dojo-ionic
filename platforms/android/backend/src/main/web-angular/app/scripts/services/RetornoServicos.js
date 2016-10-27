'use strict';
angular.module('app.Retorno',[])

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
        var successCallbackDefault = function (response, callback) {
            var retorno = objeto;
            retorno.success = true;
            retorno.items = response.items;

            if (typeof (callback) === "function") {
                callback(retorno);
            }
        };
        var errorCallbackDefault = function (data, status, callback) {
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
                console.log("Teste 2")
                return successCallbackDefault (response);
            },
            erroRetorno: function (data, status) {
                                console.log("Teste 1")
                return errorCallbackDefault (data, status);
            }
        };
    });