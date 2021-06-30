package controller;


import java.util.Date;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;

public class PersoneControllerImpl implements PersoneController {
	Model model = new ModelImpl();
	SQLUtilities sqlUtilities = model.getSqlUtilities();
	
	@Override
	public boolean aggiungiPersona(String CF, String nome, String cognome, String tipo, String nazionalita, String telefono, Date data, String via, int civico, String citta) {
		long secs = data.getTime();
		java.sql.Date sqlData = new java.sql.Date(secs);
		System.out.println("SQL DATE: "+ sqlData.toString());
		
		String query = String.format("INSERT INTO persone_fisiche(`CF`, `nome`, `cognome`, `Tipologia`, `nazionalita`, `numero_telefono`, `data_di_nascita`) "
				+ "VALUES('%s','%s','%s','%s','%s','%s','%s')", CF.toUpperCase(), nome, cognome, tipo.toUpperCase(), nazionalita.toUpperCase(), telefono, sqlData );
		
		
		
		String query1 = String.format("INSERT INTO indirizzi (`CF`, `via`, `numero_civico`, `citta`) " +
				"VALUES ((SELECT CF FROM PERSONE_FISICHE WHERE CF = '%s'), '%s', %d, '%s')", CF.toUpperCase(), via, civico, citta);
		
		if (this.sqlUtilities.connectToDatabase(query, null) && 
				this.sqlUtilities.connectToDatabase(query1, null)
				
				) {
			return true;
		}
		
		return false;
	}
	
}
