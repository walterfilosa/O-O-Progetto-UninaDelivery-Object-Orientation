import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomePageUtente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private JButton btnLogout;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblLogoutIcon;
	private JLabel lblBenvenuto;
	private JLabel Logo;
	private JLabel lblUserIcon;
	private JLabel lblCarrelloIcon;
	private JTextField txtGetSearch;
	private JLabel lblSearch;
	private JLabel lblCerca;
	private JLabel lblVisualizzaProdotti;
	public String prodottoCercato;
	public ArrayList<Prodotto> ProdottiTrovati = new ArrayList<Prodotto>();
	public boolean isProdottoCercato;
	
	public HomePageUtente(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 420);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);
		
		isProdottoCercato = false;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(22, 22, 161, 70);
		contentPane.add(Logo);
		
		lblBenvenuto = new JLabel("Benvenuto, ");
		lblBenvenuto.setBackground(new Color(216, 216, 216));
		lblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenuto.setForeground(new Color(0, 2, 160));
		lblBenvenuto.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblBenvenuto.setBounds(225, 30, 385, 50);
		contentPane.add(lblBenvenuto);
		
		txtGetSearch = new JTextField();
		txtGetSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n')
				{
					if(txtGetSearch.getText().length() < 3)
						JOptionPane.showMessageDialog(null, "Per effettuare la ricerca, immettere almeno 3 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
					else
					{
						isProdottoCercato = true;
						prodottoCercato = txtGetSearch.getText();
						myGestore.listaProdottiFrame.listaProdottiTrovati();
					}
				}
			}
		});
		txtGetSearch.setFont(new Font("PT Sans", Font.BOLD, 25));
		txtGetSearch.setBounds(193, 181, 450, 50);
		contentPane.add(txtGetSearch);
		txtGetSearch.setColumns(10);
		
		lblSearch = new JLabel("");
		lblSearch.setToolTipText("Cerca...");
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
					isProdottoCercato = true;
					prodottoCercato = txtGetSearch.getText();
					myGestore.listaProdottiFrame.listaProdottiTrovati();
				}
				
			}
		});
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setIcon(new ImageIcon("Icons/SearchIcon.png"));
		lblSearch.setBounds(653, 181, 48, 48);
		lblSearch.setCursor(Mano);
		contentPane.add(lblSearch);
		
		lblCerca = new JLabel("Cerca prodotto");
		lblCerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerca.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCerca.setBounds(323, 142, 190, 30);
		contentPane.add(lblCerca);
		
		lblVisualizzaProdotti = new JLabel("Visualizza lista prodotti");
		lblVisualizzaProdotti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(myGestore.ListaProdotti.isEmpty())
					JOptionPane.showMessageDialog(null, "Nessun prodotto presente nel registro", "", JOptionPane.INFORMATION_MESSAGE);
				else
				{
					isProdottoCercato = false;
					myGestore.listaProdottiFrame.aggiornaLista();
					myGestore.listaProdottiFrame.setVisible(true);
				}
			}
		});
		lblVisualizzaProdotti.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizzaProdotti.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblVisualizzaProdotti.setBounds(268, 242, 300, 40);
		lblVisualizzaProdotti.setCursor(Mano);
		myGestore.setBluLink(lblVisualizzaProdotti);
		contentPane.add(lblVisualizzaProdotti);
		
		lblCarrelloIcon = new JLabel();
		lblCarrelloIcon.setBounds(626, 22, 60, 60);
		contentPane.add(lblCarrelloIcon);
		lblCarrelloIcon.setToolTipText("Visualizza il carrello");
		lblCarrelloIcon.setIcon(new ImageIcon("Icons/CarrelloNeroIcon.png"));
		lblCarrelloIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello().isEmpty())
					JOptionPane.showMessageDialog(null, "Il carrello è vuoto!", "ATTTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				else
				{
					myGestore.carrelloFrame.aggiornaLista();
					myGestore.carrelloFrame.aggiornaInfo();
					myGestore.fromHomePageUtenteToCheckout();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCarrelloIcon.setIcon(new ImageIcon("Icons/CarrelloIcon.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCarrelloIcon.setIcon(new ImageIcon("Icons/CarrelloNeroIcon.png"));
			}
		});
		lblCarrelloIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrelloIcon.setFont(new Font("PT Sans", Font.PLAIN, 18));
		lblCarrelloIcon.setCursor(Mano);
		
		
		lblLogoutIcon = new JLabel("");
		lblLogoutIcon.setBounds(766, 22, 60, 60);
		contentPane.add(lblLogoutIcon);
		lblLogoutIcon.setToolTipText("Esci e torna alla schermata di login");
		lblLogoutIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avvisoLogout();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogoutIcon.setIcon(new ImageIcon("Icons/LogoutBluIcon.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogoutIcon.setIcon(new ImageIcon("Icons/LogoutIcon.png"));
			}
		});
		lblLogoutIcon.setIcon(new ImageIcon("Icons/LogoutIcon.png"));
		lblLogoutIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoutIcon.setFont(new Font("PT Sans", Font.PLAIN, 18));
		lblLogoutIcon.setCursor(Mano);
		
		lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(696, 22, 60, 60);
		contentPane.add(lblUserIcon);
		lblUserIcon.setToolTipText("VIsualizza informazioni sul profilo");
		lblUserIcon.setIcon(new ImageIcon("Icons/ProfileIcon.png"));
		lblUserIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myGestore.infoUtente.aggiornaInfo();
				myGestore.infoUtente.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUserIcon.setIcon(new ImageIcon("Icons/ProfileBluIcon.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblUserIcon.setIcon(new ImageIcon("Icons/ProfileIcon.png"));
			}
		});
		lblUserIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserIcon.setFont(new Font("PT Sans", Font.PLAIN, 18));
		lblUserIcon.setCursor(Mano);
	}
	
	private void avvisoLogout() {
		var yesOrNo = JOptionPane.showConfirmDialog(null, "Tornare alla schermata di login?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
		if(yesOrNo == JOptionPane.YES_OPTION) /*0 = SI */{
			myGestore.fromHomePageUtenteToLoginUtente();
			txtGetSearch.setText("");
		}
	}
	
	public void aggiornaInfo() {
		lblBenvenuto.setText("Benvenuto, " + myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNome());
		txtGetSearch.setText(prodottoCercato);
	}
	
	private void searchFunction() {
		for(Prodotto p : myGestore.ListaProdotti)
		{
			if(txtGetSearch.getText().contains(p.getNome()))
			{
				myGestore.listaProdottiFrame.setVisible(true);
				setVisible(false);
			}
		}
	}
}
