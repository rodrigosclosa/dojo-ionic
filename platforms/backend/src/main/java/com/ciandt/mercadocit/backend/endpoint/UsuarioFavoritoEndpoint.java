package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.UsuarioFavorito;
import com.ciandt.mercadocit.backend.service.UsuarioFavoritoService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

import javax.inject.Named;

/**
 * Created by gsanchez on 31/03/2016.
 */
@Api(
    name = "usuarioFavorito",
    version = "v1",
    namespace = @ApiNamespace(
            ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
            ownerName = "endpoint.backend.mercadocit.ciandt.com",
            packagePath = ""
    )
)
public class UsuarioFavoritoEndpoint {
    private UsuarioFavoritoService usuarioFavoritoService;

    public UsuarioFavoritoEndpoint() {
        usuarioFavoritoService = new UsuarioFavoritoService();
    }

    @ApiMethod(name = "getUsuarioFavoritos", path = "UsuarioFavorito", httpMethod = ApiMethod.HttpMethod.GET)
    public List<UsuarioFavorito> getUsuarioFavoritos(@Nullable @Named("search") String nome) throws NotFoundException {
        if(nome == null || nome.isEmpty())
            return usuarioFavoritoService.list();
        else
            return usuarioFavoritoService.list(nome);
    }

    @ApiMethod(name = "getUsuarioFavorito", path = "UsuarioFavorito/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public UsuarioFavorito getUsuarioFavorito(@Named("id") Long id) throws NotFoundException {
        return usuarioFavoritoService.getById(id);
    }

    @ApiMethod(name = "getfotosByProduto", path = "UsuarioFavoritoByUsuario/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public List<UsuarioFavorito> getfotosByProduto(@Named("id") Long id) throws NotFoundException {
        return usuarioFavoritoService.listByUsuario(id);
    }

    @ApiMethod(name = "insertUsuarioFavorito", path = "UsuarioFavorito", httpMethod = ApiMethod.HttpMethod.POST)
    public UsuarioFavorito insertUsuarioFavorito(UsuarioFavorito tipo) throws ConflictException, NotFoundException {
        return usuarioFavoritoService.insert(tipo);
    }

    @ApiMethod(name = "updateUsuarioFavorito", path = "UsuarioFavorito", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateUsuarioFavorito(UsuarioFavorito UsuarioFavorito) throws NotFoundException, ConflictException {
        usuarioFavoritoService.update(UsuarioFavorito);
    }

    @ApiMethod(name = "deleteUsuarioFavorito", path = "UsuarioFavorito/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteUsuarioFavorito(@Named("id") Long id) throws NotFoundException, ConflictException {
        usuarioFavoritoService.remove(id);
    }
}
