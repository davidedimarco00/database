package controller;

import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface BarcaController {
	void enableObject(Set<JComponent> objects, boolean value);
	void showTable(JTable table);
	
	boolean addBarca(String CIN, String nome, String tipologia, String matricola, String n_imo, String persone,
			String lunghezza, String larghezza, String motorizzazione, String numero_motori, String seriale);

	void rimuoviBarca(String valueOf);
}
