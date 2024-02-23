package br.com.bb.controleBancario.pojo;

import java.util.Date;

public class Movimento {
	
	private Integer tipo_movimento;
	private Date data_movimento;
	private Double valor_movimento;
	
	public Movimento() {
	}
	
	// sobrecarga
	public Movimento(Integer tipo, Date data, Double valor) {
		this.tipo_movimento = tipo;
		this.data_movimento = data;
		this.valor_movimento = valor;
	}
	
	public Integer registrar_movimento(Integer i, Double d) {
		return null;
		
	}
	
	public String consultar_movimento(Date inicio, Date fim) {
		return null;
		
	}

	public Integer getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(Integer tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public Date getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(Date data_movimento) {
		this.data_movimento = data_movimento;
	}

	public Double getValor_movimento() {
		return valor_movimento;
	}

	public void setValor_movimento(Double valor_movimento) {
		this.valor_movimento = valor_movimento;
	}
	
	

}
