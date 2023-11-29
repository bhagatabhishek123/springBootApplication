package com.abhinandan.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abhinandan.Request.Filterrequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

@Service
public class RevGeocodingService {

	public List<String> getrgc(String lat,String lng) throws ApiException, InterruptedException, IOException {

		String API = "AIzaSyARuQeImqp79HYTnWQQ6HNSX4ThXoccBZY";
//		String lat = filterrequest.getLat();
//		String lng = filterrequest.getLng();
		
		List<String> rg = new ArrayList<>();

		LatLng latlng = new LatLng(Double.valueOf(lat), Double.valueOf(lng));

		GeoApiContext context = new GeoApiContext.Builder().apiKey(API).build();

		GeocodingResult[] reverseGeocode = GeocodingApi.reverseGeocode(context, latlng).await();

	    rg.add(reverseGeocode[0].placeId);
	    rg.add(reverseGeocode[0].formattedAddress);
	    
	    
	    
	    return rg;

	}

}
