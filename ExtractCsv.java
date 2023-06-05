package jdbcQuestion13;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class ExtractCsv {

	public static void extract(String csvDemo) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		FileReader file =new FileReader(csvDemo);
		
		BufferedReader br = new BufferedReader(file);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc","root","1234");
		
		PreparedStatement stmt = c.prepareStatement( "insert into student (id,name,city) values(?,?,?);");
		
		c.setAutoCommit(false);
		
		
		String line="";
		String delimiter=",";
		
		String arr[];
		
		while((line=br.readLine())!=null){
			
			arr=line.split(delimiter);
			
//			for(String e:arr) {
//				
//				
//				System.out.print(e +" ");	
//				
//			}
			
			stmt.setString(1,arr[0]);
			stmt.setString(2,arr[1]);
			stmt.setString(3,arr[2]);
			stmt.addBatch();
			
			//Dao.insert(arr);
			
		}
		
			stmt.executeBatch();
		
		c.commit();
		
	}
	
	public static void read() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc","root","1234");
		
		PreparedStatement stmt = c.prepareStatement( "select * from student");
		
		ResultSet r =stmt.executeQuery();
		
		while(r.next()) {
			
			System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3));
			
		}
		
		
		
	}

}
