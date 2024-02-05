import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.util.LocaleData;

import javax.swing.JButton;
import java.awt.Font;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScegliDataConsegna extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cursor Mano;
	private Color bluLink;
	private JButton btnOK;
	private JLabel lblScegliData;
	private JLabel lblGG;
	private JSpinner spinnerGG;
	private JLabel lblMM;
	private JSpinner spinnerMM;
	private JLabel lblAAAA;
	private JSpinner spinnerAAAA;
	

	private GestoreApplicazione myGestore;
	
	public ScegliDataConsegna(GestoreApplicazione ga) {
		setResizable(false);
		myGestore = ga;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		setLocationRelativeTo(null);
		myGestore.setIconFrame(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Mano = new Cursor(Cursor.HAND_CURSOR);
		bluLink = new Color(0, 2, 160);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aaaa = (int)spinnerAAAA.getValue();
				int mm = (int)spinnerMM.getValue();
				int gg = (int)spinnerGG.getValue();
				
				if(aaaa >= LocalDate.now().getYear())
				{
					if(mm >= LocalDate.now().getMonthValue())
					{
						if(gg > LocalDate.now().getDayOfMonth())
						{
							try
							{
								
								myGestore.impostaCorriereMezzo.dataSelezionata = LocalDate.of(aaaa, mm, gg);
								myGestore.impostaCorriereMezzo.aggiornaBtn();
								myGestore.impostaCorriereMezzo.aggiornaListaDaData();
								setVisible(false);
							}
							catch(DateTimeException d)
							{
								JOptionPane.showMessageDialog(null, "Inserire valori validi", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Inserire una data valida", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Inserire una data valida", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Inserire una data valida", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnOK.setForeground(new Color(0, 2, 160));
		btnOK.setFont(new Font("PT Sans", Font.BOLD, 22));
		btnOK.setBounds(133, 152, 220, 50);
		btnOK.setCursor(Mano);
		contentPane.add(btnOK);
		
		lblScegliData = new JLabel("Scegli data");
		lblScegliData.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliData.setForeground(Color.BLACK);
		lblScegliData.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblScegliData.setBounds(168, 11, 150, 30);
		contentPane.add(lblScegliData);
		
		lblGG = new JLabel("Giorno:");
		lblGG.setForeground(Color.BLACK);
		lblGG.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblGG.setBounds(10, 92, 70, 30);
		contentPane.add(lblGG);
		
		spinnerGG = new JSpinner();
		spinnerGG.setFont(new Font("PT Sans", Font.BOLD, 22));
		spinnerGG.setBounds(86, 92, 60, 30);
		spinnerGG.setForeground(bluLink);
		spinnerGG.setModel(new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, 31, 1));
		contentPane.add(spinnerGG);
		
		lblMM = new JLabel("Mese:");
		lblMM.setForeground(Color.BLACK);
		lblMM.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblMM.setBounds(168, 92, 70, 30);
		contentPane.add(lblMM);
		
		spinnerMM = new JSpinner();
		spinnerMM.setFont(new Font("PT Sans", Font.BOLD, 22));
		spinnerMM.setBounds(229, 92, 60, 30);
		spinnerMM.setForeground(bluLink);
		spinnerMM.setModel(new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12, 1));
		contentPane.add(spinnerMM);
		
		lblAAAA = new JLabel("Anno:");
		lblAAAA.setForeground(Color.BLACK);
		lblAAAA.setFont(new Font("PT Sans", Font.BOLD, 22));
		lblAAAA.setBounds(319, 92, 70, 30);
		contentPane.add(lblAAAA);
		
		spinnerAAAA = new JSpinner();
		spinnerAAAA.setFont(new Font("PT Sans", Font.BOLD, 22));
		spinnerAAAA.setBounds(381, 92, 95, 30);
		spinnerAAAA.setForeground(bluLink);
		spinnerAAAA.setModel(new SpinnerNumberModel(LocalDate.now().getYear(), LocalDate.now().getYear(), LocalDate.now().getYear() + 100, 1));
		contentPane.add(spinnerAAAA);
	}
}
