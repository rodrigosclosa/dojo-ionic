package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Base;
import com.ciandt.mercadocit.backend.service.BaseService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

import javax.inject.Named;

/**
 * Created by rodrigosclosa on 29/12/15.
 */
@Api(
    name = "base",
    version = "v1",
    namespace = @ApiNamespace(
            ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
            ownerName = "endpoint.backend.mercadocit.ciandt.com",
            packagePath = ""
    )
)
public class BaseEndpoint {

    private BaseService baseService;

    public BaseEndpoint() {
        baseService = new BaseService();
    }

    @ApiMethod(name = "getBases", path = "base", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Base> getBases(@Nullable @Named("search") String nome) throws NotFoundException {
        if(nome == null || nome.isEmpty())
            return baseService.list();
        else
            return baseService.list(nome);
    }

    @ApiMethod(name = "getBase", path = "base/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Base getBase(@Named("id") Long id) throws NotFoundException {
        return baseService.getById(id);
    }

    @ApiMethod(name = "insertBase", path = "base", httpMethod = ApiMethod.HttpMethod.POST)
    public void insertBase(Base tipo) throws ConflictException, NotFoundException {
        baseService.insert(tipo);
    }

    @ApiMethod(name = "updateBase", path = "base", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateBase(Base base) throws NotFoundException, ConflictException {
        baseService.update(base);
    }

    @ApiMethod(name = "deleteBase", path = "base/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteBase(@Named("id") Long id) throws NotFoundException, ConflictException {
        baseService.remove(id);
    }

}
