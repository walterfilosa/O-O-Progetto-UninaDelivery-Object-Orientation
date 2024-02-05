import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestioneProdotti extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JButton btnIndietro;
	private JButton btnAggiungiProdotto;
	private JButton btnInfo;
	private JButton btnModifica;
	private JButton btnElimina;
	private DefaultListModel model;
	private JList<String> listaProdotti;
	private JScrollPane scrollPane;
	public int posizioneProdotto;
	

	@SuppressWarnings("unchecked")
	public GestioneProdotti(GestoreApplicazione ga) {
		setResizable(false);
		setFont(new Font("PT Sans", Font.BOLD, 15));
		setTitle("Gestione Prodotti");
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 555);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0,2,160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Logo = new JLabel("");
		Logo.setBounds(18, 15, 161, 70);
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setBounds(191, 35, 190, 50);
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		contentPane.add(lblUninaDelivery);
		
		model = new DefaultListModel<Prodotto>();
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromGestioneProdottiToHomePageOperatore();
				btnInfo.setEnabled(false);
         	   	btnModifica.setEnabled(false);
         	   	btnElimina.setEnabled(false);
         	   	listaProdotti.clearSelection();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setBounds(18, 457, 215, 49);
		contentPane.add(btnIndietro);
		btnIndietro.setCursor(Mano);
		
		btnAggiungiProdotto = new JButton("Aggiungi Prodotto");
		btnAggiungiProdotto.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnAggiungiProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.aggiungiProdotto.setVisible(true);
				btnInfo.setEnabled(false);
         	   	btnModifica.setEnabled(false);
         	   	btnElimina.setEnabled(false);
         	   	listaProdotti.clearSelection();
			}
		});
		btnAggiungiProdotto.setCursor(Mano);
		btnAggiungiProdotto.setForeground(new Color(0, 2, 160));
		btnAggiungiProdotto.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAggiungiProdotto.setBounds(661, 457, 215, 49);
		contentPane.add(btnAggiungiProdotto);
		
		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoProdottoInOperatore.aggiornaInfo();
				myGestore.infoProdottoInOperatore.setVisible(true);
			}
		});
		btnInfo.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfo.setEnabled(false);
		btnInfo.setToolTipText("Visualizza informazioni sul prodotto");
		btnInfo.setForeground(new Color(0, 20, 160));
		btnInfo.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnInfo.setBounds(466, 55, 130, 40);
		btnInfo.setCursor(Mano);
		contentPane.add(btnInfo);
		
		btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.modificaProdottoFrame.aggiornaInfo();
				myGestore.modificaProdottoFrame.setVisible(true);
			}
		});
		btnModifica.setIcon(new ImageIcon("Icons/ModificaIcon.png"));
		btnModifica.setEnabled(false);
		btnModifica.setToolTipText("Visualizza informazioni sul prodotto");
		btnModifica.setForeground(new Color(0, 20, 160));
		btnModifica.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnModifica.setBounds(606, 55, 130, 40);
		btnModifica.setCursor(Mano);
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var yesOrNo = JOptionPane.showConfirmDialog(null, "Eliminare il prodotto?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
				if(yesOrNo == 0)
				{
					myGestore.ListaProdotti.remove(posizioneProdotto);
					aggiornaListaProdotti();
					JOptionPane.showMessageDialog(null, "Prodotto rimosso con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnElimina.setIcon(new ImageIcon("Icons/EliminaAccountIcon.png"));
		btnElimina.setEnabled(false);
		btnElimina.setToolTipText("Visualizza informazioni sul prodotto");
		btnElimina.setForeground(new Color(255, 0, 0));
		btnElimina.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnElimina.setBounds(746, 55, 130, 40);
		btnElimina.setCursor(Mano);
		contentPane.add(btnElimina);
		
		listaProdotti = new JList<String>();
		listaProdotti.setBackground(new Color(216, 216, 216));
		listaProdotti.setFont(new Font("PT Sans", Font.BOLD, 24));
		listaProdotti.setForeground(Color.black);
		listaProdotti.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnInfo.setEnabled(true);
	            	   btnModifica.setEnabled(true);
	            	   btnElimina.setEnabled(true);
	            	   prodottoSelezionato();
	               }
	            }
	         }
	      });
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 116, 858, 330);
		scrollPane.setViewportView(listaProdotti);
		contentPane.add(scrollPane);
	}
	
	public void aggiornaListaProdotti()
	{
		model.clear();
		for(Prodotto p : myGestore.ListaProdotti)
			model.addElement(p.getNome() + "     |     ID #" + p.getIdProdotto());
		listaProdotti.setModel(model);
	}
	
	private void prodottoSelezionato() {
		for(int i = 0; i < myGestore.ListaProdotti.size(); i++)
		{
			if(listaProdotti.isSelectedIndex(i))
			{
				posizioneProdotto = i;
				break;
			}
		}
	}
}
