package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","Yohan@0007");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		int u = Integer.parseInt(request.getParameter("uid"));
		 PrintWriter out = response.getWriter();
		 String uid = request.getParameter("uid");
		 String pwd = request.getParameter("pwd");
		 String fname = request.getParameter("fname");
		 String mname = request.getParameter("mname");
		 String lname = request.getParameter("lname");
		 String email = request.getParameter("email");
		 String num = request.getParameter("num");
		 PreparedStatement ps=null ;
		 int rs=0;
		 try 
		 {
			ps = con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, lname);
			ps.setString(6, email);
			ps.setString(7, num);
			
			
			
			  rs = ps.executeUpdate();
			
			if(rs > 0)
			{
				out.print("<h1>Registration  Successfull</h1>");
			}
			else
				out.print("<h1>Registration Failed</h1>");
		 }
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 
		 }
		 finally
		 {
			 try 
			 {
				 ps.close();
			 } 
			 catch (SQLException e) 
			 {
				e.printStackTrace();
			 }
			
		 }
		 
		
	}



}
