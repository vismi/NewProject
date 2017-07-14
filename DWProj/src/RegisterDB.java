import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

@WebServlet("/Register")
public class  RegisterDB extends HttpServlet {
private static final long serialVersionUID = 1L;



public void service1(ServletRequest request, ServletResponse response ) throws IOException, ServletException
{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	//out.println("Welcome to the first servlet home.....Vismi");
	//String Name = request.getParameter("Name");  
	String Name = "Parth";
	//String MobileNo = request.getParameter("MoblieNo");  
	String MobileNo = "81037562391";
	//String Email = request.getParameter("Email");
	String Email = "fhnukd";
	//String DOB = request.getParameter("DOB");
	String DOB = "duaaaa";
	
	
	
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/Vismita","root","root");  
		  
		PreparedStatement ps = con.prepareStatement("insert into TableSample values(?,?,?,?)");
		
		
		ps.setString(1, Name);
		ps.setString(2, Email);
		ps.setString(3, DOB);
		ps.setString(4, MobileNo);
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		      
		          
		}catch (Exception e2) {System.out.println(e2);} 
	out.close();
	
	}



}
