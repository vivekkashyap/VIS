package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DBHelper;
import com.nis.model.Employees;

public class EmployeeController {
public static boolean addNewRecord(Employees E)
{try{
  String q="insert into employees(employeename,fathername,birthdate,gender,address,states,city,designation,emailid,mobileno,password,picture)values('"+E.getEmployeename()+"','"+E.getFathername()+"','"+E.getBirthdate()+"','"+E.getGender()+"','"+E.getAddress()+"','"+E.getStates()+"','"+E.getCity()+"','"+E.getDesignation()+"','"+E.getEmailid()+"','"+E.getMobileno()+"','"+E.getPassword()+"','"+E.getPicture()+"')";
   boolean status=DBHelper.executeUpdate(q);
   return(status);
}catch(Exception e){
 System.out.println("EmployeeController-addNewRecord "+e);	
 return(false);}
 	}

public static boolean editRecord(Employees E)
{try{
  String q="update employees set employeename='"+E.getEmployeename()+"',fathername='"+E.getFathername()+"',birthdate='"+E.getBirthdate()+"',gender='"+E.getGender()+"',address='"+E.getAddress()+"',states='"+E.getStates()+"',city='"+E.getCity()+"',designation='"+E.getDesignation()+"',emailid='"+E.getEmailid()+"',mobileno='"+E.getMobileno()+"' where employeeid="+E.getEmployeeid();
   boolean status=DBHelper.executeUpdate(q);
   return(status);
}catch(Exception e){
 System.out.println("EmployeeController-addNewRecord "+e);	
 return(false);}
 	}

public static boolean editPicture(String filename,int eid)
{try{
  String q="update employees set picture='"+filename+"' where employeeid="+eid;
   boolean status=DBHelper.executeUpdate(q);
   return(status);
}catch(Exception e){
 System.out.println("EmployeeController-addNewRecord "+e);	
 return(false);}
 	}




public static boolean deleteRecord(int eid)
{try{
  String q="delete from employees where employeeid="+eid;
   boolean status=DBHelper.executeUpdate(q);
   return(status);
}catch(Exception e){
 System.out.println("EmployeeController-addNewRecord "+e);	
 return(false);}
 	}


public static ResultSet displayAll()
{try{
  String q="select E.*,(select S.statename from states S where S.stateid=E.states),(select C.cityname from City C where C.cityid=E.City)  from employees E";
   ResultSet rs=DBHelper.executeQuery(q);
   return(rs);
}catch(Exception e){
 System.out.println("EmployeeController-addNewRecord "+e);	
 return(null);}
 	}
public static Employees displayById(int eid)
{try{
	String q="select E.*,(select S.statename from states S where S.stateid=E.states),(select C.cityname from City C where C.cityid=E.City)  from employees E where E.employeeid="+eid;
	    ResultSet rs=DBHelper.executeQuery(q);
   if(rs.next())
   {Employees E=new Employees();
   E.setEmployeeid(rs.getInt(1));
   E.setEmployeename(rs.getString(2));
   E.setFathername(rs.getString(3));
   E.setBirthdate(rs.getString(4));
   E.setGender(rs.getString(5));
   E.setAddress(rs.getString(6));
   E.setStates(rs.getString(7)+","+rs.getString(14));
   E.setCity(rs.getString(8)+","+rs.getString(15));
   E.setDesignation(rs.getString(9));
   E.setEmailid(rs.getString(10));
   E.setMobileno(rs.getString(11));
   E.setPassword(rs.getString(12));
   E.setPicture(rs.getString(13));
   return(E);
       
   }
   else
   {return null;}
   
}catch(Exception e){
 System.out.println("EmployeeController-addNewRecord "+e);	
 return(null);}
 	}




}
