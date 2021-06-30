package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.AggiungiAziendaController;
import controller.AggiungiAziendaControllerImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggiungiAziendaForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private AggiungiAziendaController controller = new AggiungiAziendaControllerImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AggiungiAziendaForm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param text 
	 */
	public AggiungiAziendaForm(String text) {
		frame = new JFrame();
		frame.setBounds(100, 100, 310, 206);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setBounds(187, 116, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPartitaIva = new JLabel("Partita IVA:");
		lblPartitaIva.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblPartitaIva.setBounds(10, 51, 81, 23);
		frame.getContentPane().add(lblPartitaIva);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 52, 175, 20);
		frame.getContentPane().add(textField);
		if (text != null) {
			textField.setEditable(false);
			textField.setText(text);
		}
		
		JLabel lblAggiungiAzienda = new JLabel("Aggiungi azienda:");
		lblAggiungiAzienda.setFont(new Font("Arial", Font.ITALIC, 21));
		lblAggiungiAzienda.setBounds(10, 11, 200, 40);
		frame.getContentPane().add(lblAggiungiAzienda);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNome.setBounds(10, 84, 81, 23);
		frame.getContentPane().add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 85, 175, 20);
		frame.getContentPane().add(textField_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controller.aggiungiAzienda(textField.getText(), textField_1.getText())) {
					JOptionPane.showMessageDialog(frame, "Azienda aggiunta correttamente");
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(frame, "Errore nell'inserimento");
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setBounds(335, 151, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
