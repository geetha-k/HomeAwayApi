
package test.java.com.homeaway.api.testcases;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import main.java.com.homeaway.api.helpers.ApiUtils;
import main.java.com.homeaway.api.helpers.GetStations;

public class TransportationTest {
	
	@Test
	public void testStationId() throws IOException, JSONException {
		String expectedId = "62029";
		ApiUtils apiUtils = new ApiUtils();
		GetStations stations = new GetStations();
		StringBuffer strResponse = stations.getStationsByLocation("dL8tYRsPVoio5v8LLSabFuJkW0InvdrggQ2nA4n8","Austin", "TX");
		String stationID = apiUtils.getStationId(strResponse);
		Assert.assertEquals(expectedId, stationID);
	}
	@Test
	public void testStationAddress() throws IOException, JSONException {
		String stationAddress = "208 Barton Springs Rd,Austin,TX,78704";
		ApiUtils apiUtils = new ApiUtils();
		GetStations stations = new GetStations();
		StringBuffer strResponse = stations.getStationsByLocation("dL8tYRsPVoio5v8LLSabFuJkW0InvdrggQ2nA4n8","Austin", "TX");
		String actualStationAddress = apiUtils.getStationAddress(strResponse);
		Assert.assertEquals(stationAddress, actualStationAddress);
	}
}