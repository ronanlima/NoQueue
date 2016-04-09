package br.ucb.noqueue.beans;

public class Pagamento {
	private Integer id;
	private Integer idFormaPagamento;
	
	public Pagamento(){
		
	}
	
	public Pagamento(Integer id, Integer idFormaPagamento) {
		setId(idFormaPagamento);
		setIdFormaPagamento(idFormaPagamento);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((idFormaPagamento == null) ? 0 : idFormaPagamento.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idFormaPagamento == null) {
			if (other.idFormaPagamento != null)
				return false;
		} else if (!idFormaPagamento.equals(other.idFormaPagamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", idFormaPagamento=" + idFormaPagamento
				+ "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}
	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
}
