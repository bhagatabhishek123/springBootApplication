package com.abhinandan.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinandan.Entity.NearBySearch;
import com.abhinandan.Repository.NearBySearchRepository;
import com.abhinandan.Request.Filterrequest;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;

@Service
public class NearBySearchService {

	String API = "AIzaSyARuQeImqp79HYTnWQQ6HNSX4ThXoccBZY";
	@Autowired
	private NearBySearchRepository nearBySearchRepository;

	@Autowired
	private RevGeocodingService reveGeocodingService;
	

	GeoApiContext context = new GeoApiContext.Builder().apiKey(API).build();

	public List<String> getnbs(String lat,String lng,String keyword) throws ApiException, InterruptedException, IOException {

//		String lat = filterrequest.getLat();
//		String lng = filterrequest.getLng();
//		String keyword2 = filterrequest.getKeyword();

		LatLng ll = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));

		List<String> getrgc = reveGeocodingService.getrgc(lat, lng);


		List<String> pi = new ArrayList<>();

		String placeid = getrgc.get(0);

		List<NearBySearch> findBysearchPlaceId = nearBySearchRepository.findBysearchPlaceId(placeid);

		List<NearBySearch> findBykeyword = nearBySearchRepository.findBykeyword(keyword);

		if (!findBysearchPlaceId.isEmpty() && !findBykeyword.isEmpty()) {

			List<NearBySearch> findBysearchPlaceIdAndKeyword = nearBySearchRepository
					.findBysearchPlaceIdAndKeyword(placeid, keyword);

			for (int i = 0; i < findBysearchPlaceIdAndKeyword.size(); i++) {
			   	String resultPlcaeId = findBysearchPlaceIdAndKeyword.get(i).getResultPlcaeId();
				pi.add(resultPlcaeId);
			}

			return pi;

		}

		PlacesSearchResponse keyword1 = PlacesApi.nearbySearchQuery(context, ll).radius(1000).keyword(keyword).await();
	   
		for (int i = 0; i < keyword1.results.length; i++) {

			pi.add(keyword1.results[i].placeId);

			NearBySearch n = new NearBySearch();
			n.setSearchPlaceId(placeid);
			n.setResultPlcaeId(keyword1.results[i].placeId);
			n.setKeyword(keyword);

			nearBySearchRepository.save(n);
		}

		return pi;
	}

	public List<NearBySearch> getbykeyword(Filterrequest filterrequest) {
		String keyword = filterrequest.getKeyword();

		try {

			List<NearBySearch> findbykeyword = nearBySearchRepository.findBykeyword(keyword);
//			List<keywordResponse> o = new ArrayList<>();
//			for(int i=0;i<findbykeyword.size();i++) {
//			keywordResponse k = new keywordResponse(findbykeyword.get(i));
//			o.add(k);
//			}
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
