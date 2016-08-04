package com.ciandt.mercadocit.backend.entity;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;

import javax.annotation.Nullable;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

public class UsuarioLike {

    @Id
    private Long id;

    @Index
    private Long idUsuario;

    @Ignore
    @Nullable
    private Usuario usuario;

    @Index
    private Long idProduto;

    @Ignore
    @Nullable
    private Produto produto;

    public UsuarioLike(Long idUsuario, Long idProduto) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
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

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @Nullable
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(@Nullable Produto produto) {
        this.produto = produto;
    }
}
