package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/RegisterForm")
public class RegisterForm extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		Thread thread=new Thread();
		
		try {
			thread.sleep(3000);
			response.setContentType("text/html");
			
			PrintWriter printWriter=response.getWriter();
			
			
			printWriter.print("<html><head>");
			
			printWriter.print("<title> Servlet Register </title> </head>");
			printWriter.print("</body>");
			// getting all the incoming details from the request
			
			String name=request.getParameter("user_name");
			String password=request.getParameter("user_password");
			String email=request.getParameter("user_email");
			
			
			// connection with database using JDBC
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    
				 Connection con=DriverManager.getConnection( "jdbc:mysql://root@localhost:3306/JavaRegistrationProjServlet","root","Password@123"); //create connection 
				 
				 // Add Data 
				 
				 String addQuery="insert into RegistrationServlet(uname,upass,uemail) values (?,?,?)";
				 
				 PreparedStatement preparedStatement=con.prepareStatement(addQuery);
				 
				 preparedStatement.setString(1,name);
				 preparedStatement.setString(2, password);
				 preparedStatement.setString(3, email);
				 
				 
				 preparedStatement.executeUpdate();
				 
				 printWriter.print("<h1> Data Added Successfully...</h1>");
				 
				 printWriter.print("<a href='register.jsp'> Add New User </a>");
				 
				 printWriter.print("<br><br><br>");
				 // Show Data
				 
				 
				 String showData="select * from RegistrationServlet";
				 
				 PreparedStatement preparedStatement2=con.prepareStatement(showData);
				 
				 ResultSet resultSet=preparedStatement2.executeQuery();
				 
				    printWriter.println("<table border='1' width=100%>");
		            printWriter.println("<tr>");
		            printWriter.println("<th>Id</th>");
		            printWriter.println("<th>Name</th>");
		            printWriter.println("<th>Password</th>");
		            printWriter.println("<th>Email</th>");
		            printWriter.println("</tr>");
				 
				 
				 
				 while (resultSet.next()) {
					
					 printWriter.println("<tr>");
		                printWriter.println("<td>" + resultSet.getInt("id") + "</td>");
		                printWriter.println("<td>" + resultSet.getString("uname") + "</td>");
		                printWriter.println("<td>" + resultSet.getString("upass") + "</td>");
		                printWriter.println("<td>" + resultSet.getString("uemail") + "</td>");
		                printWriter.println("</tr>");
					 
					 
					 
				}
				 
				 printWriter.println("</table>");
				 
				 
				 
					
				
				 
				
				   
			} 
			
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				printWriter.print("<h1> Error Caught ...");
			}
			
			 
			printWriter.print("</body></html>");
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
