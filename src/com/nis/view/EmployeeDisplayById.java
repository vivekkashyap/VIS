package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.EmployeeController;
import com.nis.model.Employees;

/**
 * Servlet implementation class EmployeeDisplayById
 */
@WebServlet("/EmployeeDisplayById")
public class EmployeeDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDisplayById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Employees E=EmployeeController.displayById(Integer.parseInt(request.getParameter("eid")));
	     PrintWriter out=response.getWriter();
	     
			out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
			out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
	        out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
			out.println("<script src='asset/statecity.js'></script>");
	     if(E!=null)
	     { out.println("<center><form action='EmployeeFinalEditDelete' enctype='multipart/form-data' method='post'>");
	       out.println("<h4><b><i>Employee Interface</i></b></h4>");
	    	 out.println("<table class='table table-bordered' style='width:100%'><tr><td>");
	     
	     
	    	
	       out.println("<table class='table table-bordered' style='width:100%'>");

	       String n[]=E.getEmployeename().split(" ");
	       out.println("<input type='hidden' name='eid' value='"+request.getParameter("eid")+"'>");
	       out.println("<tr><td><b><i>Employee Name:</i></b></td><td><input class='form-control' type='text'  value='"+n[0]+"' name='fn' placeholder='First Name'> <input class='form-control' type='text' value='"+n[1]+"' name='ln' placeholder='Last Name'></td></tr>");
	       
	       out.println("<tr><td><b><i>Father's Name:</i></b></td><td><input class='form-control' type='text' name='fna' value='"+E.getFathername()+"'></td></tr>");
	       out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input class='form-control' type='date' name='dob' value='"+E.getBirthdate()+"'></td></tr>");
	       if(E.getGender().equalsIgnoreCase("Male"))
	       {   
	       out.println("<tr><td><b><i>Gender:</i></b></td><td><input type='radio' name='gen' value='Male' checked>Male <input type='radio' value='Female' name='gen'>Female</td></tr>");
	       }
	       else
	       {
	    	 out.println("<tr><td><b><i>Gender:</i></b></td><td><input type='radio' name='gen' value='Male'>Male <input type='radio' value='Female' name='gen' checked>Female</td></tr>");
	 	      
	    	   
	       }
	       out.println("<tr><td><b><i>Address:</i></b></td><td><textarea rows=3 class='form-control' cols=25 name='address'>"+E.getAddress()+"</textarea></td></tr>");
	       String k[]=E.getStates().split(","); 
	       out.println("<tr><td><b><i>State:</i></b></td><td><select name='states' class='form-control' id='states'><option value='"+k[0]+"'>"+k[1]+"</option></select></td></tr>");
	       String j[]=E.getCity().split(",");
	       out.println("<tr><td><b><i>City:</i></b></td><td><select  name='city' class='form-control' id='city'><option value='"+j[0]+"'>"+j[1]+"</option></select></td></tr>");
	       out.println("<tr><td><b><i>Designation:</i></b></td><td><select class='form-control' name='designation'><option>"+E.getDesignation()+"</option><option>Supervisor</option><option>Manager</option></select></td></tr>");
	       out.println("<tr><td><b><i>Email:</i></b></td><td><input type='email' class='form-control' name='emailid' value='"+E.getEmailid()+"'></td></tr>");
	       out.println("<tr><td><b><i>Mobile:</i></b></td><td><input type='text' class='form-control' name='mobileno' value='"+E.getMobileno()+"' ></td></tr>");
	       out.println("</table>");
	       out.println("<input type='submit' class='btn btn-success btn-xs' name='btn' value='Edit'> <input type='submit' class='btn btn-danger btn-xs' value='Delete' name='btn'>");
 
	       out.println("</td><td>");
	       out.println("<img class='img-thumbnail' src='images/"+E.getPicture()+"' width=200 height=200><br><br>");
	       out.println("<b>Edit Picture:</b> <input type='file' class='form-control' name='picture'><br><br><input type='submit' class='btn btn-warning btn-xs' value='Edit Picture' name='btn'></td></tr></table></form>");
	     
	     }
	     else
	     {out.println("Not Found....");}
	     out.println("</center></html>");
	}

}
