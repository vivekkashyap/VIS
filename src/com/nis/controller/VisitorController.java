package com.nis.controller;

import java.sql.ResultSet;

import com.nis.model.Visitor;
import com.nis.dao.DBHelper;

public class VisitorController {
	public static boolean addNewRecord(Visitor e){
		try{
			String q = "Insert into visitor(visitorname,fathername,gender,address,states,city,occupation,"
					+"emailid,mobileno,image,contactperson,contactno,currentdate,currenttime,description) values('"+e.getVisitorname()+"','"+e.getFathername()
					+"','"+e.getGender()+"','"+e.getAddress()+"','"+e.getStates()+"','"+e.getCity()+"','"+e.getOccupation()
					+"','"+e.getEmailid()+"','"+e.getMobileno()+"','"+e.getImage()+"','"+e.getContactperson()+"','"+e.getContactno()
					+"','"+e.getCurrentdate()+"','"+e.getCurrenttime()+"','"+e.getDescription()+"')";
			//System.out.println(q);
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("VisitorController addNewRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static ResultSet displayAll(){
		try{
			String q = "select V.*,(Select S.statename from states S where S.stateid = V.states),"
					+ "(select C.cityname from city C where C.cityid = V.city)"
					+ " from visitor V";
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			return (rs);
		}
		catch(Exception ee){
			System.out.println("VisitorController displayAll error: "+ee.getMessage());
			return null;
		}
	}
	public static Visitor displayById(String vid){
		try{
			String q =  "select E.*,(Select S.statename from states S where S.stateid = E.states),"
					+ "(select C.cityname from city C where C.cityid = E.city)"
					+ " from visitor E where E.visitorid ="+vid;
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			Visitor e = new Visitor();
			if(rs.next()){
				e.setVisitorid(rs.getString(1));
				e.setVisitorname(rs.getString(2));
				e.setFathername(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setEmailid(rs.getString(5));
				e.setMobileno(rs.getString(6));
				e.setAddress(rs.getString(7));
				e.setStates(rs.getString(8)+","+rs.getString(17));
				e.setCity(rs.getString(9)+","+rs.getString(18));
				e.setOccupation(rs.getString(10));
				e.setContactperson(rs.getString(11));
				e.setContactno(rs.getString(12));
				e.setCurrentdate(rs.getString(13));
				e.setCurrenttime(rs.getString(14));
				e.setDescription(rs.getString(15));
				e.setImage(rs.getString(16));
			}
			return (e);
		}
		catch(Exception ee){
			System.out.println("VisitorController displayAll error: "+ee.getMessage());
			return null;
		}
	}
	public static boolean editRecord(Visitor e){
		try{
			String q = "Update visitor set visitorname='"+e.getVisitorname()+"',fathername='"+e.getFathername()
					+"',gender='"+e.getGender()+"',address='"+e.getAddress()+"',states='"+e.getStates()+"',city='"+e.getCity()
					+"',occupation='"+e.getOccupation()+"',contactperson='"+e.getContactperson()+"',contactno='"+e.getContactno()
					+"',currentdate='"+e.getCurrentdate()+"',currenttime='"+e.getCurrenttime()+"',description='"+e.getDescription()
					+"',emailid='"+e.getEmailid()+"',mobileno='"+e.getMobileno()+"' where visitorid = "+e.getVisitorid();
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("VisitorController editRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static boolean editPicture(String eid, String filename){
		try{
			String q = "update visitor set image='"+filename+"' where visitorid="+eid;
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("VisitorController editRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static boolean deleteRecord(String eid){
		try{
			String q = "delete from visitor where visitorid="+eid;
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("VisitorController editRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static String searchVisitor(String id){
		try{
			String q =  "select * from visitor  where emailid='"+id+"' or mobileno='"+id+"'";
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			
			if(rs.next()){
			 return(rs.getString(1)); 
			}
			return (null);
		}
		catch(Exception ee){
			System.out.println("VisitorController displayAll error: "+ee.getMessage());
			return null;
		}
	}
	
	
}
