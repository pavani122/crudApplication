package com.techouts.crudApplication;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String name=req.getParameter("userName");
		String password=req.getParameter("userPassword");
		String email=req.getParameter("userEmail");
		String country=req.getParameter("userCountry");
		
		Employee e=new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int status = EmpDao.saveData(e);
		if(status>0)
		{
			pw.println("<h3>Record saved successfully</h3>");
			RequestDispatcher disp=req.getRequestDispatcher("index.html");
			disp.include(req, res);
		}
		else
		{
			pw.println("<h3>Sorry, not able to save.</h3>");

		}
		
		pw.close();
	}
	
	
}
