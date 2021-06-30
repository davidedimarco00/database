package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FunzioniController;
import controller.FunzioniControllerImpl;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FunzioniForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private FunzioniController controller = new FunzioniControllerImpl();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunzioniForm frame = new FunzioniForm();
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
	public FunzioniForm() {
		setTitle("Funzioni");
		setBounds(100, 100, 590, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 164, 560, 606);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setShowGrid(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VISUALIZZA CONTROLLI EFFETTUATI SU UNA BARCA", "VISUALIZZA INFORMAZIONI SU VERBALE", "VISUALIZZARE I VERBALI DI UNA BARCA", "VISUALIZZARE CONTROLLI IN UN ANNO"}));
		comboBox.setBounds(134, 57, 364, 22);
		contentPane.add(comboBox);
		
		JLabel lblFunzioni = new JLabel("Funzioni:");
		lblFunzioni.setHorizontalAlignment(SwingConstants.LEFT);
		lblFunzioni.setForeground(Color.BLACK);
		lblFunzioni.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		lblFunzioni.setBackground(Color.GRAY);
		lblFunzioni.setBounds(10, 11, 183, 40);
		contentPane.add(lblFunzioni);
		
		JLabel lblOperazione = new JLabel("Operazione:");
		lblOperazione.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblOperazione.setBounds(16, 57, 83, 23);
		contentPane.add(lblOperazione);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 91, 587, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(124, 11, 207, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblOp = new JLabel("CIN");
		lblOp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblOp.setBounds(10, 10, 104, 23);
		panel.add(lblOp);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedIndex()) {
				case 0:
					lblOp.setText("CIN");
					break;
				case 1:
					lblOp.setText("COD. VERBALE");
					break;
				case 2:
					lblOp.setText("CIN");
					break;
				case 3:
					lblOp.setText("ANNO");
					break;
					
				}
			}
		});
		
		JButton btnNewButton = new JButton("Esegui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					controller.showTable(table, 0, textField.getText());
				}
				
				if (comboBox.getSelectedIndex() == 1) {
					controller.showTable(table, 1, textField.getText());
				}
				if (comboBox.getSelectedIndex() == 2) {
					controller.showTable(table, 2, textField.getText());
				}
				if (comboBox.getSelectedIndex() == 3) {
					controller.showTable(table, 3, textField.getText());
				}
				
				
			}
		});
		btnNewButton.setBounds(341, 10, 89, 23);
		panel.add(btnNewButton);
	}
}
