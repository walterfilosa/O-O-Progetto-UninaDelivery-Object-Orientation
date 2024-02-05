import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OperatoreLoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private GestoreApplicazione myGestore;
	private JTextField txtGetEmail;
	private JPasswordField txtGetPassword;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JCheckBox ShowPassword;
	private JLabel lblSeiUnOperatore;
	private JLabel lblAccediQui;
	private JLabel lblBenvenuto;
	private JLabel lblLoginUtente;
	private JLabel Logo;
	private JLabel lblIconEmail;
	private JLabel lblIconaPassword;
	private Cursor Mano;
	private JButton accediButton;
	public int posizioneOperatore;
	



	public OperatoreLoginFrame(GestoreApplicazione ga) {
		
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 500, 600, 350);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		myGestore.setIconFrame(this);
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
		txtGetEmail.setBounds(150, 118, 300, 30);
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
		txtGetPassword.setBounds(150, 164, 300, 30);
		getContentPane().add(txtGetPassword);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblEmail.setBounds(36, 118, 45, 30);
		getContentPane().add(lblEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblPassword.setBounds(36, 163, 85, 30);
		getContentPane().add(lblPassword);
		
		ShowPassword = new JCheckBox("Mostra Password");
		ShowPassword.setHorizontalAlignment(SwingConstants.CENTER);
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
		ShowPassword.setBounds(150, 196, 135, 23);
		getContentPane().add(ShowPassword);
		ShowPassword.setCursor(Mano);
		
		lblSeiUnOperatore = new JLabel("Sei un utente?");
		lblSeiUnOperatore.setFont(new Font("PT Sans", Font.PLAIN, 15));
		lblSeiUnOperatore.setBounds(36, 270, 100, 30);
		getContentPane().add(lblSeiUnOperatore);
		
		lblAccediQui = new JLabel("Accedi qui");
		myGestore.setBluLink(lblAccediQui);
		lblAccediQui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtGetEmail.setText("");
				txtGetPassword.setText("");
				ShowPassword.setSelected(false);
				myGestore.switchLoginToUtente();
			}
		});
		lblAccediQui.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblAccediQui.setBounds(135, 270, 75, 30);
		getContentPane().add(lblAccediQui);
		lblAccediQui.setCursor(Mano);
		
		lblBenvenuto = new JLabel("UninaDelivery");
		lblBenvenuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenvenuto.setForeground(new Color(0, 2, 160));
		lblBenvenuto.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblBenvenuto.setBounds(300, 32, 151, 30);
		getContentPane().add(lblBenvenuto);
		
		lblLoginUtente = new JLabel("Login Operatore");
		lblLoginUtente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginUtente.setForeground(Color.BLACK);
		lblLoginUtente.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblLoginUtente.setBounds(324, 60, 126, 25);
		getContentPane().add(lblLoginUtente);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
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
		
		accediButton = new JButton("Login");
		accediButton.addActionListener(new ActionListener() {
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
		myGestore.setBluLink(accediButton);
		accediButton.setCursor(Mano);
		accediButton.setVerticalAlignment(SwingConstants.BOTTOM);
		accediButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		accediButton.setBounds(350, 217, 100, 32);
		getContentPane().add(accediButton);
	}
	
	private void loginCheck() {
		boolean doesEmailExist = false;
		posizioneOperatore = 0;
		
		for(Operatore u: myGestore.ListaOperatori) {
			if(txtGetEmail.getText().equals(u.getEmail())) {
				doesEmailExist = true;	
				
				if(u.getPassword().equals(new String(txtGetPassword.getPassword()))) {
					myGestore.fromLoginOperatoreToHomePageOperatore();
					txtGetPassword.setText("");
					ShowPassword.setSelected(false);
					myGestore.infoOperatoreLoggato.aggiornaInfo();
					myGestore.homePageOperatore.aggiornaInfo();
					break;
				}	
				else {
					txtGetPassword.setText("");
					JOptionPane.showMessageDialog(null, "Password errata.", "ATTENZIONE!", JOptionPane.OK_OPTION);
				}
			}
			posizioneOperatore++;
		}
		
		if(doesEmailExist == false)
		{
			txtGetEmail.setText("");
			txtGetPassword.setText("");
			JOptionPane.showMessageDialog(null, "Email non registrata.", "ATTENZIONE!", JOptionPane.OK_OPTION);
		}
	}
}
