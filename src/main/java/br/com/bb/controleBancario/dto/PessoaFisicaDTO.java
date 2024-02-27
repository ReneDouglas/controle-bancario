package br.com.bb.controleBancario.dto;

public class PessoaFisicaDTO extends PessoaDTO{
	
	private String cpf;
	private String rg;
	private String sexo;
	
	public PessoaFisicaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
