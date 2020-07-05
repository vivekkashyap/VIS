package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DBHelper;
import com.nis.model.Admin;
import com.nis.model.Users;

public class SignUpController {
	public static boolean addNewRecord(Users U)
	
	{
	
		try{
		String q="insert into users(emailid,name,gender,dob,mobileno,password) values('"+U.getEmailid()+"','"+U.getName()+"','"+U.getGender()+"','"+U.getDob()+"','"+U.getMobileno()+"','"+U.getPassword()+"')";
		
		boolean status=DBHelper.executeUpdate(q);
		return(status);
		
		}
      catch(Exception e)
		{
    	  System.out.println("SIGNUPCONTROLLER"+e);
		return(false);
		}
	
	}
	
public static Users checkUserLogin(String mail,String pass)
{
	try{
		String q="select *  from users where (emailid='"+mail+"' or mobileno='"+mail+"') and password='"+pass+"'";	
		ResultSet rs=DBHelper.executeQuery(q);
		if(rs.next())
		{Users U=new Users();
		U.setEmailid(rs.getString(1));
		U.setName(rs.getString(2));
 
		U.setMobileno(rs.getString(5));
		return(U);
			}
		return(null);
			
			
		}catch(Exception e)
		{System.out.println("CheckAdminLogin:"+e);
		  return(null);	
		}

		
	
}

}
