package model;

import javax.swing.JFrame;

public interface Model {
	SQLUtilities getSqlUtilities();
	void showForm(JFrame frame);
}
