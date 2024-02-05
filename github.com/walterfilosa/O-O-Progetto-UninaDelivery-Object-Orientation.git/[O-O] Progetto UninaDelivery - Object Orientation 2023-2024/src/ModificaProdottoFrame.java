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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ModificaProdottoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblPrezzo;
	private JScrollPane DescrizionePane;
	private JTextArea txtGetDescrizione;
	private JButton btnIndietro;

	private GestoreApplicazione myGestore;
	private JLabel lblNomeProdotto;
	private JLabel lblIdProdotto;
	private JLabel lblAziendaVenditrice;
	private JLabel lblPeso;
	private JLabel lblQuantita;
	private JPanel panel;
	private JButton btnSalva;
	private JTextField txtGetIDProdotto;
	private JSpinner spinnerPeso;
	private JSpinner spinnerQuantità;
	private JSpinner spinnerPrezzo;
	private JTextField txtGetAzienda;
	private JTextField txtGetNome;
	
	public ModificaProdottoFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 842, 490);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPrezzo = new JLabel();
		lblPrezzo.setText("Prezzo:");
		lblPrezzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzo.setForeground(Color.BLACK);
		lblPrezzo.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblPrezzo.setBounds(540, 392, 150, 50);
		lblPrezzo.setForeground(bluLink);
		contentPane.add(lblPrezzo);
		
		DescrizionePane = new JScrollPane();
		DescrizionePane.setBounds(10, 210, 808, 169);
		contentPane.add(DescrizionePane);
		
		txtGetDescrizione = new JTextArea();
		DescrizionePane.setViewportView(txtGetDescrizione);
		txtGetDescrizione.setWrapStyleWord(true);
		txtGetDescrizione.setLineWrap(true);
		txtGetDescrizione.setFont(new Font("PT Sans", Font.PLAIN, 20));
		txtGetDescrizione.setEnabled(true);
		txtGetDescrizione.setBackground(new Color(255, 255, 255));
	
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnIndietro.setToolTipText("");
		btnIndietro.setForeground(new Color(0, 2, 160));
		btnIndietro.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnIndietro.setBounds(10, 395, 140, 50);
		btnIndietro.setCursor(Mano);
		contentPane.add(btnIndietro);
		
		panel = new JPanel();
		panel.setBackground(new Color(216, 216, 216));
		panel.setBounds(10, 25, 808, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNomeProdotto = new JLabel();
		lblNomeProdotto.setText("Prodotto");
		lblNomeProdotto.setForeground(new Color(0, 2, 160));
		lblNomeProdotto.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblNomeProdotto.setBounds(0, 0, 117, 50);
		panel.add(lblNomeProdotto);
		
		lblIdProdotto = new JLabel();
		lblIdProdotto.setText("ID #");
		lblIdProdotto.setForeground(Color.BLACK);
		lblIdProdotto.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblIdProdotto.setBounds(0, 62, 69, 50);
		panel.add(lblIdProdotto);
		
		lblAziendaVenditrice = new JLabel();
		lblAziendaVenditrice.setText("Fornito da");
		lblAziendaVenditrice.setForeground(Color.BLACK);
		lblAziendaVenditrice.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblAziendaVenditrice.setBounds(0, 124, 137, 50);
		panel.add(lblAziendaVenditrice);
		
		lblPeso = new JLabel();
		lblPeso.setText("Peso kg");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setForeground(Color.BLACK);
		lblPeso.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblPeso.setBounds(349, 62, 117, 50);
		panel.add(lblPeso);
		
		lblQuantita = new JLabel();
		lblQuantita.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantita.setText("Quantità");
		lblQuantita.setForeground(Color.BLACK);
		lblQuantita.setFont(new Font("PT Sans", Font.BOLD, 30));
		lblQuantita.setBounds(574, 61, 130, 50);
		panel.add(lblQuantita);
		
		txtGetIDProdotto = new JTextField();
		txtGetIDProdotto.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetIDProdotto.setBounds(55, 62, 270, 50);
		txtGetIDProdotto.setForeground(Color.BLACK);
		panel.add(txtGetIDProdotto);
		txtGetIDProdotto.setColumns(10);
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setFont(new Font("PT Sans", Font.BOLD, 22));
		spinnerPeso.setBounds(470, 62, 94, 51);
		spinnerPeso.setCursor(Mano);
		panel.add(spinnerPeso);
		
		spinnerQuantità = new JSpinner();
		spinnerQuantità.setFont(new Font("PT Sans", Font.BOLD, 22));
		spinnerQuantità.setBounds(714, 62, 94, 51);
		spinnerQuantità.setCursor(Mano);
		panel.add(spinnerQuantità);
		
		txtGetAzienda = new JTextField();
		txtGetAzienda.setForeground(Color.BLACK);
		txtGetAzienda.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetAzienda.setColumns(10);
		txtGetAzienda.setBounds(147, 124, 661, 50);
		panel.add(txtGetAzienda);
		
		txtGetNome = new JTextField();
		txtGetNome.setForeground(new Color(0, 0, 0));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(140, 0, 668, 50);
		txtGetNome.setForeground(bluLink);
		panel.add(txtGetNome);
		
		btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlliModifica())
				{
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setNome(txtGetNome.getText());
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setIdProdotto(txtGetIDProdotto.getText());
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setAziendaVenditrice(txtGetAzienda.getText());
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setDescrizione(txtGetDescrizione.getText());
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setPeso((double)spinnerPeso.getValue());
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setPrezzo((double)spinnerPrezzo.getValue());
					myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).setQuantitàDisponibile((int)spinnerQuantità.getValue());
					myGestore.gestioneProdotti.aggiornaListaProdotti();
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Modifiche effettuate con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnSalva.setBounds(339, 395, 150, 50);
		btnSalva.setCursor(Mano);
		contentPane.add(btnSalva);
		
		spinnerPrezzo = new JSpinner();
		spinnerPrezzo.setFont(new Font("PT Sans", Font.BOLD, 22));
		spinnerPrezzo.setBounds(703, 391, 115, 51);
		spinnerPrezzo.setForeground(bluLink);
		spinnerPrezzo.setCursor(Mano);
		contentPane.add(spinnerPrezzo);
		
		
	}
	
	public void aggiornaInfo()
	{
		txtGetNome.setText(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getNome());
		txtGetIDProdotto.setText(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getIdProdotto());
		txtGetAzienda.setText(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getAziendaVenditrice());
		spinnerPeso.setModel(new SpinnerNumberModel(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getPeso(), 0.5, 99.0, 0.5));
		spinnerQuantità.setModel(new SpinnerNumberModel(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getQuantitàDisponibile(), 1, 99, 1));
		spinnerPrezzo.setModel(new SpinnerNumberModel(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getPrezzo(), 0.5, 99999.0, 0.5));
		txtGetDescrizione.setText(myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getDescrizione());
	}
	
	public void aggiornaPrezzo() {
		double risultato = 0.0;
		DecimalFormat df = new DecimalFormat("0.00");
		risultato = myGestore.ListaProdotti.get(myGestore.gestioneProdotti.posizioneProdotto).getPrezzo();
		String str = new String(df.format(risultato) + " €");
		lblPrezzo.setText("Prezzo: " + str);
	}
	
	private boolean controlliModifica() {
		boolean allChecked = true;
		if(txtGetNome.getText().length() < 5)
		{
			JOptionPane.showMessageDialog(null, "Il nome deve contenere almeno 3 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
			txtGetNome.setText("");
			allChecked = false;
		}
		else if(allChecked == true)
		{
			if(txtGetNome.getText().length() > 50)
			{
				JOptionPane.showMessageDialog(null, "Il nome deve contenere al più 50 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetNome.setText("");
				allChecked = false;
			}
			else
			{
				for(Prodotto p: myGestore.ListaProdotti)
				{
					if(txtGetNome.getText().equals(p.getNome()) && !p.getNome().equals(txtGetNome.getText()))
					{
						JOptionPane.showMessageDialog(null, "Nome già esistente.", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						txtGetNome.setText("");
						allChecked = false;
						break;
					}
				}
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetDescrizione.getText().length() > 500)
			{
				JOptionPane.showMessageDialog(null, "La descrizione può contenere massimo 500 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				allChecked = false;
			}
		}

		
		if(allChecked == true)
		{
			if(txtGetIDProdotto.getText().length() != 10)
			{
				JOptionPane.showMessageDialog(null, "L'ID prodotto deve contenere 10 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetIDProdotto.setText("");
				allChecked = false;
			}	
			else
			{
				for(Prodotto p: myGestore.ListaProdotti)
				{
					if(txtGetIDProdotto.getText().equals(p.getIdProdotto()) && !p.getIdProdotto().equals(txtGetIDProdotto.getText()))
					{
						JOptionPane.showMessageDialog(null, "ID già esistente.", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						txtGetIDProdotto.setText("");
						allChecked = false;
						break;
					}
				}
			}
		}
		
		if(allChecked == true)
		{
			if(txtGetAzienda.getText().length() > 30)
			{
				JOptionPane.showMessageDialog(null, "Il nome dell'azienda può contenere massimo 30 caratteri.", "ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				txtGetAzienda.setText("");
				allChecked = false;
			}
		}
		
		
		
		return allChecked;
	}
}
