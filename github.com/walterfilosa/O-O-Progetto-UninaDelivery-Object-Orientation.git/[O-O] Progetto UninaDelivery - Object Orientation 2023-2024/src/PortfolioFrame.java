import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PortfolioFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;

	private GestoreApplicazione myGestore;
	private JTextField txtGetNome;
	private JTextField txtGetNumeroCarta;
	private JTextField txtGetMese;
	private JTextField txtGetAnno;
	private JLabel lblPortfolio;
	private JPanel panel;
	private JLabel lblNomeIntestatario;
	private JLabel lblNumeroCarta;
	private JLabel lblDatadiscadenza;
	private JLabel lblSlash;
	private JButton btnSalva;
	private JButton btnChiudi;
	private JLabel lblSaldo;
	private JTextField txtGetSaldo;
	
	public PortfolioFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPortfolio = new JLabel("PORTFOLIO");
		lblPortfolio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolio.setForeground(new Color(0, 2, 160));
		lblPortfolio.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblPortfolio.setBounds(243, 11, 200, 30);
		contentPane.add(lblPortfolio);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(10, 55, 666, 193);
		contentPane.add(panel);
		
		lblNomeIntestatario = new JLabel("Nome Intestatario:");
		lblNomeIntestatario.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNomeIntestatario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeIntestatario.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNomeIntestatario.setBounds(6, 17, 150, 30);
		panel.add(lblNomeIntestatario);
		
		txtGetNome = new JTextField();
		txtGetNome.setEditable(false);
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
		txtGetNumeroCarta.setEditable(false);
		txtGetNumeroCarta.setToolTipText("Inserire Numero della carta");
		txtGetNumeroCarta.setForeground(new Color(0, 2, 160));
		txtGetNumeroCarta.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetNumeroCarta.setColumns(10);
		txtGetNumeroCarta.setBounds(180, 78, 476, 35);
		panel.add(txtGetNumeroCarta);
		
		lblDatadiscadenza = new JLabel("Data di scadenza:");
		lblDatadiscadenza.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDatadiscadenza.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatadiscadenza.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblDatadiscadenza.setBounds(6, 135, 150, 30);
		panel.add(lblDatadiscadenza);
		
		txtGetMese = new JTextField();
		txtGetMese.setEditable(false);
		txtGetMese.setToolTipText("MM");
		txtGetMese.setForeground(new Color(0, 2, 160));
		txtGetMese.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetMese.setColumns(10);
		txtGetMese.setBounds(180, 137, 83, 35);
		panel.add(txtGetMese);
		
		txtGetAnno = new JTextField();
		txtGetAnno.setEditable(false);
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
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSaldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldo.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblSaldo.setBounds(490, 137, 50, 30);
		panel.add(lblSaldo);
		
		txtGetSaldo = new JTextField();
		txtGetSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGetSaldo.setToolTipText("MM");
		txtGetSaldo.setForeground(new Color(0, 2, 160));
		txtGetSaldo.setFont(new Font("PT Sans", Font.BOLD, 18));
		txtGetSaldo.setEditable(false);
		txtGetSaldo.setColumns(10);
		txtGetSaldo.setBounds(553, 137, 103, 35);
		panel.add(txtGetSaldo);
		
		btnSalva = new JButton("Aggiungi saldo");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.aggiungiImporto.setVisible(true);
			}
		});
		btnSalva.setIcon(new ImageIcon("Icons/AggiungiIcon.png"));
		btnSalva.setToolTipText("Aggiungi nuovo importo");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnSalva.setBounds(506, 270, 170, 40);
		btnSalva.setCursor(Mano);
		contentPane.add(btnSalva);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnChiudi.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		btnChiudi.setToolTipText("Annulla Modiche");
		btnChiudi.setForeground(new Color(0, 2, 160));
		btnChiudi.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnChiudi.setBounds(10, 270, 170, 40);
		btnChiudi.setCursor(Mano);
		contentPane.add(btnChiudi);
	}
	
	public void aggiornaInfo() {
		txtGetNome.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getNomeIntestatario());
		txtGetNumeroCarta.setText(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getNumeroCarta());
		txtGetMese.setText(new String(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getMeseScadenza() + ""));
		txtGetAnno.setText(new String(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getAnnoScadenza() + ""));
		txtGetSaldo.setText(decimaleConDueCifre(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getSaldo()));
	}
	
	private String decimaleConDueCifre(double d) {
		DecimalFormat df = new DecimalFormat("0.00");
		String str = new String(df.format(d) + " €");
		return str;
	}

}
