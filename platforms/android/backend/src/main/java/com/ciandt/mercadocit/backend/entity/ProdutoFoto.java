package com.ciandt.mercadocit.backend.entity;

import com.google.appengine.api.datastore.Text;
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
 * Created by gsanchez on 30/03/2016.
 */
@Entity
public class ProdutoFoto {

    @Id
    private Long id;

    @Index
    private Text base64;

    @Ignore
    @Nullable
    private Produto produto;

    @Index
    private Long idProduto;

    public ProdutoFoto() {
    }

    public ProdutoFoto(Long id,Text base64, Long idProduto) {
        this.id = id;
        this.base64 = base64;
        this.idProduto = idProduto;
    }

    @OnLoad
    void OnLoad(){
        if(this.idProduto != null){
            this.produto = ofy().load().type(Produto.class).id(this.idProduto).now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Text getBase64() {
        return base64;
    }

    public void setBase64(Text base64) {
        this.base64 = base64;
    }
}
