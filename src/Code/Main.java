package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Main {

		public static void main(String[] args)  {
			
			Connect connect = new Connect();
			connect.getQuery("Фрося", "2015-01-07", "555", "Изяслав");
			connect.getQuery("Select * from FROSYA.TESTTABLE");
	
	}	
}
