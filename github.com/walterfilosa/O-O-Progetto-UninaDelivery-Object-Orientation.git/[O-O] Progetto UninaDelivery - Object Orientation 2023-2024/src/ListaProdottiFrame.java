import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ListaProdottiFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JButton btnChiudi;
	private JButton btnInfo;
	private JButton btnAggiungiAlCarrello;
	private Vector data;
	private JScrollPane scrollPane;
	private JList<String> listaProdotti;
	private JLabel Logo;
	private JLabel lblSearch;
	private JPanel panelButtons;
	public int posizioneProdotto;
	private DefaultListModel model;

	private GestoreApplicazione myGestore;
	private JTextField txtGetSearch;
	
	public ListaProdottiFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 690, 413);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		model = new DefaultListModel<Prodotto>();
		
		listaProdotti = new JList<String>();
		listaProdotti.setForeground(new Color(0, 0, 0));
		listaProdotti.setFont(new Font("PT Sans", Font.BOLD, 20));
		listaProdotti.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnInfo.setEnabled(true);
	            	   btnAggiungiAlCarrello.setEnabled(true);
	               }
	            }
	         }
	      });
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 95, 410, 270);
		scrollPane.setViewportView(listaProdotti);
		contentPane.add(scrollPane);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				btnInfo.setEnabled(false);
				btnAggiungiAlCarrello.setEnabled(false);
				listaProdotti.clearSelection();
				txtGetSearch.setText("");
				myGestore.homePageUtente.aggiornaInfo();
			}
		});
		btnChiudi.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		btnChiudi.setForeground(new Color(0, 2, 160));
		btnChiudi.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnChiudi.setBounds(15, 277, 220, 49);
		btnChiudi.setCursor(Mano);
		contentPane.add(btnChiudi);
		
		btnInfo = new JButton("Info prodotto");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prodottoSelezionato();
				if(myGestore.homePageUtente.isProdottoCercato == false)
					myGestore.infoProdotto.aggiornaInfo();
				else
					myGestore.infoProdotto.aggiornaInfoDaRicerca();
				myGestore.infoProdotto.setVisible(true);
			}
		});
		btnInfo.setEnabled(false);
		btnInfo.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfo.setForeground(new Color(0, 2, 160));
		btnInfo.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnInfo.setBounds(15, 130, 220, 49);
		btnInfo.setCursor(Mano);
		contentPane.add(btnInfo);
		
		btnAggiungiAlCarrello = new JButton("Aggiungi al carrello");
		btnAggiungiAlCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < myGestore.ListaProdotti.size(); i++)
				{
					if(listaProdotti.getSelectedValue() == myGestore.ListaProdotti.get(i).getNome())
					{
						if(myGestore.ListaProdotti.get(i).getQuantitàDisponibile() > 0)
						{
							
							JOptionPane.showMessageDialog(null, "Prodotto aggiunto al carrello.", "", JOptionPane.INFORMATION_MESSAGE);
							myGestore.ListaProdotti.get(i).setQuantitàDisponibile(myGestore.ListaProdotti.get(i).getQuantitàDisponibile() - 1);
							if(myGestore.ListaProdotti.get(i).getQuantitàAlCarrello() == 0)
							{
								myGestore.ListaProdotti.get(i).setQuantitàAlCarrello(myGestore.ListaProdotti.get(i).getQuantitàAlCarrello() + 1);
								myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().add(myGestore.ListaProdotti.get(i));
							}
							else
								myGestore.ListaProdotti.get(i).setQuantitàAlCarrello(myGestore.ListaProdotti.get(i).getQuantitàAlCarrello() + 1);
							break;
						}
						else if(myGestore.ListaProdotti.get(i).getQuantitàDisponibile() == 0)
						{
							JOptionPane.showMessageDialog(null, "Prodotto esaurito", "", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
				}
			}
		});
		btnAggiungiAlCarrello.setEnabled(false);
		btnAggiungiAlCarrello.setIcon(new ImageIcon("Icons/AggiungiAlCarrelloIcon.png"));
		btnAggiungiAlCarrello.setForeground(new Color(0, 2, 160));
		btnAggiungiAlCarrello.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAggiungiAlCarrello.setBounds(15, 200, 220, 49);
		btnAggiungiAlCarrello.setCursor(Mano);
		contentPane.add(btnAggiungiAlCarrello);
		
		
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(10, 14, 161, 70);
		contentPane.add(Logo);
		
		txtGetSearch = new JTextField();
		txtGetSearch.setFont(new Font("PT Sans", Font.BOLD, 25));
		txtGetSearch.setColumns(10);
		txtGetSearch.setBounds(256, 14, 345, 50);
		txtGetSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n')
				{
					if(txtGetSearch.getText().length() < 3)
						JOptionPane.showMessageDialog(null, "Per effettuare la ricerca, immettere almeno 3 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
					else
					{
						myGestore.homePageUtente.isProdottoCercato = true;
						myGestore.homePageUtente.prodottoCercato = txtGetSearch.getText();
						listaProdottiTrovati();
					}
				}
			}
		});
		contentPane.add(txtGetSearch);
		
		lblSearch = new JLabel("");
		lblSearch.setIcon(new ImageIcon("Icons/SearchIcon.png"));
		lblSearch.setToolTipText("Cerca...");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(618, 14, 48, 48);
		lblSearch.setCursor(Mano);
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSearch.setIcon(new ImageIcon("Icons/SearchBluIcon.png"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblSearch.setIcon(new ImageIcon("Icons/SearchIcon.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtGetSearch.getText().length() < 3)
					JOptionPane.showMessageDialog(null, "Per effettuare la ricerca, immettere almeno 3 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				else
				{
					myGestore.homePageUtente.isProdottoCercato = true;
					myGestore.homePageUtente.prodottoCercato = txtGetSearch.getText();
					listaProdottiTrovati();
				}
			}
		});
		contentPane.add(lblSearch);
		
		panelButtons = new JPanel();
		panelButtons.setBackground(new Color(216, 216, 216));
		panelButtons.setBounds(10, 105, 230, 250);
		contentPane.add(panelButtons);
	}
	
	public void prodottoSelezionato(){
		for(int i = 0; i < myGestore.ListaProdotti.size(); i++)
		{
			if(listaProdotti.isSelectedIndex(i))
			{
				posizioneProdotto = i;
				break;
			}
		}
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Prodotto p : myGestore.ListaProdotti)
		{
			if(p.getQuantitàDisponibile() > 0)
				model.addElement(p.getNome());
			else
				model.addElement(p.getNome() + " --- PRODOTTO ESAURITO ---");
		}
		listaProdotti.setModel(model);
	}
	
	public void listaProdottiTrovati() {
		model.clear();
		myGestore.homePageUtente.ProdottiTrovati.clear();
		for(Prodotto p : myGestore.ListaProdotti)
		{
			if(containsIgnoreCase(p.getNome(), myGestore.homePageUtente.prodottoCercato))
			{
				if(p.getQuantitàDisponibile() > 0)
					model.addElement(p.getNome());
				else
					model.addElement(p.getNome() + " --- PRODOTTO ESAURITO ---");
				myGestore.homePageUtente.ProdottiTrovati.add(p);
			}
		}
		if(model.isEmpty())
			JOptionPane.showMessageDialog(null, "Nessun prodotto trovato", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
		else
		{
			listaProdotti.setModel(model);
			txtGetSearch.setText(myGestore.homePageUtente.prodottoCercato);
			setVisible(true);
		}
	}
	
	public static boolean containsIgnoreCase(String str, String searchStr)
	{
		if(str == null || searchStr == null)
			return false;
	
	    final int length = searchStr.length();
	    if (length == 0)
	        return true;
	
	    for (int i = str.length() - length; i >= 0; i--) {
	        if (str.regionMatches(true, i, searchStr, 0, length))
	            return true;
	    }
	    return false;
	}
}
