package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchByTicketId
 */
@WebServlet("/SearchByTicketId")
public class SearchByTicketId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByTicketId() {
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
	       out.println("<center><form action='TicketPrinting'>");
	       out.println("<h4><b><i>Search Ticket by ID</i></b></h4>");
	       
	       out.println("<table class='table table-bordered' style='width:100%; font-size:12px;'>");

	       out.println("<tr><td><b><i>Ticket Number:</i></b></td><td><input class='form-control' type='text' name='tid'></td>");
	        
	         out.println("<td><input type='submit' value='Search' class='btn btn-info btn-xs'></td></tr></center></form></html>");
	}

}
