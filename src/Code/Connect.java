package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ibm.db2.jcc.am.ResultSet;

public class Connect {
	
	final String URL = "jdbc:db2://localhost:50000/TESTDB";
	final String USER = "db2admin";
	
	public java.sql.Statement setConnection() {		
		
		java.sql.Connection connection = null;
		java.sql.Statement st= null;
		
		System.out.print("Enter password: ");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	   
		try {
			
			String password = bufferRead.readLine();
			
			Class.forName ("com.ibm.db2.jcc.DB2Driver");		
				connection = DriverManager.getConnection(URL,USER,password);
					st = connection.createStatement();
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(new JFrame(),
					"Connection: "+connection, "Error", JOptionPane.ERROR_MESSAGE);
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	return st;
	}
	

	public void getQuery(String query) {
		
		java.sql.ResultSet result=null;
		
		try {
			
			result = setConnection().executeQuery(query);
			Data.printResult(result);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}	

	}
	
	public void getQuery(String name, String date, String id, String city) {
		
		
		try {
			
			setConnection().executeUpdate(
					"insert into FROSYA.TESTTABLE(name, date, id, city) values('"+name+"','"+date+"','"+id+"','"+city+"')");		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Changed");
			
	}
	
	
	
	

		
}
