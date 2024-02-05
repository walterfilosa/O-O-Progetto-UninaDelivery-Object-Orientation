import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaUtenteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	
	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetCognome;
	private JTextField txtGetCodiceFiscale;
	private JTextField txtGetTelefono;
	private JPasswordField txtGetPassword;
	private JPasswordField txtGetConfermaPassword;
	private JLabel lblCognome;
	private JLabel lblNome;
	private JPanel panel;
	private JLabel lblTelefono;
	private JLabel lblCodiceFiscale;
	private JButton btnSalva;
	private JButton annullaButton;
	private JCheckBox ShowPassword;
	private JLabel lblPassword;
	private JCheckBox ShowConfirmPassword;
	private JLabel lblConfermaPassword;
	private JLabel lblTitolo;
	private JLabel lblIndirizzo;
	private JTextField txtGetIndirizzo;
	
	public ModificaUtenteFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(10, 75, 730, 338);
		contentPane.add(panel);
		
		lblNome = new JLabel("Nome:");
		lblNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNome.setBounds(6, 17, 130, 30);
		panel.add(lblNome);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTelefono.setBounds(340, 76, 110, 30);
		panel.add(lblTelefono);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Inserire Nome");
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(128, 18, 200, 35);
		panel.add(txtGetNome);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCognome.setBounds(340, 17, 95, 30);
		panel.add(lblCognome);
		
		lblCodiceFiscale = new JLabel("Codice Fiscale:");
		lblCodiceFiscale.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCodiceFiscale.setBounds(6, 76, 130, 30);
		panel.add(lblCodiceFiscale);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setToolTipText("Inserire Cognome");
		txtGetCognome.setForeground(new Color(0, 2, 160));
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(509, 19, 200, 35);
		panel.add(txtGetCognome);
		
		txtGetCodiceFiscale = new JTextField();
		txtGetCodiceFiscale.setToolTipText("Inserire Codice Fiscale");
		txtGetCodiceFiscale.setForeground(new Color(0, 2, 160));
		txtGetCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCodiceFiscale.setColumns(10);
		txtGetCodiceFiscale.setBounds(128, 77, 200, 35);
		panel.add(txtGetCodiceFiscale);
		
		txtGetTelefono = new JTextField();
		txtGetTelefono.setToolTipText("Inserire numero di telefono");
		txtGetTelefono.setForeground(new Color(0, 2, 160));
		txtGetTelefono.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetTelefono.setColumns(10);
		txtGetTelefono.setBounds(509, 78, 200, 35);
		panel.add(txtGetTelefono);
		
		btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlliRegistrazione())
				{
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setNome(txtGetNome.getText());
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setCognome(txtGetCognome.getText());
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setCodiceFiscale(txtGetCodiceFiscale.getText());
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setNumeroDiTelefono(txtGetTelefono.getText());
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setIndirizzoDiResidenza(txtGetIndirizzo.getText());
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setPassword(new String(txtGetPassword.getPassword()));
					myGestore.modificaUtenteFrame.setVisible(false);
					myGestore.infoUtente.aggiornaInfo();
					myGestore.homePageUtente.aggiornaInfo();
					txtGetNome.setText("");
					txtGetCognome.setText("");
					txtGetTelefono.setText("");
					txtGetPassword.setText("");
					txtGetCodiceFiscale.setText("");
					txtGetIndirizzo.setText("");
					
					myGestore.infoUtente.setVisible(true);
					mostraMessaggioConferma();
				}
			}
		});
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnSalva.setBounds(605, 287, 115, 40);
		btnSalva.setCursor(Mano);
		panel.add(btnSalva);
		
		annullaButton = new JButton("Annulla");
		annullaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				myGestore.infoUtente.setVisible(true);
			}
		});
		annullaButton.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		annullaButton.setToolTipText("Annulla Modiche");
		annullaButton.setForeground(new Color(0, 2, 160));
		annullaButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		annullaButton.setBounds(6, 287, 115, 40);
		annullaButton.setCursor(Mano);
		panel.add(annullaButton);
		
		txtGetPassword = new JPasswordField();
		txtGetPassword.setEchoChar('*');
		txtGetPassword.setToolTipText("Inserire Password");
		txtGetPassword.setForeground(new Color(0, 2, 160));
		txtGetPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetPassword.setBounds(128, 195, 200, 35);
		panel.add(txtGetPassword);
		
		ShowPassword = new JCheckBox("Mostra Password");
		ShowPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowPassword.setBounds(128, 231, 135, 23);
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
		panel.add(ShowPassword);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblPassword.setBounds(6, 194, 130, 30);
		panel.add(lblPassword);
		
		txtGetConfermaPassword = new JPasswordField();
		txtGetConfermaPassword.setEchoChar('*');
		txtGetConfermaPassword.setToolTipText("Confermare Password");
		txtGetConfermaPassword.setForeground(new Color(0, 2, 160));
		txtGetConfermaPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetConfermaPassword.setBounds(509, 195, 200, 35);
		panel.add(txtGetConfermaPassword);
		
		ShowConfirmPassword = new JCheckBox("Mostra Password");
		ShowConfirmPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowConfirmPassword.setBounds(509, 231, 135, 23);
		ShowConfirmPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShowConfirmPassword.isSelected()) {
					txtGetConfermaPassword.setEchoChar((char)0);
				}
				else {
					txtGetConfermaPassword.setEchoChar('*');
				}
			}
		});
		panel.add(ShowConfirmPassword);
		
		lblConfermaPassword = new JLabel("Conferma Password:");
		lblConfermaPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfermaPassword.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblConfermaPassword.setBounds(340, 193, 170, 30);
		panel.add(lblConfermaPassword);
		
		lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIndirizzo.setHorizontalAlignment(SwingConstants.LEFT);
		lblIndirizzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblIndirizzo.setBounds(6, 135, 80, 30);
		panel.add(lblIndirizzo);
		
		txtGetIndirizzo = new JTextField();
		txtGetIndirizzo.setToolTipText("Inserire indirizzo di residenza");
		txtGetIndirizzo.setForeground(new Color(0, 2, 160));
		txtGetIndirizzo.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetIndirizzo.setColumns(10);
		txtGetIndirizzo.setBounds(128, 136, 581, 35);
		panel.add(txtGetIndirizzo);
		
		lblTitolo = new JLabel("MODIFICA INFORMAZIONI PERSONALI");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(new Color(0, 2, 160));
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTitolo.setBounds(193, 20, 350, 50);
		contentPane.add(lblTitolo);
	}
	
	public void aggiornaInfo(){
		txtGetNome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNome());
		txtGetCognome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCognome());
		txtGetCodiceFiscale.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCodiceFiscale());
		txtGetTelefono.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNumeroDiTelefono());
		txtGetIndirizzo.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getIndirizzoDiResidenza());
	}
	
	private void mostraMessaggioConferma() {
		JOptionPane.showMessageDialog(this, "Informazioni aggiornate con successo.", "", JOptionPane.INFORMATION_MESSAGE);
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
			if(!isNumeric(txtGetTelefono.getText()))
			{
				JOptionPane.showMessageDialog(null, "Il numero di telefono può contenere solo numeri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetTelefono.setText("");
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

}
