package br.com.duckdelivery.duckdelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Cobranca{

    private List<Produto> produtos;
    private Double valorTotal;

    public Carrinho(List<Produto> produtos) {
        this.produtos = new ArrayList<>();
        this.produtos = produtos;
        this.calcularValorTotal();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionarProduto(List<Produto> novosProdutos){
        this.produtos.addAll(novosProdutos);
        this.calcularValorTotal();
    }

    @Override
    public void calcularValorTotal() {
        Double valor = 0.0;

        for (Produto p : this.produtos) {
            valor += p.getValor();
        }

        this.setValorTotal(valor * 1.0);
    }
}
