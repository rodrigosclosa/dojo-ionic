package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Produto;
import com.ciandt.mercadocit.backend.entity.UsuarioLike;
import com.ciandt.mercadocit.backend.model.RetornoApiBase;
import com.ciandt.mercadocit.backend.model.RetornoApiBoolean;
import com.ciandt.mercadocit.backend.service.UsuarioLikeService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * Created by Garage on 11/08/16.
 */
@Api(
        name = "usuarioLike",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
                ownerName = "endpoint.backend.mercadocit.ciandt.com",
                packagePath = ""
        )
)
public class UsuarioLikeEndpoint {
    private UsuarioLikeService usuarioLikeService;

    public UsuarioLikeEndpoint() {
        usuarioLikeService = new UsuarioLikeService();
    }

    @ApiMethod(name = "getUsuarioLike", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public UsuarioLike getUsuarioLike(@Named("id") Long id) throws NotFoundException {
        return usuarioLikeService.getById(id);
    }

    @ApiMethod(name = "getLikeByUsuario", path = "getbyusuario/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<UsuarioLike> getLikeByUsuario(@Named("id") Long id) throws NotFoundException {
        return usuarioLikeService.listByUsuario(id);
    }

    @ApiMethod(name = "getLikeByProduto", path = "getbyproduto/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<UsuarioLike> getLikeByProduto(@Named("id") Long id) throws NotFoundException {
        return usuarioLikeService.listByProduto(id);
    }

    @ApiMethod(name = "getProdutosByLikeUsuario", path = "getProdutoLike/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Produto> getProdutosByLikeUsuario(@Named("id") Long id) throws NotFoundException {
        List<UsuarioLike> usuarioLikes = usuarioLikeService.listByUsuario(id);
        List<Produto> listProdutos = new ArrayList<>();
        for(UsuarioLike userLike : usuarioLikes){
            listProdutos.add(userLike.getProduto());
        }
        return listProdutos;
    }

    @ApiMethod(name = "insertUsuarioLike", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public UsuarioLike insertUsuarioLike(UsuarioLike tipo) throws ConflictException, NotFoundException {
        return usuarioLikeService.insert(tipo);
    }

    @ApiMethod(name = "likeUsuarioLike", path = "like", httpMethod = ApiMethod.HttpMethod.POST)
    public RetornoApiBoolean likeUsuarioLike(UsuarioLike tipo) throws ConflictException, NotFoundException {
        return usuarioLikeService.like(tipo);
    }

    @ApiMethod(name = "updateUsuarioLike", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateUsuarioLike(UsuarioLike UsuarioLike) throws NotFoundException, ConflictException {
        usuarioLikeService.update(UsuarioLike);
    }

    @ApiMethod(name = "deleteUsuarioLike", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteUsuarioLike(@Named("id") Long id) throws NotFoundException, ConflictException {
        usuarioLikeService.remove(id);
    }
}
