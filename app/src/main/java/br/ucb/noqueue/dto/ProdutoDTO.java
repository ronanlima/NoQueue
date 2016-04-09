package br.ucb.noqueue.dto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int quantidade;
    private double valor;


    public ProdutoDTO(int qtde, double valor){
        setQuantidade(qtde);
        setValor(valor);
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
