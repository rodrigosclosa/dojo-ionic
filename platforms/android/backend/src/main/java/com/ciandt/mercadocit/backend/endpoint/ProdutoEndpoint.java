package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Produto;
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
    name = "produto",
    version = "v1",
    namespace = @ApiNamespace(
            ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
            ownerName = "endpoint.backend.mercadocit.ciandt.com",
            packagePath = ""
    )
)
public class ProdutoEndpoint {
    private ProdutoService produtoService;

    public ProdutoEndpoint() {
        produtoService = new ProdutoService();
    }

    @ApiMethod(name = "getProdutos", path = "Produto", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Produto> getProdutos(@Nullable @Named("search") String nome) throws NotFoundException {
        if(nome == null || nome.isEmpty())
            return produtoService.list();
        else
            return produtoService.list(nome);
    }

    @ApiMethod(name = "getProduto", path = "Produto/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Produto getProduto(@Named("id") Long id) throws NotFoundException {
        return produtoService.getById(id);
    }

    @ApiMethod(name = "insertProduto", path = "Produto", httpMethod = ApiMethod.HttpMethod.POST)
    public void insertProduto(Produto tipo) throws ConflictException, NotFoundException {
        produtoService.insert(tipo);
    }

    @ApiMethod(name = "updateProduto", path = "Produto", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateProduto(Produto Produto) throws NotFoundException, ConflictException {
        produtoService.update(Produto);
    }

    @ApiMethod(name = "deleteProduto", path = "Produto/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteProduto(@Named("id") Long id) throws NotFoundException, ConflictException {
        produtoService.remove(id);
    }
}
