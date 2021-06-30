package controller;


import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.swing.JTable;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;
import model.SQLUtilitiesImpl;
import view.AggiungiAziendaForm;
import view.BarcaForm;
import view.PersoneForm;

public class ControlloControllerImpl implements ControlloController {
	Model model = new ModelImpl();
	SQLUtilities sqlUtilities = new SQLUtilitiesImpl();

	@Override
	public String getNumVerbale() {
		this.sqlUtilities.connectToDatabase("SELECT MAX(codVerbale) FROM verbali", null);
		
		int numVerbale = Integer.valueOf(sqlUtilities.getValues().get(1).toString());
		return String.valueOf(numVerbale+1);
	}

	@Override
	public String getOrario() {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return String.valueOf(now.format(formatter));
	}

	@Override
	public boolean cercaBarca(String CIN) {
		String query = String.format("SELECT * FROM barche where CIN='%s'", CIN);
		System.out.println(sqlUtilities.getValues());
		if (sqlUtilities.connectToDatabase(query, null) && !sqlUtilities.getValues().isEmpty()) { //se mi torna qualcosa vuol dire che esiste la barca già nel database
			return true;
		}
		return false;
	}

	@Override
	public void showBarcaForm(String dati) {
		BarcaForm barca = new BarcaForm(dati);
		barca.setVisible(true);
		
	}

	@Override
	public void showTablePersone(JTable table, String text) {
		String query = "";
		if (text != "") {
			query = String.format("SELECT * FROM persone_fisiche where CF LIKE '%s'", text+"%");
		}else {
			query= String.format("SELECT * FROM persone_fisiche");
		}
		this.sqlUtilities.connectToDatabase(query, table);
	}

	@Override
	public void showTableAziende(JTable table, String text) {
		String query = "";
		if (text != "") {
			query = String.format("SELECT * FROM persone_giuridiche where partita_IVA LIKE '%s'", text+"%");
		}else {
			query= String.format("SELECT * FROM persone_giuridiche");
		}
		this.sqlUtilities.connectToDatabase(query, table);
	}

	@Override
	public void showPersoneForm(String dati) {
		PersoneForm form = new PersoneForm(dati);
		form.setVisible(true);
		
	}

	@Override
	public void showAggiungiAziendaForm(String text) {
		AggiungiAziendaForm form = new AggiungiAziendaForm(text);
	}

	
	// QUERIES
	@Override
	public boolean aggiungiPosizione(String latitudine, String longitudine) {
		String query = String.format("INSERT INTO POSIZIONI(longitudine, latitudine)\r\n"
				+ "VALUES('%s', '%s');", longitudine, latitudine);
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean aggiungiVerbale(String descrizione) {
		descrizione.replaceAll("'", " ");
		String query = String.format("INSERT INTO VERBALI(descrizione)"
				+ "VALUES ('%s');", descrizione);
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean aggiungiEsecuzioneVerbale(String matricole, String codVerbale) {
		String newString[] = matricole.split("\n");
		for (String matricola : newString) {
			String query = String.format("INSERT INTO esecuzione_verbali (matricola, codVerbale)\r\n"
					+ "VALUES((SELECT matricola from operatori where matricola= \'%s\' ),\r\n"
					+ "(SELECT codVerbale FROM verbali where codVerbale = \'%s\'));", matricola, codVerbale);
			try {
				this.sqlUtilities.connectToDatabase(query, null);
			}catch (Exception ex) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean aggiungiSanzione(Object importo, Object articolo, String codice) {
		String query = String.format("INSERT INTO SANZIONI(importo, articolo, codice) \r\n"
				+ "VALUES('%s', '%s', '%s')", importo.toString(), articolo.toString(), codice.toString());
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean aggiungiDefinizioneSanzione(String codVerbale, Object articolo, String codice) {
		String query = String.format("INSERT INTO definzione_sanzioni(codVerbale, articolo, codice) \r\n"
				+ "VALUES ((SELECT codVerbale FROM verbali where codVerbale = '%s'),\r\n"
				+ " (select articolo FROM sanzioni where sanzioni.articolo = '%s'), \r\n"
				+ " (select codice from sanzioni where sanzioni.codice = '%s'));",codVerbale, articolo.toString(), codice.toString());
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean identBarche(String codVerbale, String CIN) {
		String query = String.format("INSERT INTO identificazione_barche (codVerbale, CIN)\r\n"
				+ "VALUES(\r\n"
				+ "(SELECT codVerbale from verbali where codVerbale = '%s'),\r\n"
				+ "(SELECT CIN from barche where CIN = '%s'));", codVerbale, CIN);
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean aggiungiIdentPersone(String codVerbale, String codFiscali) {
		String newString[] = codFiscali.split("\n");
		System.out.println(newString.toString());
		
		for (String CF : newString) {
			String query = String.format("INSERT INTO identificazione_persone (codVerbale, CF)\r\n"
					+ "VALUES(\r\n"
					+ "(SELECT codVerbale from verbali where codVerbale = '%s'),\r\n"
					+ "(SELECT CF from persone_fisiche where CF = '%s'));", codVerbale, CF);
			try {
				this.sqlUtilities.connectToDatabase(query, null);
			}catch (Exception ex) {
				return false;
			}
		}
		return true;
		
	}

	@Override
	public boolean aggiungiIdentAziende(String codVerbale, String partiteIVA) {
		String newString[] = partiteIVA.split("\n");
		System.out.println(newString);
		
		if (partiteIVA!="") {
			for (String pIva : newString) {
				String query = String.format("INSERT INTO identificazione_aziende(codVerbale, partita_IVA)\r\n"
						+ "VALUES(\r\n"
						+ "(SELECT codVerbale from verbali where codVerbale = '%s'),\r\n"
						+ "(SELECT partita_IVA from persone_giuridiche where partita_IVA = '%s'));", codVerbale, pIva);
				try {
					this.sqlUtilities.connectToDatabase(query, null);
				}catch (Exception ex) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean aggiungiControllo(String tipologia, Date data, String ora, String latitudine,
			String longitudine, String CIN, String codVerbale) {
		
		long secs = data.getTime();
		
		 DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
		 java.sql.Time sqlTime = new java.sql.Time(0);
		 try {
			Date date = (Date)formatter.parse(ora);
			long secTime = date.getTime();
			sqlTime = new java.sql.Time(secTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlData = new java.sql.Date(secs);
		
		System.out.println("SQL DATE: "+ sqlData.toString());
		System.out.println("SQL TIME: "+ sqlTime.toString());
		
		String query = String.format("INSERT INTO controlli(tipo, `data`, ora, codVerbale, longitudine, latitudine, CIN)  \r\n"
				+ "VALUES(\'%s\', '%s', '%s', \r\n"
				+ "(SELECT codVerbale from verbali where codVerbale = \'%s\'), \r\n"
				+ "(SELECT longitudine from posizioni where longitudine = \'%s\'),\r\n"
				+ "(SELECT latitudine from posizioni where latitudine = \'%s\'),\r\n"
				+ "(SELECT CIN from barche where CIN = '%s'));",tipologia, sqlData, sqlTime, codVerbale, longitudine.toUpperCase(), latitudine.toUpperCase(), CIN);
		if (this.sqlUtilities.connectToDatabase(query, null)) {
			return true;
		}
		return false;
	}
		
	
	
	
	
}