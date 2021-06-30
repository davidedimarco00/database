package model;

import java.sql.ResultSet;
import java.util.Map;

import javax.swing.JTable;

public interface SQLUtilities {
	boolean connectToDatabase(String query, JTable table);

	 Map<Integer, Object> getValues();

}
