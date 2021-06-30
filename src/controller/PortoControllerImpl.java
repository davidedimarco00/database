package controller;

import javax.swing.JTable;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;

public class PortoControllerImpl implements PortoController {
	private Model model = new ModelImpl();
	private SQLUtilities sqlUtilities = model.getSqlUtilities();
	private JTable table;
	
	
	
	@Override
	public void showTable(JTable table) {
		this.table = table;
		sqlUtilities.connectToDatabase("SELECT * FROM PORTI", table);
	}
	
	@Override
	public void addPorto(String nome, String numero_ormeggi, String localita) {
		String query = String.format("INSERT INTO porti(codLocalita, nome, numeroOrmeggi) "
				+ "VALUES ((SELECT codLocalita from localita where nome = '%s'), '%s', %s)", localita, nome.toUpperCase(), numero_ormeggi);
		sqlUtilities.connectToDatabase(query, null);
		this.showTable(this.table);
	}

	@Override
	public void rimuoviPorto(String value) {
		System.out.println(value);
		String query = String.format("DELETE FROM porti where codPorto = %s", value);
		sqlUtilities.connectToDatabase(query, null);
		this.showTable(this.table);
		
	}
}
