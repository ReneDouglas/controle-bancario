package br.com.bb.controleBancario.utils;

public class CampoComErro {
	
	private String campo;
	private String mensagem;
	public final static String COR = "RED";
	
	public CampoComErro() {}

	public CampoComErro(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
