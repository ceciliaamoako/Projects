package hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc
{
	public static void main(String[] args)
	{
		String jdbcUrl =  "jdbc:mysql://localhost:3306/hb_employee";
		String user = "hbstudent";
		String pass = "hbstudent";
		try
		{
			@SuppressWarnings("unused")
			Connection myConn = DriverManager.getConnection(jdbcUrl, user,pass);
			System.out.println("Connected");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
