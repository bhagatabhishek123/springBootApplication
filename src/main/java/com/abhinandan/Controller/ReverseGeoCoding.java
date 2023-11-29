package com.abhinandan.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinandan.Request.Filterrequest;
import com.abhinandan.Service.RevGeocodingService;
import com.abhinandan.payload.ResponsePayload;
import com.google.maps.errors.ApiException;

@RestController
@RequestMapping("/revgeocode")
public class ReverseGeoCoding {

	@Autowired
	private RevGeocodingService revGeocodingService;

	@PostMapping("/revgc")
	public ResponsePayload getrevgeocode(@RequestBody Filterrequest filterrequest)
			throws ApiException, InterruptedException, IOException {

		String lat = filterrequest.getLat();
		String lng = filterrequest.getLng();
		List<String> rg = revGeocodingService.getrgc(lat, lng);

		return new ResponsePayload(rg, "retrived succesfully", 200);

	}

}
