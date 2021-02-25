package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public interface Cobranca {

    public Double calcularEntrega(List<Produto> produtos, Double taxa);

}
