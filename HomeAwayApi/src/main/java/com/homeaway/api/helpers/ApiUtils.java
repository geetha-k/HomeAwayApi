
package main.java.com.homeaway.api.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiUtils {
	public String getStationId(StringBuffer response) throws JSONException {
		String stationId="";
		JSONObject jObject = new JSONObject(response.toString());
		JSONArray fuelStations     = jObject.getJSONArray("fuel_stations");
		for (int n=0; n<fuelStations.length();n++) {
		JSONObject obj = fuelStations.getJSONObject(n);
		if (obj.getString("station_name").equals("HYATT AUSTIN")) {
		stationId = obj.getString("id");
		}
	}
	return stationId;
	}
	public String getStationAddress(StringBuffer response) throws JSONException {
		String stationAddress="";
		JSONObject jObject = new JSONObject(response.toString());
		JSONArray fuelStations     = jObject.getJSONArray("fuel_stations");
		for (int n=0; n<fuelStations.length();n++) {
		JSONObject obj = fuelStations.getJSONObject(n);
		if (obj.getString("station_name").equals("HYATT AUSTIN")) {
		stationAddress = obj.getString("street_address") + "," + obj.getString("city") + "," +  obj.getString("state") + "," + obj.getString("zip");
		}
		}
		return stationAddress;
	}

}
