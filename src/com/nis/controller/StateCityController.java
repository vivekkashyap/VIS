package com.nis.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONObject;

import com.nis.dao.DBHelper;

public class StateCityController {
public static ArrayList<JSONObject> fetchAllStates()
{try{
	ResultSet rs=DBHelper.executeQuery("select * from states");
	ArrayList<JSONObject> objects=DBHelper.JsonEngine(rs);
	return(objects);
}catch(Exception e){
	System.out.println(e);
	return(null);
}
 }

public static ArrayList<JSONObject> fetchAllCities(int stateid)
{try{
	ResultSet rs=DBHelper.executeQuery("select * from city where stateid="+stateid);
	ArrayList<JSONObject> objects=DBHelper.JsonEngine(rs);
	return(objects);
}catch(Exception e){
	System.out.println(e);
	return(null);
}}




}
