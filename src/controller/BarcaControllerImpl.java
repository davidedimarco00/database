package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;
import net.proteanit.sql.DbUtils;

public class BarcaControllerImpl implements BarcaController{
	private Model model = new ModelImpl();
	private SQLUtilities sqlUtilities = this.model.getSqlUtilities();
	private JTable table;
	
	@Override
	public void enableObject(Set<JComponent> objects, boolean value) {
		objects.forEach(t -> t.setEnabled(value));
	}

	@Override
	public boolean addBarca(String CIN, String nome, String tipologia,
			String matricola, String n_imo, String persone, String lunghezza, 
			String larghezza, String motorizzazione, String numero_motori, String seriale ) {
		
		String query = String.format("INSERT INTO barche(CIN, nome, tipologia, Numero_IMO, Matricola, lunghezza, larghezza, max_persone, motorizzazione) "
				+ "VALUES('%s','%s','%s','%s', '%s', %s, %s, %s, '%s')", CIN, nome, tipologia, n_imo, matricola, lunghezza, larghezza, persone, motorizzazione);
		
		System.out.println("Eseguo query: " + query);
		if (sqlUtilities.connectToDatabase(query, null)) {
			if (motorizzazione == "MOTORE") {
				String query1 = String.format("insert into motori(CIN, seriale, numero_motori) VALUES ((select CIN from barche where CIN = '%s'), '%s', %s)", CIN, seriale, numero_motori);
				sqlUtilities.connectToDatabase(query1, null);
				this.showTable(this.table);
			}
		}else {
			return false;
		}
		return true;
	}

	@Override
	public void showTable(JTable table) {
		this.table = table;
		sqlUtilities.connectToDatabase("SELECT barche.CIN, nome, tipologia, Numero_IMO, Matricola, lunghezza, larghezza, max_persone, motorizzazione, seriale, numero_motori \r\n"
				+ "from (barche left join motori on barche.CIN = motori.CIN) ", table);
	}

	@Override
	public void rimuoviBarca(String value) {
		String query = String.format("DELETE FROM barche where CIN = '%s'", value);
		sqlUtilities.connectToDatabase(query, null);
		this.showTable(this.table);
		
	}
}
