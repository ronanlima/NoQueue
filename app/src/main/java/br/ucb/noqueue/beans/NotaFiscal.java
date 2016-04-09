package br.ucb.noqueue.beans;

import java.io.Serializable;


public class NotaFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idNOTA_FISCAL;
	private String descricao;
	private Pedido pedido;

	public NotaFiscal() {
	}

	public int getIdNOTA_FISCAL() {
		return this.idNOTA_FISCAL;
	}

	public void setIdNOTA_FISCAL(int idNOTA_FISCAL) {
		this.idNOTA_FISCAL = idNOTA_FISCAL;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idNOTA_FISCAL;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
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
		NotaFiscal other = (NotaFiscal) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idNOTA_FISCAL != other.idNOTA_FISCAL)
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente = "+pedido.getCliente().getNomeTitular()+"NotaFiscal [idNOTA_FISCAL=" + idNOTA_FISCAL + ", descricao="
				+ descricao + ", pedido=" + pedido + "]";
	}
	
}