package br.com.bb.controleBancario.repositories;

public final class Queries {
	
	// Inserts
	public static String INSERIR_PESSOA = "INSERT INTO pessoas (nome, endereco, cep, telefone, renda, situacao) VALUES(?, ?, ?, ?, ?, ?)";
	public static String INSERIR_PESSOA_FISICA = "INSERT INTO pessoas_fisicas (id, cpf, rg, sexo) VALUES(?, ?, ?, ?)";
	public static String INSERIR_PESSOA_JURIDICA = "INSERT INTO pessoas_juridicas (id, cnpj) VALUES(?, ?)";
	
	// Selects
	public static String CONSULTAR_PESSOA_FISICA_POR_ID = "SELECT * FROM pessoas p "
												 + "JOIN pessoas_fisicas pf ON pf.id = p.id "
												 + "WHERE p.id = ?";
	public static String CONSULTAR_TODAS_PESSOAS_FISICAS = "SELECT * FROM pessoas p "
														 + "JOIN pessoas_fisicas pf ON pf.id = p.id ";
	
	// Updates
	public static String ATUALIZAR_PESSOA = "UPDATE pessoas SET nome=?, endereco=?, cep=?, telefone=?, renda=?, situacao=? WHERE id=? ";
	public static String ATUALIZAR_PESSOA_FISICA = "UPDATE pessoas_fisicas SET cpf=?, rg=?, sexo=? WHERE id=?";
	
	public static String DELETAR_PESSOA = "DELETE FROM pessoas WHERE id=?";
}
