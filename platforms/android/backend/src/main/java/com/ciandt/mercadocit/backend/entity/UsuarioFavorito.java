package com.ciandt.mercadocit.backend.entity;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;

import javax.annotation.Nullable;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by gsanchez on 31/03/2016.
 */
@Entity
public class UsuarioFavorito {

    @Id
    private Long id;

    @Index
    private Long idUsuario;

    @Ignore
    @Nullable
    private Usuario usuario;

    private Long idUsuarioFavorito;

    @Ignore
    @Nullable
    private Usuario usuarioFavorito;


    public UsuarioFavorito() {
    }

    public UsuarioFavorito(Long idUsuario, Long idUsuarioFavorito) {
        this.idUsuario = idUsuario;
        this.idUsuarioFavorito = idUsuarioFavorito;
    }

    @OnLoad
    void OnLoad(){
        if(this.idUsuarioFavorito != null){
            this.usuarioFavorito = ofy().load().type(Usuario.class).id(this.idUsuarioFavorito).now();
        }
        if(this.idUsuario != null){
            this.usuario = ofy().load().type(Usuario.class).id(this.idUsuario).now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Nullable
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@Nullable Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdUsuarioFavorito() {
        return idUsuarioFavorito;
    }

    public void setIdUsuarioFavorito(Long idUsuarioFavorito) {
        this.idUsuarioFavorito = idUsuarioFavorito;
    }

    @Nullable
    public Usuario getUsuarioFavorito() {
        return usuarioFavorito;
    }

    public void setUsuarioFavorito(@Nullable Usuario usuarioFavorito) {
        this.usuarioFavorito = usuarioFavorito;
    }
}
