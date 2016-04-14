package com.ciandt.mercadocit.backend.entity;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by gsanchez on 29/03/2016.
 */
@Entity
public class Produto {

    @Id
    private Long id;

    @Index
    private String nome;

    @Ignore
    @Nullable
    private Usuario usuario;

    @Index
    private Long idPredio;

    @Index
    private Long idUsuario;

    private String descricao;

    public Produto() {
    }

    public Produto(Long id, String nome, Long idUsuario, String descricao) {
        this.id = id;
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.descricao = descricao;
    }

    @OnLoad
    void OnLoad(){
        if(this.idUsuario != null){
            this.usuario = ofy().load().type(Usuario.class).id(this.idUsuario).now();
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
