package com.abhinandan.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinandan.Request.Filterrequest;
import com.abhinandan.Service.DirectionService;
import com.abhinandan.Service.TextSearch;
import com.abhinandan.Service.dummyuriservice;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;

@RestController
@RequestMapping("/direction")
public class DirectionController {

	@Autowired
	private DirectionService directionService;
	
	@Autowired
	private TextSearch textsaerSearch;
	
	@Autowired
	private dummyuriservice dummyuriservice;
	
	@PostMapping("/getdirection")
	public DirectionsResult getdirection(@RequestBody Filterrequest filterrequest) throws ApiException, InterruptedException, IOException {
		return directionService.getdirection(filterrequest);
	}
	
	@GetMapping("/getapi")
	public ResponseEntity<String> getdirection(){
		return dummyuriservice.getapi();
	}
	
	@PostMapping("/ts")
	public Object ts(){
		return textsaerSearch.ts();
	}
	
	

}
