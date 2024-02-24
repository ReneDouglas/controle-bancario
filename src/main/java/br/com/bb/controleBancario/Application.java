package br.com.bb.controleBancario;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import br.com.bb.controleBancario.pojo.Conta_Comum;
import br.com.bb.controleBancario.pojo.Pessoa;
import br.com.bb.controleBancario.pojo.Pessoa_Fisica;
import br.com.bb.controleBancario.repositories.ConexaoMySQL;
import br.com.bb.controleBancario.repositories.PessoaRepository;
import br.com.bb.controleBancario.view.TelaCadastroPessoa;

public class Application {

	public static void main(String[] args) throws SQLException {
		
		Pessoa p = new Pessoa_Fisica();
		p.setId(1);
		
		PessoaRepository pr = new PessoaRepository();
		
		pr.consultar(p);
		
		
		
		/*TelaCadastroPessoa telaCadastroPessoa = new TelaCadastroPessoa();
		telaCadastroPessoa.setVisible(true);
		
		Pessoa pessoa = new Pessoa_Fisica();
		pessoa.setEndereco("corrente");
		pessoa.setCep("55-555-000");
		pessoa.setNome("Joao");
		pessoa.setRenda(1500.00);
		pessoa.setSituacao(1);
		pessoa.setTelefone("99-99999-9999");
		
		Conta_Comum cc = new Conta_Comum();
		cc.setData_abertura(new Date());
		cc.setData_encerramento(null);
		cc.setNro_conta(1000l);
		cc.setSaldo(5000.00);
		cc.setSenha(123);
		cc.setSituacao(1);
		
		ArrayList<Conta_Comum> contas = new ArrayList<Conta_Comum>();
		contas.add(cc);
		pessoa.setContas(contas);
		
		
		System.out.println(pessoa.toString());*/
		
		
		

	}

}
