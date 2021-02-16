package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import connect.connectionProvider;

public class userDao 
{
	public String register(User u)
	{
		Connection c= connectionProvider.getConn();
		try {
			PreparedStatement ps =c.prepareStatement("insert into tblStudent(student_name,student_dob,student_doj) values(?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getDob());
			ps.setString(3,u.getDoj());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return "Success";
			}
			return "Fail";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Fail";
		
	}
	
	
	
	public ResultSet getStudent()
	{
		ResultSet rs=null;
		Connection c= connectionProvider.getConn();
		try {
			PreparedStatement ps =c.prepareStatement("select * from tblStudent");
			
			rs=ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
