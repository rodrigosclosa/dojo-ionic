package com.ciandt.mercadocit.backend.endpoint;

import com.ciandt.mercadocit.backend.entity.Usuario;
import com.ciandt.mercadocit.backend.service.UsuarioService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Gabriel on 29/03/2016.
 */
@Api(
        name="usuario",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "endpoint.backend.mercadocit.ciandt.com",
                ownerName = "endpoint.backend.mercadocit.ciandt.com",
                packagePath = ""
        )
)
public class UsuarioEndpoint {

    private UsuarioService usuarioService;

    public UsuarioEndpoint(){
        usuarioService = new UsuarioService();
    }

    @ApiMethod(name = "getUsuarios", path = "usuario", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Usuario> getUsuarios(@Nullable @Named("search") String nome) throws NotFoundException{
        if(nome == null || nome.isEmpty())
            return usuarioService.list();
        else
            return usuarioService.list(nome);
    }


    @ApiMethod(name = "getUsuario", path = "usuario/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Usuario getUsuario(@Named("id") Long id) throws NotFoundException {
        return usuarioService.getById(id);
    }

    @ApiMethod(name = "insertUsuario", path = "usuario", httpMethod = ApiMethod.HttpMethod.POST)
    public void insertUsuario(Usuario usuario) throws ConflictException, NotFoundException {
        usuarioService.insert(usuario);
    }

    @ApiMethod(name = "updateUsuario", path = "usuario", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateUsuario(Usuario usuario) throws NotFoundException, ConflictException {
        usuarioService.update(usuario);
    }

    @ApiMethod(name = "deleteUsuario", path = "usuario/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteUsuario(@Named("id") Long id) throws NotFoundException, ConflictException {
        usuarioService.remove(id);
    }

}
