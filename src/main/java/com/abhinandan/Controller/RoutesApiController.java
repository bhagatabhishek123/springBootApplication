package com.abhinandan.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinandan.Request.Filterrequest;
import com.abhinandan.Service.RoutesApiService;
import com.google.maps.routing.v2.ComputeRoutesResponse;

@RestController
@RequestMapping("/routesapi")
public class RoutesApiController {

	@Autowired
	private RoutesApiService routesApiService;
	
	@PostMapping("/getroute")
	public ComputeRoutesResponse getroutes(@RequestBody Filterrequest filterrequest) throws IOException {
		
		ComputeRoutesResponse getroute = routesApiService.getroute(filterrequest);
		
		return getroute;
		
	}
	
}
