package com.ciandt.mercadocit.backend.model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Garage on 22/09/16.
 */

public class RetornoApiBase<T> implements Serializable {

    private T valor;
    private String texto;

    public RetornoApiBase(T valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public RetornoApiBase() {
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
