package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.EmployeeController;
import com.nis.model.Employees;

/**
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)//Max Size 50 MB
public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        Employees E=new Employees();
        E.setEmployeename(request.getParameter("fn")+" "+request.getParameter("ln"));
        E.setFathername(request.getParameter("fna"));
        E.setBirthdate(request.getParameter("dob"));
        E.setGender(request.getParameter("gen"));
        E.setAddress(request.getParameter("address"));
        E.setStates(request.getParameter("states"));
        E.setCity(request.getParameter("city"));
        E.setDesignation(request.getParameter("designation"));
        E.setEmailid(request.getParameter("emailid"));
        E.setMobileno(request.getParameter("mobileno"));
        E.setPassword(request.getParameter("pwd"));
       
        
       
        Part part=request.getPart("picture");
        FileUpload F=new FileUpload(part,"D:/Eclipse Mars/eclipse/VIS/WebContent/images/");
        E.setPicture(F.filename);
        
        
        boolean status=EmployeeController.addNewRecord(E);
        out.println("<html>");
        if(status)
        {out.println("<b><i>Record Submitted<br><a href='EmployeeInterface'>Add More Employee</a><br><a href='EmployeeDisplayAll'>Display All Employee</a></i></b>");
       
        }
        else
        {out.println("<b><i>Fail to Submit Record</i></b>");}
        out.println("</html>");
        out.flush();
        
        
		
	}

}




