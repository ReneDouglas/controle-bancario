package br.com.bb.controleBancario.pojo;

public class Pessoa_Fisica extends Pessoa{
	
	private String cpf;
	private String rg;
	
	public Pessoa_Fisica() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer validar_cpf() {
		return null;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa_Fisica [cpf=");
		builder.append(cpf);
		builder.append(", rg=");
		builder.append(rg);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", cep=");
		builder.append(cep);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", renda=");
		builder.append(renda);
		builder.append(", situacao=");
		builder.append(situacao);
		builder.append("]");
		return builder.toString();
	}
	
	

}
