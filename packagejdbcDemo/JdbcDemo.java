package packagejdbcDemo;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcDemo {

	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");  
		System.out.println("connection established");
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from reg");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));  
		con.close();  
		}
	catch(Exception e)
		{
			System.out.println("connection not established");
		}  
		}  
		}  
