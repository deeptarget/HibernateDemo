package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import com.EmployeeBean.EmployeeBean;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
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
		String eid=request.getParameter("eid");
		String salary=request.getParameter("salary");
		
		EmployeeBean e=new EmployeeBean();
		e.setEid(Integer.parseInt(eid));
		e.setEname(name);
		e.setSalary(Double.parseDouble(salary));
		
		//cm tm hql
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		
		
		//'Insert' 'Update' 'Delete'-->all Dml operation
		Object o=ss.save(e);
		if(o!=null) {
			response.getWriter().println("Data Inserted...");
			
			tt.commit();
			ss.close();
		}
		
		
	}

}
