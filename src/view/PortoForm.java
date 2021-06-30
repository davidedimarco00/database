package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.PortoController;
import controller.PortoControllerImpl;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PortoForm extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private PortoController controller = new PortoControllerImpl();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortoForm frame = new PortoForm();
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
	public PortoForm() {
		setTitle("Aggiungi nuovo porto");
		setBounds(100, 100, 354, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAggiungiUnaNuova = new JLabel("Aggiungi nuovo porto");
		lblAggiungiUnaNuova.setBounds(5, 5, 661, 32);
		lblAggiungiUnaNuova.setHorizontalAlignment(SwingConstants.LEFT);
		lblAggiungiUnaNuova.setForeground(Color.BLACK);
		lblAggiungiUnaNuova.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		lblAggiungiUnaNuova.setBackground(Color.GRAY);
		contentPane.add(lblAggiungiUnaNuova);
		
		JLabel lblTipologia_1 = new JLabel("Nome porto:");
		lblTipologia_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTipologia_1.setBounds(15, 47, 116, 23);
		contentPane.add(lblTipologia_1);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(141, 48, 193, 20);
		contentPane.add(textNome);
		
		JLabel lblTipologia_1_1 = new JLabel("Numero ormeggi:");
		lblTipologia_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTipologia_1_1.setBounds(15, 81, 123, 23);
		contentPane.add(lblTipologia_1_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(141, 82, 193, 20);
		contentPane.add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 180, 324, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
		
		this.controller.showTable(table);
		
		JLabel lblTipologia_1_1_1 = new JLabel("Localit\u00E0:");
		lblTipologia_1_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblTipologia_1_1_1.setBounds(15, 115, 123, 23);
		contentPane.add(lblTipologia_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"RIMINI", "RAVENNA", "CESENATICO", "PESARO", "MARINA DI RAVENNA"}));
		comboBox.setBounds(141, 113, 193, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addPorto(textNome.getText(), spinner.getValue().toString(), comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setBounds(242, 146, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rimuoviPorto(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
			}
		});
		btnRimuovi.setBounds(245, 458, 89, 23);
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
