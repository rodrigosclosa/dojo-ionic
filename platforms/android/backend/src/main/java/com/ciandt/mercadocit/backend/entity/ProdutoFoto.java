package com.ciandt.mercadocit.backend.entity;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;

import javax.annotation.Nullable;

/**
 * Created by gsanchez on 30/03/2016.
 */
@Entity
public class ProdutoFoto {

    @Id
    private Long id;

    @Index
    private String nome;

    @Ignore
    @Nullable
    private Produto produto;

    @Index
    private Long idProduto;

    @Ignore
    private Objectify ofy = ObjectifyService.ofy();

    public ProdutoFoto() {
    }

    public ProdutoFoto(Long id, String nome, Long idProduto) {
        this.id = id;
        this.nome = nome;
        this.idProduto = idProduto;
    }

    @OnLoad
    void OnLoad(){
        if(this.idProduto != null){
            this.produto = ofy.load().type(Produto.class).id(this.idProduto).now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Objectify getOfy() {
        return ofy;
    }

    public void setOfy(Objectify ofy) {
        this.ofy = ofy;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
