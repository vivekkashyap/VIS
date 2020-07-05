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
import com.nis.model.Event;
import com.nis.controller.EventController;

/**
 * Servlet implementation class EventDisplayById
 */
@WebServlet("/EventDisplayById")
public class EventDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Event e= EventController.displayById(request.getParameter("eid"));
		HttpSession ses = request.getSession();
		out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");

		try{
			Admin A = (Admin) ses.getAttribute("SADMIN");
			String ltime = ses.getAttribute("LTIME").toString();
		}
		catch(Exception ex){
			response.sendRedirect("AdminLogin");
		}
		String k[]= e.getStates().split(",");
		String l[] = e.getCity().split(",");
		if(e!=null){
		out.print("<script src='asset/jquery-2.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<center><form action='EventFinalEditDelete' enctype='multipart/form-data' method='post'>"
				+ "<input type='hidden' name='eid' value='"+e.getEventid()+"'>"
				+ "<h4><b><i>Event Display</i></b></h4>"
				+ "<table class='table table-bordered' style='width:100%'><td>"
				+ "<table class='table table-bordered' style='width:100%'>"
				+ "<tr><td>Event name: </td><td><input type ='text' class='form-control' name='en' value='"+e.getEventname()+"'></td></tr>"
				+ "<tr><td>Date of Event: </td><td><input type='date' class='form-control' name='date' value='"+e.getDate()+"'><tr></tr>"
				+ "<tr><td>Starting time: </td><td><input type='time' class='form-control' name='ts' value='"+e.getTimestart()+"'><td></tr>"
				+ "<tr><td>Ending Time </td><td><input type='time' class='form-control' name='te' value='"+e.getTimeend()+"'><td></tr>"
				+ "<tr><td>Days </td><td><input type='text' name='days' class='form-control' value='"+e.getDays()+"'></td></tr>"
				+ "<tr><td>Address: </td><td><input type='text' name='add' class='form-control' value='"+e.getAddress()+"'><td></tr>"
				+ "<tr><td>State: </td><td><select name='states' id='states' class='form-control'><option value='"+k[0]+"'>"+k[1]+"</option></select><td></tr>"
				+ "<tr><td>City: </td><td><select id='city' name='cty' class='form-control'><option value='"+l[0]+"'>"+l[1]+"</option></select></td></tr>"
				+ "<tr><td>Organized By: </td><td><input type='text' class='form-control' name='orgby' value='"+e.getOrganizedby()+"'></td></tr>"
				+ "</font></table>"
				+ "<input type='submit' class='btn btn-info btn-xs' name='btn' value='edit'><input type='submit' class='btn btn-danger btn-xs' name='btn' value='delete'>"
				+ "</td>"
				+ "<td>"
				+ "<img class='img-thumbnail' src='images/"+e.getIcon()+"' width=200 hieght=200><br><br>"
				+ "Edit Picture: <br><input type='file' class='form-control' name='icon'><br><input type='submit' class='btn btn-success btn-xs' value='Edit Icon' name='btn'>"
				+ "</td></form></table></center>"
				+ "<center><h1><a href='EventDisplayAll' class='btn btn-info btn-xs'>Display All Records</a></h1></center>"
				+ "</center></html>");
		out.flush();
		}
	}
}
