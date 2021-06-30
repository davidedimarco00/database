package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import controller.PersoneController;
import controller.PersoneControllerImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class PersoneForm extends JFrame {

	private static JFrame frame;
	private JTextField cfText;
	private JTextField nomeText;
	private JTextField cognomeText;
	private JTextField telefonoText;
	private JTextField cittaText;
	private JTextField viaText;
	private JTextField civicoText;
	private PersoneController controller = new PersoneControllerImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PersoneForm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param dati 
	 */
	
	public PersoneForm(String dati) {
		setTitle("Aggiungi persona");
		setBounds(100, 100, 544, 385);
		//initialize();
		getContentPane().setLayout(null);
			
		
		JLabel lblAggiungiPersona = new JLabel("Aggiungi persona:");
		lblAggiungiPersona.setFont(new Font("Arial", Font.ITALIC, 21));
		lblAggiungiPersona.setBounds(10, 11, 200, 40);
		getContentPane().add(lblAggiungiPersona);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"PROPRIETARIO", "RESPONSABILE NAVIGAZIONE", "PASSEGGERO"}));
		comboBoxTipo.setBounds(105, 89, 175, 22);
		getContentPane().add(comboBoxTipo);
		
		cfText = new JTextField();
		cfText.setBounds(105, 62, 175, 20);
		getContentPane().add(cfText);
		cfText.setColumns(10);
		if (dati != null) {
			cfText.setText(dati);
			cfText.setEnabled(false);
		}
		
		JLabel lblCf = new JLabel("CF");
		lblCf.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCf.setBounds(20, 57, 40, 23);
		getContentPane().add(lblCf);
		
		JLabel lblNome = new JLabel("Tipologia");
		lblNome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNome.setBounds(20, 89, 86, 23);
		getContentPane().add(lblNome);
		
		
		JLabel lblNome_2 = new JLabel("Nome");
		lblNome_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNome_2.setBounds(20, 123, 40, 23);
		getContentPane().add(lblNome_2);
		
		JLabel lblNazionalit = new JLabel("Nazionalit\u00E0:");
		lblNazionalit.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNazionalit.setBounds(20, 189, 86, 23);
		getContentPane().add(lblNazionalit);
		
		JLabel lblNome_2_1 = new JLabel("Cognome");
		lblNome_2_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNome_2_1.setBounds(20, 155, 75, 23);
		getContentPane().add(lblNome_2_1);
		
		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(105, 122, 174, 20);
		getContentPane().add(nomeText);
		
		cognomeText = new JTextField();
		cognomeText.setColumns(10);
		cognomeText.setBounds(105, 157, 174, 20);
		getContentPane().add(cognomeText);
		
		JLabel lblNumeroDiTelefono = new JLabel("Telefono");
		lblNumeroDiTelefono.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNumeroDiTelefono.setBounds(20, 260, 75, 23);
		getContentPane().add(lblNumeroDiTelefono);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblIndirizzo.setBounds(300, 61, 67, 23);
		getContentPane().add(lblIndirizzo);
		
		telefonoText = new JTextField();
		telefonoText.setColumns(10);
		telefonoText.setBounds(105, 261, 175, 20);
		getContentPane().add(telefonoText);
		
		JComboBox comboBoxNaz = new JComboBox();
		comboBoxNaz.setModel(new DefaultComboBoxModel(new String[] {"ITALIANA"}));
		comboBoxNaz.setSelectedIndex(0);
		comboBoxNaz.setBounds(105, 189, 175, 22);
		getContentPane().add(comboBoxNaz);
		
		JLabel lblNome_2_1_1 = new JLabel("via");
		lblNome_2_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNome_2_1_1.setBounds(320, 123, 40, 23);
		getContentPane().add(lblNome_2_1_1);
		
		JLabel lblCitt = new JLabel("Citt\u00E0");
		lblCitt.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCitt.setBounds(320, 89, 40, 23);
		getContentPane().add(lblCitt);
		
		JLabel lblCivico = new JLabel("civico");
		lblCivico.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCivico.setBounds(319, 155, 40, 23);
		getContentPane().add(lblCivico);
		
		cittaText = new JTextField();
		cittaText.setColumns(10);
		cittaText.setBounds(368, 90, 156, 20);
		getContentPane().add(cittaText);
		
		viaText = new JTextField();
		viaText.setColumns(10);
		viaText.setBounds(368, 124, 156, 20);
		getContentPane().add(viaText);
		
		civicoText = new JTextField();
		civicoText.setColumns(10);
		civicoText.setBounds(484, 156, 40, 20);
		getContentPane().add(civicoText);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1616194800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(105, 224, 135, 20);
		getContentPane().add(spinner);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
	    spinner.setEditor(editor);
		
		JLabel lblNatoIl = new JLabel("Nato il");
		lblNatoIl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNatoIl.setBounds(20, 223, 75, 23);
		getContentPane().add(lblNatoIl);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controller.aggiungiPersona(cfText.getText(), nomeText.getText(), cognomeText.getText(), comboBoxTipo.getSelectedItem().toString(),
						comboBoxNaz.getSelectedItem().toString(), telefonoText.getText(), (Date)spinner.getValue(), viaText.getText(), Integer.valueOf(civicoText.getText()), cittaText.getText()  )) {
					JOptionPane.showMessageDialog(frame,"Persona aggiunta");
					frame.setVisible(false);
				}
			}
		});
		btnAggiungi.setBounds(429, 312, 89, 23);
		getContentPane().add(btnAggiungi);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
