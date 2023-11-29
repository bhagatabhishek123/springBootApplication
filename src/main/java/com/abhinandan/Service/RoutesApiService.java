package com.abhinandan.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.abhinandan.Request.Filterrequest;
import com.google.maps.model.LatLng;
import com.google.maps.routing.v2.ComputeRoutesRequest;
import com.google.maps.routing.v2.ComputeRoutesResponse;
import com.google.maps.routing.v2.RouteTravelMode;
import com.google.maps.routing.v2.RoutesClient;
import com.google.maps.routing.v2.RoutesSettings;
import com.google.maps.routing.v2.RoutingPreference;
import com.google.maps.routing.v2.Waypoint;

@Service
public class RoutesApiService {

	public ComputeRoutesResponse getroute(Filterrequest filterrequest) throws IOException {
	
		String slat = filterrequest.getSlat();
		String slng = filterrequest.getSlng();

		String dlat = filterrequest.getDlat();
		String dlng = filterrequest.getDlng();

		LatLng slatlng = new LatLng(Double.valueOf(slat), Double.valueOf(slng));
		LatLng dlatlng = new LatLng(Double.valueOf(dlat), Double.valueOf(dlng));
		
		
		 RoutesSettings routesSettings = RoutesSettings.newBuilder()
	              .setHeaderProvider(() -> {
	                  Map headers = new HashMap<>();
	                  headers.put("X-Goog-FieldMask", "*");
	                  return headers;
	              }).build();
	      RoutesClient routesClient = RoutesClient.create(routesSettings);
		
		ComputeRoutesResponse response = routesClient.computeRoutes(ComputeRoutesRequest.newBuilder()
	              .setOrigin(Waypoint.newBuilder().setPlaceId("ChIJeRpOeF67j4AR9ydy_PIzPuM").build())
	              .setDestination(Waypoint.newBuilder().setPlaceId("ChIJG3kh4hq6j4AR_XuFQnV0_t8").build())
	              .setRoutingPreference(RoutingPreference.TRAFFIC_AWARE)
	              .setTravelMode(RouteTravelMode.TWO_WHEELER).build());
		
		return response;
		
	}
	
}
