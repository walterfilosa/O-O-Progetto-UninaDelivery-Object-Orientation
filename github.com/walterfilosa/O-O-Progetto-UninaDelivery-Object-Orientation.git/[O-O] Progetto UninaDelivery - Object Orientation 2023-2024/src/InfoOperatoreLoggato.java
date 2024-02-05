import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoOperatoreLoggato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetEmail;
	private JTextField txtGetCognome;
	private JTextField txtGetCodiceFiscale;
	private JTextField txtGetTelefono;
	private Cursor Mano;
	private JPanel panel;
	private JLabel lblTxtNome;
	private JLabel lblTxtNumeroDiTelefono;
	private JLabel lblCognome;
	private JLabel lblCodiceFiscale;
	private JLabel lblEmail;
	private JButton chiudiButton;
	private JButton modificaButton;
	private JLabel Logo;
	private JLabel lblNomeOperatore;

	public InfoOperatoreLoggato(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Mano = new Cursor(Cursor.HAND_CURSOR);
		
		panel = new JPanel();
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(10, 110, 720, 295);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTxtNome = new JLabel("Nome:");
		lblTxtNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNome.setBounds(37, 50, 130, 30);
		panel.add(lblTxtNome);
		
		lblTxtNumeroDiTelefono = new JLabel("Telefono:");
		lblTxtNumeroDiTelefono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNumeroDiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNumeroDiTelefono.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNumeroDiTelefono.setBounds(371, 109, 80, 30);
		panel.add(lblTxtNumeroDiTelefono);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Nome operatore");
		txtGetNome.setEditable(false);
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(159, 51, 200, 35);
		panel.add(txtGetNome);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCognome.setBounds(371, 50, 95, 30);
		panel.add(lblCognome);
		
		lblCodiceFiscale = new JLabel("Codice Fiscale:");
		lblCodiceFiscale.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCodiceFiscale.setBounds(37, 109, 130, 30);
		panel.add(lblCodiceFiscale);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblEmail.setBounds(37, 169, 50, 30);
		panel.add(lblEmail);
		
		txtGetEmail = new JTextField();
		txtGetEmail.setToolTipText("Email operatore");
		txtGetEmail.setEditable(false);
		txtGetEmail.setForeground(new Color(0, 2, 160));
		txtGetEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetEmail.setColumns(10);
		txtGetEmail.setBounds(159, 170, 292, 35);
		panel.add(txtGetEmail);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setToolTipText("Cognome operatore");
		txtGetCognome.setEditable(false);
		txtGetCognome.setForeground(new Color(0, 2, 160));
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(466, 50, 200, 35);
		panel.add(txtGetCognome);
		
		txtGetCodiceFiscale = new JTextField();
		txtGetCodiceFiscale.setToolTipText("Codice Fiscale operatore");
		txtGetCodiceFiscale.setEditable(false);
		txtGetCodiceFiscale.setForeground(new Color(0, 2, 160));
		txtGetCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCodiceFiscale.setColumns(10);
		txtGetCodiceFiscale.setBounds(159, 110, 200, 35);
		panel.add(txtGetCodiceFiscale);
		
		txtGetTelefono = new JTextField();
		txtGetTelefono.setToolTipText("Numero telefono operatore");
		txtGetTelefono.setEditable(false);
		txtGetTelefono.setForeground(new Color(0, 2, 160));
		txtGetTelefono.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetTelefono.setColumns(10);
		txtGetTelefono.setBounds(466, 110, 200, 35);
		panel.add(txtGetTelefono);
		
		chiudiButton = new JButton("Chiudi");
		chiudiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromInfoOperatoreLoggatoToHomePageOperatore();
			}
		});
		
		
		chiudiButton.setForeground(new Color(0, 2, 160));
		chiudiButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		chiudiButton.setBounds(37, 234, 130, 40);
		chiudiButton.setCursor(Mano);
		panel.add(chiudiButton);
		
		modificaButton = new JButton("Modifica");
		modificaButton.setIcon(new ImageIcon("Icons/ModificaIcon.png"));
		modificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoOperatoreLoggato.setVisible(false);
				myGestore.modificaOperatoreInfo.setVisible(true);
				myGestore.modificaOperatoreInfo.aggiornaInfo();
			}
		});
		modificaButton.setForeground(new Color(0, 2, 160));
		modificaButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		modificaButton.setBounds(536, 234, 130, 40);
		modificaButton.setCursor(Mano);
		panel.add(modificaButton);
		
		Logo = new JLabel();
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(169, 20, 161, 70);
		contentPane.add(Logo);
		
		lblNomeOperatore = new JLabel();
		lblNomeOperatore.setForeground(new Color(0, 2, 160));
		lblNomeOperatore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeOperatore.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblNomeOperatore.setBounds(342, 20, 388, 70);
		contentPane.add(lblNomeOperatore);
	}
	
	
	public void aggiornaInfo() {
		lblNomeOperatore.setText("Operatore: " + myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNome());
		txtGetNome.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNome());
		txtGetCognome.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getCognome());
		txtGetCodiceFiscale.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getCodiceFiscale());
		txtGetTelefono.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNumeroDiTelefono());
		txtGetEmail.setText(myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getEmail());
	}
}
