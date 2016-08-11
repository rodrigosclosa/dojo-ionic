package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.UsuarioLike;
import com.ciandt.mercadocit.backend.service.UsuarioLikeService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

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

    @ApiMethod(name = "getUsuarioLike", path = "UsuarioLike/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public UsuarioLike getUsuarioLike(@Named("id") Long id) throws NotFoundException {
        return usuarioLikeService.getById(id);
    }

    @ApiMethod(name = "getLikeByUsuario", path = "LikeByUsuario/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<UsuarioLike> getLikeByUsuario(@Named("id") Long id) throws NotFoundException {
        return usuarioLikeService.listByUsuario(id);
    }

    @ApiMethod(name = "insertUsuarioLike", path = "UsuarioLike", httpMethod = ApiMethod.HttpMethod.POST)
    public UsuarioLike insertUsuarioLike(UsuarioLike tipo) throws ConflictException, NotFoundException {
        return usuarioLikeService.insert(tipo);
    }

    @ApiMethod(name = "updateUsuarioLike", path = "UsuarioLike", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateUsuarioLike(UsuarioLike UsuarioLike) throws NotFoundException, ConflictException {
        usuarioLikeService.update(UsuarioLike);
    }

    @ApiMethod(name = "deleteUsuarioLike", path = "UsuarioLike/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteUsuarioLike(@Named("id") Long id) throws NotFoundException, ConflictException {
        usuarioLikeService.remove(id);
    }
}
