package subjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoreJava
 */
@WebServlet(
		urlPatterns = { "/java" }, 
		initParams = { 
				@WebInitParam(name = "Subject", value = "Core-Java")
		})
public class CoreJava extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		//either in the same class or super classes
		ServletConfig config = this.getServletConfig();
		String subject = config.getInitParameter("Subject");
		
		ServletContext ctx = getServletContext();
		String provider = ctx.getInitParameter("provider");
		
		out.println("Training on "+subject+" by "+provider);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
