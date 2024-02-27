package br.com.bb.controleBancario.view.forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.bb.controleBancario.dto.PessoaFisicaDTO;
import br.com.bb.controleBancario.services.PessoaService;
import br.com.bb.controleBancario.utils.CampoComErro;
import br.com.bb.controleBancario.view.TelaInicial;
import br.com.bb.controleBancario.view.lists.TelaListarPessoasFisicas;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JRadioButton;

public class TelaCadastroPessoaFisica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldNome;
	private ButtonGroup groupSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JTextField fieldRG;
	private JTextField fieldEndereco;
	private JTextField fieldCEP;
	private JTextField fieldTelefone;
	private JTextField fieldCPF;
	private JTextField fieldRenda;
	private PessoaService service;
	private PessoaFisicaDTO pfDto;
	private Integer idPessoaFisica;

	public TelaCadastroPessoaFisica(Integer idToUpdate) {
		setTitle("Cadastrar Pessoa Física");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 431);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		this.idPessoaFisica = idToUpdate;

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
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(109, 18, 151, 27);
		contentPane.add(lblNome);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(270, 20, 247, 25);
		fieldNome.setColumns(10);
		contentPane.add(fieldNome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(109, 53, 151, 27);
		contentPane.add(lblSexo);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setActionCommand("Masculino");
		rdbtnMasculino.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnMasculino.setBounds(270, 53, 95, 24);
		rdbtnMasculino.setSelected(true);
		contentPane.add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setActionCommand("Feminino");
		rdbtnFeminino.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnFeminino.setBounds(369, 53, 122, 24);
		contentPane.add(rdbtnFeminino);
		
		groupSexo = new ButtonGroup();
		groupSexo.add(rdbtnMasculino);
		groupSexo.add(rdbtnFeminino);
		
		JLabel lblRG = new JLabel("RG");
		lblRG.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRG.setBounds(109, 127, 151, 27);
		contentPane.add(lblRG);
		
		fieldRG = new JTextField();
		fieldRG.setColumns(10);
		fieldRG.setBounds(270, 129, 247, 25);
		contentPane.add(fieldRG);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereco.setBounds(109, 163, 151, 27);
		contentPane.add(lblEndereco);
		
		fieldEndereco = new JTextField();
		fieldEndereco.setColumns(10);
		fieldEndereco.setBounds(270, 166, 247, 25);
		contentPane.add(fieldEndereco);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCEP.setBounds(109, 200, 151, 27);
		contentPane.add(lblCEP);
		
		fieldCEP = new JTextField();
		fieldCEP.setColumns(10);
		fieldCEP.setBounds(270, 203, 247, 25);
		contentPane.add(fieldCEP);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(109, 236, 151, 27);
		contentPane.add(lblTelefone);
		
		fieldTelefone = new JTextField();
		fieldTelefone.setColumns(10);
		fieldTelefone.setBounds(270, 239, 247, 25);
		contentPane.add(fieldTelefone);
		
		JLabel lblRenda = new JLabel("Renda");
		lblRenda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRenda.setBounds(109, 273, 151, 27);
		contentPane.add(lblRenda);

		fieldRenda = new JTextField();
		fieldRenda.setColumns(10);
		fieldRenda.setBounds(270, 273, 247, 25);
		contentPane.add(fieldRenda);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(109, 92, 151, 27);
		contentPane.add(lblCpf);
		
		fieldCPF = new JTextField();
		fieldCPF.setColumns(10);
		fieldCPF.setBounds(270, 92, 247, 25);
		contentPane.add(fieldCPF);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(410, 312, 107, 36);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<CampoComErro> erros = preencher_e_validar();
		
				if(!erros.isEmpty()) {
					
					mostrarErros(erros);
					return;
				}
				
				if(idPessoaFisica == null) {

					String msg = service.cadastrarPessoaFisica(pfDto);
					
					if(msg != null && msg.contains("Erro")) {
						JOptionPane.showMessageDialog(TelaCadastroPessoaFisica.this, "Erro ao cadastrar pessoa física: " + msg);
						return;
					}
				} else {
					pfDto.setId(idPessoaFisica.toString());
					Integer updated = service.atualizarPessoaFisica(pfDto);
					
					if(updated == null) {
						JOptionPane.showMessageDialog(TelaCadastroPessoaFisica.this, "Erro ao atualizar pessoa física.");
						return;
					}
				}
				
				JOptionPane.showMessageDialog(TelaCadastroPessoaFisica.this, "Operação concluída com sucesso.");
				dispose();
				new TelaCadastroPessoaFisica(null).setVisible(true);
			}
		});
		contentPane.add(btnSalvar);
		
		if(idPessoaFisica != null) {
			carregarDadosPessoaFisica();
		}
	}
	
	private ArrayList<CampoComErro> preencher_e_validar(){
		
		service = new PessoaService();
		pfDto = new PessoaFisicaDTO();
		
		pfDto.setNome(fieldNome.getText());
		pfDto.setCpf(fieldCPF.getText());
		pfDto.setRg(fieldRG.getText());
		pfDto.setSexo(groupSexo.getSelection().getActionCommand());
		pfDto.setEndereco(fieldEndereco.getText());
		pfDto.setCep(fieldCEP.getText());
		pfDto.setTelefone(fieldTelefone.getText());
		pfDto.setRenda(fieldRenda.getText());
		
		return service.validarDadosPessoaFisica(pfDto);
	}
	
	private void carregarDadosPessoaFisica() {
		
		service = new PessoaService();
		PessoaFisicaDTO pfDto = service.consultarPessoaFisicaPorID(idPessoaFisica);
		fieldNome.setText(pfDto.getNome());
		fieldCPF.setText(pfDto.getCpf());
		fieldRG.setText(pfDto.getRg());
		fieldCEP.setText(pfDto.getCep());
		fieldEndereco.setText(pfDto.getEndereco());
		fieldTelefone.setText(pfDto.getTelefone());
		fieldRenda.setText(pfDto.getRenda());
		if(pfDto.getSexo().equalsIgnoreCase("Masculino")) {
			rdbtnMasculino.setSelected(true);
		} else {
			rdbtnFeminino.setSelected(true);
		}
	}
	
	private void mostrarErros(ArrayList<CampoComErro> erros) {
		StringBuilder msgs = new StringBuilder();
		for(CampoComErro cce : erros) {
			msgs.append(cce.getCampo() + ": " + cce.getMensagem() + "\n");
		}
		JOptionPane.showMessageDialog(TelaCadastroPessoaFisica.this, "Erro ao cadastrar pessoa física:\n" + msgs);
	}
}
