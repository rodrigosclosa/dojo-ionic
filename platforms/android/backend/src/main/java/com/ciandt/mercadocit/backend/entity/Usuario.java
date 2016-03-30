package com.ciandt.mercadocit.backend.entity;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

import javax.annotation.Nullable;

/**
 * Created by rodrigosclosa on 24/03/16.
 */
@Entity
public class Usuario {

    @Id
    private Long id;

    @Index
    private String email;

    private String nome;

    @Ignore
    @Nullable
    private Predio predio;

    @Index
    private Long idPredio;

    private String telefone;

    public Usuario() {
    }

    public Usuario(Long id, String email, String nome, Long idPredio, String telefone) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.idPredio = idPredio;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Nullable
    public Predio getPredio() {
        return predio;
    }

    public void setPredio(@Nullable Predio predio) {
        this.predio = predio;
    }

    public Long getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(Long idPredio) {
        this.idPredio = idPredio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
