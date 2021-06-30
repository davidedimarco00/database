package controller;

import java.util.Date;

public interface PersoneController {

	boolean aggiungiPersona(String CF, String nome, String cognome, String tipo, String nazionalita, String telefono,
			Date data, String via, int civico, String citta);
}
