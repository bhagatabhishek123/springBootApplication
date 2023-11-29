package com.abhinandan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Testdata {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private double lat;

	private double lng;

	private String address;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Testdata() {
		super();
	}

	public Testdata(double lat, double lng, String address) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.address = address;
	}

}
