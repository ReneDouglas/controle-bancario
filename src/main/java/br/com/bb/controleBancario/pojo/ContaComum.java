package br.com.bb.controleBancario.pojo;

import java.util.Date;
import java.util.List;

public class ContaComum {
	
	protected Long nro_conta;
	protected Date data_abertura;
	protected Date data_encerramento;
	protected Integer situacao = 1;
	protected Integer senha;
	protected Double saldo = 0.0;
	protected List<Movimento> movimentos;
	
	public ContaComum() {
	}
	
	public Double saldo() {
		return null;
	}
	
	public Integer sacar(Double valor) {
		return null;
	}
	public Integer depositar(Double valor) {
		return null;
	}

	public Long getNro_conta() {
		return nro_conta;
	}

	public void setNro_conta(Long nro_conta) {
		this.nro_conta = nro_conta;
	}

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}

	public Date getData_encerramento() {
		return data_encerramento;
	}

	public void setData_encerramento(Date data_encerramento) {
		this.data_encerramento = data_encerramento;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
