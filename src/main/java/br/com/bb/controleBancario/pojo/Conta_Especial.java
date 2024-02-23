package br.com.bb.controleBancario.pojo;

public class Conta_Especial extends Conta_Comum{
	
	private Double limite_conta;
	
	public Conta_Especial() {
	}
	
	public Double juros_conta(Double juros) {
		return null;
	}

	public Double getLimite_conta() {
		return limite_conta;
	}

	public void setLimite_conta(Double limite_conta) {
		this.limite_conta = limite_conta;
	}
}
