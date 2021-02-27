package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public class EntregaTerrea extends Entrega{

    public EntregaTerrea(Integer id, String local, Double distancia, Carrinho carrinho) {
        super(id, local, distancia, carrinho);
        this.calcularValorTotal();
    }

    @Override
    public void calcularValorTotal() {
        Double valor = 0.0;

        for (Produto p : this.carrinho.getProdutos()) {
            valor += p.getValor();
        }

        this.setValorFinal(valor * 1.1);
    }

}
