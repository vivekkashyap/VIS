package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AdminController;
import com.nis.model.Admin;

/**
 * Servlet implementation class AdminCheckLogin
 */
@WebServlet("/AdminCheckLogin")
public class AdminCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 out.println("<html>");
		 Admin A=AdminController.checkAdminLogin(request.getParameter("adminid"), request.getParameter("password"));
	     if(A!=null)
	     {HttpSession ses=request.getSession();
	      //ses.putValue("SADMIN", A);
	      ses.setAttribute("SADMIN",A);
	      ses.setAttribute("LTIME",new java.util.Date());
	     // ses.putValue("LTIME", new  java.util.Date());
	     response.sendRedirect("AdminHome");	 
	     }
	     else
	     {out.println("<b><i><font color=red>Invalid Admin ID/Password</font></i></b>");
	    	 
	     }
	     out.println("</html>");
	}

}
