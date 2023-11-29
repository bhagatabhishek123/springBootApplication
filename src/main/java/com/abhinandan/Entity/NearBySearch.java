package com.abhinandan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NearBySearch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String keyword;

	private String searchPlaceId;

	private String resultPlcaeId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public NearBySearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NearBySearch(String keyword, String searchPlaceId, String resultPlcaeId) {
		super();
		this.keyword = keyword;
		this.searchPlaceId = searchPlaceId;
		this.resultPlcaeId = resultPlcaeId;
	}

}
