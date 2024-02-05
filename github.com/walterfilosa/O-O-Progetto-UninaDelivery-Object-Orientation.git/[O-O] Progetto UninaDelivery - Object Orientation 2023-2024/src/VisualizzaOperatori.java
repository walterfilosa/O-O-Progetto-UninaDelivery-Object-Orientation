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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class VisualizzaOperatori extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblUninaDelivery;
	private JLabel Logo;
	private JScrollPane scrollPane;
	private JList<String> listaOperatori;
	private JLabel lblTitolo;
	private JButton btnIndietro;
	private JButton btnInfo;
	private JButton btnAggiungi;
	private DefaultListModel model;
	public int posizioneOperatore;

	private GestoreApplicazione myGestore;
	
	public VisualizzaOperatori(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 465);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(380, 20, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(184, 20, 161, 70);
		contentPane.add(Logo);
		
		model = new DefaultListModel<Operatore>();
		
		listaOperatori = new JList();
		listaOperatori.setBackground(new Color(216, 216, 216));
		listaOperatori.setFont(new Font("PT Sans", Font.BOLD, 18));
		listaOperatori.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnInfo.setEnabled(true);
	            	   operatoreSelezionato();
	               }
	            }
	         }
	      });
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 766, 256);
		scrollPane.setViewportView(listaOperatori);
		contentPane.add(scrollPane);
		
		lblTitolo = new JLabel("LISTA OPERATORI");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(new Color(0, 0, 0));
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 25));
		lblTitolo.setBounds(355, 57, 240, 30);
		contentPane.add(lblTitolo);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromVisualizzaOperatoriToHomePageOperatore();
			}
		});
		btnIndietro.setToolTipText("Annulla Modiche");
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnIndietro.setBounds(10, 382, 250, 40);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoOperatore.aggiornaInfo();
				myGestore.infoOperatore.setVisible(true);
			}
		});
		btnInfo.setEnabled(false);
		btnInfo.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfo.setToolTipText("Annulla Modiche");
		btnInfo.setForeground(new Color(0, 2, 160));
		btnInfo.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnInfo.setBounds(268, 382, 250, 40);
		btnInfo.setCursor(Mano);
		contentPane.add(btnInfo);
		
		btnAggiungi = new JButton("Aggiungi Operatore");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.aggiungiOperatore.setVisible(true);
			}
		});
		btnAggiungi.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnAggiungi.setToolTipText("Annulla Modiche");
		btnAggiungi.setForeground(new Color(0, 2, 160));
		btnAggiungi.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnAggiungi.setBounds(526, 382, 250, 40);
		btnAggiungi.setCursor(Mano);
		contentPane.add(btnAggiungi);
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Operatore o : myGestore.ListaOperatori)
			model.addElement(o.getNome() + " " + o.getCognome() + " | Telefono: " + o.getNumeroDiTelefono() + " | Email: " + o.getEmail());
		listaOperatori.setModel(model);
	}
	
	public void operatoreSelezionato(){
		for(int i = 0; i < myGestore.ListaOperatori.size(); i++)
		{
			if(listaOperatori.isSelectedIndex(i))
			{
				posizioneOperatore = i;
				break;
			}
		}
	}
}
