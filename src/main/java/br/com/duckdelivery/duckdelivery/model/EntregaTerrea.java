package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public class EntregaTerrea extends Entrega{

    public EntregaTerrea(Integer id, String local, Double distancia, List<Produto> produtos) {
        super(id, local, distancia, produtos);
    }

    @Override
    public void calcularEntrega() {
        Double valor = 0.0;

        for (Produto p : this.produtos) {
            valor += p.getValor();
        }

        this.setValorFinal(valor * 1.1);
    }

}
