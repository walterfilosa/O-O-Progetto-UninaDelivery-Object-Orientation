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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;

public class AggiungiCorriere extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblAggiungi;
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
	private JButton btnSalva;
	
	public AggiungiCorriere(GestoreApplicazione ga) {
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
		
		lblAggiungi = new JLabel("AGGIUNGI");
		lblAggiungi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungi.setForeground(new Color(0, 2, 160));
		lblAggiungi.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblAggiungi.setBounds(231, 24, 190, 30);
		contentPane.add(lblAggiungi);
		
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
		txtGetNome.setBounds(197, 52, 425, 30);
		InfoPane.add(txtGetNome);
		txtGetNome.setColumns(10);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCognome.setBounds(10, 93, 130, 30);
		InfoPane.add(lblCognome);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(197, 93, 425, 30);
		InfoPane.add(txtGetCognome);
		
		lblCodiceFiscale = new JLabel("Codice Fiscale:");
		lblCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCodiceFiscale.setBounds(10, 134, 130, 30);
		InfoPane.add(lblCodiceFiscale);
		
		txtGetCodiceFiscale = new JTextField();
		txtGetCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetCodiceFiscale.setColumns(10);
		txtGetCodiceFiscale.setBounds(197, 134, 425, 30);
		InfoPane.add(txtGetCodiceFiscale);
		
		lblID = new JLabel("ID:");
		lblID.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblID.setBounds(10, 11, 130, 30);
		InfoPane.add(lblID);
		
		txtGetID = new JTextField();
		txtGetID.setEditable(false);
		txtGetID.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetID.setColumns(10);
		txtGetID.setBounds(197, 11, 425, 30);
		InfoPane.add(txtGetID);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnIndietro.setBounds(10, 307, 182, 41);
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlliModifica())
				{
					Corriere c = new Corriere(txtGetNome.getText(), txtGetCognome.getText(), txtGetCodiceFiscale.getText());
					c.generaIDCorriere();
					myGestore.ListaCorrieri.add(c);
					myGestore.gestioneCorriereMezzi.aggiornaListaCorrieri();
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Corriere aggiunto con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnSalva.setBounds(460, 307, 182, 41);
		btnSalva.setCursor(Mano);
		contentPane.add(btnSalva);
	}
	
	public void aggiornaInfo() {
		txtGetNome.setText("");
		txtGetCognome.setText("");
		txtGetCodiceFiscale.setText("");
	}
	
	private boolean controlliModifica() {
		boolean allChecked = true;
		if(txtGetNome.getText().length() < 3)
		{
			JOptionPane.showMessageDialog(null, "Il nome deve contenere almeno 3 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			allChecked = false;
		}
		
		if(allChecked == true)
		{
			if(txtGetCognome.getText().length() < 3)
			{
				JOptionPane.showMessageDialog(null, "Il cognome deve contenere almeno 3 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetCodiceFiscale.getText().length() != 16)
			{
				JOptionPane.showMessageDialog(null, "Il codice fiscale deve essere di 16 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else
			{
				for(Corriere c : myGestore.ListaCorrieri)
				{
					if(c.getCodiceFiscale().equals(myGestore.ListaCorrieri.get(myGestore.gestioneCorriereMezzi.posizioneCorriereSelezionato).getCodiceFiscale()) && myGestore.ListaCorrieri.indexOf(c) != myGestore.gestioneCorriereMezzi.posizioneCorriereSelezionato)
					{
						JOptionPane.showMessageDialog(null, "Codice fiscale già esistente", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						allChecked = false;
					}
				}
			}
		}
		return allChecked;
	}
}