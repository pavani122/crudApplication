package com.techouts.crudApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String sid=req.getParameter("userId");
		System.out.println(sid);
		int id=Integer.parseInt(sid);
		
		String name=req.getParameter("userName");
		String password=req.getParameter("userPassword");
		String email=req.getParameter("userEmail");
		String country=req.getParameter("userCountry");
		
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
	
		int status=EmpDao.updateData(e);
		if(status>0)
		{
			pw.println("<h3>Record saved successfully.</h3>");
			res.sendRedirect("ViewServlet");
		}
		else
		{
			pw.println("<h3>Sorry, unable to update..</h3>");

		}
		
		pw.close();
	
	}
	

}
