package controller;

import javax.swing.JTable;

public interface PortoController {

	void showTable(JTable table);

	void addPorto(String nome, String numero_ormeggi, String località);

	void rimuoviPorto(String value);

}
