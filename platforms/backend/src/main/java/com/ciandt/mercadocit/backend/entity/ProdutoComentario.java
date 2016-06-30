package com.ciandt.mercadocit.backend.entity;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;

import java.util.Date;

import javax.annotation.Nullable;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by Garage on 07/04/16.
 */

@Entity
public class ProdutoComentario {

    @Id
    private Long id;

    @Ignore
    @Nullable
    private Produto produto;

    @Index
    private Long idProduto;

    private String comentario;

    @Ignore
    @Nullable
    private Usuario usuario;

    private Long idUsuario;

    private Date data;

    public ProdutoComentario() {
    }

    public ProdutoComentario(Long id, Long idProduto, String comentario, Long idUsuario) {
        this.id = id;
        this.idProduto = idProduto;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
        this.data = new Date();
    }

    @OnLoad
    void onLoad()
    {
        if(this.idProduto != null)
        {
            this.produto = ofy().load().type(Produto.class).id(idProduto).now();

        }
        if(this.idUsuario != null)
        {
            this.usuario = ofy().load().type(Usuario.class).id(idUsuario).now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(@Nullable Produto produto) {
        this.produto = produto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Nullable
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@Nullable Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
