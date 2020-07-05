package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.EmployeeController;

/**
 * Servlet implementation class EmployeeDisplayAll
 */
@WebServlet("/EmployeeDisplayAll")
public class EmployeeDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
		out.println("<center><a href='EmployeeInterface' class='btn btn-info btn-xs'>Add New Record</a><br>");
		
		try{
		ResultSet rs=EmployeeController.displayAll();	
		if(rs.next())
		{out.println("<center><table class='table table-bordered' style='width:100%; font-size:12px;'>");
		out.println("<h4><b><i>List Of Employees</i></b></h4>");
		out.println("<tr><th>Sn</th><th>ID/Name<br>Birth Date</th><th>Picture<br>Gender</th><th>Father's<br>Name</th><th>Address</th><th>Contact</th><th>Designation</th><th>Update</th></tr>");
		int sn=1;
		do{
		out.println("<tr><td>"+sn+"</td><td>"+rs.getString(1)+"/"+rs.getString(2)+"<br>"+rs.getString(4)+"</td><td><img class='img-thumbnail' src='images/"+rs.getString(13)+"' width='30' height='30'></br>"+rs.getString(5)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(6)+"<br>"+rs.getString(14)+","+rs.getString(15)+"</td><td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td><td>"+rs.getString(9)+"</td><td><a class='btn btn-danger btn-xs' href='EmployeeDisplayById?eid="+rs.getString(1)+"'>Edit/Delete</a></td></tr>"); 	
			sn++;
		}while(rs.next());
			
		out.println("</table></center>");	
		}
		else
		{out.println("No Employee Exist in Database...");}
			
		}catch(Exception e)
		{out.println(e);}
		out.println("</html>");
	}

}
