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

import com.nis.model.Visitor;
import com.nis.controller.VisitorController;

/**
 * Servlet implementation class VisitorFinalEditDelete
 */
@WebServlet("/VisitorFinalEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize= 1024*1024*50)
public class VisitorFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String btn = request.getParameter("btn");
		if(btn.equalsIgnoreCase("edit")){
			Visitor e = new Visitor();
			e.setVisitorid(request.getParameter("eid"));
			e.setVisitorname(request.getParameter("fn")+" "+request.getParameter("ln"));
			e.setFathername(request.getParameter("fan"));
			e.setGender(request.getParameter("gen"));
			e.setAddress(request.getParameter("add"));
			e.setStates(request.getParameter("states"));
			e.setCity(request.getParameter("cty"));
			e.setEmailid(request.getParameter("emid"));
			e.setMobileno(request.getParameter("mob"));
			e.setContactperson(request.getParameter("cp"));
			e.setContactno(request.getParameter("cn"));
			e.setCurrentdate(request.getParameter("cd"));
			e.setCurrenttime(request.getParameter("ct"));
			e.setDescription(request.getParameter("des"));
			e.setOccupation(request.getParameter("occ"));
			VisitorController.editRecord(e);
		}
		else if(btn.equalsIgnoreCase("delete")){
			String eid=request.getParameter("eid");
			VisitorController.deleteRecord(eid);
		}
		else if(btn.equalsIgnoreCase("edit picture")){
			String eid=request.getParameter("eid");
			Part part = request.getPart("img");
			FileUpload F = new FileUpload(part,"D:/Eclipse Mars/eclipse/VIS/WebContent/images");
			VisitorController.editPicture(eid, F.filename);
		}
		response.sendRedirect("VisitorDisplayAll");  
	}
    


}
