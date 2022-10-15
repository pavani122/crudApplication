package com.techouts.crudApplication;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet  extends HttpServlet{

	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<a href='index.html'>AddNewEmployee</a>");
		pw.print("<h1>Employees List</h1>");
		
		List<Employee> list=EmpDao.getAllEmployees();
		
		pw.println("<table border=2><tr><th>Id</th><th>Name</th><th>Password"
				+ "</th><th>Email</th><th>Country</th>"
				+ "<th>Edit</th><th>Delete</th></tr>");
		for(Employee e:list)
		{
			pw.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"
		+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()
		+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td>"
		+"<a href='DeleteServlet?id="+e.getId()+"'>delete</a>");
		}
		
		pw.print("</table>");
		pw.close();
	}
}
