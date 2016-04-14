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
    private ProdutoService produtoService;

    public ProdutoComentarioEndpoint() {
        produtoComentarioService = new ProdutoComentarioService();
        produtoService = new ProdutoService();
    }

    @ApiMethod(name = "getProdutoComentarios", path = "produtoComentario", httpMethod = ApiMethod.HttpMethod.GET)
    public List<ProdutoComentario> getProdutoComentarios() throws NotFoundException {

            return produtoComentarioService.list();
    }

    @ApiMethod(name = "getProdutoComentario", path = "produtoComentario/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public ProdutoComentario getProdutoComentario(@Named("id") Long id) throws NotFoundException {
        return produtoComentarioService.getById(id);
    }

    @ApiMethod(name = "getProdutoComentariosByProduto", path = "produtoComentarios/{produto}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<ProdutoComentario> getProdutoComentariosByBase(@Named("produto") Long idProduto) throws NotFoundException {
        Produto produto = produtoService.getById(idProduto);
        return produtoComentarioService.listByProduto(produto.getId());
    }

    @ApiMethod(name = "insertProdutoComentario", path = "produtoComentario", httpMethod = ApiMethod.HttpMethod.POST)
    public void insertProdutoComentario(ProdutoComentario tipo) throws ConflictException, NotFoundException {
        produtoComentarioService.insert(tipo);
    }

    @ApiMethod(name = "updateProdutoComentario", path = "produtoComentario", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateProdutoComentario(ProdutoComentario ProdutoComentario) throws NotFoundException, ConflictException {
        produtoComentarioService.update(ProdutoComentario);
    }

    @ApiMethod(name = "deleteProdutoComentario", path = "produtoComentario/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteProdutoComentario(@Named("id") Long id) throws NotFoundException, ConflictException {
        produtoComentarioService.remove(id);
    }
}
