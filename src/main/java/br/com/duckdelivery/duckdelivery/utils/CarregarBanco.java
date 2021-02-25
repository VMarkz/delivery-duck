package br.com.duckdelivery.duckdelivery.utils;

import br.com.duckdelivery.duckdelivery.model.*;

import java.util.ArrayList;
import java.util.List;

public class CarregarBanco {

    static Fretadora fretadora = new Fretadora("dhl");

    public static void carregarBanco(){
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1,99.00, "dummy-product00"));
        produtos.add(new Produto(2,120.29, "dummy-product01"));
        produtos.add(new Produto(3,10.50, "dummy-product02"));
        produtos.add(new Produto(4,250.30, "dummy-product03"));

        EntregaTerrea entregaTerrea = new EntregaTerrea(1,"Campo Lindo, 347",190.00, produtos);
        EntregaMaritima entregaMaritima = new EntregaMaritima(2,"Campo Lindo, 347",190.00, produtos);
        EntregaAerea entregaAerea = new EntregaAerea(3,"Campo Lindo, 347",190.00, produtos);

        fretadora.adcionarEntrega(entregaAerea);
        fretadora.adcionarEntrega(entregaMaritima);
        fretadora.adcionarEntrega(entregaTerrea);

    }

    public static Fretadora getFretadora() {
        return fretadora;
    }
}
