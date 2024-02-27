package br.com.bb.controleBancario.view.lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.bb.controleBancario.dto.PessoaFisicaDTO;
import br.com.bb.controleBancario.services.PessoaService;
import br.com.bb.controleBancario.view.TelaInicial;
import br.com.bb.controleBancario.view.forms.TelaCadastroPessoaFisica;
import br.com.bb.controleBancario.view.forms.TelaCadastroPessoaJuridica;

public class TelaListarPessoasFisicas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JButton btnExcluir;
	private JButton btnEditar;
	private PessoaService service;

	public TelaListarPessoasFisicas() {

		setTitle("Lista de Pessoas Físicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 453);
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

		menuBar.add(menuInicio);

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
				dispose();
				new TelaListarPessoasFisicas().setVisible(true);
			}
		});
		menuConsulta.add(mntmTelaConsultaPJ);

		menuBar.add(menuCadastro);
		menuBar.add(menuConsulta);

		// Adicionando a barra de menus ao frame
		setJMenuBar(menuBar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 605, 259);
		contentPane.add(scrollPane);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(526, 14, 89, 23);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (tabela.getSelectedRow() > -1) {
					
					String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
					service = new PessoaService();
					Integer deleted = service.deletarPessoaFisica(Integer.parseInt(id));
					
					if(deleted == null) {
						JOptionPane.showMessageDialog(TelaListarPessoasFisicas.this, "Erro ao deletar pessoa.");
						return;
					}
					
					JOptionPane.showMessageDialog(TelaListarPessoasFisicas.this, "Operação concluída com sucesso.");
					TelaListarPessoasFisicas.this.dispose();
					new TelaListarPessoasFisicas().setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				}
			}
		});

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(427, 14, 89, 23);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabela.getSelectedRow() > -1){
					TelaListarPessoasFisicas.this.dispose();
					
					new TelaCadastroPessoaFisica(Integer
							.parseInt((String) modelo
							.getValueAt(tabela.getSelectedRow(), 0)))
					.setVisible(true);
				}
			}
		});
		contentPane.add(btnEditar);

		// Vetor de colunas da Tabela

		String[] colunas = new String[9];

		colunas[0] = "Cod.";
		colunas[1] = "Nome";
		colunas[2] = "Sexo";
		colunas[3] = "Endereço";
		colunas[4] = "CPF";
		colunas[5] = "RG";
		colunas[6] = "Telefone";
		colunas[7] = "Renda";
		colunas[8] = "Situação";

		// criando o modelo da tabela
		modelo = new DefaultTableModel(new Object[][] {}, colunas);
		// criando tabela
		tabela = new JTable(modelo);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(60);

		// adicionando a tabela a um scrollpanel
		scrollPane.setViewportView(tabela);
		carregarDadosTabela();
	}

	private void carregarDadosTabela() {
		
		service = new PessoaService();
		for (PessoaFisicaDTO pfDto : service.listarPessoasFisicas()) {
			modelo.addRow(new String[] {
					pfDto.getId(),
					pfDto.getNome(),
					pfDto.getSexo(),
					pfDto.getEndereco(),
					pfDto.getCpf(),
					pfDto.getRg(),
					pfDto.getTelefone(),
					pfDto.getRenda(),
					pfDto.getSituacao()
					});
		}
	}

}
