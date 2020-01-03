package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String password=request.getParameter("password");	
		HttpSession session=request.getSession();
		RequestDispatcher rd = null ;
		if(user.isEmpty()||password.isEmpty())
		{
			out.println("<font color=red>username/password should not be empty</font>");
			rd=request.getRequestDispatcher("form.html");
			rd.include(request,response);
		}
		else{
		if(user.equals("admin")){
			if(password.equals("admin")){		
			session.setAttribute("loginStatus","yes");			
			rd=request.getRequestDispatcher("Admin");
			rd.forward(request, response);
			//response.sendRedirect("http://www.yahoo.com");
			//response.sendRedirect("/sample/HelloServlet");
			}}
		else
			rd=request.getRequestDispatcher("User");
		
		//rd.forward(request, response);
		rd.include(request,response);
		//out.println("success");
		
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
