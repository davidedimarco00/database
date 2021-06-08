package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class mainView {

	private JFrame frame;
	private JTable table_barche;
	private JTable table_controlli;
	private JTable table_verbali;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView window = new mainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.RED);
		frame.setForeground(Color.CYAN);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1013, 809);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblBenvenuto = new JLabel("Benvenuto,");
		lblBenvenuto.setFont(new Font("Abyssinica SIL", Font.BOLD | Font.ITALIC, 16));
		lblBenvenuto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBenvenuto = new GridBagConstraints();
		gbc_lblBenvenuto.anchor = GridBagConstraints.LINE_START;
		gbc_lblBenvenuto.insets = new Insets(0, 0, 5, 0);
		gbc_lblBenvenuto.gridx = 0;
		gbc_lblBenvenuto.gridy = 0;
		frame.getContentPane().add(lblBenvenuto, gbc_lblBenvenuto);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 2;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panelControlli = new JPanel();
		panelControlli.setBackground(new Color(255, 255, 255));
		panelControlli.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
		tabbedPane.addTab("Controlli", null, panelControlli, null);
		panelControlli.setLayout(null);
		
		JButton btnAggiungiControllo = new JButton("Aggiungi nuovo controllo");
		btnAggiungiControllo.setBounds(812, 12, 184, 33);
		panelControlli.add(btnAggiungiControllo);
		btnAggiungiControllo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(0, 0, 802, 568);
		panelControlli.add(scrollPane_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table_controlli = new JTable();
		table_controlli.setShowVerticalLines(false);
		table_controlli.setShowHorizontalLines(false);
		table_controlli.setShowGrid(false);
		table_controlli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_controlli.setRowSelectionAllowed(false);
		table_controlli.setForeground(Color.BLACK);
		table_controlli.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane_1.setViewportView(table_controlli);
		
		JPanel panelVerbali = new JPanel();
		panelVerbali.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Verbali", null, panelVerbali, null);
		panelVerbali.setLayout(null);
		
		JButton btnAggiungiVerbale = new JButton("Aggiungi nuovo verbale");
		btnAggiungiVerbale.setBounds(814, 12, 184, 33);
		panelVerbali.add(btnAggiungiVerbale);
		btnAggiungiVerbale.setFont(new Font("Abyssinica SIL", Font.PLAIN, 12));
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(0, 0, 802, 568);
		panelVerbali.add(scrollPane_2);
		
		table_verbali = new JTable();
		scrollPane_2.setViewportView(table_verbali);
		
		JPanel panelBarche = new JPanel();
		panelBarche.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Barche", null, panelBarche, null);
		panelBarche.setLayout(null);
		
		JButton btnAggiungiBarca = new JButton("Aggiungi nuova barca");
		btnAggiungiBarca.setFont(new Font("Abyssinica SIL", Font.PLAIN, 12));
		btnAggiungiBarca.setBounds(817, 6, 184, 33);
		panelBarche.add(btnAggiungiBarca);
		
		JButton btnRimuoviBarca = new JButton("Rimuovi barca");
		btnRimuoviBarca.setFont(new Font("Abyssinica SIL", Font.PLAIN, 12));
		btnRimuoviBarca.setBounds(817, 51, 184, 33);
		panelBarche.add(btnRimuoviBarca);
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		table_barche = new JTable(data, columnNames);
		table_barche.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "Kathy", "Smith", null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "First Name", "Last Name", "New column", "New column", "New column"
			}
		));
		table_barche.setRowSelectionAllowed(false);
		table_barche.setShowGrid(false);
		JScrollPane scrollPane_3 = new JScrollPane(table_barche);
		scrollPane_3.setSize(816, 551);
		scrollPane_3.setLocation(0, 0);
		table_barche.setFillsViewportHeight(true);
		panelBarche.add(scrollPane_3);
		
		
	
	}
}
