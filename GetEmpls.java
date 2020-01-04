package web;

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
import java.util.List;
import com.deloitte.empl.beans.Emp;
import com.deloitte.empl.dao.EmpDao;
/*@WebServlet(urlPatterns={"/GetEmpls"},initParams=
{@WebInitParam(name="mobile",value="12345")})*/
import com.deloitte.empl.dao.impl.EmpDaoImpl;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet(urlPatterns={"/GetEmpls"},initParams=
{@WebInitParam(name="mobile",value="12345")})
public class GetEmpls extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ServletContext ctx=getServletContext();
		out.println("city= "+ctx.getInitParameter("city")+"<br>");
		ServletConfig config = getServletConfig();
		out.println("mobile = "+config.getInitParameter("mobile")+"<br>"); 
		EmpDao dao=new EmpDaoImpl();
		List<Emp> emplist = dao.getEmpls();
		out.println("<table border=2>");
		out.println("<tr><th>EMPNO<TH>EMPNAME<TH>JOB<th>MGR<th>HIREDATE<th>SALARY<th>DEPTNO</tr>");
		for(Emp e : emplist){
			out.println("<tr>");
			out.println("<td>"+e.getEmpno()+"</td>");
			out.println("<td>"+e.getEname()+"</td>");
			out.println("<td>"+e.getJob()+"</td>");
			out.println("<td>"+e.getMgr()+"</td>");
			out.println("<td>"+e.getHiredate()+"</td>");
			out.println("<td>"+e.getSal()+"</td>");
			out.println("<td>"+e.getDeptno()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
