package controller;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;

public class AggiungiAziendaControllerImpl implements AggiungiAziendaController {

	Model model = new ModelImpl();
	SQLUtilities sqlUtilities = model.getSqlUtilities();
	
	@Override
	public boolean aggiungiAzienda(String pIva, String nome ) {
		String query = String.format("INSERT INTO persone_giuridiche (partita_IVA, nome) VALUES('%s', '%s')  ", pIva, nome);
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
	}

}
