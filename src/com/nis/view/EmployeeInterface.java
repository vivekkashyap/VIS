package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Admin;

/**
 * Servlet implementation class EmployeeInterface
 */
@WebServlet("/EmployeeInterface")
public class EmployeeInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   PrintWriter out=response.getWriter();
	   HttpSession ses=request.getSession();
		  try{
			  Admin A=(Admin)(ses.getAttribute("SADMIN"));
			  String ltime=ses.getAttribute("LTIME").toString();
			  
			 	  }
		  catch(Exception e)
		  {
			 response.sendRedirect("AdminLogin"); 
		  }
		  out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		  out.println("    <link href='admin/main/css/style.css' rel='stylesheet'>");
	   out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");
				
	   out.println("<center><a href='EmployeeDisplayAll' class='btn btn-info btn-xs'>Display All Employees</a><br>");
		
       out.println("<form action='EmployeeSubmit' enctype='multipart/form-data' method='post'>");
       out.println("<table class='table table-bordered' style='width:75%; font-size:12px;'>");
       
       out.println("<h4><b><i>Employee Interface</i></b></h4>");
       out.println("<tr><td><b><i>Employee Name:</i></b></td><td><input type='text' class='form-control' name='fn' placeholder='First Name'> <input class='form-control' type='text' name='ln' placeholder='Last Name'></td></tr>");
       
       out.println("<tr><td><b><i>Father's Name:</i></b></td><td><input type='text' class='form-control' name='fna'></td></tr>");
       out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type='date' class='form-control' name='dob'></td></tr>");
       out.println("<tr><td><b><i>Gender:</i></b></td><td><input type='radio' name='gen' value='Male'>Male <input type='radio' value='Female' name='gen'>Female</td></tr>");
       out.println("<tr><td><b><i>Address:</i></b></td><td><textarea rows=3 class='form-control' cols=25 name='address'></textarea></td></tr>");
       out.println("<tr><td><b><i>State:</i></b></td><td><select name='states' class='form-control' id='states'><option>-States-</option></select></td></tr>");
       out.println("<tr><td><b><i>City:</i></b></td><td><select  name='city' class='form-control' id='city'><option>-City-</option></select></td></tr>");
       out.println("<tr><td><b><i>Designation:</i></b></td><td><select class='form-control' name='designation'><option>-Select-</option><option>Supervisor</option><option>Manager</option></select></td></tr>");
       out.println("<tr><td><b><i>Email:</i></b></td><td><input type='email' class='form-control' name='emailid'></td></tr>");
       out.println("<tr><td><b><i>Mobile:</i></b></td><td><input type='text' class='form-control' name='mobileno'></td></tr>");
       out.println("<tr><td><b><i>Password:</i></b></td><td><input type='password' class='form-control' name='pwd'></td></tr>");
       out.println("<tr><td><b><i>Picture:</i></b></td><td><input type='file' class='form-control' name='picture'></td></tr>");
       out.println("</table>");
       out.println("<input type='submit' class='btn btn-success btn-xs'> <input type='reset' class='btn btn-danger btn-xs'>");
       out.println("</center></form></html>");
       out.flush();
        	}

}









