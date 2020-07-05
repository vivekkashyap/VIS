package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.model.Visitor;
import com.nis.controller.VisitorController;

/**
 * Servlet implementation class VisitorDisplayById
 */
@WebServlet("/VisitorDisplayById")
public class VisitorDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Visitor e= VisitorController.displayById(request.getParameter("eid"));
		if(e!=null){
		String j[]= e.getVisitorname().split(" ");
		String k[]= e.getStates().split(",");
		String l[] = e.getCity().split(",");
		String fn="", ln="";
		for(int i=0;i<j.length/2;i++){
			fn=fn+j[i]+" ";
		}
		for(int i=j.length/2;i<j.length;i++){
			ln=ln+j[i]+" ";
		}
		out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
		out.print("<center>"
				+ "<script src='asset/jquery-2.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<form action='VisitorFinalEditDelete' enctype='multipart/form-data' method='post'>"
				+ "<input type='hidden' name='eid' value='"+e.getVisitorid()+"'>"
				+ "<h4><b><i>Visitor Display</i></b></h4>"
				+ "<table class='table table-bordered' style='width:100%'><td>"
				+ "<center><table class='table table-bordered' style='width:100%'>"
				+ "<tr><td>Visitor name: </td><td><input type ='text' name='fn' class='form-control' value='"+fn+"'><input type='text' class='form-control' name='ln' value='"+ln+"'></td></tr>"
				+ "<tr><td>Father's Name: </td><td><input type='text' name='fan' class='form-control' value='"+e.getFathername()+"'><tr></tr>");
				if(e.getGender().equalsIgnoreCase("male")){
					out.println("<tr><td>gender: </td><td>Male<input type='radio' name='gen' value='male' checked> Female<input type='radio' name='gen' value='female'></td></tr>");
				}
				else if(e.getGender().equalsIgnoreCase("female")){
					out.println("<tr><td>gender: </td><td>Male<input type='radio' name='gen' value='male'> Female<input type='radio' name='gen' value='female' checked></td></tr>");
				} 
				out.println("<tr><td>Address: </td><td><input type='text' name='add' class='form-control' value='"+e.getAddress()+"'><td></tr>"
				+ "<tr><td>State: </td><td><select name='states' class='form-control' id='states'><option value='"+k[0]+"'>"+k[1]+"</option></select><td></tr>"
				+ "<tr><td>City: </td><td><select id='cty' class='form-control' name='cty'><option value='"+l[0]+"'>"+l[1]+"</option></select></td></tr>"
				+ "<tr><td>Occupation: </td><td><select name='occ' class='form-control' id='occ'><option>"+e.getOccupation()+"</option><option>Supervisor</option><option>Manager</option></select></td></tr>"
				+ "<tr><td>Emailid: </td><td><input type='text' class='form-control' name='emid' value='"+e.getEmailid()+"'></td></tr>"
				+ "<tr><td>Mobile No.: </td><td><input type='text' class='form-control' name='mob' value='"+e.getMobileno()+"'></td></tr>"
				+ "<tr><td>Contact Person: </td><td><input type='text' class='form-control' name='cp' value='"+e.getContactperson()+"'></td></tr>"
				+ "<tr><td>ContactNo : </td><td><input type='text' class='form-control' name='cn' value='"+e.getContactno()+"'><tr></tr>"
				+ "<tr><td>Current Date: </td><td><input type='date' class='form-control' name='cd' value='"+e.getCurrentdate()+"'><tr></tr>"
				+ "<tr><td>Current Time: </td><td><input type='time' class='form-control' name='ct' value='"+e.getCurrenttime()+"'><tr></tr>"
				+ "<tr><td>Description: </td><td><input type='text' class='form-control' name='des' value='"+e.getDescription()+"'><tr></tr>"
				+ "</font></table>"
				+ "<input type='submit' class='btn btn-info btn-xs' name='btn' value='Edit'><input type='submit' name='btn' class='btn btn-danger btn-xs' value='Delete'>"
				+ "</td>"
				+ "<td>"
				+ "<img class='img-thumbnail' src='images/"+e.getImage()+"' width=200 hieght=200><br><br>"
				+ "Edit Picture: <input type='file' class='form-control' name='img'><br><input class='btn btn-success btn-xs' type='submit' value='Edit Picture' name='btn'>"
				+ "</td></form></table></center>"
				+ "<center><h1><a href='VisitorDisplayAll' class='btn btn-info btn-xs'>Display All Records</a></h1></center>"
				+ "</center></html>");
		System.out.println("picture= "+e.getImage());
		out.flush();
		}
	}

}
