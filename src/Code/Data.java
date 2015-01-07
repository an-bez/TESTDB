package Code;

import java.sql.SQLException;

import com.ibm.db2.jcc.am.ResultSet;

public class Data {
	
public static void printResult (java.sql.ResultSet result) throws SQLException {
		
		java.sql.ResultSetMetaData rsmd = result.getMetaData();
	
			while(result.next()){
			
			for (int i=0; i<rsmd.getColumnCount(); i++){
				
			System.out.print( result.getString(i+1)+"\t");
			}
			System.out.print("\n");	
			}
			
	}
}
