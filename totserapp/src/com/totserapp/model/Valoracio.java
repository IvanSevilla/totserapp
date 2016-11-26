package com.totserapp.model;

public class Valoracio {
    int valor;
    String clientId;

    public Valoracio(int valor, String clientId) {
        this.valor = valor;
        this.clientId = clientId;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
}
