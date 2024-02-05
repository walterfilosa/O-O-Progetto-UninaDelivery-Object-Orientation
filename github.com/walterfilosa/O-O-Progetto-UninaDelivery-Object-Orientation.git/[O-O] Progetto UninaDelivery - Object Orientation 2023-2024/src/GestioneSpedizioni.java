import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class GestioneSpedizioni extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JButton btnIndietro;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JLabel lblTitolo;

	private GestoreApplicazione myGestore;
	private JList<String> listaSpedizioni;
	private DefaultListModel model;
	private JScrollPane listaPane;
	public int posizioneSpedizione;
	private JButton btnCreaSpedizione;
	private JButton btnInfo;
	private JLabel lblSpedizioniTotali;
	private JLabel lblNumeroSpedizioni;
	
	public GestioneSpedizioni(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 560);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromGestioneSpedizioniToGestioneOrdini();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnIndietro.setBounds(8, 456, 220, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(10, 40, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(307, 40, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		lblTitolo = new JLabel("GESTIONE SPEDIZIONI");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.BLACK);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblTitolo.setBounds(252, 89, 300, 30);
		contentPane.add(lblTitolo);
		
		model = new DefaultListModel<Spedizione>();
		
		listaSpedizioni = new JList();
		listaSpedizioni.setBackground(new Color(216, 216, 216));
		listaSpedizioni.setFont(new Font("PT Sans", Font.BOLD, 22));
		listaSpedizioni.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   spedizioneSelezionata();
	            	   btnInfo.setEnabled(true);
	               }
	            }
	         }
	      });
		
		listaPane = new JScrollPane();
		listaPane.setBounds(10, 150, 784, 295);
		listaPane.setViewportView(listaSpedizioni);
		contentPane.add(listaPane);
		
		btnCreaSpedizione = new JButton("Crea spedizione");
		btnCreaSpedizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.creaSpedizioneFrame.aggiornaInfo();
				myGestore.creaSpedizioneFrame.aggiornaLista();
				myGestore.creaSpedizioneFrame.setVisible(true);
			}
		});
		btnCreaSpedizione.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnCreaSpedizione.setForeground(new Color(0, 2, 160));
		btnCreaSpedizione.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnCreaSpedizione.setBounds(574, 456, 220, 50);
		btnCreaSpedizione.setCursor(Mano);
		contentPane.add(btnCreaSpedizione);
		
		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoSpedizione.aggiornaInfo();
				myGestore.infoSpedizione.aggiornaLista();
				myGestore.infoSpedizione.setVisible(true);
			}
		});
		btnInfo.setEnabled(false);
		btnInfo.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfo.setForeground(new Color(0, 2, 160));
		btnInfo.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnInfo.setBounds(290, 456, 220, 50);
		btnInfo.setCursor(Mano);
		contentPane.add(btnInfo);
		
		lblSpedizioniTotali = new JLabel("Spedizioni totali:");
		lblSpedizioniTotali.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpedizioniTotali.setForeground(new Color(0, 2, 160));
		lblSpedizioniTotali.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblSpedizioniTotali.setBounds(560, 81, 236, 30);
		contentPane.add(lblSpedizioniTotali);
		
		lblNumeroSpedizioni = new JLabel();
		lblNumeroSpedizioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroSpedizioni.setForeground(Color.BLACK);
		lblNumeroSpedizioni.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblNumeroSpedizioni.setBounds(696, 110, 100, 40);
		contentPane.add(lblNumeroSpedizioni);
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Spedizione s : myGestore.ListaSpedizioni)
			model.addElement("Spedizione: #" + s.getID());
		listaSpedizioni.setModel(model);
	}
	
	public void aggiornaInfo() {
		lblNumeroSpedizioni.setText(myGestore.ListaSpedizioni.size() + "");
	}
	
	public void spedizioneSelezionata(){
		for(int i = 0; i < myGestore.ListaSpedizioni.size(); i++)
		{
			if(listaSpedizioni.isSelectedIndex(i))
			{
				posizioneSpedizione = i;
				break;
			}
		}
	}
}
