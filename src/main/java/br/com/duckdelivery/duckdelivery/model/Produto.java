package br.com.duckdelivery.duckdelivery.model;

public class Produto {

    private Integer id;
    private Double valor;
    private String descricao;

    public Produto(Integer id,Double valor, String descricao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
