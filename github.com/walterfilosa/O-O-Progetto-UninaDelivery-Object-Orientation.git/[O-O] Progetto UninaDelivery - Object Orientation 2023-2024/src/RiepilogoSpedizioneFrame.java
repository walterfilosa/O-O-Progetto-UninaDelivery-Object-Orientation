import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RiepilogoSpedizioneFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JLabel lblRiepilogoSpedizione;
	private JButton btnRegistra;
	private JButton btnIndietro;
	private JScrollPane listaOrdiniPane;
	private JList<String> listaOrdini;
	private DefaultListModel model;

	private GestoreApplicazione myGestore;
	private JLabel lblDataDiConsegna;
	private JLabel lblCorriereAssegnato;
	private JLabel lblMezzoAssegnato;
	private JLabel lblPesoSpedizione;
	
	public RiepilogoSpedizioneFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 500);
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
		Logo.setBounds(10, 25, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("UninaDelivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBounds(265, 25, 190, 30);
		contentPane.add(lblUninaDelivery);
		
		lblRiepilogoSpedizione = new JLabel("RIEPILOGO SPEDIZIONE");
		lblRiepilogoSpedizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiepilogoSpedizione.setForeground(Color.BLACK);
		lblRiepilogoSpedizione.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblRiepilogoSpedizione.setBounds(210, 65, 300, 30);
		contentPane.add(lblRiepilogoSpedizione);
		
		btnRegistra = new JButton("Registra");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var yesOrNo = JOptionPane.showConfirmDialog(null, "Confermare la registrazione della spedizione?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
				if(yesOrNo == 0)
				{
					myGestore.impostaCorriereMezzo.resetBtn();
					myGestore.creaSpedizioneFrame.s.generaIDSpedizione();
					for(Ordine o : myGestore.creaSpedizioneFrame.s.getOrdiniNellaSpedizione())
					{
						o.setDataDiConsegna(myGestore.creaSpedizioneFrame.s.getDataDiConsegna());
						o.setCorriereAssegnato(myGestore.creaSpedizioneFrame.s.getCorriereAssegnato());
						o.setMezzoAssegnato(myGestore.creaSpedizioneFrame.s.getMezzoAssegnato());
					}
					for(Corriere c : myGestore.ListaCorrieri)
					{
						if(c.getID().equals(myGestore.creaSpedizioneFrame.s.getCorriereAssegnato().getID()))
							c.aggiungiGiornoConsegna(myGestore.impostaCorriereMezzo.dataSelezionata);
					}
					for(MezzoDiTrasporto m : myGestore.ListaMezzi)
					{
						if(m.getTarga().equals(myGestore.creaSpedizioneFrame.s.getMezzoAssegnato().getTarga()))
							m.aggiungiGiornoConsegna(myGestore.impostaCorriereMezzo.dataSelezionata);
					}
					ArrayList<Ordine> temp = new ArrayList<Ordine>();
					for(Ordine o : myGestore.creaSpedizioneFrame.s.getOrdiniNellaSpedizione())
						temp.add(o);
					myGestore.ListaSpedizioni.add(new Spedizione (temp, myGestore.creaSpedizioneFrame.s.getDataDiConsegna(), myGestore.creaSpedizioneFrame.s.getCorriereAssegnato(), myGestore.creaSpedizioneFrame.s.getMezzoAssegnato(), myGestore.creaSpedizioneFrame.s.getID(), myGestore.creaSpedizioneFrame.s.getPesoTotaleSpedizione()));
					myGestore.impostaCorriereMezzo.CorrieriDisponibili.clear();
					myGestore.impostaCorriereMezzo.MezziDisponibili.clear();
					myGestore.creaSpedizioneFrame.s.clearOrdiniNellaSpedizione();
					myGestore.gestioneSpedizioni.aggiornaInfo();
					myGestore.gestioneSpedizioni.aggiornaLista();
					myGestore.creaSpedizioneFrame.s.setCorriereAssegnato(null);
					myGestore.creaSpedizioneFrame.s.setDataDiConsegna(null);
					myGestore.creaSpedizioneFrame.s.setID(null);
					myGestore.creaSpedizioneFrame.s.setMezzoAssegnato(null);
					myGestore.creaSpedizioneFrame.s.setPesoTotaleSpedizione(0.00);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnRegistra.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnRegistra.setForeground(bluLink);
		btnRegistra.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnRegistra.setBounds(488, 402, 220, 50);
		btnRegistra.setCursor(Mano);
		contentPane.add(btnRegistra);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromRiepilogoSpedizioneFrameToImpostaCorriereMezzo();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnIndietro.setBounds(10, 402, 220, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		model = new DefaultListModel<Ordine>();
		
		listaOrdini = new JList<String>();
		listaOrdini.setBackground(new Color(216, 216, 216));
		listaOrdini.setFont(new Font("PT Sans", Font.BOLD, 18));
		
		listaOrdiniPane = new JScrollPane();
		listaOrdiniPane.setBounds(10, 130, 440, 250);
		listaOrdiniPane.setViewportView(listaOrdini);
		contentPane.add(listaOrdiniPane);
		
		lblDataDiConsegna = new JLabel("");
		lblDataDiConsegna.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDiConsegna.setForeground(Color.BLACK);
		lblDataDiConsegna.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblDataDiConsegna.setBounds(458, 170, 250, 30);
		contentPane.add(lblDataDiConsegna);
		
		lblCorriereAssegnato = new JLabel("");
		lblCorriereAssegnato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorriereAssegnato.setForeground(Color.BLACK);
		lblCorriereAssegnato.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblCorriereAssegnato.setBounds(458, 211, 250, 30);
		contentPane.add(lblCorriereAssegnato);
		
		lblMezzoAssegnato = new JLabel("");
		lblMezzoAssegnato.setHorizontalAlignment(SwingConstants.CENTER);
		lblMezzoAssegnato.setForeground(Color.BLACK);
		lblMezzoAssegnato.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblMezzoAssegnato.setBounds(458, 252, 250, 30);
		contentPane.add(lblMezzoAssegnato);
		
		lblPesoSpedizione = new JLabel("");
		lblPesoSpedizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesoSpedizione.setForeground(Color.BLACK);
		lblPesoSpedizione.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblPesoSpedizione.setBounds(458, 293, 250, 30);
		contentPane.add(lblPesoSpedizione);
	}
	
	public void aggiornaLista() {
		model.clear();
		for(Ordine o : myGestore.creaSpedizioneFrame.s.getOrdiniNellaSpedizione())
			model.addElement("ID Ordine: #" + o.getIdOrdine());
		listaOrdini.setModel(model);
	}
	
	public void aggiornaInfo() {
		lblDataDiConsegna.setText("Data: " + myGestore.creaSpedizioneFrame.s.getDataDiConsegna().getDayOfMonth() + "/" + myGestore.creaSpedizioneFrame.s.getDataDiConsegna().getMonthValue() + "/" + myGestore.creaSpedizioneFrame.s.getDataDiConsegna().getYear());
		lblCorriereAssegnato.setText("ID Corriere: #" + myGestore.creaSpedizioneFrame.s.getCorriereAssegnato().getID());
		lblMezzoAssegnato.setText("Targa Mezzo: #" + myGestore.creaSpedizioneFrame.s.getMezzoAssegnato().getTarga());
		lblPesoSpedizione.setText("Peso: " + myGestore.creaSpedizioneFrame.s.getPesoTotaleSpedizione() + " kg");
	}
}
