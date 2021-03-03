package br.com.duckdelivery.duckdelivery.utils;

import br.com.duckdelivery.duckdelivery.model.*;

import java.util.ArrayList;
import java.util.List;

public class CarregarBanco {

    static Fretadora fretadora = new Fretadora("dhl");

    public static Fretadora getFretadora() {
        return fretadora;
    }

    public static void carregarBanco(){
        List<Produto> produtos = new ArrayList<>();

        Carrinho carrinho00 = new Carrinho(produtos);

        produtos.add(new Produto(1,99.00, "dummy-product00"));
        produtos.add(new Produto(2,120.29, "dummy-product01"));
        produtos.add(new Produto(3,10.50, "dummy-product02"));
        produtos.add(new Produto(4,250.30, "dummy-product03"));

        carrinho00.adicionarProduto(produtos);

        EntregaTerrea entregaTerrea = new EntregaTerrea(1,"Campo Lindo, 347",190.00, carrinho00);
        EntregaMaritima entregaMaritima = new EntregaMaritima(2,"Campo Lindo, 347",190.00, carrinho00);
        EntregaAerea entregaAerea = new EntregaAerea(3,"Campo Lindo, 347",190.00, carrinho00);

        fretadora.adcionarEntrega(entregaAerea);
        fretadora.adcionarEntrega(entregaMaritima);
        fretadora.adcionarEntrega(entregaTerrea);

    }
}
