import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggiungiProdotto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestoreApplicazione myGestore;
	private JTextField txtGetAzienda;
	private JTextField txtGetNome;
	private JTextField txtGetIDProdotto;
	private JSpinner spinnerQuantita;
	private JSpinner spinnerPeso;
	private JSpinner spinnerPrezzo;
	private SpinnerNumberModel smQuantita;
	private SpinnerNumberModel smPeso;
	private SpinnerNumberModel smPrezzo;
	private JButton btnSalva;
	private JButton btnAnnulla;
	private JLabel lblTitolo;
	private Cursor Mano;
	private JPanel panel;
	private JLabel lblTxtNome;
	private JLabel lblIdProdotto;
	private JLabel lblQuantitDaAggiungere;
	private JTextArea txtGetDescrizione;
	private JScrollPane scrollPane;
	private JLabel lblPeso;
	private JLabel lblKg;
	private JLabel lblValuta;
	private JLabel lblPrezzo;
	private JLabel lblAziendaVenditrice;
	private JLabel lblDescrizione;
	
	public AggiungiProdotto(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 470);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		Mano = new Cursor(Cursor.HAND_CURSOR);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitolo = new JLabel("Inserire i dettagli del prodotto da aggiungiere");
		lblTitolo.setForeground(new Color(0, 2, 160));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblTitolo.setBounds(200, 6, 450, 40);
		contentPane.add(lblTitolo);
		
		panel = new JPanel();
		panel.setBackground(new Color(226, 226, 226));
		panel.setBounds(6, 55, 838, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTxtNome = new JLabel("Nome:");
		lblTxtNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTxtNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtNome.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblTxtNome.setBounds(22, 26, 65, 30);
		panel.add(lblTxtNome);
		
		txtGetNome = new JTextField();
		txtGetNome.setToolTipText("Inserire Nome");
		txtGetNome.setForeground(new Color(0, 2, 160));
		txtGetNome.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetNome.setColumns(10);
		txtGetNome.setBounds(85, 21, 300, 35);
		panel.add(txtGetNome);
		
		lblIdProdotto = new JLabel("ID Prodotto:");
		lblIdProdotto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIdProdotto.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProdotto.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblIdProdotto.setBounds(414, 26, 100, 30);
		panel.add(lblIdProdotto);
		
		txtGetIDProdotto = new JTextField();
		txtGetIDProdotto.setToolTipText("Inserire ID Prodotto");
		txtGetIDProdotto.setForeground(new Color(0, 2, 160));
		txtGetIDProdotto.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetIDProdotto.setColumns(10);
		txtGetIDProdotto.setBounds(514, 21, 300, 35);
		panel.add(txtGetIDProdotto);
		
		lblQuantitDaAggiungere = new JLabel("Quantità da aggiungere:");
		lblQuantitDaAggiungere.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitDaAggiungere.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblQuantitDaAggiungere.setBounds(22, 95, 200, 30);
		panel.add(lblQuantitDaAggiungere);
		
		smQuantita = new SpinnerNumberModel(1, 1, 99, 1);
		
		spinnerQuantita = new JSpinner(smQuantita);
		spinnerQuantita.setToolTipText("Impostare quantità da aggiungere");
		spinnerQuantita.setFont(new Font("PT Sans", Font.BOLD, 18));
		spinnerQuantita.setEditor(new JSpinner.DefaultEditor(spinnerQuantita));		
		spinnerQuantita.setBounds(218, 90, 75, 40);
		panel.add(spinnerQuantita);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeso.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblPeso.setBounds(351, 94, 50, 30);
		panel.add(lblPeso);
		
		smPeso = new SpinnerNumberModel(0.5, 0.5, 100.0, 0.5);
		
		spinnerPeso = new JSpinner(smPeso);
		spinnerPeso.setToolTipText("Impostare Peso Prodotto");
		spinnerPeso.setFont(new Font("PT Sans", Font.BOLD, 18));
		spinnerPeso.setEditor(new JSpinner.DefaultEditor(spinnerPeso));
		spinnerPeso.setBounds(399, 90, 75, 40);
		panel.add(spinnerPeso);
		
		lblKg = new JLabel("Kg");
		lblKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg.setFont(new Font("PT Sans", Font.PLAIN, 18));
		lblKg.setBounds(486, 95, 50, 30);
		panel.add(lblKg);
		
		lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrezzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblPrezzo.setBounds(565, 95, 70, 30);
		panel.add(lblPrezzo);
		
		smPrezzo = new SpinnerNumberModel(1.0, 1.0, 10000.00, 1.00);
		
		spinnerPrezzo = new JSpinner(smPrezzo);
		spinnerPrezzo.setToolTipText("Impostare prezzo di vendita in €");
		spinnerPrezzo.setFont(new Font("PT Sans", Font.BOLD, 18));
		spinnerPrezzo.setEditor(new JSpinner.DefaultEditor(spinnerPrezzo));
		spinnerPrezzo.setBounds(632, 91, 75, 40);
		panel.add(spinnerPrezzo);
		
		lblValuta = new JLabel("€");
		lblValuta.setHorizontalAlignment(SwingConstants.LEFT);
		lblValuta.setFont(new Font("PT Sans", Font.PLAIN, 18));
		lblValuta.setBounds(710, 100, 50, 30);
		panel.add(lblValuta);
		
		lblAziendaVenditrice = new JLabel("Azienda Venditrice:");
		lblAziendaVenditrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblAziendaVenditrice.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblAziendaVenditrice.setBounds(19, 155, 165, 30);
		panel.add(lblAziendaVenditrice);
		
		txtGetAzienda = new JTextField();
		txtGetAzienda.setToolTipText("Inserire Nome");
		txtGetAzienda.setForeground(new Color(0, 2, 160));
		txtGetAzienda.setFont(new Font("PT Sans", Font.BOLD, 15));
		txtGetAzienda.setColumns(10);
		txtGetAzienda.setBounds(192, 154, 628, 35);
		panel.add(txtGetAzienda);
		
		lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblDescrizione.setBounds(22, 246, 105, 30);
		panel.add(lblDescrizione);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 201, 630, 120);
		panel.add(scrollPane);
		
		txtGetDescrizione = new JTextArea();
		txtGetDescrizione.setForeground(new Color(0, 2, 160));
		txtGetDescrizione.setFont(new Font("PT Sans", Font.BOLD, 15));
		scrollPane.setViewportView(txtGetDescrizione);
		txtGetDescrizione.setLineWrap(true);
		txtGetDescrizione.setToolTipText("Inserire Descrizione Prodotto");
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setCursor(Mano);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myGestore.aggiungiProdotto.setVisible(false);
			}
		});
		btnAnnulla.setToolTipText("Annulla Modifiche");
		btnAnnulla.setForeground(new Color(0, 2, 160));
		btnAnnulla.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		btnAnnulla.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnAnnulla.setBounds(6, 332, 120, 40);
		panel.add(btnAnnulla);
		
		btnSalva = new JButton("Salva");
		btnSalva.setIcon(new ImageIcon("Icons/Salva.png"));
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myGestore.ListaProdotti.isEmpty()) {
					myGestore.ListaProdotti.add(new Prodotto(txtGetNome.getText(), txtGetDescrizione.getText(), txtGetIDProdotto.getText(), (double)spinnerPrezzo.getValue(), (int)spinnerQuantita.getValue(), (double)spinnerPeso.getValue(), txtGetAzienda.getText()));
					myGestore.aggiungiProdotto.setVisible(false);
					txtGetNome.setText("");
					txtGetIDProdotto.setText("");
					txtGetAzienda.setText("");
					spinnerPrezzo.setValue(1);
					spinnerPeso.setValue(0.5);
					spinnerQuantita.setValue(1);
					txtGetDescrizione.setText("");
					myGestore.gestioneProdotti.aggiornaListaProdotti();
					JOptionPane.showMessageDialog(null, "Prodotto aggiunto con successo.", "", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(controlliRegistrazione())
					{
						myGestore.ListaProdotti.add(new Prodotto(txtGetNome.getText(), txtGetDescrizione.getText(), txtGetIDProdotto.getText(), (double)spinnerPrezzo.getValue(), (int)spinnerQuantita.getValue(), (double)spinnerPeso.getValue(), txtGetAzienda.getText()));
						myGestore.aggiungiProdotto.setVisible(false);
						txtGetNome.setText("");
						txtGetIDProdotto.setText("");
						txtGetAzienda.setText("");
						spinnerPrezzo.setValue(1);
						spinnerPeso.setValue(0.5);
						spinnerQuantita.setValue(1);
						txtGetDescrizione.setText("");
						myGestore.gestioneProdotti.aggiornaListaProdotti();
						JOptionPane.showMessageDialog(null, "Prodotto aggiunto con successo.", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnSalva.setCursor(Mano);
		btnSalva.setToolTipText("Salva Modifiche");
		btnSalva.setForeground(new Color(0, 2, 160));
		btnSalva.setFont(new Font("PT Sans", Font.BOLD, 15));
		btnSalva.setBounds(700, 333, 120, 40);
		panel.add(btnSalva);
	}
	
	
	
	private boolean controlliRegistrazione() {
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
					if(txtGetNome.getText().equals(p.getNome()))
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
					if(txtGetIDProdotto.getText().equals(p.getIdProdotto()))
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
