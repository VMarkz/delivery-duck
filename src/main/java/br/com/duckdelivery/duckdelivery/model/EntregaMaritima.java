package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public class EntregaMaritima extends Entrega{

    public EntregaMaritima(Integer id, String local, Double distancia, List<Produto> produtos) {
        super(id, local, distancia, produtos);
        this.taxa = 0.2; // retirar taxa como atributo e usar direto no metodo
    }

    @Override
    public Double calcularEntrega(List<Produto> produtos, Double taxa) {
        return null;
    }

}
