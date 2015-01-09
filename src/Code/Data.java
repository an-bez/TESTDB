package Code;

import java.sql.SQLException;
import java.util.ArrayList;

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

public static void saveResult(java.sql.ResultSet result) throws SQLException {
	
	java.sql.ResultSetMetaData rsmd = result.getMetaData();
	ArrayList<String> resultArray = new ArrayList<String>();
	
	while(result.next()){
		
		for (int i=1; i<=rsmd.getColumnCount(); i++){
			
			resultArray.add(i-1,result.getString(i));
			
		}

	}
	
	System.out.print("Writed");

	}
}
