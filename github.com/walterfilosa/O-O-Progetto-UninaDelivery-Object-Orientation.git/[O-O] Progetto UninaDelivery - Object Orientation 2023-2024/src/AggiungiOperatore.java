import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AggiungiOperatore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUninaDelivery;
	private JLabel lblTxtRegistrazione;
	private JLabel Logo;
	private JTextField txtGetNome;
	private JPasswordField txtGetPassword;
	private JPasswordField txtGetConfirmPassword;
	private JTextField txtGetEmail;
	private JTextField txtGetCognome;
	private JTextField txtGetCodiceFiscale;
	private JTextField txtGetTelefono;
	private Cursor Mano;
	private Color bluLink;
	private JPanel panel;
	private JLabel lblTxtNome;
	private JLabel lblTxtNumeroDiTelefono;
	private JLabel lblTxtPassword;
	private JLabel lblCognome;
	private JLabel lblCodiceFiscale;
	private JLabel lblEmail;
	private JLabel lblConfermaPassword;
	private JCheckBox ShowConfirmPassword;
	private JButton btnRegistrati;
	private JCheckBox ShowPassword;

	private GestoreApplicazione myGestore;
	private JLabel lblAsterisco;
	
	public AggiungiOperatore(GestoreApplicazione ga) {
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 500);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0,2,160);
		
		
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblUninaDelivery.setBounds(334, 6, 300, 50);
		contentPane.add(lblUninaDelivery);
		
		lblTxtRegistrazione = new JLabel("REGISTRAZIONE OPERATORE");
		lblTxtRegistrazione.setForeground(Color.BLACK);
		lblTxtRegistrazione.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtRegistrazione.setBounds(369, 51, 230, 30);
		contentPane.add(lblTxtRegistrazione);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(211, 11, 161, 70);
		contentPane.add(Logo);
		
		panel = new JPanel();
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(6, 93, 828, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTxtNome = new JLabel("Nome:");
		lblTxtNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNome.setBounds(28, 19, 130, 30);
		panel.add(lblTxtNome);
		
		lblTxtNumeroDiTelefono = new JLabel("Telefono:");
		lblTxtNumeroDiTelefono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNumeroDiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNumeroDiTelefono.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNumeroDiTelefono.setBounds(420, 78, 130, 30);
		panel.add(lblTxtNumeroDiTelefono);
		
		lblTxtPassword = new JLabel("Password:");
		lblTxtPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtPassword.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtPassword.setBounds(28, 199, 130, 30);
		panel.add(lblTxtPassword);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Inserire Nome");
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(168, 20, 200, 35);
		panel.add(txtGetNome);
		
		txtGetPassword = new JPasswordField();
		txtGetPassword.setToolTipText("Inserire Password");
		txtGetPassword.setForeground(new Color(0, 2, 160));
		txtGetPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetPassword.setBounds(168, 199, 200, 35);
		panel.add(txtGetPassword);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCognome.setBounds(420, 19, 130, 30);
		panel.add(lblCognome);
		
		lblCodiceFiscale = new JLabel("Codice Fiscale:");
		lblCodiceFiscale.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCodiceFiscale.setBounds(28, 78, 130, 30);
		panel.add(lblCodiceFiscale);
		
		lblEmail = new JLabel("Email: *");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblEmail.setBounds(28, 139, 130, 30);
		panel.add(lblEmail);
		
		lblConfermaPassword = new JLabel("Conferma Password:");
		lblConfermaPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfermaPassword.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblConfermaPassword.setBounds(420, 199, 170, 30);
		panel.add(lblConfermaPassword);
		
		txtGetConfirmPassword = new JPasswordField();
		txtGetConfirmPassword.setToolTipText("Confermare Password");
		txtGetConfirmPassword.setForeground(new Color(0, 2, 160));
		txtGetConfirmPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetConfirmPassword.setBounds(588, 199, 200, 35);
		panel.add(txtGetConfirmPassword);
		
		txtGetEmail = new JTextField();
		txtGetEmail.setToolTipText("Inserire Email");
		txtGetEmail.setForeground(new Color(0, 2, 160));
		txtGetEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetEmail.setColumns(10);
		txtGetEmail.setBounds(168, 139, 320, 35);
		panel.add(txtGetEmail);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setToolTipText("Inserire Cognome");
		txtGetCognome.setForeground(new Color(0, 2, 160));
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(588, 19, 200, 35);
		panel.add(txtGetCognome);
		
		txtGetCodiceFiscale = new JTextField();
		txtGetCodiceFiscale.setToolTipText("Inserire Codice Fiscale");
		txtGetCodiceFiscale.setForeground(new Color(0, 2, 160));
		txtGetCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCodiceFiscale.setColumns(10);
		txtGetCodiceFiscale.setBounds(168, 79, 200, 35);
		panel.add(txtGetCodiceFiscale);
		
		ShowConfirmPassword = new JCheckBox("Mostra Password");
		ShowConfirmPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowConfirmPassword.setBounds(588, 229, 135, 23);
		ShowConfirmPassword.setCursor(Mano);
		panel.add(ShowConfirmPassword);
		ShowConfirmPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShowConfirmPassword.isSelected()) {
					txtGetConfirmPassword.setEchoChar((char)0);
				}
				else {
					txtGetConfirmPassword.setEchoChar('●');
				}
			}
		});
		
		ShowPassword = new JCheckBox("Mostra Password");
		ShowPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowPassword.setBounds(170, 229, 135, 23);
		ShowPassword.setCursor(Mano);
		panel.add(ShowPassword);
		ShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShowPassword.isSelected()) {
					txtGetPassword.setEchoChar((char)0);
				}
				else {
					txtGetPassword.setEchoChar('●');
				}
			}
		});
		
		btnRegistrati = new JButton("Registra operatore");
		btnRegistrati.setIcon(new ImageIcon("Icons/RegistraIcon.png"));
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean emailEsistente = false;
				for(int i = 0; i < myGestore.ListaUtenti.size(); i++) {
					if(txtGetEmail.getText().equals(myGestore.ListaUtenti.get(i).getEmail())) {
						emailEsistente = true;
					}
				}
				
				if(emailEsistente == true) {
					JOptionPane.showMessageDialog(null, "Email già registrata.", "ATTENZIONE!", JOptionPane.ERROR_MESSAGE);
					txtGetEmail.setText("");
					txtGetPassword.setText("");
					txtGetConfirmPassword.setText("");
					ShowPassword.setSelected(false);
					ShowConfirmPassword.setSelected(false);
				}
				
				else {
					if(controlliRegistrazione())
					{
						if((new String(txtGetPassword.getPassword()).equals(new String(txtGetConfirmPassword.getPassword())))) {
							myGestore.ListaOperatori.add(new Operatore(txtGetNome.getText(), txtGetCognome.getText(), txtGetTelefono.getText(), txtGetCodiceFiscale.getText(), txtGetEmail.getText(), new String(txtGetPassword.getPassword())));
							txtGetNome.setText("");
							txtGetCognome.setText("");
							txtGetCodiceFiscale.setText("");
							txtGetTelefono.setText("");
							txtGetEmail.setText("");
							txtGetPassword.setText("");
							txtGetConfirmPassword.setText("");
							ShowPassword.setSelected(false);
							ShowConfirmPassword.setSelected(false);
							myGestore.visualizzaOperatori.aggiornaLista();
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo.", "REGISTRAZIONE EFFETTUATA", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							txtGetConfirmPassword.setText("");
							txtGetPassword.setText("");
							ShowPassword.setSelected(false);
							ShowConfirmPassword.setSelected(false);
							txtGetPassword.setEchoChar('●');
							txtGetConfirmPassword.setEchoChar('●');
							JOptionPane.showMessageDialog(null, "Le password non corrispondo", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnRegistrati.setForeground(bluLink);
		btnRegistrati.setCursor(Mano);
		btnRegistrati.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnRegistrati.setBounds(538, 293, 250, 40);
		panel.add(btnRegistrati);
		
		txtGetTelefono = new JTextField();
		txtGetTelefono.setToolTipText("Inserire numero di telefono");
		txtGetTelefono.setForeground(new Color(0, 2, 160));
		txtGetTelefono.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetTelefono.setColumns(10);
		txtGetTelefono.setBounds(588, 79, 200, 35);
		panel.add(txtGetTelefono);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setForeground(new Color(0, 2, 160));
		btnAnnulla.setBounds(28, 293, 150, 40);
		panel.add(btnAnnulla);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnulla.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAnnulla.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		
		lblAsterisco = new JLabel("* la registrazione è riservata esclusivamente agli operatori Unina (@unina.it)");
		lblAsterisco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAsterisco.setFont(new Font("PT Sans", Font.BOLD, 15));
		lblAsterisco.setBounds(252, 345, 566, 18);
		panel.add(lblAsterisco);
	}
	
	private boolean controlliRegistrazione() {
		boolean allChecked = true;
		if(txtGetNome.getText().length() < 3)
		{
			JOptionPane.showMessageDialog(null, "Il nome deve contenere almeno 3 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
			txtGetNome.setText("");
			allChecked = false;
		}
		else if(txtGetNome.getText().length() > 50)
		{
			JOptionPane.showMessageDialog(null, "Il nome deve contenere al più 50 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
			txtGetNome.setText("");
			allChecked = false;
		}
		
		if(allChecked == true)
		{
			if(txtGetCognome.getText().length() < 3)
			{
				JOptionPane.showMessageDialog(null, "Il cognome deve contenere almeno 3 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetCognome.setText("");
				allChecked = false;
			}
			else if(txtGetCognome.getText().length() > 50)
			{
				JOptionPane.showMessageDialog(null, "Il cognome deve contenere al più 50 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetCognome.setText("");
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetCodiceFiscale.getText().length() != 16)
			{
				JOptionPane.showMessageDialog(null, "Il codice fiscale deve contenere 16 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetCodiceFiscale.setText("");
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetTelefono.getText().length() != 10)
			{
				JOptionPane.showMessageDialog(null, "Il numero di telefono può contenere 10 cifre.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetTelefono.setText("");
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(!isNumeric(txtGetTelefono.getText()))
			{
				JOptionPane.showMessageDialog(null, "Il numero di telefono può contenere solo numeri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetTelefono.setText("");
				allChecked = false;
			}
		}
		
		
		
		if(allChecked == true)
		{
			if(!isEmailValid(txtGetEmail.getText()))
			{
				JOptionPane.showMessageDialog(null, "Indirizzo email non valido.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetEmail.setText("");
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(new String(txtGetPassword.getPassword()).length() < 8)
			{
				JOptionPane.showMessageDialog(null, "La password deve contenere almeno 8 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetPassword.setText("");
				allChecked = false;
			}
		}
		return allChecked;
	}
	
	private static boolean isNumeric(String str) { 
		try
		{  
		   Integer.parseInt(str);  
		   return true;
		}
		catch(NumberFormatException e)
		{  
		   return false;  
		}  
	}
	
	private static boolean isEmailValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "unina.it";
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
}
