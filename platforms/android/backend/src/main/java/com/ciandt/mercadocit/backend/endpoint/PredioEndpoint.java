package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Base;
import com.ciandt.mercadocit.backend.entity.Predio;
import com.ciandt.mercadocit.backend.service.BaseService;
import com.ciandt.mercadocit.backend.service.PredioService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import javax.inject.Named;
import java.util.List;

/**
 * Created by gsanchez on 24/03/2016.
 */
@Api(
        name = "predio",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
                ownerName = "endpoint.backend.mercadocit.ciandt.com",
                packagePath = ""
        )
)
public class PredioEndpoint {

    private PredioService PredioService;
    private BaseService baseService;

    public PredioEndpoint() {
        PredioService = new PredioService();
        baseService = new BaseService();
    }

    @ApiMethod(name = "getPredios", path = "predio", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Predio> getPredios(@Nullable @Named("search") String nome) throws NotFoundException {
        if(nome == null || nome.isEmpty())
            return PredioService.list();
        else
            return PredioService.list(nome);
    }

    @ApiMethod(name = "getPredio", path = "predio/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Predio getPredio(@Named("id") Long id) throws NotFoundException {
        return PredioService.getById(id);
    }

    @ApiMethod(name = "getPrediosByBase", path = "predios/{base}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Predio> getPrediosByBase(@Named("base") String Nomebase) throws NotFoundException {
        List<Base> base = baseService.list(Nomebase);
        return PredioService.list(base.get(0).getNome());
    }

    @ApiMethod(name = "insertPredio", path = "predio", httpMethod = ApiMethod.HttpMethod.POST)
    public void insertPredio(Predio tipo) throws ConflictException, NotFoundException {
        PredioService.insert(tipo);
    }

    @ApiMethod(name = "updatePredio", path = "predio", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updatePredio(Predio Predio) throws NotFoundException, ConflictException {
        PredioService.update(Predio);
    }

    @ApiMethod(name = "deletePredio", path = "predio/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deletePredio(@Named("id") Long id) throws NotFoundException, ConflictException {
        PredioService.remove(id);
    }
}
