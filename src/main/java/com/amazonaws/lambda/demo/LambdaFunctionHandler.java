package com.amazonaws.lambda.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dateapp.eventbriteeventapi.model.Event;
import com.dateapp.eventbriteeventapi.model.EventBritePOJO;
import com.dateapp.eventbriteeventapi.model.VenuePOJO;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LambdaFunctionHandler implements RequestHandler<Map<String, Object>, String> {

	public static String SEARCH_ACTION_INTEGRATION_URL = "https://www.eventbriteapi.com/v3/events/search/?location.address=chicago&location.within=25mi&token=77W2M7QMNNF2NT5YPVZD&page=%d";
	public static String VENUE_INFO_URL = "https://www.eventbriteapi.com/v3/venues/%s/?token=77W2M7QMNNF2NT5YPVZD";
	
	@Override
	public String handleRequest(Map<String, Object> input, Context context) {
		
		if (input != null)
			context.getLogger().log("Input: " + input.get("location"));
		try {
		   
		   startLoad();
			} catch (Exception e) {
			System.out.println("Exception thrown from Event brite integration " + e.getMessage());
		}
		return "SUCCESS";
	}
	

/**
  *  Function to test the load.
  */
	public void startLoad() {
		redirectLogsToFile();
		 call_integration_url(0);
	}
	/**
	 * Function to log out the sysouts to log file.
	 */
	public void redirectLogsToFile() {
		// Creating a File object that represents the disk file. 
				PrintStream o;
				try {
					o = new PrintStream(new File("Log.txt")); 
					PrintStream console = System.out; 
					System.setOut(o); 
				} catch (FileNotFoundException e) {
					System.out.println("Error redirecting logs to file");
				} 
	}

	/**
	 * Function to call Event brite Integration URL.
	 * @return
	 * @throws Exception
	 */
	public EventBritePOJO call_integration_url(int pageNumber) {
		
		StringBuffer content = new StringBuffer();
		EventBritePOJO eventbriteObj = new EventBritePOJO();
		ObjectMapper objectMapper = new ObjectMapper();
		URL url;
		String output = null;
		try {
			System.out.println("Page :" +pageNumber);
			url = new URL(String.format(SEARCH_ACTION_INTEGRATION_URL,pageNumber));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			con.setAllowUserInteraction(false);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((output = br.readLine()) != null) {
				content.append(output);
			}
			con.disconnect();
			eventbriteObj = objectMapper.readValue(content.toString(), EventBritePOJO.class);
			persist_events(eventbriteObj);
			if(eventbriteObj.getPagination().getHasMoreItems()) {
				pageNumber++;
				call_integration_url(pageNumber);
				if(pageNumber == eventbriteObj.getPagination().getPageCount()) System.out.println("!!!!!!!Done Loading!!!!!");
			}
		} catch (IOException e) {
			System.out.println("Exception converting the object" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception thrown from Event brite integration " + e.getMessage());
		}

		return eventbriteObj;
	}

	/**
	 * Function to persist events into the Events Database.
	 * 
	 */
	public void persist_events(EventBritePOJO eventObj) {
		List<Event> eventsList = eventObj.getEvents();
		Connection conn = null;
		String query;
		try {
			conn = getConnection();
			for (int eventIter = 0; eventIter < eventsList.size(); eventIter++) {
				VenuePOJO venueObj = getEventVenueInfo(eventsList.get(eventIter).getVenueId());
				query = insertEventInfoToDB(eventsList.get(eventIter), venueObj);
				System.out.println("Query returned " + query);
				Statement statement = conn.createStatement();
				statement.executeUpdate(query);

			}
		} catch (SQLException e) {
			System.out.println("Issue with persisting the records into Event DB" + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error closing Connection" + e.getMessage());
			}
		}

	}
  /**
   * Get the SQL Connection.
   * For connection details . Contact the Author..
   * @return
   */
	private Connection getConnection() {
		String host = "test";
		String userName = "test";
		String password = "test";
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(host, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


	/**
	 * Function to insert events to RDS DB
	 * 
	 * @param event
	 * @param venueObj
	 * @return
	 */
	private String insertEventInfoToDB(Event event, VenuePOJO venueObj) {
		StringBuilder sb = new StringBuilder();
		String INSERT_QUERY = "INSERT INTO public.eb_event (description, eb_name, eb_url, eb_id, event_timezone, event_start_time, event_end_time, eb_organization_id,"
				+ " status, online_event, is_free, venue_id, category_id, subcategory_id,"
				+ " eb_image_url) \n"
				+ "VALUES";
		if(event !=null ){
		if(venueObj != null) {
	       INSERT_QUERY = "INSERT INTO public.eb_event (description, eb_name, eb_url, eb_id, event_timezone, event_start_time, event_end_time, eb_organization_id, status, online_event, is_free, venue_id, category_id, subcategory_id,"
					+ " eb_image_url, address1, address2,city,state, country,zip_code,latitude, longitude,display_address, multiline_display_address, venue_name) \n"
					+ "VALUES";
		}
		sb.append(INSERT_QUERY);
		sb.append("(");
	   if(event.getDescription() != null && event.getDescription().getText()!=null)	sb.append("'" + event.getDescription().getText().replaceAll("'", "''") + "',"); else sb.append("'',");
	   if(event.getName() != null && event.getName().getText()!=null)sb.append("'" +  event.getName().getText().replaceAll("'", "''") + "',"); else sb.append("'',");
		if(event.getUrl()!=null )sb.append("'" + event.getUrl().replaceAll("'", "''")+ "',");else sb.append("'',");
		if(event.getId() !=null )sb.append("'" +  event.getId() + "',");else sb.append("'',");
		if(event.getStart() !=null && event.getStart().getTimezone()!=null )sb.append("'" +  event.getStart().getTimezone()+ "',");  else sb.append("'',");
		if( event.getStart()!=null && event.getStart().getLocal() !=null)sb.append("'" +event.getStart().getLocal()  + "',");else sb.append("'',");
		if(event.getEnd()!=null && event.getEnd().getLocal() !=null)sb.append("'" +  event.getEnd().getLocal() + "',");else sb.append("'',");
		if(event.getOrganizationId()!=null)sb.append("'" +  event.getOrganizationId()  + "',"); else sb.append("'',");
		if(event.getStatus() !=null)sb.append("'" +  event.getStatus() + "',"); else sb.append("'',");
		if(event.getOnlineEvent()!=null)sb.append("'" +  event.getOnlineEvent() + "',"); else sb.append("'',");
		if(event.getIsFree() !=null)sb.append("'" +  event.getIsFree()  + "',"); else sb.append("'',");
		if(event.getVenueId()!=null)sb.append("'" +   event.getVenueId() + "',"); else sb.append("'',");
		if(event.getCategoryId()!=null)sb.append("'" +  event.getCategoryId() + "',"); else sb.append("'0',");
		if(event.getSubcategoryId()!=null)sb.append("'" + event.getSubcategoryId() + "',"); else sb.append("'',");
		if(event.getLogo()!=null && event.getLogo().getOriginal()!=null && event.getLogo().getOriginal().getUrl()!=null) sb.append("'" +  event.getLogo().getOriginal().getUrl().replaceAll("'", "''")+ "',"); else sb.append("'',");
		if(venueObj != null && venueObj.getAddress()!=null) {
			if(venueObj.getAddress().getAddress1()!=null)sb.append("'" +   venueObj.getAddress().getAddress1().replaceAll("'", "''") + "',"); else sb.append("'',");
		if(venueObj.getAddress().getAddress2()!=null)	sb.append("'" +   venueObj.getAddress().getAddress2().replaceAll("'", "''") + "',"); else sb.append("'',");
			if(venueObj.getAddress().getCity()!=null)sb.append("'" +   venueObj.getAddress().getCity().replaceAll("'", "''") + "',"); else sb.append("'',");
			if( venueObj.getAddress().getRegion()!=null )sb.append("'" +  venueObj.getAddress().getRegion().replaceAll("'", "''") + "',"); else sb.append("'',");
			if( venueObj.getAddress().getCountry()!=null)sb.append("'" +  venueObj.getAddress().getCountry().replaceAll("'", "''") + "',"); else sb.append("'',");
			if( venueObj.getAddress().getPostalCode()!=null) sb.append("'" +  venueObj.getAddress().getPostalCode() + "',"); else sb.append("'',");
			if(venueObj.getAddress().getLatitude()!=null)sb.append("'" +   venueObj.getAddress().getLatitude().replaceAll("'", "''") + "',"); else sb.append("'',");
			if(venueObj.getAddress().getLongitude()!=null)sb.append("'" +    venueObj.getAddress().getLongitude().replaceAll("'", "''") + "',"); else sb.append("'',");
			if(venueObj.getAddress().getLocalizedAddressDisplay()!=null)sb.append("'" +   venueObj.getAddress().getLocalizedAddressDisplay().replaceAll("'", "''") + "',"); else sb.append("'',");
			if(venueObj.getAddress().getLocalizedMultiLineAddressDisplay()!=null) sb.append("'" +  venueObj.getAddress().getLocalizedMultiLineAddressDisplay().toString().replaceAll("'", "''") + "',");	 else sb.append("'',");
		}
		if(venueObj.getName() !=null) sb.append("'" +  venueObj.getName().replaceAll("'", "''") + "'"); else sb.append("''");
		
		sb.append("),");
		
		

		sb.deleteCharAt(sb.length() - 1);
		sb.append(" ON CONFLICT DO NOTHING");
		}
		return sb.toString();

	}

	/**
	 * Function to get the Venue Information.
	 * 
	 * @param venueId
	 * @return
	 */
	private VenuePOJO getEventVenueInfo(String venueId) {
		URL url;
		HttpURLConnection con = null;
		VenuePOJO venueObj = new VenuePOJO();
		StringBuffer venueContent = new StringBuffer();
		String output = null;
		try {
			url = new URL(String.format(VENUE_INFO_URL, venueId));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			con.setAllowUserInteraction(false);
			System.out.println("Calling Venue" + url);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((output = br.readLine()) != null) {
				venueContent.append(output);
			}
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				venueObj = objectMapper.readValue(venueContent.toString(), VenuePOJO.class);
			} catch (IOException e) {
				System.out.println("Exception converting the object" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		con.disconnect();

		return venueObj;

	}

	


}