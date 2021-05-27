package com.digitalhouse.restaurante.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Integer id;

    @JsonIgnore
    private Mesa mesa;

    private List<Prato> pratos = new ArrayList<>();

    public Pedido(Integer id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Double getTotalPedido(){
        return pratos.stream().mapToDouble(prato -> prato.getTotalPrato()).sum();
    }
}
