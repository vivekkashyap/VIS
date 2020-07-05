package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	
		 out.println("<!DOCTYPE html>");
			out.println("<html lang='en'>");
			out.println("<head>");
			out.println("     <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			out.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
			out.println("    <title>Admin</title>");
			out.println("    <link href='admin/assets/plugins/bootstrap/css/bootstrap.min.css' rel='stylesheet'>");
			out.println("    <link href='admin/main/css/style.css' rel='stylesheet'>");
			out.println("    <link href='admin/main/css/colors/blue.css' id='theme' rel='stylesheet'>");
			out.println("</head>");
			out.println("<body>");
			out.println("    <section id='wrapper'>");
			out.println("        <div class='login-register' style='background-image:url(admin/assets/images/background/login-register.jpg);'>");
			out.println("            <div class='login-box card' style='margin-top:-50px;'>");
			out.println("  <div class='card-body'>");
			out.println("<form class='form-horizontal form-material' action='SignUpSubmit' method='post'>");
			out.println(" <h3 class='box-title m-b-20'><center>SIGN UP PAGE</center></h3> <center><img src='logo.png' class='img'></center><br><br>");
			
			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input class='form-control' type='email' name='mail' required=''  placeholder='Email ID'> </div>");
			out.println("</div>");

	
			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input class='form-control' type='text' required='' name='fn' placeholder='First Name'> </div>");
			out.println("</div>");


			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input class='form-control' type='text' required='' name='ln' placeholder='Last ID'> </div>");
			out.println("</div>");
			
			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input type='radio' name='ge' value='male'> Male  <input type='radio' name='ge' value='Female'> Female");
			out.println("</div></div>");
			
			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input type='date' name='dob' class='form-control'>");
			out.println("</div></div>");	
			
			
			
			
			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input class='form-control' type='text' required='' name='mno' placeholder='Mobile No'> </div>");
			out.println("</div>");


			out.println("<div class='form-group '>");
			out.println("<div class='col-xs-12'>");
			out.println("<input class='form-control' type='text' required='' name='pass' placeholder='Password'> </div>");
			out.println("</div>");
			
			

			out.println("                        <div class='form-group text-center m-t-20'>");
			out.println("                            <div class='col-xs-12'>");
			out.println("<button class='btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light'  type='submit'>Sign Up</button>");
			out.println("                            </div>");
			out.println("                        </div>");
			out.println("                        <div class='row'>");
			out.println("                            <div class='col-xs-12 col-sm-12 col-md-12 m-t-10 text-center'>");
		/*	out.println("                                <div class='social'>");
			out.println("                                    <a href='javascript:void(0)' class='btn  btn-facebook' data-toggle='tooltip' title='Login with Facebook'> <i aria-hidden='true' class='fa fa-facebook'></i> </a>");
			out.println("                                    <a href='javascript:void(0)' class='btn btn-googleplus' data-toggle='tooltip' title='Login with Google'> <i aria-hidden='true' class='fa fa-google-plus'></i> </a>");
			out.println("                                </div>");*/
			out.println("                            </div>");
			out.println("                        </div>");

			out.println("                    </form>");
			
			out.println("                </div>");
			out.println("            </div>");
			out.println("        </div>");
			out.println("    </section>");
			out.println("    <script src='admin/assets/plugins/jquery/jquery.min.js'></script>");
			out.println("    <script src='admin/assets/plugins/bootstrap/js/popper.min.js'></script>");
			out.println("    <script src='admin/assets/plugins/bootstrap/js/bootstrap.min.js'></script>");
			out.println("    <script src='admin/main/js/jquery.slimscroll.js'></script>");
			out.println("    <script src='admin/main/js/waves.js'></script>");
			out.println("    <script src='admin/main/js/sidebarmenu.js'></script>");
			out.println("    <script src='admin/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js'></script>");
			out.println("    <script src='admin/assets/plugins/sparkline/jquery.sparkline.min.js'></script>");
			out.println("    <script src='admin/main/js/custom.min.js'></script>");
			out.println("    <script src='admin/assets/plugins/styleswitcher/jQuery.style.switcher.js'></script>");
			out.println("</body>");
			out.println("</html>");
		
		
		
	
	
		
	}

}
