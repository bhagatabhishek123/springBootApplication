package com.abhinandan.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhinandan.Entity.NearBySearch;
import com.abhinandan.Request.Filterrequest;
import com.abhinandan.Service.NearBySearchService;
import com.abhinandan.payload.ResponsePayload;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/nearbysearch")
public class NearBySearchController {

	@Autowired
	private NearBySearchService nearBySearchService;

	@GetMapping("/getnbs")
	public ResponseEntity<List<String>> nearbysearch(@RequestParam String lat,@RequestParam String lng, @RequestParam String keyword) {

		try {
			List<String> getnbs = nearBySearchService.getnbs(lat, lng, keyword);

			return ResponseEntity.status(HttpStatus.OK).body(getnbs);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

	@PostMapping("/getbykeyword")
	public ResponsePayload getbykeyword(@RequestBody Filterrequest filterrequest) {

		try {
			List<NearBySearch> gbk = nearBySearchService.getbykeyword(filterrequest);

			return new ResponsePayload(gbk, "retrived succesfully", 200);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponsePayload(e, "some exception", 500);

		}

	}

	@PostMapping("/getbyplaceid")
	public ResponsePayload getbyplaceid(@RequestBody Filterrequest filterrequest) {

		try {
			List<NearBySearch> gbk = nearBySearchService.getbyplaceid(filterrequest);

			return new ResponsePayload(gbk, "retrived succesfully", 200);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponsePayload(e, "some exception", 500);

		}

	}

	@GetMapping("/getmap")
	public ResponseEntity<Map<String, Integer>> getmap() {
		Map<String, Integer> getmap = nearBySearchService.getmap();
		return ResponseEntity.status(HttpStatus.OK).body(getmap);
	}

}
