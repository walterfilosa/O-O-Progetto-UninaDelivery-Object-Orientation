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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class InfoProdotto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblPrezzo;
	private JScrollPane DescrizionePane;
	private JTextArea txtGetDescrizione;
	private JButton btnAnnulla;

	private GestoreApplicazione myGestore;
	private JLabel lblNomeProdotto;
	private JLabel lblIdProdotto;
	private JLabel lblAziendaVenditrice;
	private JLabel lblPeso;
	private JLabel lblQuantita;
	private JPanel panel;
	
	public InfoProdotto(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 842, 490);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPrezzo = new JLabel();
		lblPrezzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzo.setForeground(Color.BLACK);
		lblPrezzo.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblPrezzo.setBounds(568, 392, 250, 50);
		lblPrezzo.setForeground(bluLink);
		contentPane.add(lblPrezzo);
		
		DescrizionePane = new JScrollPane();
		DescrizionePane.setBounds(10, 210, 808, 169);
		contentPane.add(DescrizionePane);
		
		txtGetDescrizione = new JTextArea();
		DescrizionePane.setViewportView(txtGetDescrizione);
		txtGetDescrizione.setWrapStyleWord(true);
		txtGetDescrizione.setLineWrap(true);
		txtGetDescrizione.setFont(new Font("PT Sans", Font.PLAIN, 20));
		txtGetDescrizione.setEnabled(true);
		txtGetDescrizione.setEditable(false);
		txtGetDescrizione.setBackground(new Color(238, 238, 238));
	
		btnAnnulla = new JButton("Indietro");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnulla.setToolTipText("Annulla Modiche");
		btnAnnulla.setForeground(new Color(0, 2, 160));
		btnAnnulla.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnAnnulla.setBounds(10, 395, 115, 40);
		btnAnnulla.setCursor(Mano);
		contentPane.add(btnAnnulla);
		
		panel = new JPanel();
		panel.setBackground(new Color(216, 216, 216));
		panel.setBounds(10, 25, 808, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNomeProdotto = new JLabel();
		lblNomeProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProdotto.setForeground(new Color(0, 2, 160));
		lblNomeProdotto.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblNomeProdotto.setBounds(0, 0, 808, 50);
		panel.add(lblNomeProdotto);
		
		lblIdProdotto = new JLabel();
		lblIdProdotto.setForeground(Color.BLACK);
		lblIdProdotto.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblIdProdotto.setBounds(0, 62, 403, 50);
		panel.add(lblIdProdotto);
		
		lblAziendaVenditrice = new JLabel();
		lblAziendaVenditrice.setForeground(Color.BLACK);
		lblAziendaVenditrice.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblAziendaVenditrice.setBounds(0, 124, 808, 50);
		panel.add(lblAziendaVenditrice);
		
		lblPeso = new JLabel();
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setForeground(Color.BLACK);
		lblPeso.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblPeso.setBounds(350, 62, 248, 50);
		panel.add(lblPeso);
		
		lblQuantita = new JLabel();
		lblQuantita.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantita.setForeground(Color.BLACK);
		lblQuantita.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblQuantita.setBounds(620, 62, 184, 50);
		panel.add(lblQuantita);
		
		
	}
	
	public void aggiornaInfo()
	{
		lblNomeProdotto.setText("Prodotto: " + myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getNome());
		lblIdProdotto.setText("ID prodotto: " + myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getIdProdotto());
		lblAziendaVenditrice.setText("Fornito da: " + myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getAziendaVenditrice());
		lblPeso.setText("Peso: " + myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getPeso() + " kg");
		aggiornaPrezzo();
		lblQuantita.setText("Quantità: " + myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getQuantitàDisponibile());
		txtGetDescrizione.setText(myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getDescrizione());
	}
	
	public void aggiornaInfoDaRicerca() {
		lblNomeProdotto.setText("Prodotto: " + myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getNome());
		lblIdProdotto.setText("ID prodotto: " + myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getIdProdotto());
		lblAziendaVenditrice.setText("Fornito da: " + myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getAziendaVenditrice());
		lblPeso.setText("Peso: " + myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getPeso() + " kg");
		aggiornaPrezzoDaRicerca();
		lblQuantita.setText("Quantità: " + myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getQuantitàDisponibile());
		txtGetDescrizione.setText(myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getDescrizione());
	}
	
	public void aggiornaPrezzo() {
		double risultato = 0.0;
		DecimalFormat df = new DecimalFormat("0.00");
		risultato = myGestore.ListaProdotti.get(myGestore.listaProdottiFrame.posizioneProdotto).getPrezzo();
		String str = new String(df.format(risultato) + " €");
		lblPrezzo.setText("Prezzo: " + str);
	}
	
	public void aggiornaPrezzoDaRicerca() {
		double risultato = 0.0;
		DecimalFormat df = new DecimalFormat("0.00");
		risultato = myGestore.homePageUtente.ProdottiTrovati.get(myGestore.listaProdottiFrame.posizioneProdotto).getPrezzo();
		String str = new String(df.format(risultato) + " €");
		lblPrezzo.setText("Prezzo: " + str);
	}
	
	
}
