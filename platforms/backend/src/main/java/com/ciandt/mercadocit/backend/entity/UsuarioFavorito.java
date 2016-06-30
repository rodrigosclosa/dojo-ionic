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

    @Ignore
    @Nullable
    private Produto produto;

    @Index
    private Long idProduto;

    @Ignore
    @Nullable
    private Usuario usuario;

    @Index
    private Long idUsuario;

    public UsuarioFavorito() {
    }

    public UsuarioFavorito(Long idProduto, Long id, Long idUsuario) {
        this.idProduto = idProduto;
        this.id = id;
        this.idUsuario = idUsuario;
    }

    @OnLoad
    void OnLoad(){
        if(this.idProduto != null){
            this.produto = ofy().load().type(Produto.class).id(this.idProduto).now();
        }
        if(this.idUsuario != null){
            this.usuario = ofy().load().type(Usuario.class).id(this.idUsuario).now();
        }
    }

    @Nullable
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(@Nullable Produto produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@Nullable Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
