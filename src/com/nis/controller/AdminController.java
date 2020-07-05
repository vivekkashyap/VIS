package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DBHelper;
import com.nis.model.Admin;

public class AdminController {
public static Admin checkAdminLogin(String adminid,String password)
{
try{
String q="select *  from admin where adminid='"+adminid+"' and password='"+password+"'";	
ResultSet rs=DBHelper.executeQuery(q);
if(rs.next())
{Admin A=new Admin();
A.setAdminid(rs.getString(1));
A.setAdminname(rs.getString(2));
A.setPassword(rs.getString(3));
return(A);
	}
return(null);
	
	
}catch(Exception e)
{System.out.println("CheckAdminLogin:"+e);
  return(null);	
}

}}
