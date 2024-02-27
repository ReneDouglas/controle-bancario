package br.com.bb.controleBancario.repositories;

public interface Operacoes {
	
	public String inserir(Object o);
	public Object consultar(Object o);
	public Integer alterar(Object o);
	public Integer deletar(Integer o);

}
