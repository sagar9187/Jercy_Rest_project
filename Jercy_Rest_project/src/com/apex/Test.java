package com.apex;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import bean.User;

import java.sql.*;
import connect.connectionProvider;
import dao.userDao;


@Path("student")
public class Test 
{
	

	User u=null;
	//APPLICATION_JSON
	@Path("post")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getRegister(String json)
	{
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement= jsonParser.parse(json);
	
		if(jsonElement.isJsonObject())
		{
			JsonObject jsonObject= jsonElement.getAsJsonObject();
			u=new User(jsonObject.get("name").getAsString(),jsonObject.get("dob").getAsString(),jsonObject.get("doj").getAsString());
		}
		
		userDao userdao=new userDao();
		String msg=userdao.register(u);
		if(msg.equals("Success"))
		{
			return "{'msg':'Success'}";
		}
		else
		{
			return "{'msg':'fail'}";
		}
		
		
	}
	
	
	@Path("get")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getStud(String json) throws SQLException
	{
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement= jsonParser.parse(json);
		
		/*if(jsonElement.isJsonObject())
		{
			JsonObject jsonObject= jsonElement.getAsJsonObject();
			u=new User(jsonObject.get("name").getAsString(),jsonObject.get("pass").getAsString());
		}
		*/
		userDao userdao=new userDao();
		ResultSet rs=userdao.getStudent();
		String demo="Student:";
		while(rs.next())
		{
			if(demo.equals("Student:"))
			{
				demo="[\n  {\n    'no':"+rs.getString(1)+",\n    'name':'"+rs.getString(2)+"',\n    'dob':'"+rs.getString(3)+"',\n    'doj':'"+rs.getString(4)+"'\n  }";
			}
			else
			{
				demo=demo+",\n  {\n    'no':"+rs.getString(1)+",\n    'name':'"+rs.getString(2)+"',\n    'dob':'"+rs.getString(3)+"',\n    'doj':'"+rs.getString(4)+"'\n  }";
			}
			
			
		}
		demo=demo+"\n]";
		
		
		return demo;
		
		
	}

}
