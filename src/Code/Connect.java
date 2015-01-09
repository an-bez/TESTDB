package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ibm.db2.jcc.am.ResultSet;

public class Connect {
	
	final static String URL = "jdbc:db2://localhost:50000/TESTDB";
	final static String USER = "db2admin";
	
	public static java.sql.Connection setConnection() {		
		
		java.sql.Connection connection = null;
		
		
		System.out.print("Enter password: ");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	   
		try {
			
			String password = bufferRead.readLine();
			
			Class.forName ("com.ibm.db2.jcc.DB2Driver");		
				connection = DriverManager.getConnection(URL,USER,password);
					
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(new JFrame(),
					"Connection: "+connection, "Error", JOptionPane.ERROR_MESSAGE);
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("<---Connected--->");
	return connection;
	}
	
	public static java.sql.ResultSet getQuery(String query) {
		
		java.sql.ResultSet result=null;
		java.sql.Statement st= null;
		try {
			st = setConnection().createStatement();
				result =st.executeQuery(query);

			
		} catch (SQLException e) {

			e.printStackTrace();
		}	
		return result;
	}
	
	public void getQuery(String name, String date, String id, String city) {
		
		int res = 0;
		try {
			
		PreparedStatement pst = setConnection().prepareStatement("insert into FROSYA.TESTTABLE(name, date, id, city) values(?,?,?,?)");
			
			pst.setString(1, name);
			pst.setString(2, date);
			pst.setString(3, id);
			pst.setString(4, city);
			
			res=pst.executeUpdate();		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Changed"+res);
			
	}
		
}
