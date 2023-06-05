package jdbcQuestion13;

import java.io.IOException;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String csvFile="C:/doc/DemoCsv.csv";
		
		ExtractCsv.extract(csvFile);
		
		ExtractCsv.read();
	}

}
