import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class InfoOrdineFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel Logo;
	private JLabel lblRiepilogoOrdine;

	private GestoreApplicazione myGestore;
	private JScrollPane scrollPane;
	private JLabel lblOrdine;
	private JLabel lblArticoliPresentiNellordine;
	private JList<String> listaProdotti;
	private JTextField txtGetAcquirente;
	private JLabel lblNome;
	private JLabel lblMetodo;
	private JLabel lblMetodoDiPagamento;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblDatiSpedizione;
	private JLabel lblCorriere;
	private JLabel lblDataPrevistaDi;
	private JButton btnIndietro;
	private JLabel lblPrezzoTotale;
	private JLabel lblPrezzoSpedizione;
	private DefaultListModel model;
	private JLabel lblDataDiAcquisto;
	
	public InfoOrdineFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Unina Delivery");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 2, 160));
		lblTitle.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblTitle.setBackground(new Color(216, 216, 216));
		lblTitle.setBounds(293, 27, 200, 50);
		contentPane.add(lblTitle);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(10, 34, 161, 70);
		contentPane.add(Logo);
		
		lblRiepilogoOrdine = new JLabel("RIEPILOGO ORDINE");
		lblRiepilogoOrdine.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiepilogoOrdine.setForeground(Color.BLACK);
		lblRiepilogoOrdine.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblRiepilogoOrdine.setBackground(new Color(216, 216, 216));
		lblRiepilogoOrdine.setBounds(293, 80, 200, 30);
		contentPane.add(lblRiepilogoOrdine);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 766, 150);
		contentPane.add(scrollPane);
		
		model = new DefaultListModel<Prodotto>();
		
		listaProdotti = new JList<String>();
		listaProdotti.setBackground(new Color(216, 216, 216));
		listaProdotti.setFont(new Font("PT Sans", Font.BOLD, 18));
		scrollPane.setViewportView(listaProdotti);
		
		lblOrdine = new JLabel("");
		lblOrdine.setForeground(new Color(0, 2, 160));
		lblOrdine.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblOrdine.setBackground(new Color(216, 216, 216));
		lblOrdine.setBounds(10, 145, 300, 30);
		contentPane.add(lblOrdine);
		
		lblArticoliPresentiNellordine = new JLabel("Articoli presenti nell'ordine:");
		lblArticoliPresentiNellordine.setForeground(Color.BLACK);
		lblArticoliPresentiNellordine.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblArticoliPresentiNellordine.setBackground(new Color(216, 216, 216));
		lblArticoliPresentiNellordine.setBounds(10, 182, 250, 30);
		contentPane.add(lblArticoliPresentiNellordine);
		
		txtGetAcquirente = new JTextField();
		txtGetAcquirente.setEditable(false);
		txtGetAcquirente.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetAcquirente.setBounds(496, 144, 280, 35);
		contentPane.add(txtGetAcquirente);
		txtGetAcquirente.setColumns(10);
		
		lblNome = new JLabel("Acquirente:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(new Color(0, 2, 160));
		lblNome.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblNome.setBackground(new Color(216, 216, 216));
		lblNome.setBounds(285, 146, 200, 30);
		contentPane.add(lblNome);
		
		lblMetodo = new JLabel("Metodo di pagamento selezionato:");
		lblMetodo.setForeground(Color.BLACK);
		lblMetodo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblMetodo.setBackground(new Color(216, 216, 216));
		lblMetodo.setBounds(10, 382, 300, 30);
		contentPane.add(lblMetodo);
		
		lblMetodoDiPagamento = new JLabel();
		lblMetodoDiPagamento.setForeground(Color.BLACK);
		lblMetodoDiPagamento.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblMetodoDiPagamento.setBackground(new Color(216, 216, 216));
		lblMetodoDiPagamento.setBounds(320, 384, 456, 30);
		lblMetodoDiPagamento.setForeground(bluLink);
		contentPane.add(lblMetodoDiPagamento);
		
		lblDatiSpedizione = new JLabel("DATI SPEDIZIONE");
		lblDatiSpedizione.setForeground(Color.BLACK);
		lblDatiSpedizione.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblDatiSpedizione.setBackground(new Color(216, 216, 216));
		lblDatiSpedizione.setBounds(10, 423, 300, 30);
		lblDatiSpedizione.setForeground(bluLink);
		contentPane.add(lblDatiSpedizione);
		
		lblCorriere = new JLabel();
		lblCorriere.setForeground(Color.BLACK);
		lblCorriere.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCorriere.setBackground(new Color(216, 216, 216));
		lblCorriere.setBounds(10, 450, 334, 30);
		contentPane.add(lblCorriere);
		
		lblDataPrevistaDi = new JLabel();
		lblDataPrevistaDi.setForeground(Color.BLACK);
		lblDataPrevistaDi.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblDataPrevistaDi.setBackground(new Color(216, 216, 216));
		lblDataPrevistaDi.setBounds(376, 450, 400, 30);
		contentPane.add(lblDataPrevistaDi);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setBounds(576, 512, 200, 40);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		lblPrezzoTotale = new JLabel("TOTALE:");
		lblPrezzoTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzoTotale.setForeground(new Color(0, 2, 160));
		lblPrezzoTotale.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblPrezzoTotale.setBounds(559, 27, 217, 40);
		contentPane.add(lblPrezzoTotale);
		
		lblPrezzoSpedizione = new JLabel("di cui € 5,00 di spedizione");
		lblPrezzoSpedizione.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzoSpedizione.setForeground(Color.BLACK);
		lblPrezzoSpedizione.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblPrezzoSpedizione.setBounds(559, 60, 217, 40);
		contentPane.add(lblPrezzoSpedizione);
		
		lblDataDiAcquisto = new JLabel();
		lblDataDiAcquisto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDiAcquisto.setForeground(Color.BLACK);
		lblDataDiAcquisto.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblDataDiAcquisto.setBackground(new Color(216, 216, 216));
		lblDataDiAcquisto.setBounds(476, 182, 300, 30);
		contentPane.add(lblDataDiAcquisto);
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini().get(myGestore.storicoOrdiniFrame.posizioneOrdine).getProdottiAcquisti())
		{
			model.addElement("" + p.getNome() + "     |     Quantità: " + p.getQuantitàAcquistata());
		}
		listaProdotti.setModel(model);
	}
	
	public void aggiornaListaDaGestioneOrdini() {
		model.clear();
		for(Prodotto p : myGestore.ListaOrdini.get(myGestore.gestioneOrdini.posizioneOrdine).getProdottiAcquisti())
		{
			model.addElement("" + p.getNome() + "     |     Quantità: " + p.getQuantitàAcquistata());
		}
		listaProdotti.setModel(model);
	}
	
	public void aggiornaListaDaReportMensile() {
		model.clear();
		for(Prodotto p : myGestore.reportMensileFrame.OrdiniFiltrati.get(myGestore.reportMensileFrame.posizioneOrdine).getProdottiAcquisti())
		{
			model.addElement("" + p.getNome() + "     |     Quantità: " + p.getQuantitàAcquistata());
		}
		listaProdotti.setModel(model);
	}
	
	public void aggiornaInfo() {
		for(Ordine o: myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini())
		{
			if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini().indexOf(o) == myGestore.storicoOrdiniFrame.posizioneOrdine)
			{
				lblOrdine.setText("Ordine: #" + o.getIdOrdine());
				if(o.getCorriereAssegnato() == null)
					lblCorriere.setText("CORRIERE: NON ANCORA ASSEGNATO");
				else
					lblCorriere.setText("Corriere: #" + o.getCorriereAssegnato().getID());
				lblDataDiAcquisto.setText("Data di acquisto: " + o.getDataAcquisto().getDayOfMonth() + "/" + o.getDataAcquisto().getMonthValue() + "/" + o.getDataAcquisto().getYear());
				if(o.getDataDiConsegna() == null)
					lblDataPrevistaDi.setText("DATA DI CONSEGNA NON DISPONIBILE");
				else
					lblDataPrevistaDi.setText("Data di consegna prevista: " + o.getDataDiConsegna().getDayOfMonth() + "/" + o.getDataDiConsegna().getMonthValue() + "/" + o.getDataDiConsegna().getYear());
				if(o.getMetodoPagamento() == null)
					lblMetodoDiPagamento.setText("Pagamento alla consegna");
				else
					lblMetodoDiPagamento.setText("Pagamento con carta n. " + mostraUltimeCifre(o));
				txtGetAcquirente.setText(o.getAcquirente().getNome() + " " + o.getAcquirente().getCognome());
				aggiornaTotale(o);
			}
		}
	}
	
	public void aggiornaInfoDaGestioneOrdini() {
		for(Ordine o: myGestore.ListaOrdini)
		{
			if(myGestore.ListaOrdini.indexOf(o) == myGestore.gestioneOrdini.posizioneOrdine)
			{
				lblOrdine.setText("Ordine: #" + o.getIdOrdine());
				if(o.getCorriereAssegnato() == null)
					lblCorriere.setText("CORRIERE: NON ANCORA ASSEGNATO");
				else
					lblCorriere.setText("Corriere: #" + o.getCorriereAssegnato().getID());
				lblDataDiAcquisto.setText("Data di acquisto: " + o.getDataAcquisto().getDayOfMonth() + "/" + o.getDataAcquisto().getMonthValue() + "/" + o.getDataAcquisto().getYear());
				if(o.getDataDiConsegna() == null)
					lblDataPrevistaDi.setText("DATA DI CONSEGNA NON DISPONIBILE");
				else
					lblDataPrevistaDi.setText("Data di consegna prevista: " + o.getDataDiConsegna().getDayOfMonth() + "/" + o.getDataDiConsegna().getMonthValue() + "/" + o.getDataDiConsegna().getYear());
				if(o.getMetodoPagamento() == null)
					lblMetodoDiPagamento.setText("Pagamento alla consegna");
				else
					lblMetodoDiPagamento.setText("Pagamento con carta n. " + mostraUltimeCifre(o));
				txtGetAcquirente.setText(o.getAcquirente().getNome() + " " + o.getAcquirente().getCognome());
				aggiornaTotale(o);
			}
		}
	}
	
	public void aggiornaInfoDaReportMensile() {
		for(Ordine o: myGestore.reportMensileFrame.OrdiniFiltrati)
		{
			if(myGestore.reportMensileFrame.OrdiniFiltrati.indexOf(o) == myGestore.reportMensileFrame.posizioneOrdine)
			{
				lblOrdine.setText("Ordine: #" + o.getIdOrdine());
				if(o.getCorriereAssegnato() == null)
					lblCorriere.setText("CORRIERE: NON ANCORA ASSEGNATO");
				else
					lblCorriere.setText("Corriere: #" + o.getCorriereAssegnato().getID());
				lblDataDiAcquisto.setText("Data di acquisto: " + o.getDataAcquisto().getDayOfMonth() + "/" + o.getDataAcquisto().getMonthValue() + "/" + o.getDataAcquisto().getYear());
				if(o.getDataDiConsegna() == null)
					lblDataPrevistaDi.setText("DATA DI CONSEGNA NON DISPONIBILE");
				else
					lblDataPrevistaDi.setText("Data di consegna prevista: " + o.getDataDiConsegna().getDayOfMonth() + "/" + o.getDataDiConsegna().getMonthValue() + "/" + o.getDataDiConsegna().getYear());
				if(o.getMetodoPagamento() == null)
					lblMetodoDiPagamento.setText("Pagamento alla consegna");
				else
					lblMetodoDiPagamento.setText("Pagamento con carta n. " + mostraUltimeCifre(o));
				txtGetAcquirente.setText(o.getAcquirente().getNome() + " " + o.getAcquirente().getCognome());
				aggiornaTotale(o);
			}
		}
	}
	
	private String mostraUltimeCifre(Ordine o) {
		char[] numeroCarta = o.getMetodoPagamento().getNumeroCarta().toCharArray();
		String str = new String("**** **** **** " + numeroCarta[12] + numeroCarta[13] + numeroCarta[14] + numeroCarta[15]);
		return str;
	}
	
	public void aggiornaTotale(Ordine o) {
		double risultato = 0.0;
		DecimalFormat df = new DecimalFormat("0.00");
		risultato += (o.getPrezzoTotale());
		String str = new String(df.format(risultato) + " €");
		lblPrezzoTotale.setText("TOTALE: " + str);
	}
	
	

}
