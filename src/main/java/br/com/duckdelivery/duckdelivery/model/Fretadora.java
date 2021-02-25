package br.com.duckdelivery.duckdelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Fretadora {

    private String nome;
    private List<Entrega> entregas;

    public Fretadora(String nome) {
        this.nome = nome;
        entregas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    public void adcionarEntrega(Entrega entrega){
        entregas.add(entrega);
    }

    public void cancelarEntrega(Integer index){
        entregas.remove(index);
    }

    public void deletarProduto(Integer entregaIndex ,Integer produtoId){

        for (int i = 0;
             i < entregas.get(entregaIndex).getProdutos().size();
             i++) {
            if(entregas.get(entregaIndex).getProdutos().get(i).getId() == produtoId){
                entregas.get(entregaIndex).getProdutos().remove(i);
            }
        }
// Tentei fazer com forEach mas pelo jeito não posso alterar a lista enquanto dentro do forEach
// nesse caso remover um item.
//        entregas.get(entregaIndex).getProdutos().forEach(p -> {
//            if(p.getId() == produtoId){
//                entregas.get(entregaIndex).getProdutos().remove(p);
//            }
//        });
    }
}
