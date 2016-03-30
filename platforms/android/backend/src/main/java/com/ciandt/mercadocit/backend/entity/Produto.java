package com.ciandt.mercadocit.backend.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

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
    private List<ProdutoFoto> fotos;

    private List<Long> idFotos;

    @Ignore
    @Nullable
    private Usuario usuario;

    @Index
    private Long idUsuario;

    public Produto() {
    }

    public Produto(Long id, String nome, List<Long> idFotos, Long idUsuario) {
        this.id = id;
        this.nome = nome;
        this.idFotos = idFotos;
        this.idUsuario = idUsuario;
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
    public List<ProdutoFoto> getFotos() {
        return fotos;
    }

    public void setFotos(@Nullable List<ProdutoFoto> fotos) {
        this.fotos = fotos;
    }

    public List<Long> getIdFotos() {
        return idFotos;
    }

    public void setIdFotos(List<Long> idFotos) {
        this.idFotos = idFotos;
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
