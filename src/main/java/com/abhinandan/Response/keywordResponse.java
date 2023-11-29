package com.abhinandan.Response;

import com.abhinandan.Entity.NearBySearch;

public class keywordResponse {

	private GeocodingResponse geocodingResponse;
	
	private Long id;
	
	private String keyword;
	
	private String searchPlaceId;
	
	private String resultPlcaeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchPlaceId() {
		return searchPlaceId;
	}

	public void setSearchPlaceId(String searchPlaceId) {
		this.searchPlaceId = searchPlaceId;
	}

	public String getResultPlcaeId() {
		return resultPlcaeId;
	}

	public void setResultPlcaeId(String resultPlcaeId) {
		this.resultPlcaeId = resultPlcaeId;
	}
	

	public GeocodingResponse getGeocodingResponse() {
		return geocodingResponse;
	}

	public void setGeocodingResponse(GeocodingResponse geocodingResponse) {
		this.geocodingResponse = geocodingResponse;
	}

	public keywordResponse(NearBySearch n) {
		super();
		
		this.id = n.getId();
		this.keyword = n.getKeyword();
		this.searchPlaceId = n.getSearchPlaceId();
		this.resultPlcaeId = n.getResultPlcaeId();
	}

	public keywordResponse(GeocodingResponse geocodingResponse, NearBySearch n) {
		this.geocodingResponse = geocodingResponse;
		this.id = n.getId();
		this.keyword = n.getKeyword();
		this.searchPlaceId = n.getSearchPlaceId();
		this.resultPlcaeId = n.getResultPlcaeId();
	}
	
	
	
	
	
}
