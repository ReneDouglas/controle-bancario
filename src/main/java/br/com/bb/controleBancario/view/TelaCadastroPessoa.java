package br.com.bb.controleBancario.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public TelaCadastroPessoa() {
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();

        // Criando os menus
        JMenu menu1 = new JMenu("Menu 1");
        JMenu menu2 = new JMenu("Menu 2");
        JMenu menu3 = new JMenu("Menu 3");
        
        menuBar.add(menu1);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
        menu1.add(mntmNewMenuItem);
        menuBar.add(menu2);
        menuBar.add(menu3);

        // Adicionando a barra de menus ao frame
        setJMenuBar(menuBar);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(109, 18, 151, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(109, 92, 151, 27);
		contentPane.add(lblEndereo);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCep.setBounds(109, 128, 151, 27);
		contentPane.add(lblCep);
		
		JLabel lblRenda = new JLabel("Telefone");
		lblRenda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRenda.setBounds(109, 165, 151, 27);
		contentPane.add(lblRenda);
		
		JLabel lblNewLabel_3_1 = new JLabel("Renda");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(109, 201, 151, 27);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Situa\u00E7\u00E3o");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(109, 238, 151, 27);
		contentPane.add(lblNewLabel_3_1_1);
		
		textField = new JTextField();
		textField.setBounds(270, 20, 247, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(270, 94, 247, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 131, 247, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(270, 168, 247, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(270, 204, 247, 25);
		contentPane.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 240, 247, 25);
		comboBox.addItem("Ativo");
		comboBox.addItem("Inativo");
		contentPane.add(comboBox);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfcnpj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpfcnpj.setBounds(109, 57, 151, 27);
		contentPane.add(lblCpfcnpj);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(270, 57, 247, 25);
		contentPane.add(textField_5);
		
		DatePicker dp = new DatePicker();
		dp.setBounds(270, 270, 247, 25);
		contentPane.add(dp);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(410, 312, 107, 36);
		contentPane.add(btnNewButton);
		
		
	}
}
