package com.abhinandan.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinandan.Entity.Geocoding;
import com.abhinandan.Repository.GeocodingRepository;
import com.abhinandan.Request.Filterrequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Service
public class GeocodingService {

	@Autowired
	private GeocodingRepository geocodingRepository;

	String API = "AIzaSyARuQeImqp79HYTnWQQ6HNSX4ThXoccBZY";

	public Geocoding getgeocode(Geocoding filterrequest)
			throws ApiException, InterruptedException, IOException {

		String address = filterrequest.getAddress();

		GeoApiContext context = new GeoApiContext.Builder().apiKey(API).build();

		GeocodingResult[] result = GeocodingApi.geocode(context, address).await();

		double lat = result[0].geometry.location.lat;
		double lng = result[0].geometry.location.lng;

		Geocoding g = new Geocoding();

		g.setAddress(address);
		g.setLat(String.valueOf(lat));
		g.setLng(String.valueOf(lng));
		
		geocodingRepository.save(g);


		return g;

	}

}
