
package main.java.com.homeaway.api.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetStations {
	String apiUrl = "https://developer.nrel.gov/api/alt-fuel-stations/v1/nearest.json?api_key=";
	String api_key= "dL8tYRsPVoio5v8LLSabFuJkW0InvdrggQ2nA4n8";
		public GetStations() {
		//empty constructor.
		}
		public StringBuffer getStationsByLocation(String apiKey, String city, String state) throws IOException {
			String getStationsEndpoint = apiUrl + apiKey + "&location=" + city + "+" + state + "&ev_network=ChargePoint" + "+" + "Network";
			URL obj = new URL(getStationsEndpoint);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
		
			while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			}
			in.close();
			return response;
		}
}