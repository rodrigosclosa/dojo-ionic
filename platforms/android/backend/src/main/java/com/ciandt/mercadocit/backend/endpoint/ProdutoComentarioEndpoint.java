package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Produto;
import com.ciandt.mercadocit.backend.entity.ProdutoComentario;
import com.ciandt.mercadocit.backend.service.ProdutoComentarioService;
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
 * Created by Garage on 07/04/16.
 */
@Api(
        name = "produtoComentario",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
                ownerName = "endpoint.backend.mercadocit.ciandt.com",
                packagePath = ""
        )
)
public class ProdutoComentarioEndpoint {

    private ProdutoComentarioService produtoComentarioService;

    public ProdutoComentarioEndpoint() {
        produtoComentarioService = new ProdutoComentarioService();
    }

    @ApiMethod(name = "getProdutoComentarios", path = "get", httpMethod = ApiMethod.HttpMethod.GET)
    public List<ProdutoComentario> getProdutoComentarios() throws NotFoundException {

            return produtoComentarioService.list();
    }

    @ApiMethod(name = "getProdutoComentario", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public ProdutoComentario getProdutoComentario(@Named("id") Long id) throws NotFoundException {
        return produtoComentarioService.getById(id);
    }

    @ApiMethod(name = "getProdutoComentariosByProduto", path = "getbyproduto/{produto}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<ProdutoComentario> getProdutoComentariosByProduto(@Named("produto") Long idProduto) throws NotFoundException {
        return produtoComentarioService.listByProduto(idProduto);
    }

    @ApiMethod(name = "insertProdutoComentario", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public ProdutoComentario insertProdutoComentario(ProdutoComentario tipo) throws ConflictException, NotFoundException {
        return produtoComentarioService.insert(tipo);
    }

    @ApiMethod(name = "updateProdutoComentario", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateProdutoComentario(ProdutoComentario ProdutoComentario) throws NotFoundException, ConflictException {
        produtoComentarioService.update(ProdutoComentario);
    }

    @ApiMethod(name = "deleteProdutoComentario", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteProdutoComentario(@Named("id") Long id) throws NotFoundException, ConflictException {
        produtoComentarioService.remove(id);
    }
}
