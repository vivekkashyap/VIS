package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.model.Event;
import com.nis.model.Visitor;
import com.nis.model.VisitorEvent;
import com.nis.controller.VisitorController;
import com.nis.controller.VisitorEventController;

/**
 * Servlet implementation class VisitorSubmit
 */
@WebServlet("/VisitorSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize= 1024*1024*50)
public class VisitorSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		Visitor e = new Visitor();
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
		Part part = request.getPart("img");
		FileUpload F = new FileUpload(part,"D:/Eclipse Mars/eclipse/VIS/WebContent/images");
		e.setImage(F.filename);
		boolean s = VisitorController.addNewRecord(e);
		out.print("<html>");
		if(s){
			HttpSession ses=request.getSession();
			try{
			 Event E=(Event)(ses.getAttribute("EVENT"));	
			 VisitorEvent VE =new VisitorEvent(); 	
			 Calendar C=Calendar.getInstance();
			 String td=C.get(Calendar.YEAR)+"-"+(C.get(Calendar.MONTH)+1)+"-"+C.get(Calendar.DATE);
			VE.setCurrentdate(td);
			VE.setEventid(Integer.parseInt(E.getEventid()));
			VE.setEventname(E.getEventname());
			VE.setEventdate(E.getDate());
			VE.setEventtime(E.getTimestart());
			String c[]=E.getCity().split(",");
			String st[]=E.getStates().split(",");
			VE.setVenue(E.getAddress()+"<br>"+c[1]+","+st[1]);
			VE.setEpicture(E.getIcon());
			VE.setVpicture(e.getImage());
			VE.setEmailid(e.getEmailid());
			VE.setMobileno(e.getMobileno());
			VE.setVisitorname(e.getVisitorname());
			VisitorEventController.addNewRecord(VE);
			}catch(Exception err){System.out.println("xxxxxxxxxxx"+err);}
			out.print("<b><i><h3>Record Submitted</h3></i></b>");
		}
		else{
			out.print("<br><b><i><h1>Sorry! Record could not be submitted...</h1></i></b>");
		}
		out.print("</html>");
		  }

}
