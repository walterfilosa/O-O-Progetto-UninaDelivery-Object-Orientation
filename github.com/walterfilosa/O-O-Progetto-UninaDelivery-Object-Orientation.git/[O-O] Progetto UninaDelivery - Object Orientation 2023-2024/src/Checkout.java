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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Checkout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel Logo;
	private JLabel lblUninaDelivery;
	private JLabel lblTitolo;

	private GestoreApplicazione myGestore;
	private JLabel lblDatiAcquirente;
	private JLabel lblNome;
	private JTextField txtGetNome;
	private JLabel lblCognome;
	private JTextField txtGetCognome;
	private JLabel lblIndirizzo;
	private JTextField txtGetIndirizzo;
	private JButton btnAcquista;
	private JPanel InfoPagamentoPane;
	private JButton btnIndietro;
	private JPanel InfoPersonaliPane;
	private JTextField txtGetNomeIntestatario;
	private JTextField txtGetNumeroCarta;
	private JTextField txtGetMese;
	private JLabel lblMetodoDiPagamento;
	private JRadioButton btnPagamentoCarta;
	private JRadioButton btnPagamentoConsegna;
	private ButtonGroup btnPagamento ;
	private JLabel lblNomeIntestatario;
	private JLabel lblNumeroCarta;
	private JLabel lblDataDiScadenza;
	private JTextField txtGetAnno;
	private JLabel lblSlash;
	private JLabel lblCVV;
	private JPasswordField txtGetCVV;
	private JLabel lblPrezzoTotale;
	private JLabel lblPrezzoSpedizione;
	
	
	public Checkout(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550
				);
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
		Logo.setBounds(10, 28, 161, 70);
		contentPane.add(Logo);
		
		lblUninaDelivery = new JLabel("Unina Delivery");
		lblUninaDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblUninaDelivery.setForeground(new Color(0, 2, 160));
		lblUninaDelivery.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblUninaDelivery.setBackground(new Color(216, 216, 216));
		lblUninaDelivery.setBounds(393, 28, 200, 50);
		contentPane.add(lblUninaDelivery);
		
		lblTitolo = new JLabel("CHECKOUT");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.BLACK);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTitolo.setBackground(new Color(216, 216, 216));
		lblTitolo.setBounds(393, 81, 200, 30);
		contentPane.add(lblTitolo);
		
		lblDatiAcquirente = new JLabel("DATI ACQUIRENTE");
		lblDatiAcquirente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatiAcquirente.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblDatiAcquirente.setBounds(158, 140, 170, 40);
		lblDatiAcquirente.setForeground(bluLink);
		contentPane.add(lblDatiAcquirente);
		
		InfoPersonaliPane = new JPanel();
		InfoPersonaliPane.setBackground(new Color(216, 216, 216));
		InfoPersonaliPane.setBounds(10, 190, 470, 254);
		contentPane.add(InfoPersonaliPane);
		InfoPersonaliPane.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNome.setBounds(10, 40, 80, 30);
		InfoPersonaliPane.add(lblNome);
		
		txtGetNome = new JTextField();
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetNome.setEditable(false);
		txtGetNome.setBounds(95, 40, 350, 30);
		InfoPersonaliPane.add(txtGetNome);
		txtGetNome.setColumns(10);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCognome.setBounds(10, 114, 80, 30);
		InfoPersonaliPane.add(lblCognome);
		
		txtGetCognome = new JTextField();
		txtGetCognome.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetCognome.setEditable(false);
		txtGetCognome.setColumns(10);
		txtGetCognome.setBounds(95, 114, 350, 30);
		InfoPersonaliPane.add(txtGetCognome);
		
		lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblIndirizzo.setBounds(10, 187, 80, 30);
		InfoPersonaliPane.add(lblIndirizzo);
		
		txtGetIndirizzo = new JTextField();
		txtGetIndirizzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetIndirizzo.setColumns(10);
		txtGetIndirizzo.setBounds(95, 187, 350, 30);
		InfoPersonaliPane.add(txtGetIndirizzo);
		
		InfoPagamentoPane = new JPanel();
		InfoPagamentoPane.setBounds(506, 190, 470, 254);
		contentPane.add(InfoPagamentoPane);
		InfoPagamentoPane.setLayout(null);
		
		lblNomeIntestatario = new JLabel("Nome Intestatario:");
		lblNomeIntestatario.setEnabled(false);
		lblNomeIntestatario.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNomeIntestatario.setBounds(6, 81, 150, 30);
		InfoPagamentoPane.add(lblNomeIntestatario);
		
		txtGetNomeIntestatario = new JTextField();
		txtGetNomeIntestatario.setEnabled(false);
		txtGetNomeIntestatario.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetNomeIntestatario.setColumns(10);
		txtGetNomeIntestatario.setBounds(161, 81, 280, 30);
		InfoPagamentoPane.add(txtGetNomeIntestatario);
		
		lblNumeroCarta = new JLabel("Numero Carta:");
		lblNumeroCarta.setEnabled(false);
		lblNumeroCarta.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNumeroCarta.setBounds(6, 122, 150, 30);
		InfoPagamentoPane.add(lblNumeroCarta);
		
		txtGetNumeroCarta = new JTextField();
		txtGetNumeroCarta.setEnabled(false);
		txtGetNumeroCarta.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetNumeroCarta.setColumns(10);
		txtGetNumeroCarta.setBounds(161, 122, 280, 30);
		InfoPagamentoPane.add(txtGetNumeroCarta);
		
		lblDataDiScadenza = new JLabel("Data di scadenza:");
		lblDataDiScadenza.setEnabled(false);
		lblDataDiScadenza.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblDataDiScadenza.setBounds(6, 163, 150, 30);
		InfoPagamentoPane.add(lblDataDiScadenza);
		
		txtGetMese = new JTextField();
		txtGetMese.setEnabled(false);
		txtGetMese.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetMese.setColumns(10);
		txtGetMese.setBounds(161, 163, 70, 30);
		InfoPagamentoPane.add(txtGetMese);
		
		btnPagamentoCarta = new JRadioButton("Pagamento con carta");
		btnPagamentoCarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				metodoPagamento();
			}
		});
		btnPagamentoCarta.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnPagamentoCarta.setBounds(6, 19, 210, 40);
		btnPagamentoCarta.setForeground(new Color(0, 0, 0));
		btnPagamentoCarta.setCursor(Mano);
		InfoPagamentoPane.add(btnPagamentoCarta);
		
		btnPagamentoConsegna = new JRadioButton("Pagamento alla consegna");
		btnPagamentoConsegna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				metodoPagamento();
			}
		});
		btnPagamentoConsegna.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnPagamentoConsegna.setBounds(220, 19, 250, 40);
		btnPagamentoConsegna.setForeground(new Color(0, 0, 0));
		btnPagamentoConsegna.setCursor(Mano);
		InfoPagamentoPane.add(btnPagamentoConsegna);
		
		btnPagamento = new ButtonGroup();
		btnPagamento.add(btnPagamentoCarta);
		btnPagamento.add(btnPagamentoConsegna);
		
		txtGetAnno = new JTextField();
		txtGetAnno.setEnabled(false);
		txtGetAnno.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetAnno.setColumns(10);
		txtGetAnno.setBounds(262, 163, 85, 30);
		InfoPagamentoPane.add(txtGetAnno);
		
		lblSlash = new JLabel("/");
		lblSlash.setEnabled(false);
		lblSlash.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlash.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblSlash.setBounds(209, 163, 80, 30);
		InfoPagamentoPane.add(lblSlash);
		
		lblCVV = new JLabel("CVV:");
		lblCVV.setEnabled(false);
		lblCVV.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblCVV.setBounds(6, 204, 150, 30);
		InfoPagamentoPane.add(lblCVV);
		
		txtGetCVV = new JPasswordField();
		txtGetCVV.setEnabled(false);
		txtGetCVV.setEchoChar('*');
		txtGetCVV.setBounds(161, 204, 85, 30);
		InfoPagamentoPane.add(txtGetCVV);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.fromCheckoutToCarrelloFrame();
				svuotaCampi();
			}
		});
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnIndietro.setBounds(10, 460, 200, 40);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		btnAcquista = new JButton("ACQUISTA");
		btnAcquista.setEnabled(false);
		btnAcquista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta() != null && btnPagamentoCarta.isSelected() && !btnPagamentoConsegna.isSelected())
				{
					if(controlliImmissioneCarta())
					{
						if(controlloEsistenzaCarta())
						{
							if(txtGetIndirizzo.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Inserire un indirizzo di spedizione", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
							else
							{
								if(controlloSaldo())
								{
									double prezzoTotale = prezzoTotale();
									for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
									{
										p.setQuantitàAcquistata(p.getQuantitàAlCarrello());
										p.setQuantitàAlCarrello(0);
									}
									Ordine ord = new Ordine(generaIDOrdine(), prezzoTotale, myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente), txtGetIndirizzo.getText(), LocalDate.now(), myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta());
									ord.riempiOrdine();
									ord.setAssegnataASpedizione(false);
									myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).aggiungiOrdineAlllStorico(ord);
									myGestore.ListaOrdini.add(ord);
									setVisible(false);
									myGestore.homePageUtente.setVisible(true);
									svuotaCampi();
									myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).svuotaCarrello();
									myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().setSaldo(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getSaldo() - ord.getPrezzoTotale());
									JOptionPane.showMessageDialog(null, "Ordine effettuato!", "", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}
				else if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta() == null && btnPagamentoCarta.isSelected() && !btnPagamentoConsegna.isSelected())
				{
					var yesOrNo = JOptionPane.showConfirmDialog(null, "Nessuna carta registrata.\nRegistrarne una?", "ATTENZIONE", JOptionPane.YES_NO_OPTION);
					if(yesOrNo == 0)
					{
						myGestore.aggiungiCartaFrame.setVisible(true);
						setVisible(false);
						svuotaCampi();
					}
				}
				if(!btnPagamentoCarta.isSelected() && btnPagamentoConsegna.isSelected())
				{
					if(txtGetIndirizzo.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Inserire un indirizzo di spedizione", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
					else
					{
						double prezzoTotale = prezzoTotale();
						for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
						{
							p.setQuantitàAcquistata(p.getQuantitàAlCarrello());
							p.setQuantitàAlCarrello(0);
						}
						Ordine ord = new Ordine(generaIDOrdine(), prezzoTotale, myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente), txtGetIndirizzo.getText(), LocalDate.now(), myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta());
						ord.riempiOrdine();
						ord.setAssegnataASpedizione(false);
						myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).aggiungiOrdineAlllStorico(ord);
						myGestore.ListaOrdini.add(ord);
						setVisible(false);
						myGestore.homePageUtente.setVisible(true);
						svuotaCampi();
						myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).svuotaCarrello();
						JOptionPane.showMessageDialog(null, "Ordine effettuato!", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnAcquista.setForeground(new Color(0, 2, 160));
		btnAcquista.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnAcquista.setBounds(776, 460, 200, 40);
		btnAcquista.setCursor(Mano);
		contentPane.add(btnAcquista);
		
		lblMetodoDiPagamento = new JLabel("METODO DI PAGAMENTO");
		lblMetodoDiPagamento.setBounds(632, 140, 230, 40);
		contentPane.add(lblMetodoDiPagamento);
		lblMetodoDiPagamento.setToolTipText("Inserire il metodo di pagamento desiderato");
		lblMetodoDiPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetodoDiPagamento.setForeground(new Color(0, 2, 160));
		lblMetodoDiPagamento.setFont(new Font("PT Sans", Font.BOLD, 20));
		
		lblPrezzoTotale = new JLabel("TOTALE:");
		lblPrezzoTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzoTotale.setForeground(new Color(0, 2, 160));
		lblPrezzoTotale.setFont(new Font("PT Sans", Font.BOLD, 24));
		lblPrezzoTotale.setBounds(759, 28, 217, 40);
		contentPane.add(lblPrezzoTotale);
		
		lblPrezzoSpedizione = new JLabel("di cui € 5,00 di spedizione");
		lblPrezzoSpedizione.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzoSpedizione.setForeground(new Color(0, 0, 0));
		lblPrezzoSpedizione.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblPrezzoSpedizione.setBounds(759, 61, 217, 40);
		contentPane.add(lblPrezzoSpedizione);
	}
	
	public void aggiornaInfo() {
		double risultato = 0.0;
		DecimalFormat df = new DecimalFormat("0.00");
		for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
			risultato += (p.getPrezzo() * p.getQuantitàAlCarrello());
		String str = new String(df.format(risultato + 5.00) + " €");
		lblPrezzoTotale.setText(str);
		
		txtGetNome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getNome());
		txtGetCognome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCognome());
	}
	
	private boolean controlliImmissioneCarta() {
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
	
	private boolean controlloEsistenzaCarta() {
		boolean allChecked = true;
		if(!myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getNumeroCarta().equals(txtGetNumeroCarta.getText()))
		{
			JOptionPane.showMessageDialog(null, "Il numero della carta non corrisponde", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			allChecked = false;
		}
		
		if(allChecked == true)
		{
			if((myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getMeseScadenza() != Integer.valueOf(txtGetMese.getText())) || (myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getAnnoScadenza() != Integer.valueOf(txtGetAnno.getText())))
			{
				JOptionPane.showMessageDialog(null, "La data di scadenza della carta non corrispode", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(!(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getCVV().equals(new String(txtGetCVV.getPassword()))))
			{
				JOptionPane.showMessageDialog(null, "Il CVV non corrisponde", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
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
	
	private void metodoPagamento() {
		btnAcquista.setEnabled(true);
		if(btnPagamentoCarta.isSelected() && !btnPagamentoConsegna.isSelected())
		{
			lblNomeIntestatario.setEnabled(true);
			lblNumeroCarta.setEnabled(true);
			lblDataDiScadenza.setEnabled(true);
			lblCVV.setEnabled(true);
			lblSlash.setEnabled(true);
			
			txtGetNomeIntestatario.setEnabled(true);
			txtGetNumeroCarta.setEnabled(true);
			txtGetMese.setEnabled(true);
			txtGetAnno.setEnabled(true);
			txtGetCVV.setEnabled(true);
		}
		else if(btnPagamentoConsegna.isSelected() && !btnPagamentoCarta.isSelected())
		{
			lblNomeIntestatario.setEnabled(false);
			lblNumeroCarta.setEnabled(false);
			lblDataDiScadenza.setEnabled(false);
			lblCVV.setEnabled(false);
			lblSlash.setEnabled(false);
			
			txtGetNomeIntestatario.setEnabled(false);
			txtGetNumeroCarta.setEnabled(false);
			txtGetMese.setEnabled(false);
			txtGetAnno.setEnabled(false);
			txtGetCVV.setEnabled(false);
		}
	}
	
	private void svuotaCampi() {
		btnAcquista.setEnabled(false);
		btnPagamentoCarta.setSelected(false);
		btnPagamentoConsegna.setSelected(false);
		
		lblNomeIntestatario.setEnabled(false);
		lblNumeroCarta.setEnabled(false);
		lblDataDiScadenza.setEnabled(false);
		lblCVV.setEnabled(false);
		lblSlash.setEnabled(false);
		
		txtGetNomeIntestatario.setEnabled(false);
		txtGetNumeroCarta.setEnabled(false);
		txtGetMese.setEnabled(false);
		txtGetAnno.setEnabled(false);
		txtGetCVV.setEnabled(false);
		
		txtGetIndirizzo.setText("");
		txtGetNomeIntestatario.setText("");
		txtGetNumeroCarta.setText("");
		txtGetMese.setText("");
		txtGetAnno.setText("");
		txtGetCVV.setText("");
	}
	
	private String generaIDOrdine() {
		    int leftLimit = 48; // numeral '0'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		    
		    return generatedString;
	}
	
	private double prezzoTotale() {
		double risultato = 0.0;
		for(Prodotto p : myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarrello())
			risultato += (p.getPrezzo() * p.getQuantitàAlCarrello());
		return risultato + 5.00;
	}
	
	 private boolean controlloSaldo() {
		if(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getSaldo() < prezzoTotale())
		{
			JOptionPane.showMessageDialog(null, "Saldo insufficiente", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	 }
}
