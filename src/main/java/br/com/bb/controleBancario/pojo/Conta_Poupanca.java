package br.com.bb.controleBancario.pojo;

import java.util.Date;

public class Conta_Poupanca extends Conta_Comum{
	
	private Date data_aniver;
	
	public Conta_Poupanca() {
	}
	
	public Double rendimento(Double r) {
		return null;
	}

	public Date getData_aniver() {
		return data_aniver;
	}

	public void setData_aniver(Date data_aniver) {
		this.data_aniver = data_aniver;
	}


}
