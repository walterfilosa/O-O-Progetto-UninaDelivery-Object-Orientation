import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReportMensileFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JLabel lblTitolo;
	private Cursor Mano;
	private Color bluLink;

	private GestoreApplicazione myGestore;
	private JButton btnIndietro;
	private JScrollPane listaOrdiniPane;
	private JList<String> listaOrdini;
	private DefaultListModel model;
	private JButton btnInfoOrdine;
	private JButton btnCerca;
	private JTextField txtGetMese;
	private JTextField txtGetAnno;
	private JPanel statistichePanel;
	private JLabel lblMedia;
	private JLabel lblOrdineConPiùProdotti;
	private JLabel lblOrdineConMenoProdotti;
	private JLabel lblValoreMedia;
	private JLabel lblValoreOrdineConPiùProdotti;
	private JLabel lblValoreOrdineConMenoProdotti;
	private JLabel lblMese;
	private JLabel lblAnno;
	public ArrayList<Ordine> OrdiniFiltrati;
	public int posizioneOrdine;
	private DecimalFormat df;
	
	public ReportMensileFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(10, 27, 161, 70);
		contentPane.add(Logo);

		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(181, 27, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		lblTitolo = new JLabel("REPORT MENSILE");
		lblTitolo.setForeground(Color.BLACK);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblTitolo.setBounds(181, 60, 170, 30);
		contentPane.add(lblTitolo);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromReportMensileFrameToGestioneOrdini();
				txtGetMese.setText("");
				txtGetMese.setText("");
				lblValoreMedia.setText("");
				lblValoreOrdineConMenoProdotti.setText("");
				lblValoreOrdineConPiùProdotti.setText("");
				btnInfoOrdine.setEnabled(false);
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnIndietro.setBounds(10, 402, 220, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		model = new DefaultListModel<Ordine>();
		
		listaOrdini = new JList();
		listaOrdini.setBackground(new Color(216, 216, 216));
		listaOrdini.setFont(new Font("PT Sans", Font.BOLD, 22));
		listaOrdini.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   ordineSelezionato();
	            	   btnInfoOrdine.setEnabled(true);
	               }
	            }
	         }
	      });
		
		listaOrdiniPane = new JScrollPane();
		listaOrdiniPane.setBounds(10, 130, 500, 250);
		listaOrdiniPane.setViewportView(listaOrdini);
		contentPane.add(listaOrdiniPane);
		
		btnInfoOrdine = new JButton("Info ordine");
		btnInfoOrdine.setEnabled(false);
		btnInfoOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoOrdineFrame.aggiornaInfoDaReportMensile();
				myGestore.infoOrdineFrame.aggiornaListaDaReportMensile();
				myGestore.infoOrdineFrame.setVisible(true);
			}
		});
		btnInfoOrdine.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfoOrdine.setForeground(new Color(0, 2, 160));
		btnInfoOrdine.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnInfoOrdine.setBounds(606, 402, 220, 50);
		btnInfoOrdine.setCursor(Mano);
		contentPane.add(btnInfoOrdine);
		
		btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlliRicercaPerData())
				{
					aggiornaListaDaRicerca();
					aggiornaInfo();
					btnInfoOrdine.setEnabled(false);
				}	
			}
		});
		btnCerca.setIcon(new ImageIcon("Icons/SearchIcon24px.png"));
		btnCerca.setForeground(new Color(0, 2, 160));
		btnCerca.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnCerca.setBounds(521, 60, 305, 50);
		btnCerca.setCursor(Mano);
		contentPane.add(btnCerca);
		
		lblMese = new JLabel("Mese:");
		lblMese.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblMese.setBounds(521, 16, 55, 30);
		contentPane.add(lblMese);
		
		txtGetMese = new JTextField();
		txtGetMese.setForeground(new Color(0, 2, 160));
		txtGetMese.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetMese.setColumns(10);
		txtGetMese.setBounds(576, 11, 85, 40);
		contentPane.add(txtGetMese);
		
		lblAnno = new JLabel("Anno:");
		lblAnno.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblAnno.setBounds(666, 16, 55, 30);
		contentPane.add(lblAnno);
		
		txtGetAnno = new JTextField();
		txtGetAnno.setForeground(new Color(0, 2, 160));
		txtGetAnno.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetAnno.setColumns(10);
		txtGetAnno.setBounds(721, 11, 105, 40);
		contentPane.add(txtGetAnno);
		
		statistichePanel = new JPanel();
		statistichePanel.setBackground(new Color(255, 255, 255));
		statistichePanel.setBounds(520, 130, 306, 250);
		contentPane.add(statistichePanel);
		statistichePanel.setLayout(null);
		
		lblMedia = new JLabel("Media ordini:");
		lblMedia.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedia.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblMedia.setBounds(4, 30, 297, 30);
		lblMedia.setForeground(bluLink);
		statistichePanel.add(lblMedia);
		
		lblOrdineConPiùProdotti = new JLabel("Ordine con più prodotti:");
		lblOrdineConPiùProdotti.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdineConPiùProdotti.setForeground(new Color(0, 2, 160));
		lblOrdineConPiùProdotti.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblOrdineConPiùProdotti.setBounds(4, 100, 297, 30);
		statistichePanel.add(lblOrdineConPiùProdotti);
		
		lblOrdineConMenoProdotti = new JLabel("Ordine con meno prodotti:");
		lblOrdineConMenoProdotti.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdineConMenoProdotti.setForeground(new Color(0, 2, 160));
		lblOrdineConMenoProdotti.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblOrdineConMenoProdotti.setBounds(4, 170, 297, 30);
		statistichePanel.add(lblOrdineConMenoProdotti);
		
		lblValoreMedia = new JLabel("");
		lblValoreMedia.setHorizontalAlignment(SwingConstants.CENTER);
		lblValoreMedia.setForeground(new Color(0, 0, 0));
		lblValoreMedia.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblValoreMedia.setBounds(4, 65, 297, 30);
		statistichePanel.add(lblValoreMedia);
		
		lblValoreOrdineConPiùProdotti = new JLabel("");
		lblValoreOrdineConPiùProdotti.setHorizontalAlignment(SwingConstants.CENTER);
		lblValoreOrdineConPiùProdotti.setForeground(Color.BLACK);
		lblValoreOrdineConPiùProdotti.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblValoreOrdineConPiùProdotti.setBounds(4, 135, 297, 30);
		statistichePanel.add(lblValoreOrdineConPiùProdotti);
		
		lblValoreOrdineConMenoProdotti = new JLabel("");
		lblValoreOrdineConMenoProdotti.setHorizontalAlignment(SwingConstants.CENTER);
		lblValoreOrdineConMenoProdotti.setForeground(Color.BLACK);
		lblValoreOrdineConMenoProdotti.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblValoreOrdineConMenoProdotti.setBounds(4, 205, 297, 30);
		statistichePanel.add(lblValoreOrdineConMenoProdotti);
	}
	
	public void aggiornaInfo() {
		int minimo = 0;
		int massimo = 0;
		int posizioneOrdineConPiùProdotti = 0;
		int posizioneOrdineConMenoProdotti = 0;
		int somma = 0;
		for(Ordine o : OrdiniFiltrati)
		{
			somma = 0;
			if(OrdiniFiltrati.indexOf(o) == 0)
			{
				for(Prodotto p : OrdiniFiltrati.get(OrdiniFiltrati.indexOf(o)).getProdottiAcquisti())
					somma += p.getQuantitàAcquistata();
				minimo = somma;
				massimo = somma;
				posizioneOrdineConPiùProdotti = OrdiniFiltrati.indexOf(o);
				posizioneOrdineConMenoProdotti = OrdiniFiltrati.indexOf(o);
			}
			else
			{
				for(Prodotto p : OrdiniFiltrati.get(OrdiniFiltrati.indexOf(o)).getProdottiAcquisti())
					somma += p.getQuantitàAcquistata();
				
				if(somma > massimo)
				{
					massimo = somma;
					posizioneOrdineConPiùProdotti = OrdiniFiltrati.indexOf(o);
				}
				else if(somma < minimo)
				{
					minimo = somma;
					posizioneOrdineConMenoProdotti = OrdiniFiltrati.indexOf(o);
				}
			}
		}
		lblValoreOrdineConPiùProdotti.setText("Ordine: #" + OrdiniFiltrati.get(posizioneOrdineConPiùProdotti).getIdOrdine() + " | " + OrdiniFiltrati.get(posizioneOrdineConPiùProdotti).getDataAcquisto().getDayOfMonth() + "/" + OrdiniFiltrati.get(posizioneOrdineConPiùProdotti).getDataAcquisto().getMonthValue() + "/" + OrdiniFiltrati.get(posizioneOrdineConPiùProdotti).getDataAcquisto().getYear());
		lblValoreOrdineConMenoProdotti.setText("Ordine: #" + OrdiniFiltrati.get(posizioneOrdineConMenoProdotti).getIdOrdine() + " | " + OrdiniFiltrati.get(posizioneOrdineConMenoProdotti).getDataAcquisto().getDayOfMonth() + "/" + OrdiniFiltrati.get(posizioneOrdineConMenoProdotti).getDataAcquisto().getMonthValue() + "/" + OrdiniFiltrati.get(posizioneOrdineConMenoProdotti).getDataAcquisto().getYear());
		
		df = new DecimalFormat("0.00");
		double media = (double)(OrdiniFiltrati.size()) / 30;
		String str = new String(df.format(media) + "");
		lblValoreMedia.setText(str + " ordine/i al giorno");
	}
	
	public void aggiornaListaDaRicerca() {
		model.clear();
		OrdiniFiltrati = new ArrayList<Ordine>();
		OrdiniFiltrati.clear();
		for(Ordine o : myGestore.ListaOrdini)
		{
			if(Integer.parseInt(txtGetAnno.getText()) == o.getDataAcquisto().getYear())
			{
				if(Integer.parseInt(txtGetMese.getText()) == o.getDataAcquisto().getMonthValue())
				{
					model.addElement("Ordine: #" + o.getIdOrdine() + " | Effettuato in data: " + o.getDataAcquisto().getDayOfMonth() + "/" + o.getDataAcquisto().getMonthValue() + "/" + o.getDataAcquisto().getYear());
					OrdiniFiltrati.add(o);
				}
			}
		}
		listaOrdini.setModel(model);
		
		if(model.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Nessun ordine corrisponde ai criteri di ricerca", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
			lblValoreMedia.setText("");
			lblValoreOrdineConMenoProdotti.setText("");
			lblValoreOrdineConPiùProdotti.setText("");
		}
	}
	
	private boolean controlliRicercaPerData() {
		boolean allChecked = true;
		if(allChecked == true)
		{
			if(!isNumeric(txtGetAnno.getText()) || !isNumeric(txtGetMese.getText()))
			{
				JOptionPane.showMessageDialog(null, "La data può contenere solo cifre", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((txtGetMese.getText().length() > 2 || txtGetAnno.getText().length() != 4) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((txtGetMese.getText().equals("0") || txtGetMese.getText().equals("00")) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((Integer.valueOf(txtGetAnno.getText()) > LocalDate.now().getYear() || (Integer.valueOf(txtGetAnno.getText()) == LocalDate.now().getYear() && Integer.valueOf(txtGetMese.getText()) > LocalDate.now().getMonthValue())) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi", "ERRORE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		return allChecked;
	}
	
	public static boolean isNumeric(String str) {
		  ParsePosition pos = new ParsePosition(0);
		  NumberFormat.getInstance().parse(str, pos);
		  return str.length() == pos.getIndex();
		}
	
	public void ordineSelezionato(){
		for(int i = 0; i < myGestore.ListaOrdini.size(); i++)
		{
			if(listaOrdini.isSelectedIndex(i))
			{
				posizioneOrdine = i;
				break;
			}
		}
	}
}
