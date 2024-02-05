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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AggiungiCartaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;

	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetNumeroCarta;
	private JPasswordField txtGetCVV;
	private JTextField txtGetMese;
	private JTextField txtGetAnno;
	private JLabel lblAggiungiCarta;
	private JPanel panel;
	private JLabel lblNomeIntestatario;
	private JLabel lblNumeroCarta;
	private JLabel lblCVV;
	private JLabel lblDatadiscadenza;
	private JButton btnSalva;
	private JButton btnAnnulla;
	private JLabel lblSlash;
	
	public AggiungiCartaFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 370);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAggiungiCarta = new JLabel("AGGIUNGI CARTA");
		lblAggiungiCarta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiCarta.setForeground(new Color(0, 2, 160));
		lblAggiungiCarta.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblAggiungiCarta.setBounds(243, 20, 200, 30);
		contentPane.add(lblAggiungiCarta);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(10, 64, 666, 193);
		contentPane.add(panel);
		
		lblNomeIntestatario = new JLabel("Nome Intestatario:");
		lblNomeIntestatario.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNomeIntestatario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeIntestatario.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNomeIntestatario.setBounds(6, 17, 150, 30);
		panel.add(lblNomeIntestatario);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Inserire Nome e Cognome dell'intestatario della carta");
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(180, 18, 476, 35);
		panel.add(txtGetNome);
		
		lblNumeroCarta = new JLabel("Numero Carta:");
		lblNumeroCarta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNumeroCarta.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroCarta.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNumeroCarta.setBounds(6, 76, 150, 30);
		panel.add(lblNumeroCarta);
		
		txtGetNumeroCarta = new JTextField();
		txtGetNumeroCarta.setToolTipText("Inserire Numero della carta");
		txtGetNumeroCarta.setForeground(new Color(0, 2, 160));
		txtGetNumeroCarta.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetNumeroCarta.setColumns(10);
		txtGetNumeroCarta.setBounds(180, 78, 476, 35);
		panel.add(txtGetNumeroCarta);
		
		txtGetCVV = new JPasswordField();
		txtGetCVV.setToolTipText("Inserire il CVV");
		txtGetCVV.setForeground(new Color(0, 2, 160));
		txtGetCVV.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetCVV.setEchoChar('*');
		txtGetCVV.setBounds(576, 137, 80, 35);
		panel.add(txtGetCVV);
		
		lblCVV = new JLabel("CVV:");
		lblCVV.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCVV.setHorizontalAlignment(SwingConstants.LEFT);
		lblCVV.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCVV.setBounds(528, 135, 50, 30);
		panel.add(lblCVV);
		
		lblDatadiscadenza = new JLabel("Data di scadenza:");
		lblDatadiscadenza.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDatadiscadenza.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatadiscadenza.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblDatadiscadenza.setBounds(6, 135, 150, 30);
		panel.add(lblDatadiscadenza);
		
		txtGetMese = new JTextField();
		txtGetMese.setToolTipText("MM");
		txtGetMese.setForeground(new Color(0, 2, 160));
		txtGetMese.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetMese.setColumns(10);
		txtGetMese.setBounds(180, 137, 83, 35);
		panel.add(txtGetMese);
		
		txtGetAnno = new JTextField();
		txtGetAnno.setToolTipText("AAAA");
		txtGetAnno.setForeground(new Color(0, 2, 160));
		txtGetAnno.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetAnno.setColumns(10);
		txtGetAnno.setBounds(286, 137, 108, 35);
		panel.add(txtGetAnno);
		
		lblSlash = new JLabel("/");
		lblSlash.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlash.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblSlash.setBounds(252, 137, 49, 33);
		panel.add(lblSlash);
		
		btnSalva = new JButton("Salva");
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlliRegistrazioneCarta() == true)
				{
					CartaDiCredito c = new CartaDiCredito(txtGetNome.getText(), txtGetNumeroCarta.getText(), new String(txtGetCVV.getPassword()), Integer.valueOf(txtGetMese.getText()), Integer.valueOf(txtGetAnno.getText()));
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).setCarta(c);
					JOptionPane.showMessageDialog(null, "Carta registrata con successo!", "", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					myGestore.infoUtente.aggiornaInfo();
					myGestore.infoUtente.setVisible(true);
					
				}
			}
		});
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnSalva.setBounds(561, 285, 115, 40);
		btnSalva.setCursor(Mano);
		contentPane.add(btnSalva);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				txtGetNumeroCarta.setText("");
				txtGetCVV.setText("");
				myGestore.infoUtente.aggiornaInfo();
				myGestore.infoUtente.setVisible(true);
			}
		});
		btnAnnulla.setToolTipText("Annulla Modiche");
		btnAnnulla.setForeground(new Color(0, 2, 160));
		btnAnnulla.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnAnnulla.setBounds(10, 285, 115, 40);
		btnAnnulla.setCursor(Mano);
		contentPane.add(btnAnnulla);
	}
	
	public void aggiornaInfo() {
		txtGetNome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNome() + " " + myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCognome());
		txtGetMese.setText((LocalDate.now().getMonthValue() + 1) + "");
		txtGetAnno.setText(LocalDate.now().getYear() + "");
		txtGetNumeroCarta.setText("");
		txtGetCVV.setText("");
	}
	
	private boolean controlliRegistrazioneCarta() {
		boolean allChecked = true;
		if(txtGetNome.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Inserire un nome", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			allChecked = false;
		}
		
		if(allChecked == true)
		{
			if(isNumeric(txtGetNumeroCarta.getText()) == false)
			{
				JOptionPane.showMessageDialog(null, "Il numero della carta può contenere solo cifre", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetNumeroCarta.getText().length() != 16)
			{
				JOptionPane.showMessageDialog(null, "Il numero della carta deve essere lungo 16 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(!isNumeric(txtGetAnno.getText()) || !isNumeric(txtGetMese.getText()))
			{
				JOptionPane.showMessageDialog(null, "La data di scadenza può contenere solo cifre", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((txtGetMese.getText().length() > 2 || txtGetAnno.getText().length() != 4) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi per la data di scadenza", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((txtGetMese.getText().equals("0") || txtGetMese.getText().equals("00")) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi per la data di scadenza", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((Integer.valueOf(txtGetAnno.getText()) < LocalDate.now().getYear() || (Integer.valueOf(txtGetAnno.getText()) == LocalDate.now().getYear() && Integer.valueOf(txtGetMese.getText()) < LocalDate.now().getMonthValue())) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Carta scaduta", "ERRORE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(!isNumeric(new String(txtGetCVV.getPassword())))
			{
				JOptionPane.showMessageDialog(null, "Il CVV può contenere 3 cifre", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				txtGetCVV.setText("");
				allChecked = false;
			}
			else if(new String(txtGetCVV.getPassword()).length() != 3)
			{
				JOptionPane.showMessageDialog(null, "Il CVV può contenere 3 cifre", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		return allChecked;

	}
	
	public static boolean isNumeric(String str) {
		  ParsePosition pos = new ParsePosition(0);
		  NumberFormat.getInstance().parse(str, pos);
		  return str.length() == pos.getIndex();
		}
}
