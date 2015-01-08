package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Main {
		
		public static void main(String[] args) throws IOException, SQLException  {
			
			String query="Select * from FROSYA.TESTTABLE";
			
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			
			Connect connect = new Connect();

			System.out.print("1) Select and show"+"\n"+
							 "2) Insert"+"\n"+
							 "3) Select and write into the file"+"\n"+
							 "Choose the function: ");
			
			
			
			String choose = bufferRead.readLine();
			
			
			
			switch(choose){
			
				case "1": Data.printResult(connect.getQuery(query));
				
				 break;
				
				case "2": connect.getQuery("Фрося", "2015-01-07", "555", "Изяслав");
				 
				 break;
				 
				case "3": Data.saveResult(connect.getQuery(query));
				
				 break;
			}
			
		}	
		
		
}
