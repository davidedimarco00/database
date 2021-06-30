package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import com.toedter.calendar.JCalendar;

import controller.ControlloController;
import controller.ControlloControllerImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;

public class ControlloForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLat;
	private JTextField textFieldLong;
	private JTextField textCIN;
	private ControlloController controller = new ControlloControllerImpl();
	private static ControlloForm frame;
	private JTable tablePersone;
	private JTable tableAziende;
	private JTextField textFieldCF;
	private JTextField textField_1;
	private JTextField textFieldPIVA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ControlloForm();
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
	public ControlloForm() {
		setTitle("Aggiungi nuovo controllo");
		setBounds(100, 100, 899, 913);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblControllo = new JLabel("Controllo:");
		lblControllo.setFont(new Font("Arial", Font.ITALIC, 21));
		lblControllo.setBounds(10, 11, 121, 40);
		contentPane.add(lblControllo);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblData.setBounds(20, 62, 40, 23);
		contentPane.add(lblData);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"ORDINARIO", "POLIZIA"}));
		comboBoxTipo.setBounds(60, 130, 254, 22);
		contentPane.add(comboBoxTipo);
		
		JLabel lblTIpo = new JLabel("Tipo");
		lblTIpo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTIpo.setBounds(20, 130, 40, 23);
		contentPane.add(lblTIpo);
		
		JLabel lblOrat = new JLabel("Ora:");
		lblOrat.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblOrat.setBounds(20, 96, 40, 23);
		contentPane.add(lblOrat);
		
		JLabel lblOra = new JLabel("00:00");
		lblOra.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblOra.setBounds(60, 96, 242, 23);
		contentPane.add(lblOra);
		
		JLabel lblLatitudine = new JLabel("Latitudine");
		lblLatitudine.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblLatitudine.setBounds(20, 201, 73, 23);
		contentPane.add(lblLatitudine);
		
		JLabel lblLongitudine = new JLabel("Longitudine");
		lblLongitudine.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblLongitudine.setBounds(20, 235, 80, 23);
		contentPane.add(lblLongitudine);
		
		textFieldLat = new JTextField();
		textFieldLat.setBounds(101, 201, 86, 20);
		contentPane.add(textFieldLat);
		textFieldLat.setColumns(10);
		
		textFieldLong = new JTextField();
		textFieldLong.setBounds(101, 235, 86, 20);
		contentPane.add(textFieldLong);
		textFieldLong.setColumns(10);
		
		JLabel label = new JLabel("Esempio: N 41\u00B0 53'");
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		label.setBounds(197, 201, 121, 23);
		contentPane.add(label);
		
		JLabel label2 = new JLabel("Esempio:  E 12\u00B0 29' ");
		label2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		label2.setBounds(197, 235, 153, 23);
		contentPane.add(label2);
		
		JLabel lblPosizione = new JLabel("Posizione:");
		lblPosizione.setFont(new Font("Arial", Font.ITALIC, 21));
		lblPosizione.setBounds(10, 163, 121, 40);
		contentPane.add(lblPosizione);
		
		JLabel lblBarca = new JLabel("Barca controllata:");
		lblBarca.setFont(new Font("Arial", Font.ITALIC, 21));
		lblBarca.setBounds(10, 269, 177, 40);
		contentPane.add(lblBarca);
		
		textCIN = new JTextField();
		textCIN.setColumns(10);
		textCIN.setBounds(60, 320, 155, 20);
		contentPane.add(textCIN);
		
		JLabel lblCin = new JLabel("CIN:");
		lblCin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCin.setBounds(20, 319, 40, 23);
		contentPane.add(lblCin);
		
		
		lblOra.setText(controller.getOrario());
		
		JPanel panel = new JPanel();
		panel.setBounds(395, 330, 446, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblVerbale_1 = new JLabel("Contestazione:");
		lblVerbale_1.setBounds(0, 0, 200, 40);
		panel.add(lblVerbale_1);
		lblVerbale_1.setFont(new Font("Arial", Font.ITALIC, 21));
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCodice.setBounds(27, 81, 133, 23);
		panel.add(lblCodice);
		
		JComboBox comboBoxCodice = new JComboBox();
		comboBoxCodice.setModel(new DefaultComboBoxModel(new String[] {"CODICE PENALE", "CODICE CIVILE", "CODICE NAUTICA DA DIPORTO", "CODICE POLIZIA AMBIENTALE", "LEGGE SPECIALE"}));
		comboBoxCodice.setBounds(168, 81, 278, 22);
		panel.add(comboBoxCodice);
		
		JLabel lblArticolo = new JLabel("Articolo/Numero legge:");
		lblArticolo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblArticolo.setBounds(27, 115, 159, 23);
		panel.add(lblArticolo);
		
		JSpinner spinnerArticolo = new JSpinner();
		spinnerArticolo.setBounds(192, 114, 254, 20);
		panel.add(spinnerArticolo);
		
		JLabel lblImporto = new JLabel("Importo:");
		lblImporto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblImporto.setBounds(27, 149, 78, 23);
		panel.add(lblImporto);
		
		JLabel lblImporto_1 = new JLabel("\u20AC");
		lblImporto_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblImporto_1.setBounds(181, 145, 17, 23);
		panel.add(lblImporto_1);
		
		JSpinner spinner_importo = new JSpinner();
		spinner_importo.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spinner_importo.setBounds(192, 145, 254, 20);
		panel.add(spinner_importo);
		
		JLabel lblVerbale = new JLabel("Verbale n\u00B0:");
		lblVerbale.setBounds(395, 11, 109, 40);
		contentPane.add(lblVerbale);
		lblVerbale.setFont(new Font("Arial", Font.ITALIC, 21));
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(427, 62, 80, 23);
		contentPane.add(lblDescrizione);
		lblDescrizione.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblverbalenum = new JLabel("lblVerbaleNum");
		lblverbalenum.setBounds(514, 11, 162, 40);
		contentPane.add(lblverbalenum);
		lblverbalenum.setFont(new Font("Arial", Font.ITALIC, 21));
		lblverbalenum.setText(this.controller.getNumVerbale());
		
		JTextArea textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setBounds(507, 66, 338, 133);
		contentPane.add(textAreaDescrizione);
		
		JComboBox comboBoxMatricola = new JComboBox();
		comboBoxMatricola.setBounds(571, 210, 73, 22);
		contentPane.add(comboBoxMatricola);
		comboBoxMatricola.setModel(new DefaultComboBoxModel(new String[] {"1245", "3589", "1745", "9865", "8899", "5541"}));
		
		JLabel lblMatricola = new JLabel("Matricola operatore/i:");
		lblMatricola.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblMatricola.setBounds(428, 210, 133, 23);
		contentPane.add(lblMatricola);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				rdbtnNo.setSelected(false);
			}
		});
		rdbtnSi.setBounds(568, 286, 109, 23);
		contentPane.add(rdbtnSi);
		
		JLabel lblSanzionato = new JLabel("Sanzionato:");
		lblSanzionato.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblSanzionato.setBounds(427, 285, 133, 23);
		contentPane.add(lblSanzionato);
		
		
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				rdbtnSi.setSelected(false);
			}
		});
		rdbtnNo.setBounds(679, 286, 109, 23);
		contentPane.add(rdbtnNo);
		
		JButton btnNewButton_1 = new JButton("Ricerca");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCIN.getText() != "" && textCIN.getText().length() == 15) {
					if (controller.cercaBarca(textCIN.getText())) {
						JOptionPane.showMessageDialog(frame, "Barca trovata nel database");
					}else {
						JOptionPane.showMessageDialog(frame, "La barca non è stata trovata nel database. Per proseguire è necessario aggiungerla");
						controller.showBarcaForm(textCIN.getText());
					}
				}else {
					JOptionPane.showMessageDialog(frame, "CIN non valido");
				}
			}
		});
		btnNewButton_1.setBounds(225, 319, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblIdentificazioni = new JLabel("Identificazioni:");
		lblIdentificazioni.setFont(new Font("Arial", Font.ITALIC, 21));
		lblIdentificazioni.setBounds(10, 512, 153, 40);
		contentPane.add(lblIdentificazioni);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 576, 539, 147);
		contentPane.add(scrollPane);
		
	
		
		tablePersone = new JTable();
		scrollPane.setViewportView(tablePersone);
		tablePersone.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tablePersone.setShowVerticalLines(false);
		tablePersone.setShowHorizontalLines(false);
		tablePersone.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePersone.setShowGrid(false);
		tablePersone.getTableHeader().setReorderingAllowed(false);
		tablePersone.setFillsViewportHeight(true);
		tablePersone.setRowHeight(20);
		tablePersone.setBackground(Color.WHITE);
		
		scrollPane.setViewportView(tablePersone);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(569, 576, 177, 147);
		contentPane.add(scrollPane_1);
		
		tableAziende = new JTable();
		scrollPane_1.setViewportView(tableAziende);
		scrollPane.setViewportView(tablePersone);
		tableAziende.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableAziende.setShowVerticalLines(false);
		tableAziende.setShowHorizontalLines(false);
		tableAziende.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAziende.setShowGrid(false);
		tableAziende.getTableHeader().setReorderingAllowed(false);
		tableAziende.setFillsViewportHeight(true);
		tableAziende.setRowHeight(20);
		tableAziende.setBackground(Color.WHITE);
		scrollPane.setViewportView(tablePersone);
		this.controller.showTablePersone(tablePersone, "");
		this.controller.showTableAziende(tableAziende, "");
		

		JButton btnidentifica = new JButton("Identifica persona");
		btnidentifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showPersoneForm(textFieldCF.getText());
			}
		});
		btnidentifica.setEnabled(false);
		btnidentifica.setBounds(225, 548, 141, 23);
		contentPane.add(btnidentifica);
		
		
	
		JLabel lblCf = new JLabel("CF:");
		lblCf.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCf.setBounds(20, 548, 40, 23);
		contentPane.add(lblCf);
		
		textFieldCF = new JTextField();
		textFieldCF.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  find();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  find();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  find();
			  }

			  public void find() {
				System.out.println(tablePersone.getRowCount());
			    controller.showTablePersone(tablePersone, textFieldCF.getText());
			    if (textFieldCF.getText().length() == 16 && tablePersone.getRowCount() == 0) { //se e stato inserito un codice fiscale
					  btnidentifica.setEnabled(true);
				  }else {
					  btnidentifica.setEnabled(false);
				  }
			  }
			});
		
		textFieldCF.setColumns(10);
		textFieldCF.setBounds(60, 549, 155, 20);
		contentPane.add(textFieldCF);
		
		JLabel lblCin_1_1 = new JLabel("P. IVA:");
		lblCin_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblCin_1_1.setBounds(556, 548, 50, 23);
		contentPane.add(lblCin_1_1);
		
		JButton btnidentificaiva = new JButton("Identifica azienda");
		textField_1 = new JTextField();
		btnidentificaiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showAggiungiAziendaForm(textField_1.getText());
			}
		});
		btnidentificaiva.setEnabled(false);
		btnidentificaiva.setBounds(717, 548, 145, 23);
		contentPane.add(btnidentificaiva);
		
		textFieldPIVA = new JTextField();
		textFieldPIVA.setColumns(10);
		textFieldPIVA.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  find();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  find();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  find();
			  }

			  public void find() {
			    controller.showTableAziende(tableAziende, textField_1.getText());
			    if (textField_1.getText().length() == 11 && tableAziende.getRowCount() == 0) { //se e stato inserito una partita iva
					  btnidentificaiva.setEnabled(true);
				  }else {
					  btnidentificaiva.setEnabled(false);
				  }
			  }
			  
			});
		textFieldPIVA.setBounds(603, 549, 109, 20);
		contentPane.add(textFieldPIVA);
		
		ScrollPane scrollPane_2 = new ScrollPane();
		scrollPane_2.setBounds(106, 729, 260, 100);
		contentPane.add(scrollPane_2);
		JTextArea textAreaCF = new JTextArea();
		textAreaCF.setEditable(false);
		scrollPane_2.add(textAreaCF);
		textAreaCF.setBounds(101, 733, 256, 96);
		
		JTextArea textAreaIVA = new JTextArea();
		textAreaIVA.setEditable(false);
		textAreaIVA.setForeground(Color.BLACK);
		textAreaIVA.setBounds(756, 574, 106, 147);
	
		
		ScrollPane scrollPane_3 = new ScrollPane();
		scrollPane_3.setBounds(762, 576, 100, 147);
		contentPane.add(scrollPane_3);
		scrollPane_3.add(textAreaIVA);
		
		JButton btnAggiungiSelezionati = new JButton("Aggiungi selezionato/i");
		btnAggiungiSelezionati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int  i = 0; i < tablePersone.getSelectedRowCount();i++) {
					
					if (!textAreaCF.getText().contains((String) tablePersone.getValueAt(tablePersone.getSelectedRow(), 0))) {
						textAreaCF.setText(textAreaCF.getText() + tablePersone.getValueAt(tablePersone.getSelectedRow(), 0) +"\n");
					}
					
				}
			}
		});
		btnAggiungiSelezionati.setEnabled(false);
		btnAggiungiSelezionati.setBounds(372, 734, 177, 23);
		contentPane.add(btnAggiungiSelezionati);
		
		JButton btnAggiungiSelIva = new JButton("Aggiungi selezionato");
		btnAggiungiSelIva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int  i = 0; i < tableAziende.getSelectedRowCount();i++) {
					if (!textAreaIVA.getText().contains((String) tableAziende.getValueAt(tableAziende.getSelectedRow(), 0))) {
						textAreaIVA.setText(textAreaIVA.getText() + tableAziende.getValueAt(tableAziende.getSelectedRow(), 0) +"\n");
					}
					
				}
			}
		});
		btnAggiungiSelIva.setEnabled(false);
		btnAggiungiSelIva.setBounds(569, 734, 177, 23);
		contentPane.add(btnAggiungiSelIva);
		
		JLabel lblUnoPerRiga = new JLabel("Uno per riga");
		lblUnoPerRiga.setFont(new Font("Arial", Font.PLAIN, 9));
		lblUnoPerRiga.setBounds(104, 823, 111, 23);
		contentPane.add(lblUnoPerRiga);
		
		JLabel lblUnoPerRiga_1 = new JLabel("Uno per riga");
		lblUnoPerRiga_1.setFont(new Font("Arial", Font.PLAIN, 9));
		lblUnoPerRiga_1.setBounds(769, 721, 93, 23);
		contentPane.add(lblUnoPerRiga_1);
	
		
		
		tablePersone.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tablePersone.getSelectedRowCount() > 0) {
					btnAggiungiSelezionati.setEnabled(true);
				}else {
					btnAggiungiSelezionati.setEnabled(false);
				}
			}
			
		});
		
		tableAziende.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableAziende.getSelectedRowCount() > 0) {
					btnAggiungiSelIva.setEnabled(true);
				}else {
					btnAggiungiSelIva.setEnabled(false);
				}
			}
			
		});
		
		
		JSpinner spinnerData = new JSpinner();
		spinnerData.setModel(new SpinnerDateModel(new Date(1624226400000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerData.setBounds(60, 63, 254, 20);
		contentPane.add(spinnerData);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerData, "dd/MM/yy");
	    spinnerData.setEditor(editor);
	    
	    ScrollPane scrollPaneOp = new ScrollPane();
		scrollPaneOp.setBounds(746, 210, 86, 57);
		contentPane.add(scrollPaneOp);
		JTextArea textAreaOperatori = new JTextArea();
		textAreaOperatori.setBounds(769, 234, 5, 22);
		scrollPaneOp.add(textAreaOperatori);
	    
	    JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						controller.aggiungiPosizione(textFieldLat.getText(), textFieldLong.getText());
						controller.aggiungiVerbale(textAreaDescrizione.getText());
						
						controller.aggiungiEsecuzioneVerbale(textAreaOperatori.getText(), lblverbalenum.getText());
						
						if (rdbtnSi.isSelected()) { //se e stata effettuata una sanzione allora aggiungo anche la sanzione
							controller.aggiungiSanzione(spinner_importo.getValue(), spinnerArticolo.getValue(), 
									comboBoxCodice.getSelectedItem().toString());
							controller.aggiungiDefinizioneSanzione(lblverbalenum.getText(), spinnerArticolo.getValue(), 
									comboBoxCodice.getSelectedItem().toString());
						}
						controller.identBarche(lblverbalenum.getText(), textCIN.getText());
						
						if (textAreaIVA.getText() != "") {
							controller.aggiungiIdentAziende(lblverbalenum.getText(), textAreaIVA.getText());
						}
						
						if (textAreaCF.getText() != "") {
							controller.aggiungiIdentPersone(lblverbalenum.getText(), textAreaCF.getText());
						}
						
						
						controller.aggiungiControllo(comboBoxTipo.getSelectedItem().toString(), (Date)spinnerData.getValue(), 
								lblOra.getText(), textFieldLat.getText(), textFieldLong.getText(), textCIN.getText(), lblverbalenum.getText());
		}
		});
		
		
		
		btnNewButton.setBounds(717, 823, 145, 40);
		contentPane.add(btnNewButton);
		
		
		JButton btnAggiungiOp = new JButton("Aggiungi");
		btnAggiungiOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textAreaOperatori.getText().contains(comboBoxMatricola.getSelectedItem().toString())) {
					textAreaOperatori.setText(textAreaOperatori.getText() + comboBoxMatricola.getSelectedItem().toString() +"\n");
				}
			}
		});
		btnAggiungiOp.setEnabled(true);
		btnAggiungiOp.setBounds(654, 210, 86, 23);
		contentPane.add(btnAggiungiOp);
		
		
		
		
	
		
	}
}
