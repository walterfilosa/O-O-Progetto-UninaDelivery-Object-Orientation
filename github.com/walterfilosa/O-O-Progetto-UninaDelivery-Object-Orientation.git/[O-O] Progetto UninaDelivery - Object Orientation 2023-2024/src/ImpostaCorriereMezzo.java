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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ImpostaCorriereMezzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo ;
	private JLabel lblUninaDelivery;
	private JLabel lblTitolo;
	private JButton btnIndietro;

	private GestoreApplicazione myGestore;
	private JButton btnAvanti;
	private JScrollPane corrieriPane;
	private JScrollPane mezziPane;
	private JList<String> listaCorrieri;
	private JList<String> listaMezzi;
	private DefaultListModel modelCorrieri;
	private DefaultListModel modelMezzi;
	private JLabel lblListaCorrieriDisponibili;
	private JLabel lblListaMezziDisponibili;
	private JLabel lblData;
	private JButton btnData;
	public LocalDate dataSelezionata;
	public int posizioneCorriere;
	public int posizioneMezzo;
	public double pesoTotaleSpedizione;
	public ArrayList<Corriere> CorrieriDisponibili;
	public ArrayList<MezzoDiTrasporto> MezziDisponibili;
	
	public ImpostaCorriereMezzo(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		Logo.setBounds(10, 33, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(398, 33, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		lblTitolo = new JLabel("CREA SPEDIZIONE");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.BLACK);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblTitolo.setBounds(343, 73, 300, 30);
		contentPane.add(lblTitolo);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.creaSpedizioneFrame.aggiornaLista();
				myGestore.creaSpedizioneFrame.aggiornaInfo();
				setVisible(false);
				myGestore.creaSpedizioneFrame.setVisible(true);
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnIndietro.setBounds(10, 452, 220, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnAvanti = new JButton("Avanti");
		btnAvanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!btnData.getText().equals("Scegli data..."))
				{
					if(!listaCorrieri.isSelectionEmpty())
					{
						if(!listaMezzi.isSelectionEmpty())
						{
							listaCorrieri.clearSelection();
							listaMezzi.clearSelection();
							myGestore.creaSpedizioneFrame.s.setDataDiConsegna(dataSelezionata);
							myGestore.creaSpedizioneFrame.s.setPesoTotaleSpedizione(pesoTotaleSpedizione);
							myGestore.creaSpedizioneFrame.s.setCorriereAssegnato(CorrieriDisponibili.get(posizioneCorriere));
							myGestore.creaSpedizioneFrame.s.setMezzoAssegnato(MezziDisponibili.get(posizioneMezzo));
							myGestore.riepilogoSpedizioneFrame.aggiornaLista();
							myGestore.riepilogoSpedizioneFrame.aggiornaInfo();
							myGestore.fromImpostaCorriereMezzoToRiepilogoSpedizioneFrame();
						}
						else
							JOptionPane.showMessageDialog(null, "Selezionare un mezzo di trasporto", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Selezionare un corriere", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Selezionare una data per la consegna", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAvanti.setIcon(new ImageIcon("Icons/AvantiIcon.png"));
		btnAvanti.setForeground(new Color(0, 2, 160));
		btnAvanti.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnAvanti.setBounds(756, 452, 220, 50);
		btnAvanti.setCursor(Mano);
		contentPane.add(btnAvanti);
		
		modelCorrieri = new DefaultListModel<Corriere>();
		
		listaCorrieri = new JList<String>();
		listaCorrieri.setBackground(new Color(216, 216, 216));
		listaCorrieri.setFont(new Font("PT Sans", Font.BOLD, 22));
		listaCorrieri.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   corriereSelezionato();
	               }
	            }
	         }
	      });
		
		corrieriPane = new JScrollPane();
		corrieriPane.setBounds(10, 150, 480, 250);
		corrieriPane.setViewportView(listaCorrieri);
		contentPane.add(corrieriPane);
		
		modelMezzi = new DefaultListModel<MezzoDiTrasporto>();
		
		listaMezzi = new JList<String>();
		listaMezzi.setBackground(new Color(216, 216, 216));
		listaMezzi.setFont(new Font("PT Sans", Font.BOLD, 22));
		listaMezzi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   mezzoSelezionato();
	               }
	            }
	         }
	      });
		
		mezziPane = new JScrollPane();
		mezziPane.setBounds(496, 150, 480, 250);
		mezziPane.setViewportView(listaMezzi);
		contentPane.add(mezziPane);
		
		lblListaCorrieriDisponibili = new JLabel("Lista Corrieri Disponibili");
		lblListaCorrieriDisponibili.setForeground(Color.BLACK);
		lblListaCorrieriDisponibili.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblListaCorrieriDisponibili.setBackground(new Color(216, 216, 216));
		lblListaCorrieriDisponibili.setBounds(10, 114, 220, 30);
		lblListaCorrieriDisponibili.setForeground(bluLink);
		contentPane.add(lblListaCorrieriDisponibili);
		
		lblListaMezziDisponibili = new JLabel("Lista Mezzi Disponibili");
		lblListaMezziDisponibili.setHorizontalAlignment(SwingConstants.RIGHT);
		lblListaMezziDisponibili.setForeground(Color.BLACK);
		lblListaMezziDisponibili.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblListaMezziDisponibili.setBackground(new Color(216, 216, 216));
		lblListaMezziDisponibili.setBounds(756, 114, 220, 30);
		lblListaMezziDisponibili.setForeground(bluLink);
		contentPane.add(lblListaMezziDisponibili);
		
		lblData = new JLabel("Data di consegna:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setForeground(new Color(0, 2, 160));
		lblData.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblData.setBounds(290, 461, 190, 30);
		contentPane.add(lblData);
		
		btnData = new JButton("Scegli data...");
		btnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.scegliDataConsegna.setVisible(true);
			}
		});
		btnData.setForeground(new Color(0, 2, 160));
		btnData.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnData.setBounds(496, 452, 220, 50);
		btnData.setCursor(Mano);
		contentPane.add(btnData);
		
		CorrieriDisponibili = new ArrayList<Corriere>();
		MezziDisponibili = new ArrayList<MezzoDiTrasporto>();
	}
	
	public void aggiornaListaCorrieri() {
		modelCorrieri.clear();
		for(Corriere c : myGestore.ListaCorrieri)
			modelCorrieri.addElement("ID Corriere: #" + c.getID());
		listaCorrieri.setModel(modelCorrieri);
	}
	
	public void aggiornaListaMezzi() {
		modelMezzi.clear();
		for(MezzoDiTrasporto m : myGestore.ListaMezzi)
			modelMezzi.addElement(m.getTipo() + " | Targa: " + m.getTarga());
		listaMezzi.setModel(modelMezzi);
	}
	
	public void aggiornaBtn() {
		btnData.setText(dataSelezionata.getDayOfMonth() + "/" + dataSelezionata.getMonthValue() + "/" + dataSelezionata.getYear());
	}
	
	public void resetBtn() {
		btnData.setText("Scegli data...");
	}
	
	public void aggiornaListaDaData() {
		modelCorrieri.clear();
		modelMezzi.clear();
		CorrieriDisponibili.clear();
		MezziDisponibili.clear();
		boolean isImpegnato = false;
		for(Corriere c : myGestore.ListaCorrieri)
		{
			isImpegnato = false;
			for(LocalDate date : c.getGiorniDiConsegna())
			{
				if(dataSelezionata.isEqual(date))
					isImpegnato = true;
			}
			if(isImpegnato == false)
			{
				modelCorrieri.addElement("ID Corriere: #" + c.getID());
				CorrieriDisponibili.add(c);
			}
		}
		for(MezzoDiTrasporto m : myGestore.ListaMezzi)
		{
			isImpegnato = false;
			if(controlloPeso(m))
			{
				for(LocalDate date : m.getGiorniDiConsegna())
				{
					if(date.isEqual(dataSelezionata) == true)
					{
						isImpegnato = true;
						break;
					}
				}
			}
			else
				isImpegnato = true;
			if(isImpegnato == false)
			{
				modelMezzi.addElement(m.getTipo() + " | Targa: " + m.getTarga());
				MezziDisponibili.add(m);
			}
		}
		listaCorrieri.setModel(modelCorrieri);
		listaMezzi.setModel(modelMezzi);
	}
	
	public boolean controlloPeso(MezzoDiTrasporto m) {
		pesoTotaleSpedizione = 0.0;
		for(Ordine o : myGestore.creaSpedizioneFrame.s.getOrdiniNellaSpedizione())
			pesoTotaleSpedizione += o.calcolaPesoTotaleOrdine();
		if(m.getPesoMassimoTrasportabile() >= pesoTotaleSpedizione)
			return true;
		else
			return false;
	}
	
	public void corriereSelezionato(){
		for(int i = 0; i < CorrieriDisponibili.size(); i++)
		{
			if(listaCorrieri.isSelectedIndex(i))
			{
				posizioneCorriere = i;
				break;
			}
		}
	}
	
	public void mezzoSelezionato(){
		for(int i = 0; i < MezziDisponibili.size(); i++)
		{
			if(listaMezzi.isSelectedIndex(i))
			{
				posizioneMezzo = i;
				break;
			}
		}
	}
}