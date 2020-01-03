package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.empl.beans.Emp;
import com.deloitte.empl.dao.EmpDao;
import com.deloitte.empl.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class AddEmp
 */
@WebServlet("/AddEmp")
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int empno=Integer.parseInt(request.getParameter("empno"));
		String ename=request.getParameter("ename");
		String job=request.getParameter("job");
		int mgr=Integer.parseInt(request.getParameter("mgr"));
		String hiredate=request.getParameter("date");
		double sal=Double.parseDouble(request.getParameter("sal"));
		double comm=Double.parseDouble(request.getParameter("comm"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
		EmpDao dao = new EmpDaoImpl();
		int rows = dao.addEmp(emp);
		if(rows>0)
			out.println("inserted");
		else
			out.println("not inserted");

	}

}
