package com.ciandt.mercadocit.backend.model;

/**
 * Created by Garage on 22/09/16.
 */

public class RetornoApiBoolean {
    public Boolean valor;

    public RetornoApiBoolean(Boolean valor) {
        this.valor = valor;
    }

    public RetornoApiBoolean() {
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }
}
