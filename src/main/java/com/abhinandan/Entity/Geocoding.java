package com.abhinandan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "geocoding")
public class Geocoding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String lat;
	private String lng;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Geocoding() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Geocoding(String lat, String lng, String address) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.address = address;
	}
	public Geocoding(String address) {
		super();
		this.address = address;
	}
	
	
	
	
	
}
