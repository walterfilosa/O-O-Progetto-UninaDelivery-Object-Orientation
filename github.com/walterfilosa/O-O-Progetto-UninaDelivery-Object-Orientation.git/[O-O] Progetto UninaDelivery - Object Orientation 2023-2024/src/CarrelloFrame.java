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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.text.DecimalFormat;

public class CarrelloFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblTitle;
	private JScrollPane scrollPane;
	private DefaultListModel model;

	private GestoreApplicazione myGestore;
	private JButton btnIndietro;
	private JButton btnAcquistaOra;
	private JButton btnPiu;
	private JLabel lblRiepilogoCarrello;
	private JButton btnMeno;
	private JButton btnRimuovi;
	private JLabel lblTotale;
	private JLabel lblPrezzoTotale;
	private JLabel Logo;
	private JList<String> listaProdotti;
	private JLabel lblTestoQuantità;
	private JLabel lblQuantità;
	
	public CarrelloFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 570);
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
		lblTitle.setBounds(318, 26, 200, 50);
		contentPane.add(lblTitle);
		
		model = new DefaultListModel<Prodotto>();
		listaProdotti = new JList<String>();
		listaProdotti.setBackground(new Color(216, 216, 216));
		listaProdotti.setFont(new Font("PT Sans", Font.BOLD, 18));
		
		listaProdotti.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnMeno.setEnabled(true);
	            	   btnPiu.setEnabled(true);
	            	   btnRimuovi.setEnabled(true);
	            	   lblQuantità.setEnabled(true);
	            	   for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
	            	   {
	            		   if(p.getNome().equals(listaProdotti.getSelectedValue()))
	            		   {
	            			   String numero = new String(p.getQuantitàAlCarrello() + "");
	            			   lblQuantità.setText(numero);
	            			   break;
	            		   }
	            	   }
	               }
	            }
	         }
	      });
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 600, 316);
		scrollPane.setViewportView(listaProdotti);
		contentPane.add(scrollPane);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromCheckoutToHomePageUtente();
				listaProdotti.clearSelection();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setCursor(Mano);
		btnIndietro.setBounds(10, 480, 200, 40);
		contentPane.add(btnIndietro);
		
		btnAcquistaOra = new JButton("ACQUISTA ORA");
		btnAcquistaOra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Carrello vuoto!", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
					myGestore.homePageUtente.setVisible(true);
					setVisible(false);
				}
				else
				{
					myGestore.checkout.aggiornaInfo();
					myGestore.fromCarrelloFrameToCheckout();
					listaProdotti.clearSelection();
				}
					
			}
		});
		btnAcquistaOra.setToolTipText("Procedi con il checkout");
		btnAcquistaOra.setForeground(new Color(0, 2, 160));
		btnAcquistaOra.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAcquistaOra.setCursor(Mano);
		btnAcquistaOra.setIcon(new ImageIcon("Icons/AcquistaOra.png"));
		btnAcquistaOra.setBounds(626, 480, 200, 40);
		contentPane.add(btnAcquistaOra);
		
		lblRiepilogoCarrello = new JLabel("RIEPILOGO CARRELLO");
		lblRiepilogoCarrello.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiepilogoCarrello.setForeground(new Color(0, 0, 0));
		lblRiepilogoCarrello.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblRiepilogoCarrello.setBackground(new Color(216, 216, 216));
		lblRiepilogoCarrello.setBounds(318, 79, 200, 30);
		contentPane.add(lblRiepilogoCarrello);
		
		btnMeno = new JButton("1");
		btnMeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
				{
					
					if(p.getNome().equals(listaProdotti.getSelectedValue()))
					{
						p.setQuantitàAlCarrello(p.getQuantitàAlCarrello() - 1);
						p.setQuantitàDisponibile(p.getQuantitàDisponibile() + 1);
						
						if(p.getQuantitàAlCarrello() == 0)
							myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().remove(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().indexOf(p));
						break;
					}
						
				}
				aggiornaLista();
				aggiornaInfo();
				setVisible(false);
				setVisible(true);
			}
		});
		btnMeno.setEnabled(false);
		btnMeno.setIcon(new ImageIcon("Icons/RemoveIcon.png"));
		btnMeno.setForeground(new Color(0, 2, 160));
		btnMeno.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnMeno.setBounds(620, 263, 98, 49);
		btnMeno.setCursor(Mano);
		contentPane.add(btnMeno);
		
		btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
				{
					
					if(p.getNome().equals(listaProdotti.getSelectedValue()))
					{
						p.setQuantitàDisponibile(p.getQuantitàDisponibile() + p.getQuantitàAlCarrello());
						p.setQuantitàAlCarrello(0);
						myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().remove(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().indexOf(p));
						break;
					}
						
				}
				aggiornaLista();
				aggiornaInfo();
				setVisible(false);
				setVisible(true);
			}
		});
		btnRimuovi.setEnabled(false);
		btnRimuovi.setToolTipText("Rimuovi elemento dal carrello");
		btnRimuovi.setIcon(new ImageIcon("Icons/EliminaAccountIcon.png"));
		btnRimuovi.setForeground(new Color(255, 0, 0));
		btnRimuovi.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnRimuovi.setCursor(Mano);
		btnRimuovi.setBounds(620, 323, 210, 49);
		contentPane.add(btnRimuovi);
		
		btnPiu = new JButton("1");
		btnPiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
				{
					
					if(p.getNome().equals(listaProdotti.getSelectedValue()))
					{
						if(p.getQuantitàDisponibile() > 0)
						{
							p.setQuantitàDisponibile(p.getQuantitàDisponibile() - 1);
							p.setQuantitàAlCarrello(p.getQuantitàAlCarrello() + 1);
							break;
						}
						else
							JOptionPane.showMessageDialog(null, "Limite quantità acquistabile raggiunto!", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
						
					}	
				}
				aggiornaLista();
				aggiornaInfo();
				setVisible(false);
				setVisible(true);
			}
		});
		btnPiu.setEnabled(false);
		btnPiu.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnPiu.setForeground(new Color(0, 2, 160));
		btnPiu.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnPiu.setBounds(728, 263, 98, 49);
		btnPiu.setCursor(Mano);
		contentPane.add(btnPiu);
		
		lblTotale = new JLabel("TOTALE:");
		lblTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotale.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblTotale.setBounds(609, 33, 217, 40);
		lblTotale.setForeground(bluLink);
		contentPane.add(lblTotale);
		
		lblPrezzoTotale = new JLabel();
		lblPrezzoTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzoTotale.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblPrezzoTotale.setBounds(594, 69, 232, 40);
		contentPane.add(lblPrezzoTotale);
		
		Logo = new JLabel("");
		Logo.setBounds(10, 33, 161, 70);
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		contentPane.add(Logo);
		
		lblTestoQuantità = new JLabel("Quantità:");
		lblTestoQuantità.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestoQuantità.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblTestoQuantità.setBounds(620, 163, 210, 30);
		lblTestoQuantità.setForeground(bluLink);
		contentPane.add(lblTestoQuantità);
		
		lblQuantità = new JLabel();
		lblQuantità.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantità.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblQuantità.setBounds(673, 203, 100, 49);
		lblQuantità.setForeground(bluLink);
		contentPane.add(lblQuantità);
	}
	
	public void aggiornaLista() {
		if(!myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().isEmpty())
		{
			model.clear();
			if(model.size() != myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().size())
			{
				for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
				{
					String str = new String(p.getNome());
					model.addElement(str);
				}
				listaProdotti.setModel(model);
			}
		}
	}
	
	public void aggiornaInfo() {
		double risultato = 0.0;
		DecimalFormat df = new DecimalFormat("0.00");
		for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
			risultato += (p.getPrezzo() * p.getQuantitàAlCarrello());
		String str = new String(df.format(risultato) + " €");
		lblPrezzoTotale.setText(str);
	}
}
