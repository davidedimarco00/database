package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableCell;

import controller.BarcaController;
import controller.BarcaControllerImpl;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class BarcaForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTipologia;
	private JTextField CINtext;
	private BarcaController controller = new BarcaControllerImpl();
	private JLabel lblMatricola;
	private JLabel lblNumeroImo;
	private JLabel lblLarghezza;
	private JLabel lblNumeroPersoneTrasportabili;
	private JLabel lblLunghezza_3;
	private JTextField textFieldMatricola;
	private JTextField textFieldNImo;
	private JTextField lunghezzaText;
	private JTextField larghezzaText;
	private JTextField textFieldNmotori;
	private JLabel lblNumeroMotori;
	private JLabel lblSeriale;
	private JTextField textFieldSeriale;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField nomeText;
	private static BarcaForm frame ;
	private JButton btnRimuovi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BarcaForm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BarcaForm(String dati) {
		setTitle("Aggiungi nuova barca");
		setBounds(100, 100, 729, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipologia = new JLabel("Tipologia:");
		lblTipologia.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTipologia.setBounds(20, 120, 74, 23);
		contentPane.add(lblTipologia);
		
		JLabel lblAggiungiUnaNuova = new JLabel("Aggiungi una nuova barca");
		lblAggiungiUnaNuova.setHorizontalAlignment(SwingConstants.LEFT);
		lblAggiungiUnaNuova.setForeground(Color.BLACK);
		lblAggiungiUnaNuova.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		lblAggiungiUnaNuova.setBackground(Color.GRAY);
		lblAggiungiUnaNuova.setBounds(10, 11, 672, 40);
		contentPane.add(lblAggiungiUnaNuova);
		
		JLabel lblTipologia_1 = new JLabel("CIN*:\r\n");
		lblTipologia_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTipologia_1.setBounds(20, 56, 40, 23);
		contentPane.add(lblTipologia_1);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"NATANTE", "IMBARCAZIONE", "NAVE"}));
		comboBoxTipo.setBounds(104, 120, 193, 22);
		contentPane.add(comboBoxTipo);
		comboBoxTipo.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (comboBoxTipo.getSelectedItem().toString() == "IMBARCAZIONE" || comboBoxTipo.getSelectedItem().toString() == "NATANTE")
		    	{
		    		controller.enableObject(Set.of(lblMatricola, textFieldMatricola), true);
		    		
		    	}else if (comboBoxTipo.getSelectedItem().toString() == "NAVE") {
		    		controller.enableObject(Set.of(lblMatricola, lblNumeroImo, textFieldNImo, textFieldMatricola), true);
		    	}
		    }
		});
		
		CINtext = new JTextField();
		CINtext.setBounds(104, 57, 193, 20);
		contentPane.add(CINtext);
		CINtext.setColumns(10);
		if (dati != null) {
			CINtext.setText(dati);
		}
		
		lblMatricola = new JLabel("Matricola");
		lblMatricola.setEnabled(false);
		lblMatricola.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblMatricola.setBounds(20, 158, 74, 23);
		contentPane.add(lblMatricola);
		
		lblNumeroImo = new JLabel("Numero IMO");
		lblNumeroImo.setEnabled(false);
		lblNumeroImo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNumeroImo.setBounds(20, 189, 101, 23);
		contentPane.add(lblNumeroImo);
		
		lblLarghezza = new JLabel("Larghezza:");
		lblLarghezza.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblLarghezza.setBounds(360, 120, 74, 23);
		contentPane.add(lblLarghezza);
		
		lblNumeroPersoneTrasportabili = new JLabel("Persone trasportabili:");
		lblNumeroPersoneTrasportabili.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNumeroPersoneTrasportabili.setBounds(360, 56, 147, 23);
		contentPane.add(lblNumeroPersoneTrasportabili);
		
		lblLunghezza_3 = new JLabel("Lunghezza:");
		lblLunghezza_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblLunghezza_3.setBounds(360, 86, 74, 23);
		contentPane.add(lblLunghezza_3);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setEnabled(false);
		textFieldMatricola.setColumns(10);
		textFieldMatricola.setBounds(104, 159, 193, 20);
		contentPane.add(textFieldMatricola);
		
		textFieldNImo = new JTextField();
		textFieldNImo.setEnabled(false);
		textFieldNImo.setColumns(10);
		textFieldNImo.setBounds(104, 190, 193, 20);
		contentPane.add(textFieldNImo);
		
		lunghezzaText = new JTextField();
		lunghezzaText.setColumns(10);
		lunghezzaText.setBounds(499, 87, 193, 20);
		contentPane.add(lunghezzaText);
		
		larghezzaText = new JTextField();
		larghezzaText.setColumns(10);
		larghezzaText.setBounds(499, 121, 193, 20);
		contentPane.add(larghezzaText);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(499, 57, 193, 20);
		contentPane.add(spinner);
		
		JComboBox comboBoxMotori = new JComboBox();
		comboBoxMotori.setModel(new DefaultComboBoxModel(new String[] {"REMI", "MOTORE", "VELA"}));
		comboBoxMotori.setBounds(499, 155, 193, 22);
		comboBoxMotori.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (comboBoxMotori.getSelectedItem().toString() == "MOTORE")
		    	{
		    		controller.enableObject(Set.of(lblNumeroMotori, textFieldNmotori, lblSeriale, textFieldSeriale), true);
		    		
		    	}else {
		    		controller.enableObject(Set.of(lblNumeroMotori, textFieldNmotori, lblSeriale, textFieldSeriale), false);
		    	}
		    }
		});
		contentPane.add(comboBoxMotori);
		
	
		DefaultTableModel model = new DefaultTableModel(new String[]{"Class Name", "Home work", "Due Date"}, 0);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controller.addBarca(CINtext.getText(), nomeText.getText(), comboBoxTipo.getSelectedItem().toString(),
						textFieldMatricola.getText(), textFieldNImo.getText(), 
						spinner.getValue().toString(), lunghezzaText.getText(), 
						larghezzaText.getText(), comboBoxMotori.getSelectedItem().toString(),
						textFieldNmotori.getText(), textFieldSeriale.getText())) {
						JOptionPane.showMessageDialog(frame, "Aggiunta con successo");
				}else {
					JOptionPane.showMessageDialog(frame, "Errore query");
				}
			}
		});
		btnNewButton.setBounds(603, 255, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblMotorizzazione = new JLabel("Motorizzazione:");
		lblMotorizzazione.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblMotorizzazione.setBounds(360, 155, 108, 23);
		contentPane.add(lblMotorizzazione);
		
		
		
		lblNumeroMotori = new JLabel("Numero motori:");
		lblNumeroMotori.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNumeroMotori.setEnabled(false);
		lblNumeroMotori.setBounds(360, 189, 108, 23);
		contentPane.add(lblNumeroMotori);
		
		textFieldNmotori = new JTextField();
		textFieldNmotori.setEnabled(false);
		textFieldNmotori.setColumns(10);
		textFieldNmotori.setBounds(499, 190, 193, 20);
		contentPane.add(textFieldNmotori);
		
		lblSeriale = new JLabel("Seriale motore:");
		lblSeriale.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblSeriale.setEnabled(false);
		lblSeriale.setBounds(360, 223, 108, 23);
		contentPane.add(lblSeriale);
		
		textFieldSeriale = new JTextField();
		textFieldSeriale.setEnabled(false);
		textFieldSeriale.setColumns(10);
		textFieldSeriale.setBounds(499, 224, 193, 20);
		contentPane.add(textFieldSeriale);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 289, 672, 246);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setShowGrid(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		controller.showTable(table);
		
		JLabel lblTipologia_1_1 = new JLabel("Nome:");
		lblTipologia_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTipologia_1_1.setBounds(20, 86, 40, 23);
		contentPane.add(lblTipologia_1_1);
		
		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(104, 87, 193, 20);
		contentPane.add(nomeText);
		
		btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rimuoviBarca(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
			}
		});
		btnRimuovi.setEnabled(false);
		btnRimuovi.setBounds(603, 539, 89, 23);
		contentPane.add(btnRimuovi);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedColumn() > 0) {
					btnRimuovi.setEnabled(true);
				}
			}
		});
		
	}
}
