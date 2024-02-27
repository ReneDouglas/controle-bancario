package br.com.bb.controleBancario.view.forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.bb.controleBancario.view.TelaInicial;
import br.com.bb.controleBancario.view.lists.TelaListarPessoasFisicas;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TelaCadastroPessoaJuridica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldNome;
	private JTextField fieldEndereco;
	private JTextField fieldCEP;
	private JTextField fieldTelefone;
	private JTextField fieldCNPJ;
	private JTextField fieldRenda;

	public TelaCadastroPessoaJuridica() {
		setTitle("Cadastrar Pessoa Jurídica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 431);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();

        // Criando os menus
        JMenu menuInicio = new JMenu("Início");
        JMenu menuCadastro = new JMenu("Cadastros");
        JMenu menuConsulta = new JMenu("Consultas");
        
        JMenuItem mntmTelaInicial = new JMenuItem("Tela Inicial");
        mntmTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial().setVisible(true);
			}
		});
        menuInicio.add(mntmTelaInicial);
        
        JMenuItem mntmTelaCadastroPF = new JMenuItem("Pessoa Física");
        mntmTelaCadastroPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastroPessoaFisica(null).setVisible(true);
			}
		});
        menuCadastro.add(mntmTelaCadastroPF);
        
        JMenuItem mntmTelaCadastroPJ = new JMenuItem("Pessoa Jurídica");
        mntmTelaCadastroPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastroPessoaJuridica().setVisible(true);
			}
		});
        menuCadastro.add(mntmTelaCadastroPJ);
        
        JMenuItem mntmTelaConsultaPF = new JMenuItem("Pessoas Físicas");
        mntmTelaConsultaPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaListarPessoasFisicas().setVisible(true);
			}
		});
        menuConsulta.add(mntmTelaConsultaPF);
        
        JMenuItem mntmTelaConsultaPJ = new JMenuItem("Pessoas Jurídicas");
        mntmTelaConsultaPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				//new TelaListarPessoasFisicas().setVisible(true);
			}
		});
        menuConsulta.add(mntmTelaConsultaPJ);
        
        menuBar.add(menuInicio);
        menuBar.add(menuCadastro);
        menuBar.add(menuConsulta);

        // Adicionando a barra de menus ao frame
        setJMenuBar(menuBar);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeFantasia.setBounds(109, 18, 151, 27);
		contentPane.add(lblNomeFantasia);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(270, 20, 247, 25);
		fieldNome.setColumns(10);
		contentPane.add(fieldNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereco.setBounds(109, 92, 151, 27);
		contentPane.add(lblEndereco);
		
		fieldEndereco = new JTextField();
		fieldEndereco.setColumns(10);
		fieldEndereco.setBounds(270, 92, 247, 25);
		contentPane.add(fieldEndereco);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCEP.setBounds(109, 129, 151, 27);
		contentPane.add(lblCEP);
		
		fieldCEP = new JTextField();
		fieldCEP.setColumns(10);
		fieldCEP.setBounds(270, 127, 247, 25);
		contentPane.add(fieldCEP);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(109, 159, 151, 27);
		contentPane.add(lblTelefone);
		
		fieldTelefone = new JTextField();
		fieldTelefone.setColumns(10);
		fieldTelefone.setBounds(270, 162, 247, 25);
		contentPane.add(fieldTelefone);
		
		JLabel lblRenda = new JLabel("Renda");
		lblRenda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRenda.setBounds(109, 194, 151, 27);
		contentPane.add(lblRenda);

		fieldRenda = new JTextField();
		fieldRenda.setColumns(10);
		fieldRenda.setBounds(270, 197, 247, 25);
		contentPane.add(fieldRenda);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCnpj.setBounds(109, 55, 151, 27);
		contentPane.add(lblCnpj);
		
		fieldCNPJ = new JTextField();
		fieldCNPJ.setColumns(10);
		fieldCNPJ.setBounds(270, 55, 247, 25);
		contentPane.add(fieldCNPJ);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(410, 253, 107, 36);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		contentPane.add(btnSalvar);
		
	}
}
