package com.abhinandan.Entity;

import com.google.maps.model.LatLng;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Direction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LatLng slatng;

	private LatLng dlatlng;

	public LatLng getSlatng() {
		return slatng;
	}

	public void setSlatng(LatLng slatng) {
		this.slatng = slatng;
	}

	public LatLng getDlatlng() {
		return dlatlng;
	}

	public void setDlatlng(LatLng dlatlng) {
		this.dlatlng = dlatlng;
	}

	public Direction() {
		super();
	}

	public Direction(LatLng slatng, LatLng dlatlng) {
		super();
		this.slatng = slatng;
		this.dlatlng = dlatlng;
	}

}
