package br.com.bb.controleBancario.pojo;

import java.util.ArrayList;

public abstract class Pessoa {
	
	protected String nome;
	protected String endereco;
	protected String cep;
	protected String telefone;
	protected Double renda;
	protected Integer situacao;
	protected ArrayList<Conta_Comum> contas;
	
	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public ArrayList<Conta_Comum> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta_Comum> contas) {
		this.contas = contas;
	}
	
	

}
