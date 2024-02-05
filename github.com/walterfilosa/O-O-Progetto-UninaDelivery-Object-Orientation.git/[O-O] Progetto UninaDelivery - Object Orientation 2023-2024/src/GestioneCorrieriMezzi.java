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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class GestioneCorrieriMezzi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblNomeOperatore;
	private JLabel lblUninaDelivery;
	private JLabel Logo;
	private JLabel lblGestioneCorrieriE;
	private	JButton btnIndietro;

	private GestoreApplicazione myGestore;
	private JScrollPane CorrieriPane;
	private JScrollPane MezziPane;
	private JList<String> listaCorrieri;
	private JList<String> listaMezzi;
	private JButton btnInfoCorriere;
	private JButton btnRimuoviCorriere;
	private JButton btnModificaCorriere;
	private JButton btnAggiungiCorriere;
	private JButton btnInfoMezzo;
	private JButton btnModificaMezzo;
	private JButton btnAggiungiMezzo;
	private JButton btnRimuoviMezzo;
	private DefaultListModel modelCorriere;
	private DefaultListModel modelMezzo;
	public int posizioneCorriereSelezionato;
	public int posizioneMezzoSelezionato;
	private JLabel lblCorrieri;
	private JLabel lblMezzi;
	
	public GestioneCorrieriMezzi(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
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
		lblUninaDelivery.setBounds(448, 22, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Icons/Logo.png"));
		Logo.setBounds(10, 22, 161, 70);
		contentPane.add(Logo);
		
		lblGestioneCorrieriE = new JLabel("GESTIONE CORRIERI E MEZZI");
		lblGestioneCorrieriE.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneCorrieriE.setForeground(Color.BLACK);
		lblGestioneCorrieriE.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblGestioneCorrieriE.setBackground(new Color(216, 216, 216));
		lblGestioneCorrieriE.setBounds(418, 63, 250, 30);
		contentPane.add(lblGestioneCorrieriE);
		
		lblNomeOperatore = new JLabel();
		lblNomeOperatore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeOperatore.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblNomeOperatore.setBounds(573, 22, 503, 70);
		contentPane.add(lblNomeOperatore);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromGestioneCorrieriMezziToHomePageOperatore();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setBounds(10, 553, 215, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		modelCorriere = new DefaultListModel<Corriere>();
		
		listaCorrieri = new JList<String>();
		listaCorrieri.setBackground(new Color(216, 216, 216));
		listaCorrieri.setFont(new Font("PT Sans", Font.BOLD, 20));
		listaCorrieri.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnInfoCorriere.setEnabled(true);
	            	   btnModificaCorriere.setEnabled(true);
	            	   btnRimuoviCorriere.setEnabled(true);
	            	   corriereSelezionato();
	               }
	            }
	         }
	      });
		
		CorrieriPane = new JScrollPane();
		CorrieriPane.setBounds(10, 152, 530, 300);
		CorrieriPane.setViewportView(listaCorrieri);
		contentPane.add(CorrieriPane);
		
		modelMezzo = new DefaultListModel<MezzoDiTrasporto>();
		
		listaMezzi = new JList<String>();
		listaMezzi.setBackground(new Color(216, 216, 216));
		listaMezzi.setFont(new Font("PT Sans", Font.BOLD, 20));
		listaMezzi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
	               JList target = (JList)me.getSource();
	               int index = target.locationToIndex(me.getPoint());
	               if (index >= 0)
	               {
	            	   btnInfoMezzo.setEnabled(true);
	            	   btnModificaMezzo.setEnabled(true);
	            	   btnRimuoviMezzo.setEnabled(true);
	            	   mezzoSelezionato();
	               }
	            }
	         }
	      });
	
		MezziPane = new JScrollPane();
		MezziPane.setBounds(546, 152, 530, 300);
		MezziPane.setViewportView(listaMezzi);
		contentPane.add(MezziPane);
		
		btnInfoCorriere = new JButton("Info");
		btnInfoCorriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoCorriere.aggiornaInfo();
				myGestore.infoCorriere.setVisible(true);
			}
		});
		btnInfoCorriere.setEnabled(false);
		btnInfoCorriere.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfoCorriere.setForeground(new Color(0, 2, 160));
		btnInfoCorriere.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnInfoCorriere.setBounds(10, 463, 150, 40);
		btnInfoCorriere.setCursor(Mano);
		contentPane.add(btnInfoCorriere);
		
		btnRimuoviCorriere = new JButton("Rimuovi");
		btnRimuoviCorriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var yesOrNo = JOptionPane.showConfirmDialog(null, "Rimuovere il corriere selezionato?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
				if(yesOrNo == 0)
				{
					for(Corriere c : myGestore.ListaCorrieri)
					{
						if(listaCorrieri.getSelectedValue().equals(c.getNome() + " " + c.getCognome()))
						{
							myGestore.ListaCorrieri.remove(c);
							break;
						}
					}
					aggiornaListaCorrieri();
					JOptionPane.showMessageDialog(null, "Corriere rimosso con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnRimuoviCorriere.setEnabled(false);
		btnRimuoviCorriere.setIcon(new ImageIcon("Icons/EliminaAccountIcon.png"));
		btnRimuoviCorriere.setForeground(new Color(255, 0, 0));
		btnRimuoviCorriere.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnRimuoviCorriere.setBounds(390, 463, 150, 40);
		btnRimuoviCorriere.setCursor(Mano);
		contentPane.add(btnRimuoviCorriere);
		
		btnModificaCorriere = new JButton("Modifica");
		btnModificaCorriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.modificaCorriere.aggiornaInfo();
				myGestore.modificaCorriere.setVisible(true);
			}
		});
		btnModificaCorriere.setEnabled(false);
		btnModificaCorriere.setIcon(new ImageIcon("Icons/ModificaIcon.png"));
		btnModificaCorriere.setForeground(new Color(0, 2, 160));
		btnModificaCorriere.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnModificaCorriere.setBounds(200, 463, 150, 40);
		btnModificaCorriere.setCursor(Mano);
		contentPane.add(btnModificaCorriere);
		
		btnAggiungiCorriere = new JButton("Aggiungi Corriere");
		btnAggiungiCorriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.aggiungiCorriere.aggiornaInfo();
				myGestore.aggiungiCorriere.setVisible(true);
			}
		});
		btnAggiungiCorriere.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnAggiungiCorriere.setForeground(new Color(0, 2, 160));
		btnAggiungiCorriere.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAggiungiCorriere.setBounds(617, 553, 215, 50);
		btnAggiungiCorriere.setCursor(Mano);
		contentPane.add(btnAggiungiCorriere);
		
		btnInfoMezzo = new JButton("Info");
		btnInfoMezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.infoMezzo.aggiornaInfo();
				myGestore.infoMezzo.setVisible(true);
			}
		});
		btnInfoMezzo.setEnabled(false);
		btnInfoMezzo.setIcon(new ImageIcon("Icons/InfoIcon.png"));
		btnInfoMezzo.setForeground(new Color(0, 2, 160));
		btnInfoMezzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnInfoMezzo.setBounds(546, 463, 150, 40);
		btnInfoMezzo.setCursor(Mano);
		contentPane.add(btnInfoMezzo);
		
		btnModificaMezzo = new JButton("Modifica");
		btnModificaMezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.modificaMezzo.aggiornaInfo();
				myGestore.modificaMezzo.setVisible(true);
			}
		});
		btnModificaMezzo.setEnabled(false);
		btnModificaMezzo.setIcon(new ImageIcon("Icons/ModificaIcon.png"));
		btnModificaMezzo.setForeground(new Color(0, 2, 160));
		btnModificaMezzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnModificaMezzo.setBounds(736, 463, 150, 40);
		btnModificaMezzo.setCursor(Mano);
		contentPane.add(btnModificaMezzo);
		
		btnAggiungiMezzo = new JButton("Aggiungi Mezzo");
		btnAggiungiMezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.aggiungiMezzo.aggiornaInfo();
				myGestore.aggiungiMezzo.setVisible(true);
			}
		});
		btnAggiungiMezzo.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnAggiungiMezzo.setForeground(new Color(0, 2, 160));
		btnAggiungiMezzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAggiungiMezzo.setBounds(861, 553, 215, 50);
		btnAggiungiMezzo.setCursor(Mano);
		contentPane.add(btnAggiungiMezzo);
		
		btnRimuoviMezzo = new JButton("Rimuovi");
		btnRimuoviMezzo.setEnabled(false);
		btnRimuoviMezzo.setIcon(new ImageIcon("Icons/EliminaAccountIcon.png"));
		btnRimuoviMezzo.setForeground(new Color(255, 0, 0));
		btnRimuoviMezzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnRimuoviMezzo.setBounds(926, 463, 150, 40);
		btnRimuoviMezzo.setCursor(Mano);
		btnRimuoviMezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var yesOrNo = JOptionPane.showConfirmDialog(null, "Rimuovere il mezzo di trasporto selezionato?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
				if(yesOrNo == 0)
				{
					for(MezzoDiTrasporto m : myGestore.ListaMezzi)
					{
						if(listaMezzi.getSelectedValue().equals(m.getTipo() + " | Targa: " + m.getTarga()))
						{
							myGestore.ListaMezzi.remove(m);
							break;
						}
					}
					aggiornaListaMezzi();
					JOptionPane.showMessageDialog(null, "Mezzo di trasporto rimosso con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		contentPane.add(btnRimuoviMezzo);
		
		lblCorrieri = new JLabel("Lista Corrieri");
		lblCorrieri.setForeground(Color.BLACK);
		lblCorrieri.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblCorrieri.setBackground(new Color(216, 216, 216));
		lblCorrieri.setBounds(10, 111, 130, 30);
		lblCorrieri.setForeground(bluLink);
		contentPane.add(lblCorrieri);
		
		lblMezzi = new JLabel("Lista Mezzi");
		lblMezzi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMezzi.setForeground(Color.BLACK);
		lblMezzi.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblMezzi.setBackground(new Color(216, 216, 216));
		lblMezzi.setBounds(946, 111, 130, 30);
		lblMezzi.setForeground(bluLink);
		contentPane.add(lblMezzi);
	}
	
	public void aggiornaNomeOperatore() {
		lblNomeOperatore.setText("Operatore: " + myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getNome() + " " + myGestore.ListaOperatori.get(myGestore.operatoreLoginFrame.posizioneOperatore).getCognome());
	}
	
	public void aggiornaListaCorrieri() {
		modelCorriere.clear();
		for(Corriere c : myGestore.ListaCorrieri)
			modelCorriere.addElement(c.getNome() + " " + c.getCognome());
		listaCorrieri.setModel(modelCorriere);
	}
	
	public void aggiornaListaMezzi() {
		modelMezzo.clear();
		for(MezzoDiTrasporto m : myGestore.ListaMezzi)
			modelMezzo.addElement(m.getTipo()+ " | Targa: " + m.getTarga());
		listaMezzi.setModel(modelMezzo);
	}
	
	private void corriereSelezionato() {
		for(int i = 0; i < myGestore.ListaCorrieri.size(); i++)
		{
			if(listaCorrieri.isSelectedIndex(i))
			{
				posizioneCorriereSelezionato = i;
				break;
			}
		}
	}
	
	private void mezzoSelezionato() {
		for(int i = 0; i < myGestore.ListaMezzi.size(); i++)
		{
			if(listaMezzi.isSelectedIndex(i))
			{
				posizioneMezzoSelezionato = i;
				break;
			}
		}
	}
}
