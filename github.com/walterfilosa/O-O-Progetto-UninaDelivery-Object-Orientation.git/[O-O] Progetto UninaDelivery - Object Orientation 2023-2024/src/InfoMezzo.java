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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InfoMezzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblInfo;
	private JLabel lblInfoMezzoDiTrasporto;
	private JPanel InfoPane;

	private GestoreApplicazione myGestore;
	private final JButton btnIndietro = new JButton("Indietro");
	private JLabel lblTarga;
	private JTextField txtGetTarga;
	private JTextField txtGetPeso;
	private JLabel lblTipo;
	private JTextField txtGetTipo;
	private JLabel lblPeso;
	
	public InfoMezzo(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 666, 350);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfo = new JLabel("INFO");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(new Color(0, 2, 160));
		lblInfo.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblInfo.setBounds(231, 24, 190, 30);
		contentPane.add(lblInfo);
		
		lblInfoMezzoDiTrasporto = new JLabel("INFO MEZZO DI TRASPORTO");
		lblInfoMezzoDiTrasporto.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoMezzoDiTrasporto.setForeground(Color.BLACK);
		lblInfoMezzoDiTrasporto.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblInfoMezzoDiTrasporto.setBackground(new Color(216, 216, 216));
		lblInfoMezzoDiTrasporto.setBounds(201, 65, 250, 30);
		contentPane.add(lblInfoMezzoDiTrasporto);
		
		InfoPane = new JPanel();
		InfoPane.setBackground(new Color(216, 216, 216));
		InfoPane.setBounds(10, 118, 632, 140);
		contentPane.add(InfoPane);
		InfoPane.setLayout(null);
		
		lblTarga = new JLabel("Targa:");
		lblTarga.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTarga.setBounds(10, 52, 130, 30);
		InfoPane.add(lblTarga);
		
		txtGetTarga = new JTextField();
		txtGetTarga.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetTarga.setEditable(false);
		txtGetTarga.setBounds(197, 52, 425, 30);
		InfoPane.add(txtGetTarga);
		txtGetTarga.setColumns(10);
		
		lblPeso = new JLabel("Peso trasportabile:");
		lblPeso.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblPeso.setBounds(10, 93, 180, 30);
		InfoPane.add(lblPeso);
		
		txtGetPeso = new JTextField();
		txtGetPeso.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetPeso.setEditable(false);
		txtGetPeso.setColumns(10);
		txtGetPeso.setBounds(197, 93, 425, 30);
		InfoPane.add(txtGetPeso);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTipo.setBounds(10, 11, 130, 30);
		InfoPane.add(lblTipo);
		
		txtGetTipo = new JTextField();
		txtGetTipo.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetTipo.setEditable(false);
		txtGetTipo.setColumns(10);
		txtGetTipo.setBounds(197, 11, 425, 30);
		InfoPane.add(txtGetTipo);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnIndietro.setBounds(235, 269, 182, 41);
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
	}
	
	public void aggiornaInfo() {
		txtGetTarga.setText(myGestore.ListaMezzi.get(myGestore.gestioneCorriereMezzi.posizioneMezzoSelezionato).getTarga());
		txtGetPeso.setText(new String("" + myGestore.ListaMezzi.get(myGestore.gestioneCorriereMezzi.posizioneMezzoSelezionato).getPesoMassimoTrasportabile() + " kg"));
		txtGetTipo.setText(myGestore.ListaMezzi.get(myGestore.gestioneCorriereMezzi.posizioneMezzoSelezionato).getTipo());
	}
}
