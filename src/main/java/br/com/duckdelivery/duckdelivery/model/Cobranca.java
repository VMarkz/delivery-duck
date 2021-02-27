package br.com.duckdelivery.duckdelivery.model;

import java.util.List;

public interface Cobranca {

    // Escolhi utizar interface, pois precisava forçar que duas classes
    // que não pertencem ao mesmo grupo, ou podem endar de uma mesma classe mãe
    // implemtacem o mesmo método.
    public void calcularValorTotal();

}
