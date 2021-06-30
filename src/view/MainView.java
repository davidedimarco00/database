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
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.table.TableColumn;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.MainControllerImpl;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainView {

	private JFrame frmDatabaseBarcheControlli;
	private final MainControllerImpl controller = new MainControllerImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmDatabaseBarcheControlli.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabaseBarcheControlli = new JFrame();
		frmDatabaseBarcheControlli.setTitle("Database barche controlli");
		frmDatabaseBarcheControlli.setResizable(false);
		frmDatabaseBarcheControlli.setBounds(100, 100, 1013, 809);
		frmDatabaseBarcheControlli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanelWithBackground("resources/images/sea.jpg", 1700, 800);
		frmDatabaseBarcheControlli.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new BorderLayout());
		
		JPanel lateralPanel = new JPanel();
		panel1.add(lateralPanel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Nuovo controllo...");
		btnNewButton.setBackground(new Color(255, 239, 213));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showForm(new ControlloForm());
			}
		});
		
		btnNewButton.setFont(new Font("Linux Libertine Display G", Font.BOLD, 22));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(59, 83, 225, 165);
		lateralPanel.setLayout(null);
		
		lateralPanel.add(btnNewButton);
		lateralPanel.setOpaque(false);
		
		JButton btnNewButton_2 = new JButton("Nuova barca...");
		btnNewButton_2.setBackground(new Color(255, 239, 213));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showForm(new BarcaForm(null));
			}
		});
		btnNewButton_2.setFont(new Font("Linux Libertine Display G", Font.BOLD, 22));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(407, 83, 225, 165);
		lateralPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Funzioni");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showForm(new FunzioniForm());
			}
		});
		btnNewButton_3.setBackground(new Color(255, 239, 213));
		btnNewButton_3.setFont(new Font("Linux Libertine Display G", Font.BOLD, 22));
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(59, 296, 225, 165);
		lateralPanel.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Nuovo porto...");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showForm(new PortoForm());
			}
		});
		btnNewButton_5.setBackground(new Color(255, 239, 213));
		btnNewButton_5.setFont(new Font("Linux Libertine Display G", Font.BOLD, 22));
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setBounds(746, 83, 225, 165);
		lateralPanel.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Benvenuto,");
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 21));
		lblNewLabel.setBounds(32, 11, 981, 40);
		lateralPanel.add(lblNewLabel);

	}
	
	
	public class JPanelWithBackground extends JPanel {

		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image backgroundImage;
		private int x;
		private int y;
		  public JPanelWithBackground(String fileName, int x, int y) {
			  this.x = x;
			  this.y = y;
		    try {
				backgroundImage = ImageIO.read(new File(fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(backgroundImage.getScaledInstance(this.x, this.y, Image.SCALE_SMOOTH), 0, 0, this);
		  }
		}
}


