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
        return {
            retorno: function () {
                return objeto;
            }
        };
    });