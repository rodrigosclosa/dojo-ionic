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
    private Long idUsuario;

    @Ignore
    private Objectify ofy = ObjectifyService.ofy();

    public Produto() {
    }

    public Produto(Long id, String nome, Long idUsuario) {
        this.id = id;
        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    @OnLoad
    void OnLoad(){
        if(this.idUsuario != null){
            this.usuario = ofy.load().type(Usuario.class).id(this.idUsuario).now();
        }
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
