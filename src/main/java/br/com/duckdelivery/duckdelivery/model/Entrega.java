package br.com.duckdelivery.duckdelivery.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Entrega implements Cobranca{

    protected Integer id;
    protected String local;
    protected Double distancia;
    protected Double taxa;
    protected List<Produto> produtos;

    public Entrega(Integer id, String local, Double distancia, List<Produto> produtos) {
        this.id = id;
        this.local = local;
        this.distancia = distancia;
        this.produtos = produtos;
        produtos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", local='" + local + '\'' +
                ", distancia=" + distancia +
                ", taxa=" + taxa +
                ", produtos=" + produtos +
                '}';
    }
}
