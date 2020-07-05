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
import com.nis.model.Event;
import com.nis.controller.EventController;

/**
 * Servlet implementation class EventFinalEditDelete
 */
@WebServlet("/EventFinalEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize = 1024*1024*10,maxRequestSize= 1024*1024*50)
public class EventFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String btn = request.getParameter("btn");
		if(btn.equalsIgnoreCase("edit")){
			Event e = new Event();
			
			e.setEventid(request.getParameter("eid"));
			e.setEventname(request.getParameter("en"));
			e.setDate(request.getParameter("date"));
			e.setTimeend(request.getParameter("te"));
			e.setTimestart(request.getParameter("ts"));
			e.setDays(request.getParameter("days"));
			e.setAddress(request.getParameter("add"));
			e.setStates(request.getParameter("states"));
			e.setCity(request.getParameter("cty"));
			e.setOrganizedby(request.getParameter("orgby"));
			EventController.editRecord(e);
		}
		else if(btn.equalsIgnoreCase("delete")){
			String eid=request.getParameter("eid");
			EventController.deleteRecord(eid);
		}
		else if(btn.equalsIgnoreCase("edit icon")){
			System.out.println("fu");
			String eid=request.getParameter("eid");
			Part part = request.getPart("icon");
			 FileUpload F=new FileUpload(part,"D:/Eclipse Mars/eclipse/VIS/WebContent/images/");
			EventController.editIcon(eid, F.filename);
		}
		response.sendRedirect("EventDisplayAll");  
	}

}
