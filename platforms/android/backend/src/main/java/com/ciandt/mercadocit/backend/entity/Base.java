package com.ciandt.mercadocit.backend.entity;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by rodrigosclosa on 24/03/16.
 */
@Entity
public class Base {

    @Id
    private Long id;

    @Index
    private String nome;
    private String icone;

    public Base() {
    }

    public Base(Long id, String nome, String icone) {
        this.id = id;
        this.nome = nome;
        this.icone = icone;
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

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
}