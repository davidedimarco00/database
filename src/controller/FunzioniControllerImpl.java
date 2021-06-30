package controller;

import javax.swing.JTable;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;
import model.SQLUtilitiesImpl;

public class FunzioniControllerImpl implements FunzioniController {
	
	Model model = new ModelImpl();
	SQLUtilities sqlUtilities = model.getSqlUtilities();
	
	@Override
	public void showTable(JTable table, int operation, String text) {
		String query = "";
		switch (operation) {
		case 0:
			query = String.format("SELECT * FROM controlli WHERE CIN = '%s'", text);
			this.sqlUtilities.connectToDatabase(query, table);
			break;
		case 1:
			System.out.println("SONO QUI");
			query = String.format("SELECT verbali.codVerbale, verbali.descrizione, sanzioni.codice, sanzioni.articolo, sanzioni.importo, identificazione_barche.CIN, \r\n"
			+ "GROUP_CONCAT(DISTINCT operatori.matricola) as matricola_operatori  , GROUP_CONCAT(DISTINCT operatori.cognome) as cognome_operatore, identificazione_aziende.partita_IVA, GROUP_CONCAT(DISTINCT CF) as CF_identificati\r\n"
			+ "FROM verbali \r\n"
			+ "LEFT JOIN definzione_sanzioni ON verbali.codVerbale = definzione_sanzioni.codVerbale\r\n"
			+ "LEFT JOIN sanzioni ON sanzioni.articolo = definzione_sanzioni.articolo AND sanzioni.codice = definzione_sanzioni.codice\r\n"
			+ "LEFT JOIN identificazione_barche ON verbali.codVerbale = identificazione_barche.codVerbale\r\n"
			+ "LEFT JOIN esecuzione_verbali ON esecuzione_verbali.codVerbale = verbali.codVerbale\r\n"
			+ "LEFT JOIN operatori ON esecuzione_verbali.matricola = operatori.matricola\r\n"
			+ "LEFT JOIN identificazione_aziende ON verbali.codVerbale = identificazione_aziende.codVerbale\r\n"
			+ "LEFT JOIN identificazione_persone ON verbali.codVerbale = identificazione_persone.codVerbale\r\n"
			+ "WHERE verbali.codVerbale = \"%s\"; \r\n", text);
			sqlUtilities.connectToDatabase(query,table);
			break;
		case 2:
			System.out.println(text);
			query = String.format("SELECT identificazione_barche.codVerbale, CIN, descrizione FROM (identificazione_barche join verbali on identificazione_barche.codVerbale = verbali.codVerbale)"
					+ "WHERE CIN = '%s';", text);
			this.sqlUtilities.connectToDatabase(query, table);
			break;
		case 3:
			query = String.format("SELECT * FROM CONTROLLI where `data` >= '%s-01-01' AND `data` <= '%s-12-31'", text, text);
			this.sqlUtilities.connectToDatabase(query, table);
			break;
			
		}
	}
}
