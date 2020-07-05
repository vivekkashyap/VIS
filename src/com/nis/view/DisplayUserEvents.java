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

import com.nis.controller.EventController;
import com.nis.controller.VisitorEventController;

/**
 * Servlet implementation class DisplayUserEvents
 */
@WebServlet("/DisplayUserEvents")
public class DisplayUserEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		String uid="";
	 	try{
	 	 
		  uid= ses.getAttribute("MAIL").toString();
			
	 	}
		catch(Exception e){
			response.sendRedirect("UserLogin");
		}
       try{
		out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
		ResultSet rs =VisitorEventController.displayAll(uid);
		if(rs.next()){
			out.println("<center><table class='table table-bordered' style='width:100%; font-size:12px;'>"
					+ "<h4><b><i>List Of Events</i></b></h4>"
					+ "<tr><th>Sno</th>"
					+ "<th>Current Date</th>"
					+ "<th>Event</th>"
					+ "<th>Venue</th>"
					
					+ "<th>Visitor</th>"
					+ "<th>Email/Mobile</th>"
					+ "<th>Ticket</th></tr>");
				       
			int sn=1;
			do{
				out.println("<tr><td>"+sn+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td><img class='img-thumbnail' src='images/"+rs.getString(9)+"' width=40 height=40><br>"+rs.getString(4)+"</td>"
						+ "<td>Date:"+rs.getString(5)+"<br>Time:"+rs.getString(6)+"<br>"+rs.getString(7)+"</td>"
						+ "<td><img class='img-thumbnail' src='images/"+rs.getString(8)+"' width=40 height=40><br>"+rs.getString(12)+"</td>"
						+ "<td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td>"
				    	+ "<td><a class='btn btn-info btn-xs' href='TicketPrinting?tid="+rs.getString(1)+"'>Generate</a><br><a class='btn btn-success btn-xs' href='https://chart.googleapis.com/chart?chs=200x200&cht=qr&chl=200x200&chld=M|0&cht=qr&chl=http://192.168.43.36:9090/VIS/TicketPrinting?tid="+rs.getString(1)+"'>On Mobile</td></tr>");
				sn++;
			}while(rs.next());
		}
		else{
			out.println("<h1>Sorry No records found</h1>");
		}
	 
		out.print("</center></html>");
	}
	catch(Exception e){
		System.out.println(e);
	}
	}

}