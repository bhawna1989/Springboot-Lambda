package com.datametrics.GetDmClientDetailApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//com.datametrics.GetDmClientDetailApi.App::handleRequest
public class App implements RequestHandler<Object, Object> {
	private Connection conn = null;

	@Override
	public Object handleRequest(Object input, Context context) {
		// TODO Auto-generated method stub
		System.out.println("input is "+input);
		 ObjectMapper mapper = new ObjectMapper();  
		 Long id = null;
		try {
			String jsonString = mapper.writeValueAsString(input);
			System.out.println("jsonString is "+jsonString);
			JSONParser parser = new JSONParser();  
			JSONObject jsonObj = (JSONObject) parser.parse(jsonString);  
			System.out.println("jsonObj is "+jsonObj);
			Object dmClientSiteReq =  jsonObj.get("queryStringParameters");
			System.out.println("dmClientSiteReq.toString() "+dmClientSiteReq.toString());
			Gson gson=new Gson();
			DmClientSiteResponse instance = gson.fromJson(dmClientSiteReq.toString(),DmClientSiteResponse.class);
             id = instance.getClientSiteId();
			System.out.println("instance "+instance);
			System.out.println("id "+id);
		} catch (JsonProcessingException e1) {
			System.out.println("e1 "+e1);
			e1.printStackTrace();
		} catch (ParseException e) {
			System.out.println("e "+e);
			e.printStackTrace();
		}
		DmClientSiteResponse dmclient = new DmClientSiteResponse();
		try {
			conn = makeConnection();
			String query = "SELECT  client_site_id, client_site_name, client_site_logo_url, client_site_url, sort_order, "
					+ "brand_mapping_type, good_returns_pct, bb_calculation_lookback_days, is_active_flag \r\n "
					+ " FROM portal.dm_client_site where client_site_id = ?  ";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dmclient.setClientSiteId(rs.getLong(1));
				dmclient.setClientSiteName(rs.getString(2));
				dmclient.setClientSiteLogoUrl(rs.getString(3));
				dmclient.setClientSiteUrl(rs.getString(4));
				dmclient.setSortOrder(rs.getInt(5));
				dmclient.setBrandMappingType(rs.getString(6));
				dmclient.setGoodReturnsPct(rs.getFloat(7));
				dmclient.setBbCalculationLookbackDays(rs.getInt(8));
				dmclient.setIsActiveFlag(rs.getInt(9));
				// System.out.println(rs.getString());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("exception n"+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return dmclient;
	}

	public  Connection makeConnection() throws ClassNotFoundException {
		//Connection conn;
		System.out.println("I want to make DB connection");
		Statement stmt = null;
		Class.forName("com.amazon.redshift.jdbc42.Driver");
		System.out.println("Driver found");
		String url = "jdbc:redshift://redshift-dm-dtc-76736-cluster.co4jeppkufgk.us-east-1.redshift.amazonaws.com:5439/dmdw";
			//String url = "jdbc:redshift://75.101.236.250:5439/dmdw";
		Properties props = new Properties();
		props.setProperty("user", "dmmstruser");
		props.setProperty("password", "pjxAyc4P3hY");
		System.out.println("properties set ");
		try {
			conn = DriverManager.getConnection(url, props);
			System.out.println("connection made successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("exception n"+e.getMessage());
			e.printStackTrace();
		}
		return conn ;
	}

	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
}
