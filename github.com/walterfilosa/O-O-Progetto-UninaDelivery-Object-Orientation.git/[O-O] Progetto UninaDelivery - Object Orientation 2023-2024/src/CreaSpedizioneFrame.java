import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class CreaSpedizioneFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JLabel lblTitolo;
	private JScrollPane listaOrdiniPane;
	private JList<String> listaOrdini;
	private DefaultListModel model;
	private JButton btnAggiungi;

	private GestoreApplicazione myGestore;
	private JButton btnRimuovi;
	private JButton btnAnnulla;
	private JButton btnAvanti;
	private JLabel lblOrdiniAggiunti;
	private JLabel lblNumeroOrdini;
	public Spedizione s;
	private int posizioneOrdine;
	private JCheckBox boxCambiaLista;
	
	public CreaSpedizioneFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);
		s = new Spedizione();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(10, 29, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(298, 29, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		lblTitolo = new JLabel("CREA SPEDIZIONE");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.BLACK);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblTitolo.setBounds(243, 69, 300, 30);
		contentPane.add(lblTitolo);
		
		model = new DefaultListModel<Ordine>();
		
		listaOrdini = new JList<String>();
		listaOrdini.setBackground(new Color(216, 216, 216));
		listaOrdini.setFont(new Font("PT Sans", Font.BOLD, 22));
		listaOrdini.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   if(boxCambiaLista.isSelected())
	            	   {
	            		   ordineSelezionato();
	            		   aggiornaLista();
	            		   btnRimuovi.setEnabled(true);
	            		   btnAggiungi.setEnabled(false);
	            	   }
	            	   else
	            	   {
	            		   ordineSelezionato();
	            		   aggiornaLista();
	            		   btnRimuovi.setEnabled(false);
	            		   btnAggiungi.setEnabled(true);
	            	   }
	            	   
	               }
	            }
	         }
	      });
		
		listaOrdiniPane = new JScrollPane();
		listaOrdiniPane.setBounds(243, 159, 533, 285);
		listaOrdiniPane.setViewportView(listaOrdini);
		contentPane.add(listaOrdiniPane);
		
		btnAggiungi = new JButton("Aggiungi ordine");
		btnAggiungi.setEnabled(false);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myGestore.ListaOrdini.get(posizioneOrdine).getDataDiConsegna() == null)
				{
					if(s.getOrdiniNellaSpedizione().isEmpty())
						s.aggiungiOrdineAllaSpedizione(myGestore.ListaOrdini.get(posizioneOrdine));
					else if(!controlloListaOrdini(myGestore.ListaOrdini.get(posizioneOrdine)))
						s.aggiungiOrdineAllaSpedizione(myGestore.ListaOrdini.get(posizioneOrdine));
					aggiornaLista();
					aggiornaInfo();
				}
				else
					JOptionPane.showMessageDialog(null, "Ordine già presente in una spedizione", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAggiungi.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnAggiungi.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnAggiungi.setBounds(13, 219, 220, 50);
		btnAggiungi.setForeground(bluLink);
		btnAggiungi.setCursor(Mano);
		contentPane.add(btnAggiungi);
		
		btnRimuovi = new JButton("Rimuovi ordine");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.rimuoviOrdineDallaSpedizione(posizioneOrdine);
				aggiornaLista();
				aggiornaInfo();
			}
		});
		btnRimuovi.setEnabled(false);
		btnRimuovi.setIcon(new ImageIcon("Icons/EliminaAccountIcon.png"));
		btnRimuovi.setForeground(new Color(255, 0, 0));
		btnRimuovi.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnRimuovi.setBounds(13, 315, 220, 50);
		btnRimuovi.setCursor(Mano);
		contentPane.add(btnRimuovi);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boxCambiaLista.setSelected(false);
				s.clearOrdiniNellaSpedizione();
				myGestore.gestioneSpedizioni.setVisible(true);
				setVisible(false);
			}
		});
		btnAnnulla.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		btnAnnulla.setForeground(new Color(0, 2, 160));
		btnAnnulla.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnAnnulla.setBounds(10, 462, 220, 50);
		btnAnnulla.setCursor(Mano);
		contentPane.add(btnAnnulla);
		
		btnAvanti = new JButton("Avanti");
		btnAvanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(s.getOrdiniNellaSpedizione().isEmpty())
					JOptionPane.showMessageDialog(null, "Nessun ordine aggiunto alla spedizione", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				else
				{
					myGestore.impostaCorriereMezzo.aggiornaListaCorrieri();
					myGestore.impostaCorriereMezzo.aggiornaListaMezzi();
					boxCambiaLista.setSelected(false);
					for(Corriere c : myGestore.ListaCorrieri)
						myGestore.impostaCorriereMezzo.CorrieriDisponibili.add(c);
					for(MezzoDiTrasporto m : myGestore.ListaMezzi)
						myGestore.impostaCorriereMezzo.MezziDisponibili.add(m);
					setVisible(false);
					myGestore.impostaCorriereMezzo.setVisible(true);
				}
			}
		});
		btnAvanti.setIcon(new ImageIcon("Icons/AvantiIcon.png"));
		btnAvanti.setForeground(new Color(0, 2, 160));
		btnAvanti.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnAvanti.setBounds(556, 462, 220, 50);
		btnAvanti.setCursor(Mano);
		contentPane.add(btnAvanti);
		
		lblOrdiniAggiunti = new JLabel("N° ordini aggiunti:");
		lblOrdiniAggiunti.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrdiniAggiunti.setForeground(new Color(0, 2, 160));
		lblOrdiniAggiunti.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblOrdiniAggiunti.setBounds(586, 86, 190, 30);
		contentPane.add(lblOrdiniAggiunti);
		
		lblNumeroOrdini = new JLabel("");
		lblNumeroOrdini.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroOrdini.setForeground(Color.BLACK);
		lblNumeroOrdini.setFont(new Font("PT Sans", Font.BOLD, 25));
		lblNumeroOrdini.setBounds(671, 118, 105, 30);
		contentPane.add(lblNumeroOrdini);
		
		boxCambiaLista = new JCheckBox("Aggiungi ordine alla spedizione");
		boxCambiaLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(boxCambiaLista.isSelected())
					boxCambiaLista.setText("Lista ordini aggiunti");
				else
					boxCambiaLista.setText("Aggiungi ordine alla spedizione");
				aggiornaLista();
			}
		});
		boxCambiaLista.setForeground(new Color(0, 0, 0));
		boxCambiaLista.setFont(new Font("PT Sans", Font.BOLD, 20));
		boxCambiaLista.setBounds(243, 125, 300, 25);
		boxCambiaLista.setForeground(bluLink);
		boxCambiaLista.setCursor(Mano);
		contentPane.add(boxCambiaLista);
	}
	
	public void aggiornaLista() {
		model.clear();
		if(!boxCambiaLista.isSelected())
		{
			for(Ordine o : myGestore.ListaOrdini)
				model.addElement("Ordine: #" + o.getIdOrdine());
		}
		else if(boxCambiaLista.isSelected())
		{
			for(Ordine o : s.getOrdiniNellaSpedizione())
				model.addElement("Ordine: #" + o.getIdOrdine());
		}
		listaOrdini.setModel(model);
	}
	
	public void aggiornaInfo() {
		if(s.getOrdiniNellaSpedizione() == null)
			lblNumeroOrdini.setText("0");
		else
			lblNumeroOrdini.setText(s.getOrdiniNellaSpedizione().size() + "");
	}
	
	public void ordineSelezionato(){
		if(boxCambiaLista.isSelected())
		{
			for(Ordine o : s.getOrdiniNellaSpedizione())
			{
				if(listaOrdini.isSelectedIndex(s.getOrdiniNellaSpedizione().indexOf(o)))
				{
					posizioneOrdine = s.getOrdiniNellaSpedizione().indexOf(o);
					break;
				}
			}
		}
		else
		{
			for(Ordine o : myGestore.ListaOrdini)
			{
				if(listaOrdini.isSelectedIndex(myGestore.ListaOrdini.indexOf(o)))
				{
					posizioneOrdine = myGestore.ListaOrdini.indexOf(o);
					break;
				}
			}
		}
	}
	
	private boolean controlloListaOrdini(Ordine o) {
		boolean isGiàAggiunto = false;
		for(Ordine ord : s.getOrdiniNellaSpedizione())
		{
			if(o.getIdOrdine().equals(ord.getIdOrdine()))
			{
				JOptionPane.showMessageDialog(null, "Ordine già aggiunto", "ATTENZIONE", JOptionPane.PLAIN_MESSAGE);
				isGiàAggiunto = true;
				break;
			}
		}
		return isGiàAggiunto;
	}
}
