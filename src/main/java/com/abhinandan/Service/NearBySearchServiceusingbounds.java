package com.abhinandan.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinandan.Controller.ReverseGeoCoding;
import com.abhinandan.Entity.NearBySearch;
import com.abhinandan.Repository.NearBySearchRepository;
import com.abhinandan.Request.Filterrequest;
import com.google.api.client.http.HttpRequest;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceAutocompleteType;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.RankBy;
import com.google.type.LatLngOrBuilder;

@Service
public class NearBySearchServiceusingbounds {

	String API = "AIzaSyARuQeImqp79HYTnWQQ6HNSX4ThXoccBZY";
	@Autowired
	private NearBySearchRepository nearBySearchRepository;

	@Autowired
	private RevGeocodingService reveGeocodingService;

	GeoApiContext context = new GeoApiContext.Builder().apiKey(API).build();

	public List<String> getnbs(Filterrequest filterrequest) throws ApiException, InterruptedException, IOException {

		String slat = filterrequest.getSlat();
		String slng = filterrequest.getSlng();
		String dlat = filterrequest.getDlat();
		String dlng = filterrequest.getDlng();
		String keyword2 = filterrequest.getKeyword();

		LatLng ll = new LatLng(Double.parseDouble(slat), Double.parseDouble(slng));
		LatLng dll = new LatLng(Double.parseDouble(dlat), Double.parseDouble(dlng));
		List<LatLng> bll = new ArrayList<>();
		bll.add(ll);
		bll.add(dll);
		System.out.println(bll);

		
		
//		LatLng bll = new LatLng();
		
//		List<String> getrgc = reveGeocodingService.getrgc(lat, lng);
		List<String> pi = new ArrayList<>();
		PlacesSearchResponse await = PlacesApi.nearbySearchQuery(context, dll).keyword(keyword2).radius(1000).rankby(RankBy.DISTANCE).await();
//		String placeid = getrgc.get(0);

//		List<NearBySearch> findBysearchPlaceId = nearBySearchRepository.findBysearchPlaceId(placeid);

//		List<NearBySearch> findBykeyword = nearBySearchRepository.findBykeyword(keyword2);

//		if (!findBysearchPlaceId.isEmpty() && !findBykeyword.isEmpty()) {
//
//			List<NearBySearch> findBysearchPlaceIdAndKeyword = nearBySearchRepository
//					.findBysearchPlaceIdAndKeyword(placeid, keyword2);
//
//			for (int i = 0; i < findBysearchPlaceIdAndKeyword.size(); i++) {
//			   	String resultPlcaeId = findBysearchPlaceIdAndKeyword.get(i).getResultPlcaeId();
//				pi.add(resultPlcaeId);
//			}
//
//			return pi;
//
//		}

		PlacesSearchResponse keyword = PlacesApi.nearbySearchQuery(context, ll).radius(5000).keyword(keyword2).await();
	    
		for (int i = 0; i < keyword.results.length; i++) {

			pi.add(keyword.results[i].placeId);

			NearBySearch n = new NearBySearch();
//			n.setSearchPlaceId(placeid);
			n.setResultPlcaeId(keyword.results[i].placeId);
			n.setKeyword(keyword2);

			nearBySearchRepository.save(n);
		}

		return pi;
	}

	public List<NearBySearch> getbykeyword(Filterrequest filterrequest) {
		String keyword = filterrequest.getKeyword();

		try {

			List<NearBySearch> findbykeyword = nearBySearchRepository.findBykeyword(keyword);

			return findbykeyword;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<NearBySearch> getbyplaceid(Filterrequest filterrequest) {
		String searchPlaceId = filterrequest.getPlaceid();

		try {

			List<NearBySearch> findbykeyword = nearBySearchRepository.findBysearchPlaceId(searchPlaceId);

			return findbykeyword;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Integer> getmap() {

		List<String> l = new ArrayList<>();
		l.add("store");
		l.add("ATM");
		l.add("Bank");

		Map<String, Integer> nhm = new HashMap<>();

		for (int i = 0; i < l.size(); i++) {
			String s = l.get(i);
			List<NearBySearch> findBykeyword = nearBySearchRepository.findBykeyword(s);
			nhm.put(s, findBykeyword.size());
		}

		return nhm;

	}

}
