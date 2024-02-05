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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoUtente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;

	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetIndirizzo;
	private JTextField txtGetCognome;
	private JTextField txtGetCodiceFiscale;
	private JTextField txtGetTelefono;
	private JTextField txtGetEmail;
	private JPanel panel;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblTelefono;
	private JLabel lblCodiceFiscale;
	private JLabel lblIndirizzo;
	private JLabel lblEmail;
	private JButton chiudiButton;
	private JButton modificaButton;
	private JButton rimuoviAccountButton;
	private JButton btnStorico;
	private JButton btnPortfolio;
	
	public InfoUtente(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 380);
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
		panel.setBounds(10, 74, 720, 195);
		contentPane.add(panel);
		
		lblNome = new JLabel("Nome:");
		lblNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNome.setBounds(34, 21, 130, 30);
		panel.add(lblNome);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTelefono.setBounds(368, 80, 80, 30);
		panel.add(lblTelefono);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Nome operatore");
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetNome.setEditable(false);
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(156, 22, 200, 35);
		panel.add(txtGetNome);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCognome.setBounds(368, 21, 95, 30);
		panel.add(lblCognome);
		
		lblCodiceFiscale = new JLabel("Codice Fiscale:");
		lblCodiceFiscale.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCodiceFiscale.setBounds(34, 80, 130, 30);
		panel.add(lblCodiceFiscale);
		
		lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIndirizzo.setHorizontalAlignment(SwingConstants.LEFT);
		lblIndirizzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblIndirizzo.setBounds(34, 140, 80, 30);
		panel.add(lblIndirizzo);
		
		txtGetIndirizzo = new JTextField();
		txtGetIndirizzo.setToolTipText("Email operatore");
		txtGetIndirizzo.setForeground(new Color(0, 2, 160));
		txtGetIndirizzo.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetIndirizzo.setEditable(false);
		txtGetIndirizzo.setColumns(10);
		txtGetIndirizzo.setBounds(156, 141, 200, 35);
		panel.add(txtGetIndirizzo);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setToolTipText("Cognome operatore");
		txtGetCognome.setForeground(new Color(0, 2, 160));
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCognome.setEditable(false);
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(463, 21, 200, 35);
		panel.add(txtGetCognome);
		
		txtGetCodiceFiscale = new JTextField();
		txtGetCodiceFiscale.setToolTipText("Codice Fiscale operatore");
		txtGetCodiceFiscale.setForeground(new Color(0, 2, 160));
		txtGetCodiceFiscale.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetCodiceFiscale.setEditable(false);
		txtGetCodiceFiscale.setColumns(10);
		txtGetCodiceFiscale.setBounds(156, 81, 200, 35);
		panel.add(txtGetCodiceFiscale);
		
		txtGetTelefono = new JTextField();
		txtGetTelefono.setToolTipText("Numero telefono operatore");
		txtGetTelefono.setForeground(new Color(0, 2, 160));
		txtGetTelefono.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetTelefono.setEditable(false);
		txtGetTelefono.setColumns(10);
		txtGetTelefono.setBounds(463, 81, 200, 35);
		panel.add(txtGetTelefono);
		
		txtGetEmail = new JTextField();
		txtGetEmail.setToolTipText("Email operatore");
		txtGetEmail.setForeground(new Color(0, 2, 160));
		txtGetEmail.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetEmail.setEditable(false);
		txtGetEmail.setColumns(10);
		txtGetEmail.setBounds(463, 140, 200, 35);
		panel.add(txtGetEmail);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblEmail.setBounds(368, 140, 50, 30);
		panel.add(lblEmail);
		
		chiudiButton = new JButton("Chiudi");
		chiudiButton.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		chiudiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				myGestore.homePageUtente.setVisible(true);
			}
		});
		chiudiButton.setForeground(new Color(0, 2, 160));
		chiudiButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		chiudiButton.setBounds(10, 292, 170, 40);
		chiudiButton.setCursor(Mano);
		contentPane.add(chiudiButton);
		
		modificaButton = new JButton("Modifica");
		modificaButton.setIcon(new ImageIcon("Icons/ModificaIcon.png"));
		modificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				myGestore.modificaUtenteFrame.aggiornaInfo();
				myGestore.modificaUtenteFrame.setVisible(true);
			}
		});
		modificaButton.setForeground(new Color(0, 2, 160));
		modificaButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		modificaButton.setBounds(283, 292, 170, 40);
		modificaButton.setCursor(Mano);
		contentPane.add(modificaButton);
		
		rimuoviAccountButton = new JButton("Elimina account");
		rimuoviAccountButton.setIcon(new ImageIcon("Icons/EliminaAccountIcon.png"));
		rimuoviAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var yesOrNo = JOptionPane.showConfirmDialog(null, "Rimuovere account?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
				if(yesOrNo == JOptionPane.YES_OPTION){
					for(Prodotto p : myGestore.ListaProdotti)
					{
						for(Prodotto q : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
						{
							if(p.getNome().equals(q.getNome()))
								p.setQuantitàDisponibile(p.getQuantitàDisponibile() + q.getQuantitàAlCarrello());
						}
					}
					
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().clear();
					myGestore.ListaUtenti.remove(myGestore.loginUtente.posizioneUtente);
					myGestore.fromHomePageUtenteToLoginUtente();
					JOptionPane.showMessageDialog(null, "Account rimosso con successo!", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		rimuoviAccountButton.setForeground(Color.RED);
		rimuoviAccountButton.setFont(new Font("PT Sans", Font.BOLD, 15));
		rimuoviAccountButton.setBounds(560, 292, 170, 40);
		rimuoviAccountButton.setCursor(Mano);
		contentPane.add(rimuoviAccountButton);
		
		btnStorico = new JButton("Visualizza storico ordini");
		btnStorico.setIcon(new ImageIcon("Icons/ListIcon.png"));
		btnStorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini().isEmpty())
					JOptionPane.showMessageDialog(null, "Nessun ordine registrato", "", JOptionPane.INFORMATION_MESSAGE);
				else
				{
					myGestore.storicoOrdiniFrame.aggiornaLista();
					myGestore.storicoOrdiniFrame.setVisible(true);
				}
			}
		});
		btnStorico.setForeground(new Color(0, 2, 160));
		btnStorico.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnStorico.setBounds(10, 15, 230, 40);
		btnStorico.setCursor(Mano);
		contentPane.add(btnStorico);
		
		btnPortfolio = new JButton("Portfolio");
		btnPortfolio.setIcon(new ImageIcon("Icons/CartaDiCreditoBluIcon.png"));
		btnPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta() == null)
				{
					var yesOrNo = JOptionPane.showConfirmDialog(null, "Nessuna carta collegata all'account.\nRegistrarne una?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
					if(yesOrNo == JOptionPane.YES_OPTION)
					{
						myGestore.aggiungiCartaFrame.aggiornaInfo();
						myGestore.aggiungiCartaFrame.setVisible(true);
						setVisible(false);
					}
				}
				else
				{
					myGestore.portfolioFrame.aggiornaInfo();
					myGestore.portfolioFrame.setVisible(true);
				}
			}
		});
		btnPortfolio.setForeground(new Color(0, 2, 160));
		btnPortfolio.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnPortfolio.setBounds(496, 15, 230, 40);
		btnPortfolio.setCursor(Mano);
		contentPane.add(btnPortfolio);
	}
	
	public void aggiornaInfo() {
		txtGetNome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNome());
		txtGetCognome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCognome());
		txtGetCodiceFiscale.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCodiceFiscale());
		txtGetTelefono.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNumeroDiTelefono());
		txtGetIndirizzo.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getIndirizzoDiResidenza());
		txtGetEmail.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getEmail());
	}
}
