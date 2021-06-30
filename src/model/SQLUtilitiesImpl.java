package model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;


public class SQLUtilitiesImpl implements SQLUtilities {

	private Connection conn;
	Map<Integer, Object> valuesMap = new HashMap<>(); //mappa numero record -> colonna-valore
	
	@Override
	public boolean connectToDatabase(String query, JTable table) {
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/controlli_barche1?serverTimezone=UTC", "root","A87?ciaoA87*");
		    stmt = conn.prepareStatement(query);
		    ResultSet rs;
		    if (table != null) { //è una lettura da mettere in tabella
		    	rs = stmt.executeQuery(query);
		    	table.setModel(DbUtils.resultSetToTableModel(rs));
	    		while ( rs.next() ) {
	 			    int numCol =rs.getMetaData().getColumnCount();
 				    for ( int i = 1 ;i <= numCol ; i++) { 
 					    this.valuesMap.put(i, rs.getObject(i));
 				    } 
	    		}
	    		rs.close();
		    	stmt.close();
		    	conn.close();
		    	return true;
		    	
		    }
		    else { 
		    	
		    	if (query.contains("insert") || query.contains("INSERT") || query.contains("delete") || query.contains("DELETE") ) { //è un'aggiunta o una rimozione
		    		System.out.println("sono qui");
		    		stmt.executeUpdate(query);
		    		
		    		stmt.close(); 
		    		return true;
		    	} 
		    	else {                            //è una select particolare
		    		rs = stmt.executeQuery(query);
		    		while ( rs.next() ) {
		 			    int numCol =rs.getMetaData().getColumnCount();
	 				    for ( int i = 1 ; i <= numCol ; i++) { 
	 					    System.out.println( "COL" + i + "="
	 					    +rs.getObject(i));
	 					    this.valuesMap.put(i, rs.getObject(i));
	 				    } 
	 				   System.out.println( "sono qui!");
		    		}
		    		stmt.close(); 
		    		conn.close();
		    		return true;
		    	}
		    }
		    
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<Integer, Object> getValues() { //ritorna i valori eventualmente letti
		Map<Integer, Object> temp = new HashMap<>(); //creo una temporanea per spedirla indietro cosi posso svuotare i valori appena trovati
		temp.putAll(this.valuesMap);
		this.valuesMap.clear();
		return temp;
	}

}