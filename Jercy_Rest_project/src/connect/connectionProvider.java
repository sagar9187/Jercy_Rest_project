package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionProvider 
{
	static String host = "free-version.caqfsrs22pzw.us-west-2.rds.amazonaws.com";
	static String user = "admin";
	static String passwd = "12345678";
	 static Connection c=null;
	private connectionProvider() 
	{
		
	}
	public static Connection getConn()
	{
		
		if(c==null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://"+ host +"/student?"
						+ "user=" + user + "&password=" + passwd);
				return c;
			}
			catch(Exception ee)
			{
				
			}
		}
		else
		{
			return c;
		}
		return c;
		
		
	}

}
