package com.abhinandan.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.abhinandan.Request.Filterrequest;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TravelMode;

@Service
public class DirectionService {

	String API = "AIzaSyARuQeImqp79HYTnWQQ6HNSX4ThXoccBZY";

	public DirectionsResult getdirection(Filterrequest filterrequest)
			throws ApiException, InterruptedException, IOException {

		String slat = filterrequest.getSlat();
		String slng = filterrequest.getSlng();

		String dlat = filterrequest.getDlat();
		String dlng = filterrequest.getDlng();	

		LatLng slatlng = new LatLng(Double.valueOf(slat), Double.valueOf(slng));
		LatLng dlatlng = new LatLng(Double.valueOf(dlat), Double.valueOf(dlng));

		GeoApiContext context = new GeoApiContext.Builder().apiKey(API).build();

		return DirectionsApi.newRequest(context).origin(slatlng).destination(dlatlng).mode(TravelMode.DRIVING).await();

	}

}
