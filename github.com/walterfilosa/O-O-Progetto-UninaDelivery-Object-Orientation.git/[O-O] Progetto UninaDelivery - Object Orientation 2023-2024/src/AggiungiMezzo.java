import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;

public class AggiungiMezzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblAggiungi;
	private JLabel lblInfoMezzo;
	private JPanel InfoPane;

	private GestoreApplicazione myGestore;
	private JButton btnIndietro;
	private JLabel lblTarga;
	private JTextField txtGetTarga;
	private JLabel lblTipo;
	private JTextField txtGetTipo;
	private JLabel lblPeso;
	private JButton btnSalva;
	private JLabel lblKg;
	private JSpinner spinnerPeso;
	
	public AggiungiMezzo(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 666, 300);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAggiungi = new JLabel("AGGIUNGI");
		lblAggiungi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungi.setForeground(new Color(0, 2, 160));
		lblAggiungi.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblAggiungi.setBounds(231, 24, 190, 30);
		contentPane.add(lblAggiungi);
		
		lblInfoMezzo = new JLabel("INFO MEZZO");
		lblInfoMezzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoMezzo.setForeground(Color.BLACK);
		lblInfoMezzo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblInfoMezzo.setBackground(new Color(216, 216, 216));
		lblInfoMezzo.setBounds(201, 65, 250, 30);
		contentPane.add(lblInfoMezzo);
		
		InfoPane = new JPanel();
		InfoPane.setBackground(new Color(216, 216, 216));
		InfoPane.setBounds(10, 105, 632, 93);
		contentPane.add(InfoPane);
		InfoPane.setLayout(null);
		
		lblTarga = new JLabel("Targa:");
		lblTarga.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTarga.setBounds(10, 52, 130, 30);
		InfoPane.add(lblTarga);
		
		txtGetTarga = new JTextField();
		txtGetTarga.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetTarga.setBounds(110, 52, 170, 30);
		InfoPane.add(txtGetTarga);
		txtGetTarga.setColumns(10);
		
		lblPeso = new JLabel("Peso trasportabile:");
		lblPeso.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblPeso.setBounds(331, 52, 170, 30);
		InfoPane.add(lblPeso);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTipo.setBounds(10, 11, 130, 30);
		InfoPane.add(lblTipo);
		
		txtGetTipo = new JTextField();
		txtGetTipo.setFont(new Font("PT Sans", Font.BOLD, 20));
		txtGetTipo.setColumns(10);
		txtGetTipo.setBounds(110, 11, 512, 30);
		InfoPane.add(txtGetTipo);
		
		lblKg = new JLabel("kg");
		lblKg.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblKg.setBounds(601, 52, 21, 30);
		InfoPane.add(lblKg);
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setFont(new Font("PT Sans", Font.BOLD, 20));
		spinnerPeso.setBounds(511, 50, 76, 35);
		spinnerPeso.setCursor(Mano);
		InfoPane.add(spinnerPeso);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnIndietro.setBounds(10, 210, 182, 41);
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlliModifica())
				{
					MezzoDiTrasporto m = new MezzoDiTrasporto(txtGetTipo.getText(), (double)spinnerPeso.getValue(), txtGetTarga.getText());
					myGestore.ListaMezzi.add(m);
					myGestore.gestioneCorriereMezzi.aggiornaListaMezzi();
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Modifiche apportate con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnSalva.setBounds(460, 210, 182, 41);
		btnSalva.setCursor(Mano);
		contentPane.add(btnSalva);
	}
	
	public void aggiornaInfo() {
		txtGetTipo.setText("");
		txtGetTarga.setText("");
		spinnerPeso.setModel(new SpinnerNumberModel(50.00, 50.00, null, 50.00));
	}
	
	private boolean controlliModifica() {
		boolean allChecked = true;
		if(txtGetTarga.getText().length() != 7)
		{
			JOptionPane.showMessageDialog(null, "La targa deve contenere 7 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			allChecked = false;
		}
		
		if(allChecked == true)
		{
			for(MezzoDiTrasporto m : myGestore.ListaMezzi)
			{
				if(m.getTarga().equals(txtGetTarga.getText()))
				{
					JOptionPane.showMessageDialog(null, "Targa già esistente", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
					allChecked = false;
					break;
				}
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetTipo.getText().length() < 3)
			{
				JOptionPane.showMessageDialog(null, "Il tipo deve contenere almeno 3 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		return allChecked;
	}
}
