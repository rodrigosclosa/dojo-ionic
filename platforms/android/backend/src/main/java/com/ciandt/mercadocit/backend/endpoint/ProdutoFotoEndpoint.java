package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Produto;
import com.ciandt.mercadocit.backend.entity.ProdutoFoto;
import com.ciandt.mercadocit.backend.service.ProdutoFotoService;
import com.ciandt.mercadocit.backend.service.ProdutoService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

import javax.inject.Named;

/**
 * Created by gsanchez on 30/03/2016.
 */
@Api(
    name = "produtoFoto",
    version = "v1",
    namespace = @ApiNamespace(
            ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
            ownerName = "endpoint.backend.mercadocit.ciandt.com",
            packagePath = ""
    )
)
public class ProdutoFotoEndpoint {

    private ProdutoFotoService ProdutoFotoService;
    private ProdutoService produtoService;

    public ProdutoFotoEndpoint() {
        ProdutoFotoService = new ProdutoFotoService();
        produtoService = new ProdutoService();
    }

    @ApiMethod(name = "getProdutoFotos", path = "get", httpMethod = ApiMethod.HttpMethod.GET)
    public List<ProdutoFoto> getProdutoFotos(@Nullable @Named("search") String nome) throws NotFoundException {
        if(nome == null || nome.isEmpty())
            return ProdutoFotoService.list();
        else
            return ProdutoFotoService.list(nome);
    }

    @ApiMethod(name = "getProdutoFoto", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public ProdutoFoto getProdutoFoto(@Named("id") Long id) throws NotFoundException {
        return ProdutoFotoService.getById(id);
    }

    @ApiMethod(name = "getfotosByProduto", path = "getbyproduto/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<ProdutoFoto> getfotosByProduto(@Named("id") Long id) throws NotFoundException {
        return ProdutoFotoService.listByProduto(id);
    }

    @ApiMethod(name = "insertProdutoFoto", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public ProdutoFoto insertProdutoFoto(ProdutoFoto tipo) throws ConflictException, NotFoundException {
        return ProdutoFotoService.insert(tipo);
    }

    @ApiMethod(name = "updateProdutoFoto", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateProdutoFoto(ProdutoFoto ProdutoFoto) throws NotFoundException, ConflictException {
        ProdutoFotoService.update(ProdutoFoto);
    }

    @ApiMethod(name = "deleteProdutoFoto", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteProdutoFoto(@Named("id") Long id) throws NotFoundException, ConflictException {
        ProdutoFotoService.remove(id);
    }
}
