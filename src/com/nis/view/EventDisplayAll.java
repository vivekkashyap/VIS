package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Admin;
import com.nis.controller.EventController;

/**
 * Servlet implementation class EventDisplayAll
 */
@WebServlet("/EventDisplayAll")
public class EventDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try{
			HttpSession ses = request.getSession();
			out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
			out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
			try{
				Admin A = (Admin) ses.getAttribute("SADMIN");
				String ltime = ses.getAttribute("LTIME").toString();
				
			}
			catch(Exception e){
				response.sendRedirect("AdminLogin");
			}
			ResultSet rs = EventController.displayAll();
			if(rs.next()){
				out.println("<center><table class='table table-bordered' style='width:100%; font-size:12px;'>"
						+ "<h4><b><i>List Of Events</i></b></h4>"
						+ "<tr><th>Sno</th>"
						+ "<th>ID/Name</th>"
						+ "<th>Date of Event</th>"
						+ "<th>Starting time</th>"
						+ "<th>Ending Time</th>"
						+ "<th>Days</th>"
						+ "<th>Icon</th>"
						+ "<th>Address<br>State,City</th>"
						+ "<th>Organized By</th>"
						+ "<th>Update</th>");
				int sn=1;
				do{
					out.println("<tr><td>"+sn+"</td>"
							+ "<td>"+rs.getString(1)+"/"+rs.getString(2)+"</td>"
							+ "<td>"+rs.getString(3)+"</td>"
							+ "<td>"+rs.getString(4)+"</td>"
							+ "<td>"+rs.getString(5)+"</td>"
							+ "<td>"+rs.getString(6)+"</td>"
							+ "<td><img class='img-thumbnail' src='images/"+rs.getString(7)+"' width=30 height=30></td>"
							+ "<td>"+rs.getString(8)+"<br>"+rs.getString(12)+","+rs.getString(13)+"</td>"
							+ "<td>"+rs.getString(11)+"</td>"
							+ "<td><a class='btn btn-warning btn-xs' href='EventDisplayById?eid="+rs.getString(1)+"'>Update/delete</a></tr>");
					sn++;
				}while(rs.next());
			}
			else{
				out.println("<h1>Sorry No records found</h1>");
			}
			out.println("<h1><a href='EventInterface' class='btn btn-info btn-xs'>Add New Record</a></h1>");
			out.print("</center></html>");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
