import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class ModificaOperatoreInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetCognome;
	private JTextField txtGetCodiceFiscale;
	private JTextField txtGetTelefono;
	private Cursor Mano;
	private JPanel panel;
	private JLabel lblTxtNome;
	private JLabel lblTxtNumeroDiTelefono;
	private JLabel lblCognome;
	private JLabel lblCodiceFiscale;
	private JButton btnSalva;
	private JButton annullaButton;
	private JLabel lblTitolo;
	private JPasswordField txtGetPassword;
	private JPasswordField txtGetConfermaPassword;
	private JLabel lblTxtPassword;
	private JCheckBox ShowPassword;
	private JCheckBox ShowConfirmPassword;
	private JLabel lblConfermaPassword;
	
	public ModificaOperatoreInfo(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 370);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mano = new Cursor(Cursor.HAND_CURSOR);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(6, 65, 730, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTxtNome = new JLabel("Nome:");
		lblTxtNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNome.setBounds(6, 17, 130, 30);
		panel.add(lblTxtNome);
		
		lblTxtNumeroDiTelefono = new JLabel("Telefono:");
		lblTxtNumeroDiTelefono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNumeroDiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNumeroDiTelefono.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNumeroDiTelefono.setBounds(340, 76, 110, 30);
		panel.add(lblTxtNumeroDiTelefono);
		
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
					myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).setNome(txtGetNome.getText());
					myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).setCognome(txtGetCognome.getText());
					myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).setNumeroDiTelefono(txtGetTelefono.getText());
					myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).setPassword(new String(txtGetPassword.getPassword()));
					myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).setCodiceFiscale(txtGetCodiceFiscale.getText());
					myGestore.homePageOperatore.setVisible(false);
					myGestore.modificaOperatoreInfo.setVisible(false);
					myGestore.infoOperatoreLoggato.aggiornaInfo();
					myGestore.homePageOperatore.aggiornaInfo();
					myGestore.homePageOperatore.setVisible(true);
					
					txtGetNome.setText("");
					txtGetCognome.setText("");
					txtGetTelefono.setText("");
					txtGetPassword.setText("");
					txtGetCodiceFiscale.setText("");
					myGestore.infoOperatoreLoggato.setVisible(true);
					mostraMessaggioConferma();
				}
			}
		});
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setCursor(Mano);
		
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnSalva.setBounds(605, 217, 115, 40);
		panel.add(btnSalva);
		
		annullaButton = new JButton("Annulla");
		annullaButton.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		annullaButton.setToolTipText("Annulla Modiche");
		annullaButton.setCursor(Mano);
		annullaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGetNome.setText("");
				txtGetCognome.setText("");
				txtGetPassword.setText("");
				txtGetConfermaPassword.setText("");
				txtGetTelefono.setText("");
				txtGetCodiceFiscale.setText("");
				myGestore.modificaOperatoreInfo.setVisible(false);
				myGestore.infoOperatoreLoggato.setVisible(true);
			}
		});
		annullaButton.setForeground(new Color(0, 2, 160));
		annullaButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		annullaButton.setBounds(6, 217, 115, 40);
		panel.add(annullaButton);
		
		txtGetPassword = new JPasswordField();
		txtGetPassword.setToolTipText("Inserire Password");
		txtGetPassword.setForeground(new Color(0, 2, 160));
		txtGetPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetPassword.setBounds(128, 136, 200, 35);
		panel.add(txtGetPassword);
		
		ShowPassword = new JCheckBox("Mostra Password");
		ShowPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowPassword.setBounds(128, 172, 135, 23);
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
		
		lblTxtPassword = new JLabel("Password:");
		lblTxtPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtPassword.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtPassword.setBounds(6, 135, 130, 30);
		panel.add(lblTxtPassword);
		
		txtGetConfermaPassword = new JPasswordField();
		txtGetConfermaPassword.setToolTipText("Confermare Password");
		txtGetConfermaPassword.setForeground(new Color(0, 2, 160));
		txtGetConfermaPassword.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetConfermaPassword.setBounds(509, 136, 200, 35);
		panel.add(txtGetConfermaPassword);
		
		ShowConfirmPassword = new JCheckBox("Mostra Password");
		ShowConfirmPassword.setFont(new Font("PT Sans Caption", Font.PLAIN, 12));
		ShowConfirmPassword.setBounds(509, 172, 135, 23);
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
		lblConfermaPassword.setBounds(340, 134, 170, 30);
		panel.add(lblConfermaPassword);
		
		lblTitolo = new JLabel("MODIFICA INFORMAZIONI PERSONALI");
		lblTitolo.setForeground(new Color(0, 2, 160));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTitolo.setBounds(193, 10, 350, 50);
		contentPane.add(lblTitolo);
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
	
	public void aggiornaInfo() {
		txtGetNome.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNome());
		txtGetCognome.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getCognome());
		txtGetCodiceFiscale.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getCodiceFiscale());
		txtGetTelefono.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNumeroDiTelefono());
	}
}
