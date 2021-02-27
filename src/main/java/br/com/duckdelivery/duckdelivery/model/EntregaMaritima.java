package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public class EntregaMaritima extends Entrega{

    public EntregaMaritima(Integer id, String local, Double distancia, Carrinho carrinho) {
        super(id, local, distancia, carrinho);
        this.tipoEntrega = "Marítima";
        this.calcularValorTotal();
    }

    @Override
    public void calcularValorTotal() {
        Double valor = 0.0;

        for (Produto p : this.carrinho.getProdutos()) {
            valor += p.getValor();
        }

        this.setValorFinal(valor * 1.2);
    }

}
