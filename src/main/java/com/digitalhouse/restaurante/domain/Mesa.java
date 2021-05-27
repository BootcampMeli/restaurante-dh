package com.digitalhouse.restaurante.domain;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private Integer id;
    private List<Pedido> pedidos = new ArrayList<>();

    public Mesa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Double getTotalConsumido(){
        return pedidos.stream().mapToDouble(pedido -> pedido.getTotalPedido()).sum();
    }
}
