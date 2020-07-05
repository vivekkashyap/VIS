package com.nis.controller;

import java.sql.ResultSet;

import com.nis.model.Event;
import com.nis.dao.DBHelper;

public class EventController {
	public static boolean addNewRecord(Event e){
		try{
			String q = "Insert into Event(Eventname,eventdate,timestart,timeend,days,icon,address,states,city,organizedby) values('"
					+e.getEventname()+"','"+e.getDate()+"','"+e.getTimestart()
					+"','"+e.getTimeend()+"','"+e.getDays()+"','"+e.getIcon()+"','"
					+e.getAddress()+"','"+e.getStates()+"','"+e.getCity()+"','"+e.getOrganizedby()+"')";
			System.out.println(q);
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("EventController addNewRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static ResultSet searchUser(String param){
		try{
			String q = "select E.*, (Select S.statename from states S where S.stateid = E.states) as eventstate,"
					+ "(select C.cityname from city C where C.cityid = E.city) as eventcity "
					+ "from Event E where eventname like '%"+param+"%'";
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			return (rs);
		}
		catch(Exception ee){
			System.out.println("EventController displayAll error: "+ee.getMessage());
			return null;
		}
	}

	
	
	public static ResultSet displayAll(){
		try{
			String q = "select E.*, (Select S.statename from states S where S.stateid = E.states) as eventstate,"
					+ "(select C.cityname from city C where C.cityid = E.city) as eventcity "
					+ "from Event E";
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			return (rs);
		}
		catch(Exception ee){
			System.out.println("EventController displayAll error: "+ee.getMessage());
			return null;
		}
	}
	public static Event displayById(String eid){
		try{
			String q =  "select E.*,(Select S.statename from states S where S.stateid = E.states),"
					+ "(select C.cityname from city C where C.cityid = E.city)"
					+ " from Event E where Eventid ="+eid;
			ResultSet rs = (ResultSet) DBHelper.executeQuery(q);
			Event e = new Event();
			if(rs.next()){
				e.setEventid(rs.getString(1));
				e.setEventname(rs.getString(2));
				e.setDate(rs.getString(3));
				e.setTimestart(rs.getString(4));
				e.setTimeend(rs.getString(5));
				e.setDays(rs.getString(6));
				e.setIcon(rs.getString(7));
				e.setAddress(rs.getString(8));
				e.setStates(rs.getString(9)+","+rs.getString(12));
				e.setCity(rs.getString(10)+","+rs.getString(13));
				e.setOrganizedby(rs.getString(11));
			}
			return (e);
		}
		catch(Exception ee){
			System.out.println("EventController displayAll error: "+ee.getMessage());
			return null;
		}
	}
	public static boolean editRecord(Event e){
		try{
			String q = "Update Event set Eventname='"+e.getEventname()+"',eventdate='"+e.getDate()+"',timestart='"+e.getTimestart()
					+"',timeend='"+e.getTimeend()+"',days='"+e.getDays()+"',address='"+e.getAddress()+"',states='"+e.getStates()
					+"',city='"+e.getCity()+"',organizedby='"+e.getOrganizedby()
					+"' where Eventid = "+e.getEventid();
			System.out.println(q);
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("EventController editRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static boolean editIcon(String eid, String filename){
		try{
			String q = "update Event set Icon='"+filename+"' where Eventid="+eid;
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("EventController editRecord error: "+ee.getMessage());
			return false;
		}
	}
	public static boolean deleteRecord(String eid){
		try{
			String q = "delete from Event where Eventid="+eid;
			return (DBHelper.executeUpdate(q));
		}
		catch(Exception ee){
			System.out.println("EventController editRecord error: "+ee.getMessage());
			return false;
		}
	}
	
}
