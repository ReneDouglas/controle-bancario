package br.com.bb.controleBancario.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.bb.controleBancario.Application;
import br.com.bb.controleBancario.view.forms.TelaCadastroPessoaFisica;
import br.com.bb.controleBancario.view.forms.TelaCadastroPessoaJuridica;
import br.com.bb.controleBancario.view.lists.TelaListarPessoasFisicas;

public class TelaInicial extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public TelaInicial() {
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 431);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 700, 400);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		URL imageURL = Application.class.getResource("/images/sistema_bancario_logo.jpg");
		ImageIcon backgroundIcon = new ImageIcon(imageURL);
		JLabel background = new JLabel(backgroundIcon);
		background.setBounds(0, 0, backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
		contentPane.add(background);
		
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
		
				
		
	}

}
