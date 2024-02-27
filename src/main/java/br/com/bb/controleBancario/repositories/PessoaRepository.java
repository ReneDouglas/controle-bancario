package br.com.bb.controleBancario.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.bb.controleBancario.pojo.PessoaFisica;

public class PessoaRepository implements Operacoes {

	public String inserir(Object o) {

		if (o instanceof PessoaFisica) {
			PessoaFisica pessoaFisica = (PessoaFisica) o;

			Connection con = ConexaoMySQL.getConnection();

			PreparedStatement ps;
			try {
				ps = con.prepareStatement(Queries.INSERIR_PESSOA, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, pessoaFisica.getNome());
				ps.setString(2, pessoaFisica.getEndereco());
				ps.setString(3, pessoaFisica.getCep());
				ps.setString(4, pessoaFisica.getTelefone());
				ps.setBigDecimal(5, pessoaFisica.getRenda());
				ps.setInt(6, pessoaFisica.getSituacao());

				ps.executeUpdate();
				ResultSet newId = ps.getGeneratedKeys();
				
				if(newId.next()) {
					pessoaFisica.setId(newId.getInt(1));
				}

				ps = con.prepareStatement(Queries.INSERIR_PESSOA_FISICA);

				ps.setInt(1, pessoaFisica.getId());
				ps.setString(2, pessoaFisica.getCpf());
				ps.setString(3, pessoaFisica.getRg());
				ps.setString(4, pessoaFisica.getSexo());

				ps.execute();
				ps.close();
				con.close();

				return "sucesso";

			} catch (SQLException e) {
				e.printStackTrace();
				return "Erro: " + e.getMessage();
			}
		} else {
			return null;
		}
	}

	public Object consultar(Object o) {

		if (o instanceof PessoaFisica) {

			PessoaFisica pessoaFisica = (PessoaFisica) o;

			Connection con = ConexaoMySQL.getConnection();
			String consulta = Queries.CONSULTAR_PESSOA_FISICA_POR_ID;
			PreparedStatement ps;

			try {
				ps = con.prepareStatement(consulta);
				ps.setInt(1, pessoaFisica.getId());
				ResultSet resultado = ps.executeQuery();

				while (resultado.next()) {

					pessoaFisica.setNome(resultado.getString("nome"));
					pessoaFisica.setSexo(resultado.getString("sexo"));
					pessoaFisica.setCpf(resultado.getString("cpf"));
					pessoaFisica.setRg(resultado.getString("rg"));
					pessoaFisica.setCep(resultado.getString("cep"));
					pessoaFisica.setEndereco(resultado.getString("endereco"));
					pessoaFisica.setTelefone(resultado.getString("telefone"));
					pessoaFisica.setRenda(resultado.getBigDecimal("renda"));
					pessoaFisica.setSituacao(resultado.getInt("situacao"));

				}
				ps.close();
				con.close();
				return pessoaFisica;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;

		} else {
			return null;
		}
	}

	public ArrayList<PessoaFisica> listarPessoasFisicas() {

		ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();

		Connection con = ConexaoMySQL.getConnection();
		String consulta = Queries.CONSULTAR_TODAS_PESSOAS_FISICAS;
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(consulta);
			ResultSet resultado = ps.executeQuery();

			while (resultado.next()) {

				PessoaFisica pf = new PessoaFisica();

				pf.setId(resultado.getInt("id"));
				pf.setNome(resultado.getString("nome"));
				pf.setSexo(resultado.getString("sexo"));
				pf.setCpf(resultado.getString("cpf"));
				pf.setRg(resultado.getString("rg"));
				pf.setCep(resultado.getString("cep"));
				pf.setEndereco(resultado.getString("endereco"));
				pf.setTelefone(resultado.getString("telefone"));
				pf.setRenda(resultado.getBigDecimal("renda"));
				pf.setSituacao(resultado.getInt("situacao"));

				pessoasFisicas.add(pf);
			}
			ps.close();
			con.close();
			return pessoasFisicas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer alterar(Object o) {

		if (o instanceof PessoaFisica) {

			PessoaFisica pessoaFisica = (PessoaFisica) o;

			Connection con = ConexaoMySQL.getConnection();
			PreparedStatement ps;

			try {
				ps = con.prepareStatement(Queries.ATUALIZAR_PESSOA);
				ps.setString(1, pessoaFisica.getNome());
				ps.setString(2, pessoaFisica.getEndereco());
				ps.setString(3, pessoaFisica.getCep());
				ps.setString(4, pessoaFisica.getTelefone());
				ps.setBigDecimal(5, pessoaFisica.getRenda());
				ps.setInt(6, pessoaFisica.getSituacao());
				ps.setInt(7, pessoaFisica.getId());

				ps.executeUpdate();

				ps = con.prepareStatement(Queries.ATUALIZAR_PESSOA_FISICA);

				ps.setString(1, pessoaFisica.getCpf());
				ps.setString(2, pessoaFisica.getRg());
				ps.setString(3, pessoaFisica.getSexo());
				ps.setInt(4, pessoaFisica.getId());

				Integer updated = ps.executeUpdate();

				ps.close();
				con.close();
				return updated;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} else {

		}

		return null;
	}

	public Integer deletar(Integer id) {

		Connection con = ConexaoMySQL.getConnection();
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(Queries.DELETAR_PESSOA);
			ps.setInt(1, id);

			Integer deleted = ps.executeUpdate();

			ps.close();
			con.close();
			return deleted;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
