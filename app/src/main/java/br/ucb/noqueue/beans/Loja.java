package br.ucb.noqueue.beans;

import java.io.Serializable;


public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idLOJA;
	private String descricao;

	public Loja() {
	}

	public int getIdLOJA() {
		return this.idLOJA;
	}

	public void setIdLOJA(int idLOJA) {
		this.idLOJA = idLOJA;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idLOJA;
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
		Loja other = (Loja) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idLOJA != other.idLOJA)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loja [idLOJA=" + idLOJA + ", descricao=" + descricao + "]";
	}
	
}