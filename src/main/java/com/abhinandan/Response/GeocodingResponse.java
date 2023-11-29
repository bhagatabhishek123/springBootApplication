package com.abhinandan.Response;

import com.abhinandan.Entity.Geocoding;

public class GeocodingResponse {

	private Long id;
	
	private String address;
	
	private String lat;
	
	private String lng;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public GeocodingResponse(Geocoding g) {
		this.address = g.getAddress();
		this.lat = g.getLat();
		this.lng = g.getLng();
	}
	
	
	
}
