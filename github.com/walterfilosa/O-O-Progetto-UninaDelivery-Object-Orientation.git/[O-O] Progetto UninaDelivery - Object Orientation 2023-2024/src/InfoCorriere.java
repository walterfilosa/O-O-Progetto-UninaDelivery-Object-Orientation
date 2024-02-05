import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InfoCorriere extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblInfo;
	private JLabel lblGeneralitàCorriere;
	private JPanel InfoPane;

	private GestoreApplicazione myGestore;
	private JButton btnIndietro;
	private JLabel lblNome;
	private JTextField txtGetNome;
	private JTextField txtGetCognome;
	private JTextField txtGetCodiceFiscale;
	private JLabel lblID;
	private JTextField txtGetID;
	private JLabel lblCognome;
	private JLabel lblCodiceFiscale;
	
	public InfoCorriere(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 666, 390);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfo = new JLabel("INFO");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(new Color(0, 2, 160));
		lblInfo.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblInfo.setBounds(231, 24, 190, 30);
		contentPane.add(lblInfo);
		
		lblGeneralitàCorriere = new JLabel("GENERALITÀ CORRIERE");
		lblGeneralitàCorriere.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneralitàCorriere.setForeground(Color.BLACK);
		lblGeneralitàCorriere.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblGeneralitàCorriere.setBackground(new Color(216, 216, 216));
		lblGeneralitàCorriere.setBounds(201, 65, 250, 30);
		contentPane.add(lblGeneralitàCorriere);
		
		InfoPane = new JPanel();
		InfoPane.setBackground(new Color(216, 216, 216));
		InfoPane.setBounds(10, 118, 632, 178);
		contentPane.add(InfoPane);
		InfoPane.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblNome.setBounds(10, 52, 130, 30);
		InfoPane.add(lblNome);
		
		txtGetNome = new JTextField();
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetNome.setEditable(false);
		txtGetNome.setBounds(197, 52, 425, 30);
		InfoPane.add(txtGetNome);
		txtGetNome.setColumns(10);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCognome.setBounds(10, 93, 130, 30);
		InfoPane.add(lblCognome);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetCognome.setEditable(false);
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(197, 93, 425, 30);
		InfoPane.add(txtGetCognome);
		
		lblCodiceFiscale = new JLabel("Codice Fiscale:");
		lblCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCodiceFiscale.setBounds(10, 134, 130, 30);
		InfoPane.add(lblCodiceFiscale);
		
		txtGetCodiceFiscale = new JTextField();
		txtGetCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetCodiceFiscale.setEditable(false);
		txtGetCodiceFiscale.setColumns(10);
		txtGetCodiceFiscale.setBounds(197, 134, 425, 30);
		InfoPane.add(txtGetCodiceFiscale);
		
		lblID = new JLabel("ID:");
		lblID.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblID.setBounds(10, 11, 130, 30);
		InfoPane.add(lblID);
		
		txtGetID = new JTextField();
		txtGetID.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetID.setEditable(false);
		txtGetID.setColumns(10);
		txtGetID.setBounds(197, 11, 425, 30);
		InfoPane.add(txtGetID);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnIndietro.setBounds(235, 307, 182, 41);
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
	}
	
	public void aggiornaInfo() {
		txtGetNome.setText(myGestore.ListaCorrieri.get(myGestore.gestioneCorriereMezzi.posizioneCorriereSelezionato).getNome());
		txtGetCognome.setText(myGestore.ListaCorrieri.get(myGestore.gestioneCorriereMezzi.posizioneCorriereSelezionato).getCognome());
		txtGetCodiceFiscale.setText(myGestore.ListaCorrieri.get(myGestore.gestioneCorriereMezzi.posizioneCorriereSelezionato).getCodiceFiscale());
		txtGetID.setText("#" + myGestore.ListaCorrieri.get(myGestore.gestioneCorriereMezzi.posizioneCorriereSelezionato).getID());
	}
}
