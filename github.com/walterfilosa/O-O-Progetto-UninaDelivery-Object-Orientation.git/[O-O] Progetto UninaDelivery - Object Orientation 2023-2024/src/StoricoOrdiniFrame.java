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

public class StoricoOrdiniFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo;
	private JLabel lblStoricoOrdini; 
	private JScrollPane scrollPane;
	private JList<String> listaOrdini;
	private JButton btnIndietro;
	private JButton btnInfoOrdine;
	private DefaultListModel model;
	public int posizioneOrdine;

	private GestoreApplicazione myGestore;
	
	public StoricoOrdiniFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		Logo.setBounds(10, 21, 161, 70);
		contentPane.add(Logo);
		
		lblStoricoOrdini = new JLabel("Storico ordini");
		lblStoricoOrdini.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoricoOrdini.setForeground(new Color(0, 2, 160));
		lblStoricoOrdini.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblStoricoOrdini.setBackground(new Color(216, 216, 216));
		lblStoricoOrdini.setBounds(225, 21, 385, 50);
		contentPane.add(lblStoricoOrdini);
		
		
		
		model = new DefaultListModel<Ordine>();
		
		listaOrdini = new JList<String>();
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
	            	   for(Ordine o : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini())
	            	   {
	            		   if(o.getIdOrdine().equals(listaOrdini.getSelectedValue()))
	            		   {
	            			   
	            			   break;
	            		   }
	            	   }
	               }
	            }
	         }
	      });
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 816, 250);
		scrollPane.setViewportView(listaOrdini);
		contentPane.add(scrollPane);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInfoOrdine.setEnabled(false);
				setVisible(false);
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setBounds(10, 412, 200, 40);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnInfoOrdine = new JButton("Info ordine");
		btnInfoOrdine.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfoOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prodottoSelezionato();
				myGestore.infoOrdineFrame.aggiornaLista();
				myGestore.infoOrdineFrame.aggiornaInfo();
				myGestore.infoOrdineFrame.setVisible(true);
			}
		});
		btnInfoOrdine.setEnabled(false);
		btnInfoOrdine.setToolTipText("Visualizza informazioni sull'ordine");
		btnInfoOrdine.setForeground(new Color(0, 2, 160));
		btnInfoOrdine.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnInfoOrdine.setBounds(626, 412, 200, 40);
		btnInfoOrdine.setCursor(Mano);
		contentPane.add(btnInfoOrdine);
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Ordine o : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini())
			model.addElement("Ordine: #" + o.getIdOrdine() + "     |     Effettuato in data: " + o.getDataAcquisto().getDayOfMonth() + "/" + o.getDataAcquisto().getMonthValue() + "/" + o.getDataAcquisto().getYear());
		listaOrdini.setModel(model);
	}
	
	public void prodottoSelezionato(){
		for(int i = 0; i < myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getStoricoOrdini().size(); i++)
		{
			if(listaOrdini.isSelectedIndex(i))
			{
				posizioneOrdine = i;
				break;
			}
		}
	}
}
