package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

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
 * Servlet implementation class VisitorDisplayAll
 */
@WebServlet("/VisitorDisplayAll")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize= 1024*1024*50)
public class VisitorDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try{
			out.println("<html><link href='asset/bootstrap.min.css' rel='stylesheet' type='text/css'>");
			out.println(" <link href='admin/main/css/style.css' rel='stylesheet'>");
			ResultSet rs = VisitorController.displayAll();
			if(rs.next()){
				out.println("<center><table class='table table-bordered' style='width:100%; font-size:12px;'>"
						+ "<h4><b><i>List Of Visitors</i></b></h4>"
						+ "<tr><th>Sno</th>"
						+ "<th>ID/Name</th>"
						+ "<th>Father's<br> Name</th>"
						+ "<th>Emailid</th>"
						+ "<th>Mobileno</th>"
						+ "<th>Address<br>State,City</th>"
						+ "<th>Occupation</th>"
						+ "<th>Contact Person</th>"
						+ "<th>Contactno</th>"
						+ "<th>Image</th>"
						+ "<th>Update</th></tr>");
				int sn=1;
				do{
					out.println("<tr><td>"+sn+"</td>"
							+ "<td>"+rs.getString(1)+"/"+rs.getString(2)+"</td>"
							+ "<td>"+rs.getString(3)+"</td>"
							+ "<td>"+rs.getString(5)+"</td>"
							+ "<td>"+rs.getString(6)+"</td>"
							+ "<td>"+rs.getString(7)+"<br>"+rs.getString(17)+", "+rs.getString(18)+"</td>"
							+ "<td>"+rs.getString(10)+"</td>"
							+ "<td>"+rs.getString(11)+"</td>"
							+ "<td>"+rs.getString(12)+"</td>"
							+ "<td><img class='img-thumbnail' src='images/"+rs.getString(16)+"' width=30 height=30></td>"
							+ "<td><a class='btn btn-info btn-xs' href='VisitorDisplayById?eid="+rs.getString(1)+"'>Update/delete</a></tr>");
					sn++;
				}while(rs.next());
			}
			else{
				out.println("<h1>Sorry No records found</h1>");
			}
			out.println("<h1><a class='btn btn-danger btn-xs' href='VisitorInterface'>Add New Record</a></h1>");
			out.print("</center></html>");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
