package com.techouts.crudApplication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	static int status;
	public static Connection getConnection()
	{
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/employee","root","techouts@123");	
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	return con;	
	}
	
	public static int saveData(Employee e)
	{
		status=0;
		try {
		Connection	con=getConnection();
		PreparedStatement ps=con.prepareStatement(
		" insert into employeedetails(Name,Password,Email,Country) values(?,?,?,?)");
		ps.setString(1,e.getName());
		ps.setString(2,e.getPassword());
		ps.setString(3,e.getEmail());
		ps.setString(4,e.getCountry());
		
		status=ps.executeUpdate();
		
		con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;	
	}
	
	public static int updateData(Employee e)
	{
		status=0;
		try {
			Connection	con=getConnection();
			PreparedStatement ps=con.prepareStatement(
			" update employeedetails set Name=?, Password=?,Email=?,Country=? where Id=? ");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
			}
			catch (Exception e1) 
		    {
				e1.printStackTrace();
			}
			return status;		
	}
	
	public static int deleteData(int id)
	{
		status=0;
		try {
			Connection	con=getConnection();
			PreparedStatement ps=con.prepareStatement(
			" delete from employeedetails where Id=? ");

			ps.setInt(1,id);
			
			status=ps.executeUpdate();
			
			con.close();
			}
			catch (Exception e1) 
		    {
				e1.printStackTrace();
			}
			return status;		
	}
	public static Employee getEmpById(int id)
	{
		Employee e=new Employee();
		status=0;
		try {
			Connection	con=getConnection();
			PreparedStatement ps=con.prepareStatement(
			" select * from  employeedetails where Id=? ");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
		        e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}		
			con.close();
	       }
		catch (Exception e2) 
		{
			System.out.println(e2);	
		}
	return e;
   }
	
	 public static List<Employee> getAllEmployees()
	 {
		 List<Employee> list=new ArrayList<>();
		 
		 try {
				Connection	con=getConnection();
				PreparedStatement ps=con.prepareStatement(
				"select * from  employeedetails");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					Employee e=new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setPassword(rs.getString(3));
					e.setEmail(rs.getString(4));
					e.setCountry(rs.getString(5));
					list.add(e);
				}
		 }
		 catch (Exception e) {
			
		}
		return list;
	 }
	 
	
}
		 
		 
		 
		 
	 
	 
	 
	 
	 
	 
	 
