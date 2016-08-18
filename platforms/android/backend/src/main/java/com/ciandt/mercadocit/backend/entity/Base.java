package com.ciandt.mercadocit.backend.entity;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

import java.util.List;

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
    private String sigla;
    @Ignore
    private List<Predio> predios;

    public Base() {
    }

    public Base(Long id, String nome, String icone, String sigla) {
        this.id = id;
        this.nome = nome;
        this.icone = icone;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Predio> getPredios() {
        return predios;
    }

    public void setPredios(List<Predio> predios) {
        this.predios = predios;
    }
}
