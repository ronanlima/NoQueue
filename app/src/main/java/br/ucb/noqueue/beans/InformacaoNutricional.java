package br.ucb.noqueue.beans;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the informacao_nutricional database table.
 * 
 */
public class InformacaoNutricional implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idINFORMACAO_NUTRICIONAL;

	private Double calorias;

	private Double carboidratos;

	private Double fibras;

	private Double gorduras;

	private Double gordurasTrans;

	private Double proteinas;

	public InformacaoNutricional() {
	}

	public int getIdINFORMACAO_NUTRICIONAL() {
		return this.idINFORMACAO_NUTRICIONAL;
	}

	public void setIdINFORMACAO_NUTRICIONAL(int idINFORMACAO_NUTRICIONAL) {
		this.idINFORMACAO_NUTRICIONAL = idINFORMACAO_NUTRICIONAL;
	}

	public Double getCalorias() {
		return this.calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	public Double getCarboidratos() {
		return this.carboidratos;
	}

	public void setCarboidratos(Double carboidratos) {
		this.carboidratos = carboidratos;
	}

	public Double getFibras() {
		return this.fibras;
	}

	public void setFibras(Double fibras) {
		this.fibras = fibras;
	}

	public Double getGorduras() {
		return this.gorduras;
	}

	public void setGorduras(Double gorduras) {
		this.gorduras = gorduras;
	}

	public Double getGordurasTrans() {
		return this.gordurasTrans;
	}

	public void setGordurasTrans(Double gordurasTrans) {
		this.gordurasTrans = gordurasTrans;
	}

	public Double getProteinas() {
		return this.proteinas;
	}

	public void setProteinas(Double proteinas) {
		this.proteinas = proteinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(carboidratos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fibras);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gorduras);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gordurasTrans);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idINFORMACAO_NUTRICIONAL;
		temp = Double.doubleToLongBits(proteinas);
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
		InformacaoNutricional other = (InformacaoNutricional) obj;
		if (Double.doubleToLongBits(calorias) != Double
				.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(carboidratos) != Double
				.doubleToLongBits(other.carboidratos))
			return false;
		if (Double.doubleToLongBits(fibras) != Double
				.doubleToLongBits(other.fibras))
			return false;
		if (Double.doubleToLongBits(gorduras) != Double
				.doubleToLongBits(other.gorduras))
			return false;
		if (Double.doubleToLongBits(gordurasTrans) != Double
				.doubleToLongBits(other.gordurasTrans))
			return false;
		if (idINFORMACAO_NUTRICIONAL != other.idINFORMACAO_NUTRICIONAL)
			return false;
		if (Double.doubleToLongBits(proteinas) != Double
				.doubleToLongBits(other.proteinas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InformacaoNutricional [idINFORMACAO_NUTRICIONAL="
				+ idINFORMACAO_NUTRICIONAL + ", calorias=" + calorias
				+ ", carboidratos=" + carboidratos + ", fibras=" + fibras
				+ ", gorduras=" + gorduras + ", gordurasTrans=" + gordurasTrans
				+ ", proteinas=" + proteinas + "]";
	}

}