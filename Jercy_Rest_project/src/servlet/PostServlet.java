package servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String doj=request.getParameter("doj");
		
		
		doGet(request, response);
		 final String USER_AGENT = "Mozilla/5.0";
		String url = "http://localhost:9090/Jercy_Rest_project/rest/student/post";
		  URL obj = new URL(url);
		  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 
		        // Setting basic post request
		  con.setRequestMethod("POST");
		  con.setRequestProperty("User-Agent", USER_AGENT);
		  con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		  con.setRequestProperty("Content-Type","application/json");
		 
		   String postJsonData = "{\"name\":\""+name+"\",\"dob\":\""+dob+"\",\"doj\":\""+doj+"\"}\r\n"
		   		+ "\r\n"
		   		+ "";
		 
		  
		  con.setDoOutput(true);
		  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		  wr.writeBytes(postJsonData);
		  wr.flush();
		  wr.close();
		 
		  int responseCode = con.getResponseCode();
		  System.out.println("nSending 'POST' request to URL : " + url);
		  System.out.println("Post Data : " + postJsonData);
		  System.out.println("Response Code : " + responseCode);
		 
		  BufferedReader in = new BufferedReader(
		          new InputStreamReader(con.getInputStream()));
		  String output;
		  StringBuffer response1 = new StringBuffer();
		 
		  while ((output = in.readLine()) != null) {
		   response1.append(output);
		  }
		  in.close();
		  response.setContentType("text/html");
		  RequestDispatcher rd=request.getRequestDispatcher("result.html");
			PrintWriter pw=response.getWriter();
			pw.print("<p>"+response1.toString()+"</p>");
			rd.include(request, response);
		  
		 // System.out.println(response1.toString());
	}

}
