package br.ucb.noqueue.beans;

import java.io.Serializable;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPRODUTO;

	private int estoque;

	private String nome;

	private Double valor;

	private InformacaoNutricional informacaoNutricional;

	public Produto() {
	}

	public int getIdPRODUTO() {
		return this.idPRODUTO;
	}

	public void setIdPRODUTO(int idPRODUTO) {
		this.idPRODUTO = idPRODUTO;
	}

	public int getEstoque() {
		return this.estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public InformacaoNutricional getInformacaoNutricional() {
		return this.informacaoNutricional;
	}

	public void setInformacaoNutricional(InformacaoNutricional informacaoNutricional) {
		this.informacaoNutricional = informacaoNutricional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estoque;
		result = prime * result + idPRODUTO;
		result = prime
				* result
				+ ((informacaoNutricional == null) ? 0 : informacaoNutricional
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
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
		Produto other = (Produto) obj;
		if (estoque != other.estoque)
			return false;
		if (idPRODUTO != other.idPRODUTO)
			return false;
		if (informacaoNutricional == null) {
			if (other.informacaoNutricional != null)
				return false;
		} else if (!informacaoNutricional.equals(other.informacaoNutricional))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public String toString2() {
		return "Produto [idPRODUTO=" + idPRODUTO + ", estoque=" + estoque
				+ ", nome=" + nome + ", valor=" + valor
				+ ", informacaoNutricional=" + informacaoNutricional + "]";
	}
	
	
}