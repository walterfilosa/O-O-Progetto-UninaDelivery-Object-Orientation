import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FiltraFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JLabel lblFiltraPerNome;
	private JRadioButton btnNomeCognome;
	private JRadioButton btnData;
	private ButtonGroup btnFiltro;

	private GestoreApplicazione myGestore;
	private JTextField txtSearch;
	private JTextField txtGetMese;
	private JLabel lblMese;
	private JLabel lblAnno;
	private JTextField txtGetAnno;
	private JButton btnCerca;
	public String testoDaCercare;
	private boolean isRicercaNomeSelected;
	public String meseDaCercare;
	public String annoDaCercare;
	private JButton btnAnnulla;
	
	public FiltraFrame(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 550, 330);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setEnabled(false);
		txtSearch.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtSearch.setBounds(10, 109, 516, 40);
		txtSearch.setForeground(bluLink);
		txtSearch.setColumns(10);
		contentPane.add(txtSearch);
		
		lblFiltraPerNome = new JLabel("Filtra per:");
		lblFiltraPerNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltraPerNome.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblFiltraPerNome.setBounds(176, 11, 190, 30);
		contentPane.add(lblFiltraPerNome);
		
		btnNomeCognome = new JRadioButton("Nome/Cognome");
		btnNomeCognome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isRicercaNomeSelected = true;
				txtSearch.setEnabled(true);
				lblMese.setEnabled(false);
				lblAnno.setEnabled(false);
				txtGetMese.setEnabled(false);
				txtGetAnno.setEnabled(false);
			}
		});
		btnNomeCognome.setHorizontalAlignment(SwingConstants.CENTER);
		btnNomeCognome.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnNomeCognome.setBounds(103, 56, 170, 30);
		btnNomeCognome.setCursor(Mano);
		contentPane.add(btnNomeCognome);
		
		btnData = new JRadioButton("Data di acquisto");
		btnData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isRicercaNomeSelected = false;
				lblMese.setEnabled(true);
				lblAnno.setEnabled(true);
				txtGetMese.setEnabled(true);
				txtGetAnno.setEnabled(true);
				txtSearch.setEnabled(false);
			}
		});
		btnData.setHorizontalAlignment(SwingConstants.CENTER);
		btnData.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnData.setBounds(291, 56, 170, 30);
		btnData.setCursor(Mano);
		contentPane.add(btnData);
		
		btnFiltro = new ButtonGroup();
		btnFiltro.add(btnNomeCognome);
		btnFiltro.add(btnData);
		
		txtGetMese = new JTextField();
		txtGetMese.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetMese.setEnabled(false);
		txtGetMese.setBounds(76, 173, 150, 40);
		txtGetMese.setForeground(bluLink);
		contentPane.add(txtGetMese);
		txtGetMese.setColumns(10);
		
		lblMese = new JLabel("Mese:");
		lblMese.setEnabled(false);
		lblMese.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblMese.setBounds(10, 178, 66, 30);
		contentPane.add(lblMese);
		
		lblAnno = new JLabel("Anno:");
		lblAnno.setEnabled(false);
		lblAnno.setFont(new Font("PT Sans", Font.BOLD, 20));
		lblAnno.setBounds(250, 178, 66, 30);
		contentPane.add(lblAnno);
		
		txtGetAnno = new JTextField();
		txtGetAnno.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetAnno.setEnabled(false);
		txtGetAnno.setColumns(10);
		txtGetAnno.setBounds(326, 173, 200, 40);
		txtGetAnno.setForeground(bluLink);
		contentPane.add(txtGetAnno);
		
		btnCerca = new JButton("Cerca");
		btnCerca.setIcon(new ImageIcon("Icons/SearchIcon24px.png"));
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtGetMese.getText().isEmpty() && !txtGetAnno.getText().isEmpty() && !txtSearch.isEnabled())
				{
					meseDaCercare = txtGetMese.getText();
					annoDaCercare = txtGetAnno.getText();
					isRicercaNomeSelected = false;
				}
				else if(txtGetMese.getText().isEmpty() && txtGetAnno.getText().isEmpty() && txtSearch.isEnabled())
				{
					testoDaCercare = txtSearch.getText();
					isRicercaNomeSelected = true;
				}
				setVisible(false);
				myGestore.gestioneOrdini.aggiornaListaDaRicerca(isRicercaNomeSelected);
				txtSearch.setText("");
				txtGetMese.setText("");
				txtGetAnno.setText("");
			}
		});
		btnCerca.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnCerca.setBounds(376, 242, 150, 40);
		btnCerca.setForeground(bluLink);
		btnCerca.setCursor(Mano);
		contentPane.add(btnCerca);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setIcon(new ImageIcon("Icons/AnnullaIcon.png"));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnulla.setForeground(new Color(0, 2, 160));
		btnAnnulla.setFont(new Font("PT Sans", Font.BOLD, 20));
		btnAnnulla.setBounds(10, 242, 150, 40);
		btnAnnulla.setCursor(Mano);
		contentPane.add(btnAnnulla);
	}
	
	private boolean controlliRicercaPerNome() {
		boolean allChecked = true;
		if(txtSearch.getText().length() < 3)
		{
			JOptionPane.showMessageDialog(null, "Immettere almeno 3 caratteri", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			allChecked = false;
		}
		
		return allChecked;
	}
	
	private boolean controlliRicercaPerData() {
		boolean allChecked = true;
		if(allChecked == true)
		{
			if(!isNumeric(txtGetAnno.getText()) || !isNumeric(txtGetMese.getText()))
			{
				JOptionPane.showMessageDialog(null, "La data può contenere solo cifre", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((txtGetMese.getText().length() > 2 || txtGetAnno.getText().length() != 4) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((txtGetMese.getText().equals("0") || txtGetMese.getText().equals("00")) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
			else if((Integer.valueOf(txtGetAnno.getText()) > LocalDate.now().getYear() || (Integer.valueOf(txtGetAnno.getText()) == LocalDate.now().getYear() && Integer.valueOf(txtGetMese.getText()) > LocalDate.now().getMonthValue())) && allChecked == true)
			{
				JOptionPane.showMessageDialog(null, "Inserire valori validi", "ERRORE", JOptionPane.ERROR_MESSAGE);
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
