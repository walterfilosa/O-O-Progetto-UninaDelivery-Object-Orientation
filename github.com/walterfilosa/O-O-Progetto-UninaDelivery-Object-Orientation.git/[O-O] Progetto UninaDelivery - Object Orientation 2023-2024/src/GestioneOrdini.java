import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestioneOrdini extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JLabel lblTitolo;
	private JScrollPane OrdiniPane;
	private JList<String> listaOrdini;
	private DefaultListModel model;

	private GestoreApplicazione myGestore;
	private JButton btnIndietro;
	private JButton btnInfoOrdine;
	private JButton btnReport;
	public int posizioneOrdine;
	private JButton btnFiltraPer;
	private JButton btnRimuoviFiltri;
	public ArrayList<Ordine> OrdiniFiltrati;
	private JButton btnSpedizioni;
	
	public GestioneOrdini(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
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
		Logo.setBounds(10, 22, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(398, 22, 190, 50);
		contentPane.add(lblUninaDelivery);
		
		lblTitolo = new JLabel("GESTIONE SPEDIZIONI/ORDINI");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(new Color(0, 0, 0));
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblTitolo.setBounds(343, 71, 300, 40);
		contentPane.add(lblTitolo);
		
		model = new DefaultListModel<Ordine>();
		
		listaOrdini = new JList();
		listaOrdini.setBackground(new Color(216, 216, 216));
		listaOrdini.setFont(new Font("PT Sans", Font.BOLD, 18));
		listaOrdini.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnInfoOrdine.setEnabled(true);
	            	   ordineSelezionato();
	               }
	            }
	         }
	      });
		
		OrdiniPane = new JScrollPane();
		OrdiniPane.setBounds(10, 145, 730, 300);
		OrdiniPane.setViewportView(listaOrdini);
		contentPane.add(OrdiniPane);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromGestioneSpedizioniToHomePageOperatore();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnIndietro.setBounds(10, 452, 220, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnInfoOrdine = new JButton("Info ordine");
		btnInfoOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoOrdineFrame.aggiornaListaDaGestioneOrdini();
				myGestore.infoOrdineFrame.aggiornaInfoDaGestioneOrdini();
				myGestore.infoOrdineFrame.setVisible(true);
			}
		});
		btnInfoOrdine.setEnabled(false);
		btnInfoOrdine.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfoOrdine.setForeground(new Color(0, 2, 160));
		btnInfoOrdine.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnInfoOrdine.setBounds(756, 191, 220, 50);
		btnInfoOrdine.setCursor(Mano);
		contentPane.add(btnInfoOrdine);
		
		btnReport = new JButton("Report mensile");
		btnReport.setIcon(new ImageIcon("Icons/ReportMensileIcon.png"));
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromGestioneOrdiniToReportMensileFrame();
			}
		});
		btnReport.setToolTipText("Visualizza il report mensile");
		btnReport.setForeground(new Color(0, 2, 160));
		btnReport.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnReport.setBounds(756, 452, 220, 50);
		btnReport.setCursor(Mano);
		contentPane.add(btnReport);
		
		btnFiltraPer = new JButton("Filtra per...");
		btnFiltraPer.setIcon(new ImageIcon("Icons/FilterIcon.png"));
		btnFiltraPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.filtraFrame.setVisible(true);
			}
		});
		btnFiltraPer.setToolTipText("Visualizza il report mensile");
		btnFiltraPer.setForeground(new Color(0, 2, 160));
		btnFiltraPer.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnFiltraPer.setBounds(756, 252, 220, 50);
		btnFiltraPer.setCursor(Mano);
		contentPane.add(btnFiltraPer);
		
		btnRimuoviFiltri = new JButton("Rimuovi Filtri");
		btnRimuoviFiltri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiornaLista();
			}
		});
		btnRimuoviFiltri.setIcon(new ImageIcon("Icons/FilterOffIcon.png"));
		btnRimuoviFiltri.setToolTipText("Visualizza il report mensile");
		btnRimuoviFiltri.setForeground(new Color(0, 2, 160));
		btnRimuoviFiltri.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnRimuoviFiltri.setBounds(756, 313, 220, 50);
		btnRimuoviFiltri.setCursor(Mano);
		contentPane.add(btnRimuoviFiltri);
		
		btnSpedizioni = new JButton("Gestisci Spedizioni");
		btnSpedizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.gestioneSpedizioni.aggiornaInfo();
				myGestore.gestioneSpedizioni.aggiornaLista();
				myGestore.fromGestioneOrdiniToGestioneSpedizioni();
			}
		});
		btnSpedizioni.setIcon(new ImageIcon("Icons/GestioneSpedizioniIcon.png"));
		btnSpedizioni.setToolTipText("Visualizza il report mensile");
		btnSpedizioni.setForeground(new Color(0, 2, 160));
		btnSpedizioni.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnSpedizioni.setBounds(756, 42, 220, 50);
		btnSpedizioni.setCursor(Mano);
		contentPane.add(btnSpedizioni);
		
		OrdiniFiltrati = new ArrayList<Ordine>();
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Ordine o : myGestore.ListaOrdini)
			model.addElement("Ordine: #" + o.getIdOrdine());
		listaOrdini.setModel(model);
	}
	
	public void aggiornaListaDaRicerca(boolean isRicercaNomeSelected) {
		model.clear();
		OrdiniFiltrati.clear();
		if(isRicercaNomeSelected == true)
		{
			for(Ordine o : myGestore.ListaOrdini)
			{
				if(searchFunction(o))
				{
					model.addElement("Ordine: #" + o.getIdOrdine() + " | Acquirente: " + o.getAcquirente().getNome() + " " + o.getAcquirente().getCognome());
					OrdiniFiltrati.add(o);
				}
			}
			listaOrdini.setModel(model);
			
			if(model.isEmpty())
				JOptionPane.showMessageDialog(null, "Nessun ordine corrisponde ai criteri di ricerca", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			for(Ordine o : myGestore.ListaOrdini)
			{
				if(Integer.parseInt(myGestore.filtraFrame.annoDaCercare) == o.getDataAcquisto().getYear())
				{
					if(Integer.parseInt(myGestore.filtraFrame.meseDaCercare) == o.getDataAcquisto().getMonthValue())
					{	
						model.addElement("Ordine: #" + o.getIdOrdine() + " | Effettuato in data: " + o.getDataAcquisto().getDayOfMonth() + "/" + o.getDataAcquisto().getMonthValue() + "/" + o.getDataAcquisto().getYear());
						OrdiniFiltrati.add(o);
					}
				}
			}
			listaOrdini.setModel(model);
			
			if(model.isEmpty())
				JOptionPane.showMessageDialog(null, "Nessun ordine corrisponde ai criteri di ricerca", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
		}
		
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
	
	public boolean searchFunction(Ordine o) {
		boolean ordineTrovato = false;
		if((myGestore.filtraFrame.testoDaCercare.contains(o.getAcquirente().getNome()) || (myGestore.filtraFrame.testoDaCercare.contains(o.getAcquirente().getCognome()))))
			ordineTrovato = true;
		return ordineTrovato;
	}
}
