package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Admin;

/**
 * Servlet implementation class EventInterface
 */
@WebServlet("/EventInterface")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize= 1024*1024*50)
public class EventInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter();
		HttpSession ses = request.getSession();
		  out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		  out.println("    <link href='admin/main/css/style.css' rel='stylesheet'>");
		try{
			Admin A = (Admin) ses.getAttribute("SADMIN");
			String ltime = ses.getAttribute("LTIME").toString();
			
		}
		catch(Exception e){
			response.sendRedirect("AdminLogin");
		}
		out.print("<script src='asset/jquery-2.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<center><form action='EventSubmit' enctype='multipart/form-data' method='post'>"
				+ "<h4><b><i>Event Interface</i></b></h4>"
				+ "<table class='table table-bordered' style='width:80%'>"
				+ "<tr><td>Event name: </td><td><input type ='text' class='form-control' name='en'></td></tr>"
				+ "<tr><td>Date: </td><td><input type='date' class='form-control' name='date'><tr></tr>"
				+ "<tr><td>Time Start: </td><td><input type='time' class='form-control' name='ts'><td></tr>"
				+ "<tr><td>Time End: </td><td><input type='time' class='form-control' name='te'></td></tr>"
				+ "<tr><td>Days: </td><td><input type='text' class='form-control' name='days'><td></tr>"
				+ "<tr><td>Icon: </td><td><input type='file' class='form-control' name='icon'></td></tr>"
				+ "<tr><td>Address: </td><td><input class='form-control' type='text' name='add'><td></tr>"
				+ "<tr><td>State: </td><td><select class='form-control' name='states' id='states'><option>-States-</option></select><td></tr>"
				+ "<tr><td>City: </td><td><select id='city' class='form-control' name='cty'><option>-city-</option></select></td></tr>"
				+ "<tr><td>Organized By: </td><td><input class='form-control' type='text' name='orgby'></td></tr>"
				+ "</font></table>"
				+ "<input type='submit' class='btn btn-danger btn-xs'>"
				+ "</form></center>"
				+ "<center><h1><a href='EventDisplayAll' class='btn btn-info btn-xs'>Display All Records</a></h1></center>"
				+ "</center></html>");
		out.flush();
	}
}
