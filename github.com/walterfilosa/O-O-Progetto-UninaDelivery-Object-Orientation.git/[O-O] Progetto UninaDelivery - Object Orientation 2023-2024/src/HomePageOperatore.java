import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class HomePageOperatore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private JLabel lblUninaDelivery;
	private JLabel Logo;
	private JPanel sezioneMenu;
	private JLabel lblProfileIcon;
	private JLabel lblExitIcon;
	private JLabel lblProfilo;
	private JLabel lblEsci;
	private JPanel panelBassoSx;
	private JPanel panelAltoDx;
	private JPanel panelBassoDx;
	private JLabel lblIconGestioneProdotti;
	private JTextPane txtpnGestioneDeiMezziCorrieri;
	private JTextPane txtpnGestioneDegliOperatori;
	private JTextPane txtpnGestioneDegliOrdini;
	private JLabel lblBenvenuto;
	private Cursor Mano;
	private JPanel panelAltoSx;
	private JTextPane txtpnGestioneDeiProdotti;
	private JLabel lblIconGestioneCorrieriMezzi;
	private JLabel lblIconGestioneOperatori;
	private JLabel lblIconGestioneOrdini;
	
	public HomePageOperatore(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Mano = new Cursor(Cursor.HAND_CURSOR);
		
		
		sezioneMenu = new JPanel();
		sezioneMenu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sezioneMenu.setBackground(new Color(226, 226, 226));
		sezioneMenu.setBounds(748, 100, 102, 350);
		contentPane.add(sezioneMenu);
		sezioneMenu.setLayout(null);
		
		lblProfileIcon = new JLabel();
		lblProfileIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGestore.FromHomePageOperatoreToInfoOperatoreLoggato();
			}
		});
		lblProfileIcon.setBounds(25, 65, 50, 50);
		sezioneMenu.add(lblProfileIcon);
		lblProfileIcon.setCursor(Mano);
		lblProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfileIcon.setIcon(new ImageIcon("Icons/ProfileIcon.png"));
		
		lblProfilo = new JLabel("Profilo");
		lblProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGestore.FromHomePageOperatoreToInfoOperatoreLoggato();
			}
		});
		lblProfilo.setBounds(25, 115, 50, 16);
		sezioneMenu.add(lblProfilo);
		lblProfilo.setCursor(Mano);
		lblProfilo.setFont(new Font("PT Sans", Font.PLAIN, 15));
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblExitIcon = new JLabel();
		lblExitIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avvisoLogout();
			}
		});
		lblExitIcon.setBounds(25, 215, 50, 50);
		sezioneMenu.add(lblExitIcon);
		lblExitIcon.setCursor(Mano);
		lblExitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitIcon.setIcon(new ImageIcon("Icons/LogoutIcon.png"));
		
		lblEsci = new JLabel("Logout");
		lblEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avvisoLogout();
			}
		});
		lblEsci.setBounds(25, 265, 50, 18);
		sezioneMenu.add(lblEsci);
		lblEsci.setCursor(Mano);
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setFont(new Font("PT Sans", Font.PLAIN, 15));
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(30, 10, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setBounds(203, 30, 190, 50);
		contentPane.add(lblUninaDelivery);
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		
		panelAltoSx = new JPanel();
		panelAltoSx.setBorder(new LineBorder(new Color(0, 2, 160), 1, true));
		panelAltoSx.setBackground(new Color(226, 226, 226));
		panelAltoSx.setBounds(29, 99, 335, 175);
		contentPane.add(panelAltoSx);
		panelAltoSx.setLayout(null);
		
		
		
		lblIconGestioneProdotti = new JLabel("");
		lblIconGestioneProdotti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(myGestore.ListaProdotti.isEmpty()) {
					noProdotti();
				}
				else {
					myGestore.gestioneProdotti.aggiornaListaProdotti();
					myGestore.fromHomePageOperatoreToGestioneProdotti();
				}
			}
		});
		lblIconGestioneProdotti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconGestioneProdotti.setBounds(39, 39, 90, 90);
		lblIconGestioneProdotti.setIcon(new ImageIcon("Icons/GestioneProdotto.png"));
		lblIconGestioneProdotti.setCursor(Mano);
		panelAltoSx.add(lblIconGestioneProdotti);
		
		txtpnGestioneDeiProdotti = new JTextPane();
		txtpnGestioneDeiProdotti.setText("Gestione dei prodotti\n- Visualizza prodotti\n- Modifica prodotti\n- Aggiungi prodotti\n- Rimuovi prodotti");
		txtpnGestioneDeiProdotti.setForeground(Color.BLACK);
		txtpnGestioneDeiProdotti.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtpnGestioneDeiProdotti.setBackground(new Color(226, 226, 226));
		txtpnGestioneDeiProdotti.setEditable(false);
		txtpnGestioneDeiProdotti.setBounds(141, 34, 150, 110);
		panelAltoSx.add(txtpnGestioneDeiProdotti);
	
		panelBassoSx = new JPanel();
		panelBassoSx.setForeground(new Color(0, 0, 0));
		panelBassoSx.setBorder(new LineBorder(new Color(0, 2, 160), 1, true));
		panelBassoSx.setBackground(new Color(226, 226, 226));
		panelBassoSx.setBounds(29, 276, 335, 175);
		contentPane.add(panelBassoSx);
		panelBassoSx.setLayout(null);
		
		lblIconGestioneCorrieriMezzi = new JLabel("");
		lblIconGestioneCorrieriMezzi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGestore.gestioneCorriereMezzi.aggiornaListaCorrieri();
				myGestore.gestioneCorriereMezzi.aggiornaListaMezzi();
				myGestore.gestioneCorriereMezzi.aggiornaNomeOperatore();
				myGestore.fromHomePageOperatoreToGestioneCorrieriMezzi();
			}
		});
		lblIconGestioneCorrieriMezzi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconGestioneCorrieriMezzi.setBounds(39, 39, 90, 90);
		lblIconGestioneCorrieriMezzi.setCursor(Mano);
		lblIconGestioneCorrieriMezzi.setIcon(new ImageIcon("Icons/GestioneCorrieriMezzi.png"));
		panelBassoSx.add(lblIconGestioneCorrieriMezzi);
		
		txtpnGestioneDeiMezziCorrieri = new JTextPane();
		txtpnGestioneDeiMezziCorrieri.setText("Gestione corrieri/mezzi\r\n- Aggiungi corriere\r\n- Aggiungi mezzo\r\n- Rimuovi corriere\r\n- Rimuovi mezzo");
		txtpnGestioneDeiMezziCorrieri.setForeground(Color.BLACK);
		txtpnGestioneDeiMezziCorrieri.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtpnGestioneDeiMezziCorrieri.setEditable(false);
		txtpnGestioneDeiMezziCorrieri.setBackground(new Color(226, 226, 226));
		txtpnGestioneDeiMezziCorrieri.setBounds(145, 32, 180, 110);
		panelBassoSx.add(txtpnGestioneDeiMezziCorrieri);
		
		panelAltoDx = new JPanel();
		panelAltoDx.setBorder(new LineBorder(new Color(0, 2, 160), 1, true));
		panelAltoDx.setBackground(new Color(226, 226, 226));
		panelAltoDx.setBounds(365, 99, 335, 175);
		contentPane.add(panelAltoDx);
		panelAltoDx.setLayout(null);
		
		lblIconGestioneOrdini = new JLabel("");
		lblIconGestioneOrdini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGestore.gestioneOrdini.aggiornaLista();
				myGestore.fromHomePageOperatoreToGestioneSpedizioni();
			}
		});
		lblIconGestioneOrdini.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconGestioneOrdini.setBounds(206, 39, 90, 90);
		lblIconGestioneOrdini.setCursor(Mano);
		lblIconGestioneOrdini.setIcon(new ImageIcon("Icons/GestioneOrdini.png"));
		panelAltoDx.add(lblIconGestioneOrdini);
		
		txtpnGestioneDegliOrdini = new JTextPane();
		txtpnGestioneDegliOrdini.setText("Gestione delle spedizioni/ordini\r\n- Ricerca ordini\r\n- Report mensile\r\n- Gestisci spedizioni");
		txtpnGestioneDegliOrdini.setForeground(Color.BLACK);
		txtpnGestioneDegliOrdini.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtpnGestioneDegliOrdini.setEditable(false);
		txtpnGestioneDegliOrdini.setBackground(new Color(226, 226, 226));
		txtpnGestioneDegliOrdini.setBounds(21, 32, 180, 110);
		panelAltoDx.add(txtpnGestioneDegliOrdini);
		
		panelBassoDx = new JPanel();
		panelBassoDx.setBorder(new LineBorder(new Color(0, 2, 160), 1, true));
		panelBassoDx.setBackground(new Color(226, 226, 226));
		panelBassoDx.setBounds(365, 276, 335, 175);
		contentPane.add(panelBassoDx);
		panelBassoDx.setLayout(null);
		
		lblIconGestioneOperatori = new JLabel("");
		lblIconGestioneOperatori.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGestore.visualizzaOperatori.aggiornaLista();
				myGestore.fromHomePageOperatoreToVisualizzaOperatori();
			}
		});
		lblIconGestioneOperatori.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconGestioneOperatori.setBounds(206, 39, 90, 90);
		lblIconGestioneOperatori.setCursor(Mano);
		lblIconGestioneOperatori.setIcon(new ImageIcon("Icons/GestioneOperatori.png"));
		panelBassoDx.add(lblIconGestioneOperatori);
		
		txtpnGestioneDegliOperatori = new JTextPane();
		txtpnGestioneDegliOperatori.setText("Gestione degli operatori\r\n- Visualizza Operatori\r\n- Aggiungi Operatori");
		txtpnGestioneDegliOperatori.setForeground(Color.BLACK);
		txtpnGestioneDegliOperatori.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtpnGestioneDegliOperatori.setEditable(false);
		txtpnGestioneDegliOperatori.setBackground(new Color(226, 226, 226));
		txtpnGestioneDegliOperatori.setBounds(21, 52, 180, 70);
		panelBassoDx.add(txtpnGestioneDegliOperatori);
		
		lblBenvenuto = new JLabel();
		lblBenvenuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenvenuto.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblBenvenuto.setBounds(377, 10, 445, 70);
		lblBenvenuto.setIcon(new ImageIcon("Icons/UserIcon.png"));
		contentPane.add(lblBenvenuto);
		}
	private void avvisoLogout() {
		var yesOrNo = JOptionPane.showConfirmDialog(null, "Tornare alla schermata di login?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
		if(yesOrNo == JOptionPane.YES_OPTION) /*0 = SI */{
			myGestore.fromHomePageOperatoreToLoginOperatore();
		}
	}
	
	private void noProdotti() {
		var indietroOAggiungi = JOptionPane.showConfirmDialog(this, "Nessun prodotto registrato.\nAggiungerne uno?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
		if(indietroOAggiungi == JOptionPane.YES_OPTION) {
			myGestore.aggiungiProdotto.setVisible(true);
		}
	}
	
	public void aggiornaInfo() {
		lblBenvenuto.setText("Benvenuto, " + myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNome());
	}
}
