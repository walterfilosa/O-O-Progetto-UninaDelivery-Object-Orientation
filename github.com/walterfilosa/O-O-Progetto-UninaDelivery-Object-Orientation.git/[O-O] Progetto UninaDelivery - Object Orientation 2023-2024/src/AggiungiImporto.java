import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AggiungiImporto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;

	private GestoreApplicazione myGestore;
	private JTextField txtGetSaldo;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	public AggiungiImporto(GestoreApplicazione ga) {
		setTitle("Inserire importo");
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGetSaldo = new JTextField();
		txtGetSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGetSaldo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n')
				{
					if(controlloInserimento())
					{
						myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().setSaldo(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getSaldo() + Double.parseDouble(txtGetSaldo.getText()));
						myGestore.portfolioFrame.aggiornaInfo();
						setVisible(false);
						txtGetSaldo.setText("");
						JOptionPane.showMessageDialog(null, "Importo aggiunto con successo", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		txtGetSaldo.setToolTipText("Inserire la quota che si vuole aggiungere al saldo");
		txtGetSaldo.setFont(new Font("PT Sans", Font.BOLD, 22));
		txtGetSaldo.setBounds(28, 20, 205, 30);
		txtGetSaldo.setForeground(new Color(0, 2, 160));
		contentPane.add(txtGetSaldo);
		txtGetSaldo.setColumns(10);
		
		btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlloInserimento())
				{
					myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().setSaldo(myGestore.ListaUtenti.get(myGestore.loginUtente.posizioneUtente).getCarta().getSaldo() + Double.parseDouble(txtGetSaldo.getText()));
					myGestore.portfolioFrame.aggiornaInfo();
					setVisible(false);
					txtGetSaldo.setText("");
					JOptionPane.showMessageDialog(null, "Importo aggiunto con successo", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("PT Sans", Font.BOLD, 18));
		btnNewButton.setBounds(28, 61, 230, 35);
		btnNewButton.setForeground(new Color(0, 2, 160));
		btnNewButton.setCursor(Mano);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("€");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("PT Sans", Font.BOLD, 18));
		lblNewLabel.setBounds(228, 21, 30, 30);
		contentPane.add(lblNewLabel);
	}
	
	private boolean controlloInserimento() {
		boolean allChecked = true;
		if(txtGetSaldo.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Inserire un valore", "", JOptionPane.ERROR_MESSAGE);
			allChecked = false;
		}
		
		if(allChecked == true)
		{
			if(isNumeric(txtGetSaldo.getText()) == false)
			{
				JOptionPane.showMessageDialog(null, "Inserire un valore numerico", "", JOptionPane.ERROR_MESSAGE);
				allChecked = false;
			}
		}
		
		if(allChecked == true)
		{
			if(Double.parseDouble(txtGetSaldo.getText()) <= 0.0)
			{
				JOptionPane.showMessageDialog(null, "Inserire un importo maggiore di 0", "", JOptionPane.ERROR_MESSAGE);
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
