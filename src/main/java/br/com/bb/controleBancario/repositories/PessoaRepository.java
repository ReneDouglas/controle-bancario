package br.com.bb.controleBancario.repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bb.controleBancario.pojo.Pessoa;
import br.com.bb.controleBancario.pojo.Pessoa_Fisica;

public class PessoaRepository implements Operacoes {

	public void inserir(Object o) {
		
		Pessoa pessoa = (Pessoa) o;
		
		Connection con = ConexaoMySQL.getConnection();

		String query = "INSERT INTO pessoa (nome, cpf, rg, cnpj, endereco, cep, telefone, renda)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, null);
			ps.setString(3, null);
			ps.setString(4, null);
			ps.setString(5, pessoa.getEndereco());
			ps.setString(6, pessoa.getCep());
			ps.setString(7, pessoa.getTelefone());
			ps.setBigDecimal(8, pessoa.getRenda());

			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void consultar(Object o) {
		
		Pessoa pessoa = (Pessoa) o;
		
		Connection con = ConexaoMySQL.getConnection();
		
		String consulta = Queries.CONSULTAR_POR_ID;
		
		PreparedStatement ps ;
		try {
			ps = con.prepareStatement(consulta);
			ps.setInt(1, pessoa.getId());
			ResultSet resultado = ps.executeQuery();
			
			Pessoa pf = new Pessoa_Fisica();
			
			while (resultado.next()) {
				
				pf.setId(resultado.getInt("id"));
				pf.setNome(resultado.getString("nome"));
				pf.setCep(resultado.getString("cep"));
				pf.setEndereco(resultado.getString("endereco"));
				pf.setRenda(resultado.getBigDecimal("renda"));
				
				System.out.println("id: " + pf.getId());
				System.out.println("nome: " + pf.getNome());
				System.out.println("cep: " + pf.getCep());
				System.out.println("endereco: " + pf.getEndereco());
				System.out.println("renda: " + pf.getRenda());
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
