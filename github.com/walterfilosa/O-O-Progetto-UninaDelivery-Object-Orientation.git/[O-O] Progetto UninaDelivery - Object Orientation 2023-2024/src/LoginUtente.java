import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginUtente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private GestoreApplicazione myGestore;
	private JLabel lblBenvenuto;
	private JTextField txtGetEmail;
	private JPasswordField txtGetPassword;
	private JLabel lblLoginUtente;
	private JLabel lblPassword;
	private JCheckBox ShowPassword;
	private JLabel lblSeiUnOperatore;
	private JLabel lblAccediQui;
	private JLabel lblNonRegistrato;
	private JLabel lblRegistrati;
	private JLabel lblEmail;
	private JLabel Logo;
	private JLabel lblIconaPassword;
	private JLabel lblIconEmail;
	private Cursor Mano;
	private JButton loginButton;
	public int posizioneUtente;
	
	public LoginUtente(GestoreApplicazione ga) {
		setTitle("UninaDelivery");
		
		String imgPath = "res" + File.separator;
		ImageIcon image = new ImageIcon(imgPath + "Logo.png");

		
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 500, 600, 350);
		myGestore.setIconFrame(this);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		Mano = new Cursor(Cursor.HAND_CURSOR);
		
		txtGetEmail = new JTextField();
		txtGetEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n')
				{
					if(txtGetEmail.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Inserisci una mail", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
					else
					{
						if(new String(txtGetPassword.getPassword()).equals(""))
							JOptionPane.showMessageDialog(null, "Inserisci una password", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
						else
							loginCheck();
					}
				}
			}
		});
		txtGetEmail.setToolTipText("Inserisci Email");
		txtGetEmail.setForeground(new Color(0, 2, 160));
		txtGetEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetEmail.setColumns(10);
		txtGetEmail.setBackground(Color.WHITE);
		txtGetEmail.setBounds(151, 118, 300, 30);
		getContentPane().add(txtGetEmail);
		
		txtGetPassword = new JPasswordField();
		txtGetPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n')
				{
					if(txtGetEmail.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Inserisci una mail", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
					else
					{
						if(new String(txtGetPassword.getPassword()).equals(""))
							JOptionPane.showMessageDialog(null, "Inserisci una password", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
						else
							loginCheck();
					}
				}
			}
		});
		txtGetPassword.setEchoChar('*');
		txtGetPassword.setToolTipText("Inserisci Password");
		txtGetPassword.setForeground(new Color(0, 2, 160));
		txtGetPassword.setFont(new Font("PT Sans", Font.PLAIN, 15));
		txtGetPassword.setBounds(151, 164, 300, 30);
		getContentPane().add(txtGetPassword);
		
		lblBenvenuto = new JLabel("UninaDelivery");
		lblBenvenuto.setForeground(new Color(0, 2, 160));
		lblBenvenuto.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblBenvenuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenvenuto.setBounds(300, 32, 151, 30);
		getContentPane().add(lblBenvenuto);
		
		lblLoginUtente = new JLabel("Login Utente");
		lblLoginUtente.setForeground(Color.BLACK);
		lblLoginUtente.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblLoginUtente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginUtente.setBounds(350, 60, 100, 25);
		getContentPane().add(lblLoginUtente);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblPassword.setBounds(37, 163, 85, 30);
		getContentPane().add(lblPassword);
		
		ShowPassword = new JCheckBox("Mostra Password");
		ShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShowPassword.isSelected()) {
					txtGetPassword.setEchoChar((char)0);
				}
				else {
					txtGetPassword.setEchoChar('*');
				}
			}
		});
		ShowPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowPassword.setBounds(151, 196, 135, 23);
		getContentPane().add(ShowPassword);
		ShowPassword.setCursor(Mano);
		
		lblNonRegistrato = new JLabel("Non sono registrato:");
		lblNonRegistrato.setFont(new Font("PT Sans", Font.PLAIN, 15));
		lblNonRegistrato.setBounds(363, 270, 140, 30);
		getContentPane().add(lblNonRegistrato);
		
		lblRegistrati = new JLabel("Registrati");
		myGestore.setBluLink(lblRegistrati);
		lblRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtGetEmail.setText("");
				txtGetPassword.setText("");
				ShowPassword.setSelected(false);
				myGestore.switchToRegisterUser();
			}
		});
		lblRegistrati.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblRegistrati.setBounds(502, 270, 66, 30);
		getContentPane().add(lblRegistrati);
		lblRegistrati.setCursor(Mano);
		
		lblSeiUnOperatore = new JLabel("Sei un operatore?");
		lblSeiUnOperatore.setFont(new Font("PT Sans", Font.PLAIN, 15));
		lblSeiUnOperatore.setBounds(23, 270, 120, 30);
		getContentPane().add(lblSeiUnOperatore);
		
		lblAccediQui = new JLabel("Accedi qui");
		
		myGestore.setBluLink(lblAccediQui);
		lblAccediQui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtGetEmail.setText("");
				txtGetPassword.setText("");
				ShowPassword.setSelected(false);
				myGestore.switchLoginToOperatore();
			}
		});
		lblAccediQui.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblAccediQui.setBounds(140, 270, 75, 30);
		getContentPane().add(lblAccediQui);
		lblAccediQui.setCursor(Mano);
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblEmail.setBounds(37, 118, 45, 30);
		getContentPane().add(lblEmail);
		
		Logo = new JLabel("");
		Logo.setIcon(image);
		Logo.setBounds(151, 24, 161, 70);
		getContentPane().add(Logo);
		
		lblIconEmail = new JLabel("");
		lblIconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEmail.setBounds(455, 118, 30, 30);
		lblIconEmail.setIcon(new ImageIcon("Icons/EmailIcon.png"));
		getContentPane().add(lblIconEmail);
		
		lblIconaPassword = new JLabel("");
		lblIconaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconaPassword.setBounds(455, 164, 30, 30);
		lblIconaPassword.setIcon(new ImageIcon("Icons/PasswordIcon.png"));
		getContentPane().add(lblIconaPassword);
		
		loginButton = new JButton("Login");
		myGestore.setBluLink(loginButton);
		loginButton.setCursor(Mano);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtGetEmail.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Inserisci una mail", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				else
				{
					if(new String(txtGetPassword.getPassword()).equals(""))
						JOptionPane.showMessageDialog(null, "Inserisci una password", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
					else
						loginCheck();
				}
			}
		});
		loginButton.setVerticalAlignment(SwingConstants.BOTTOM);
		loginButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		loginButton.setBounds(334, 206, 117, 29);
		getContentPane().add(loginButton);
	}
	
	private void loginCheck() {
		boolean doesEmailExist = false;
		posizioneUtente = 0;
		
		for(Utente u: myGestore.ListaUtenti) {
			if(txtGetEmail.getText().equals(u.getEmail())) {
				doesEmailExist = true;	
				
				if(u.getPassword().equals(new String(txtGetPassword.getPassword()))) {
					myGestore.homePageUtente.aggiornaInfo();
					myGestore.fromLoginUtenteToHomePageUtente();
					txtGetPassword.setText("");
					ShowPassword.setSelected(false);
					break;
				}	
				else {
					txtGetPassword.setText("");
					JOptionPane.showMessageDialog(null, "Password errata.", "ATTENZIONE!", JOptionPane.OK_OPTION);
				}
			}
			posizioneUtente++;
		}
		
		if(doesEmailExist == false)
		{
			txtGetEmail.setText("");
			txtGetPassword.setText("");
			JOptionPane.showMessageDialog(null, "Email non registrata.", "ATTENZIONE!", JOptionPane.OK_OPTION);
		}
	}
}
