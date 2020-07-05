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

import com.nis.model.Event;
import com.nis.controller.EventController;

@WebServlet("/EventSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize= 1024*1024*50)

public class EventSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Event e = new Event();
		e.setEventname(request.getParameter("en"));
		e.setDate(request.getParameter("date"));
		e.setTimeend(request.getParameter("te"));
		e.setTimestart(request.getParameter("ts"));
		e.setDays(request.getParameter("days"));
		e.setAddress(request.getParameter("add"));
		e.setStates(request.getParameter("states"));
		e.setCity(request.getParameter("cty"));
		e.setOrganizedby(request.getParameter("orgby"));
		Part part = request.getPart("icon");
		 FileUpload F=new FileUpload(part,"D:/Eclipse Mars/eclipse/VIS/WebContent/images/");
		e.setIcon(F.filename);
		boolean s = EventController.addNewRecord(e);
		out.print("<html>");
		if(s){
			out.print("<b><i><h1>Record Submitted</h1></i></b>");
		}
		else{
			out.print("<br><b><i><h1>Sorry! Record could not be submitted...</h1></i></b>");
		}
		out.print("<center><h1><a href='EventDisplayAll'>Display All Records</a></h1><br>"
				+ "<h1><a href='EventInterface'>Add New Record</a></h1></center>"
				+ "</html>");
	}

}
