package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DBHelper;
import com.nis.model.Visitor;
import com.nis.model.VisitorEvent;

public class VisitorEventController {
	public static boolean addNewRecord(VisitorEvent e){
		try{
			String q = "Insert into visitorevent(currentdate,eventid,eventname,eventdate,eventtime,venue,epicture,vpicture,emailid,mobileno,visitorname)values('"+e.getCurrentdate()+"','"+e.getEventid()+"','"+e.getEventname()+"','"+e.getEventdate()+"','"+e.getEventtime()+"','"+e.getVenue()+"','"+e.getEpicture()+"','"+e.getVpicture()+"','"+e.getEmailid()+"','"+e.getMobileno()+"','"+e.getVisitorname()+"')";
			 System.out.println(q);
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("VisitorController addNewRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static ResultSet displayAll(String uid){
		try{
			String q = "select * from visitorevent where emailid='"+uid+"' or mobileno='"+uid+"'";
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			return (rs);
		}
		catch(Exception ee){
			System.out.println("EventController displayAll error: "+ee.getMessage());
			return null;
		}
	}
	
	
	public static VisitorEvent displayTicket(String id){
		try{
			String q = "select * from visitorevent where transactionid="+id;
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			VisitorEvent V=new VisitorEvent();
			if(rs.next())
			{V.setTransactionid(Integer.parseInt(rs.getString(1)));
				V.setCurrentdate(rs.getString(2));
			V.setEventid(Integer.parseInt(rs.getString(3)));
			V.setEventname(rs.getString(4));
			V.setEventdate(rs.getString(5));
			V.setEventtime(rs.getString(6));
			V.setVenue(rs.getString(7));
			V.setVpicture(rs.getString(8));
			V.setEpicture(rs.getString(9));
			V.setEmailid(rs.getString(10));
			V.setMobileno(rs.getString(11));
			V.setVisitorname(rs.getString(12));
			
			
			}
			return(V);
		 	}
		catch(Exception ee){
			System.out.println("EventController displayTicket error: "+ee.getMessage());
			return null;
		}
	}
}
