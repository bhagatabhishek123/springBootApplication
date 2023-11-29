package com.abhinandan.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinandan.Entity.Geocoding;
import com.abhinandan.Service.GeocodingService;

@RestController
@RequestMapping("/geocoding")
public class GeocodingController {

	@Autowired
	private GeocodingService geocodingService;

	@PostMapping("/savegeocode")
	public ResponseEntity<Geocoding> getgeocode(@RequestBody Geocoding filterrequest) {

		try {
			Geocoding getgeocode = geocodingService.getgeocode(filterrequest);
			return new ResponseEntity<Geocoding>(getgeocode, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
