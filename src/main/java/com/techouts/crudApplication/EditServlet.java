package com.techouts.crudApplication;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.print("<h1>Update Employee</h1><br>");
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Employee e=EmpDao.getEmpById(id);
		pw.println("<html><body><form action='EditServlet2'>");
		pw.println(
		  "<input type='hidden' name='userId' value='"+e.getId()+"'");
		pw.println("<br><br><label>Name</label>"
	     + "<input type='text' name='userName' value='"+e.getName()+"'");
		pw.println("<br><br><label>Password</label>"
	     + "<input type='Password' name='userPassword' value='"+e.getPassword()+"'");
		pw.println("<br><br><label>Email</label>"
	     + "<input type='text' name='userEmail'value='"+e.getEmail()+"'");
		pw.println("<br><br><label>Country</label>"
		 + "<select  name='userCountry'><option value='India'>India</option>"
		 +"<option value='Germany'>Germany</option><option value='USA'>USA</option>"
		 + "<option value='Canada'>Canada</option><option value='Australia'>Australia</option></select>");
		pw.println(
		 "<br><br><input type='submit' value='Edit&Save'<br><br>");
		pw.println("</form></body></html>");
		
		pw.close();
		
	
	}

}
