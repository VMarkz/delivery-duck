package br.com.duckdelivery.duckdelivery.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Entrega implements Cobranca{

    protected Integer id;
    protected String local;
    protected Double distancia;
    protected Carrinho carrinho;
    protected Double valorFinal;

    public Entrega(Integer id, String local, Double distancia, Carrinho carrinho) {
        this.id = id;
        this.local = local;
        this.distancia = distancia;
        this.carrinho = carrinho;
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

    public Carrinho getCarrinho() { return carrinho; }

    public void setCarrinho(Carrinho carrinho) { this.carrinho = carrinho; }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

}
