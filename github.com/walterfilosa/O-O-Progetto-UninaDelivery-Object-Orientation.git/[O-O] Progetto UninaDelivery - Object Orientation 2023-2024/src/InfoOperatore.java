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

public class InfoOperatore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetEmail;
	private JTextField txtGetCognome;
	private JTextField txtGetTelefono;
	private Cursor Mano;
	private JPanel panel;
	private JLabel lblTxtNome;
	private JLabel lblTxtNumeroDiTelefono;
	private JLabel lblCognome;
	private JLabel lblEmail;
	private JButton btnChiudi;
	private JLabel lblInfoOperatore;
	private JLabel lblDatiAnagrafici;
	private JLabel lblContatti;

	public InfoOperatore(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 360);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Mano = new Cursor(Cursor.HAND_CURSOR);
		
		panel = new JPanel();
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(10, 60, 720, 190);
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
		lblTxtNumeroDiTelefono.setBounds(371, 143, 80, 30);
		panel.add(lblTxtNumeroDiTelefono);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Nome operatore");
		txtGetNome.setEditable(false);
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(120, 51, 230, 35);
		panel.add(txtGetNome);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCognome.setBounds(371, 50, 95, 30);
		panel.add(lblCognome);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblEmail.setBounds(37, 143, 50, 30);
		panel.add(lblEmail);
		
		txtGetEmail = new JTextField();
		txtGetEmail.setToolTipText("Email operatore");
		txtGetEmail.setEditable(false);
		txtGetEmail.setForeground(new Color(0, 2, 160));
		txtGetEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetEmail.setColumns(10);
		txtGetEmail.setBounds(120, 144, 230, 35);
		panel.add(txtGetEmail);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setToolTipText("Cognome operatore");
		txtGetCognome.setEditable(false);
		txtGetCognome.setForeground(new Color(0, 2, 160));
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(466, 50, 230, 35);
		panel.add(txtGetCognome);
		
		txtGetTelefono = new JTextField();
		txtGetTelefono.setToolTipText("Numero telefono operatore");
		txtGetTelefono.setEditable(false);
		txtGetTelefono.setForeground(new Color(0, 2, 160));
		txtGetTelefono.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetTelefono.setColumns(10);
		txtGetTelefono.setBounds(466, 144, 230, 35);
		panel.add(txtGetTelefono);
		
		lblDatiAnagrafici = new JLabel();
		lblDatiAnagrafici.setText("Dati Anagrafici:");
		lblDatiAnagrafici.setForeground(new Color(0, 2, 160));
		lblDatiAnagrafici.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblDatiAnagrafici.setBounds(37, 11, 140, 30);
		panel.add(lblDatiAnagrafici);
		
		lblContatti = new JLabel();
		lblContatti.setText("Contatti:");
		lblContatti.setForeground(new Color(0, 2, 160));
		lblContatti.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblContatti.setBounds(37, 102, 80, 30);
		panel.add(lblContatti);
		
		lblInfoOperatore = new JLabel();
		lblInfoOperatore.setText("INFO OPERATORE");
		lblInfoOperatore.setForeground(new Color(0, 2, 160));
		lblInfoOperatore.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoOperatore.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblInfoOperatore.setBounds(268, 20, 200, 30);
		contentPane.add(lblInfoOperatore);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.setBounds(303, 279, 130, 40);
		contentPane.add(btnChiudi);
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		btnChiudi.setForeground(new Color(0, 2, 160));
		btnChiudi.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnChiudi.setCursor(Mano);
	}
	
	
	public void aggiornaInfo() {
		txtGetNome.setText(myGestore.ListaOperatori.get(myGestore.visualizzaOperatori.posizioneOperatore).getNome());
		txtGetCognome.setText(myGestore.ListaOperatori.get(myGestore.visualizzaOperatori.posizioneOperatore).getCognome());
		txtGetTelefono.setText(myGestore.ListaOperatori.get(myGestore.visualizzaOperatori.posizioneOperatore).getNumeroDiTelefono());
		txtGetEmail.setText(myGestore.ListaOperatori.get(myGestore.visualizzaOperatori.posizioneOperatore).getEmail());
	}
}
