package br.ucb.noqueue.beans;

import java.io.Serializable;
import java.util.List;


public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPEDIDO;
	private double valorTotal;
	private Loja loja;
	private Cliente cliente;
	private List<Produto> produtos; 

	public Pedido() {
	}

	public int getIdPEDIDO() {
		return this.idPEDIDO;
	}

	public void setIdPEDIDO(int idPEDIDO) {
		this.idPEDIDO = idPEDIDO;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + idPEDIDO;
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
		result = prime * result
				+ ((produtos == null) ? 0 : produtos.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (idPEDIDO != other.idPEDIDO)
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double
				.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [idPEDIDO=" + idPEDIDO + ", valorTotal=" + valorTotal
				+ ", loja=" + loja + ", cliente=" + cliente + ", produtos="
				+ produtos + "]";
	}
	
	
	
}