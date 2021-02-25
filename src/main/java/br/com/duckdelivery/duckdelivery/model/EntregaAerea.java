package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public class EntregaAerea extends Entrega{

    public EntregaAerea(Integer id, String local, Double distancia, List<Produto> produtos) {
        super(id, local, distancia, produtos);
        this.taxa = 0.3;
    }

    @Override
    public Double calcularEntrega(List<Produto> produtos, Double taxa) {
        return null;
    }
}
