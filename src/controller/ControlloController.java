package controller;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;

public interface ControlloController {
	String getNumVerbale();
	String getOrario();
	boolean cercaBarca(String CIN);
	void showBarcaForm(String dati);
	void showPersoneForm(String string);
	void showTablePersone(JTable table, String text);
	void showTableAziende(JTable table, String text);
	void showAggiungiAziendaForm(String text);
	
	boolean aggiungiPosizione(String latitudine, String longitudine);
	boolean aggiungiVerbale(String descrizione);
	boolean aggiungiEsecuzioneVerbale(String matricola, String codVerbale);
	boolean aggiungiSanzione(Object importo, Object articolo, String codice);
	boolean aggiungiDefinizioneSanzione(String codVerbale, Object articolo, String codice);
	boolean identBarche(String codVerbale, String CIN);
	boolean aggiungiIdentPersone(String codVerbale, String codFiscali);
	boolean aggiungiIdentAziende(String codVerbale, String partiteIVA);
	boolean aggiungiControllo(String tipologia, Date data, String ora, String latitudine, String longitudine, String CIN,
			String codVerbale);
}
