package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.EventController;
import com.nis.controller.VisitorEventController;
import com.nis.model.Admin;
import com.nis.model.Event;
import com.nis.model.VisitorEvent;

/**
 * Servlet implementation class TicketPrinting
 */
@WebServlet("/TicketPrinting")
public class TicketPrinting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketPrinting() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		VisitorEvent V=VisitorEventController.displayTicket(request.getParameter("tid"));
		out.println("<html><link  rel='stylesheet' href='asset/print.css' type='text/css'>");

		out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
		 
   		if(V!=null){
             out.println("<body><div id='section-to-print' class='header'>");
             out.println("<center><table  cellpadding='10' cellspacing='10' style='background-color: #ffffff; border:3px green solid;'>");
             
             out.println("<tr><td><b><i>Ticket:<br>"+V.getTransactionid()+"</i></b></td>");
             
             out.println("<td>&nbsp;</td><td><i><b>Date:<br>"+V.getCurrentdate()+"</b></i></td></tr>");
             out.println("<tr><td>&nbsp;</td><th><i><b>"+V.getEventname()+"</i></b></th><td>&nbsp;</td></tr>");
             out.println("<tr><td>&nbsp;</td><th><img src=images/"+V.getVpicture()+" width='150' height='200'></th><td>&nbsp;</td></tr>");
             out.println("<tr><td>&nbsp;</td><th>"+V.getVisitorname()+"</th><td>&nbsp;</th><td>&nbsp;</td></tr>");
             out.println("<tr><td><b><i> Event Date:<br>"+V.getEventdate()+"</i></b></td>");
             out.println("<td>&nbsp;</td><td><i><b>Event Time:<br>"+V.getEventtime()+"</b></i></td></tr></table>");
             
             out.println("venue:"+V.getVenue()+"</center></div>");
             
             out.println("<center><input type='button' class='btn btn-info btn-xs' id='print' value='Print'></center><br>");
             
             out.println("<script>document.querySelector('#print').addEventListener('click',function(){ window.print();});</script>");
             out.println("</body></html>");
             
   		   }
		out.flush();
	}

}
