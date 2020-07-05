package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Users;

/**
 * Servlet implementation class VisitorInterface
 */
@WebServlet("/VisitorInterface")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize= 1024*1024*50)
public class VisitorInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter();
		Calendar C=Calendar.getInstance();
		String td=C.get(Calendar.YEAR)+"-"+(C.get(Calendar.MONTH)+1)+"-"+C.get(Calendar.DATE);
		String t[]={"AM","PM"};
		String tt=C.get(Calendar.HOUR)+":"+(C.get(Calendar.MINUTE)+1)+":"+C.get(Calendar.SECOND)+" "+t[C.get(Calendar.AM_PM)];
		HttpSession ses=request.getSession();
		String emailid="";
		String firstname="";
		String lastname="";
		String mobileno="";
		try{
		Users U=(Users)ses.getAttribute("USER");
		String s[]=U.getName().split(" ");
		firstname=s[0];
		
		lastname=s[1];
		emailid=U.getEmailid();
		mobileno=U.getMobileno();
			
		}catch(Exception e){}
		
		
		out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
		
		out.print(""
				+ "<script src='asset/jquery-2.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<center><form action='VisitorSubmit' enctype='multipart/form-data' method='post'>"
				+ "<h4><b><i>Visitor Interface</i></b></h4>"
				+ "<table class='table table-bordered' style='width:80%'>"
				+ "<tr><td>Visitor name: </td><td><input type ='text' class='form-control' name='fn' placeholder='first name' value='"+firstname+"'><input class='form-control' type='text' name='ln' placeholder='last name'  value='"+lastname+"'></td></tr>"
				+ "<tr><td>Father's Name: </td><td><input type='text' class='form-control' name='fan'><tr></tr>"
				+ "<tr><td>gender: </td><td>Male<input type='radio' name='gen' value='male'> Female<input type='radio' name='gen' value='female'></td></tr>"
				+ "<tr><td>Address: </td><td><input type='text' class='form-control' name='add'><td></tr>"
				+ "<tr><td>State: </td><td><select name='states' class='form-control' id='states'><option>-States-</option></select><td></tr>"
				+ "<tr><td>City: </td><td><select id='city' class='form-control' name='cty'><option>-city-</option></select></td></tr>"
				+ "<tr><td>Occupation: </td><td><select name='occ' class='form-control' id='occ'><option>-Select-</option><option>Supervisor</option><option>Manager</option></select></td></tr>"
				+ "<tr><td>Emailid: </td><td><input type='text' class='form-control' name='emid'  value='"+emailid+"'></td></tr>"
				+ "<tr><td>Mobile No.: </td><td><input type='text' class='form-control' name='mob'  value='"+mobileno+"'></td></tr>"
				+ "<tr><td>Contact Person: </td><td><input type='text' class='form-control' name='cp'></td></tr>"
				+ "<tr><td>ContactNo : </td><td><input type='text' class='form-control' name='cn'><tr></tr>"
				+ "<tr><td>Current Date: </td><td><input type='text' class='form-control' name='cd' value='"+td+"'><tr></tr>"
				+ "<tr><td>Current Time: </td><td><input type='text' class='form-control' name='ct' value='"+tt+"'><tr></tr>"
				+ "<tr><td>Description: </td><td><input type='text' class='form-control' name='des'><tr></tr>"
				+ "<tr><td>Image: </td><td><input type='file' class='form-control' name='img'></td></tr>"
				+ "</font></table>"
				+ "<input type='submit' class='btn btn-success btn-xs'>"
				+ "</form></center>"
				+ "<center><h1><a href='VisitorDisplayAll' class='btn btn-info btn-xs'>Display All Records</a></h1></center>"
				+ "</html>");
		out.flush();
	}

}
