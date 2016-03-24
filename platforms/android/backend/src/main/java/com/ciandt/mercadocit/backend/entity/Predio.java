package com.ciandt.mercadocit.backend.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

import javax.annotation.Nullable;


/**
 * Created by rodrigosclosa on 24/03/16.
 */
@Entity
public class Predio {

    @Id
    private Long id;

    @Index
    private String nome;

    private String icone;

    @Ignore
    @Nullable
    private Base base;

    @Index
    private Long idBase;

    public Predio() {
    }

    public Predio(Long id, String nome, String icone, Long idBase) {
        this.id = id;
        this.nome = nome;
        this.icone = icone;
        this.idBase = idBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Nullable
    public Base getBase() {
        return base;
    }

    public void setBase(@Nullable Base base) {
        this.base = base;
    }

    public Long getIdBase() {
        return idBase;
    }

    public void setIdBase(Long idBase) {
        this.idBase = idBase;
    }
}
