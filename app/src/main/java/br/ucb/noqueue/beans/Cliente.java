package br.ucb.noqueue.beans;

import java.io.Serializable;
import java.util.List;


public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCLIENTE;
    private int codigoSeguranca;
    private String dataValidadeCartao;
    private String nomeTitular;
    private String formaPagamento;
    private String numeroCartao;
    private String bandeira;

    public Cliente() {
    }

    public int getIdCLIENTE() {
        return this.idCLIENTE;
    }

    public void setIdCLIENTE(int idCLIENTE) {
        this.idCLIENTE = idCLIENTE;
    }

    public int getCodigoSeguranca() {
        return this.codigoSeguranca;
    }

    public void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getDataValidadeCartao() {
        return this.dataValidadeCartao;
    }

    public void setDataValidadeCartao(String dataValidadeCartao) {
        this.dataValidadeCartao = dataValidadeCartao;
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNumeroCartao() {
        return this.numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getBandeira() {
        return this.bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    @Override
    public String toString() {
        return "Cliente [idCLIENTE=" + idCLIENTE + ", nomeTitular=" + nomeTitular
                + ", formaPagamento=" + formaPagamento + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((bandeira == null) ? 0 : bandeira.hashCode());
        result = prime * result + codigoSeguranca;
        result = prime
                * result
                + ((dataValidadeCartao == null) ? 0 : dataValidadeCartao
                .hashCode());
        result = prime * result
                + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
        result = prime * result + idCLIENTE;
        result = prime * result
                + ((nomeTitular == null) ? 0 : nomeTitular.hashCode());
        result = prime * result
                + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (bandeira == null) {
            if (other.bandeira != null)
                return false;
        } else if (!bandeira.equals(other.bandeira))
            return false;
        if (codigoSeguranca != other.codigoSeguranca)
            return false;
        if (dataValidadeCartao == null) {
            if (other.dataValidadeCartao != null)
                return false;
        } else if (!dataValidadeCartao.equals(other.dataValidadeCartao))
            return false;
        if (formaPagamento == null) {
            if (other.formaPagamento != null)
                return false;
        } else if (!formaPagamento.equals(other.formaPagamento))
            return false;
        if (idCLIENTE != other.idCLIENTE)
            return false;
        if (nomeTitular == null) {
            if (other.nomeTitular != null)
                return false;
        } else if (!nomeTitular.equals(other.nomeTitular))
            return false;
        if (numeroCartao == null) {
            if (other.numeroCartao != null)
                return false;
        } else if (!numeroCartao.equals(other.numeroCartao))
            return false;
        return true;
    }



}