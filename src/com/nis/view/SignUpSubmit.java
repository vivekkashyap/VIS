package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.SignUpController;
import com.nis.model.Users;

/**
 * Servlet implementation class SignUpSubmit
 */
@WebServlet("/SignUpSubmit")
public class SignUpSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Users U=new Users();
		U.setEmailid(request.getParameter("mail"));
		U.setName(request.getParameter("fn")+" "+request.getParameter("ln"));
		U.setGender(request.getParameter("ge"));
		U.setDob(request.getParameter("dob"));
		U.setMobileno(request.getParameter("mno"));
		U.setPassword(request.getParameter("pass"));
	boolean status=SignUpController.addNewRecord(U);
	out.println("<html>");
	if(status)
	{HttpSession ses=request.getSession();
	 ses.setAttribute("UEMAIL",U.getEmailid());	
	 response.sendRedirect("UserLogin");
	}
	else
	{
		out.println("<b><i>record not submitted....</i></b>");
	}
		out.println("<html>");
		out.flush();
	}

}
