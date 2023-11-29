package com.abhinandan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abhinandan.Entity.Geocoding;
import com.abhinandan.Entity.NearBySearch;
import com.abhinandan.Request.Filterrequest;

@Repository
public interface NearBySearchRepository extends JpaRepository<NearBySearch, Long> {

	List<NearBySearch> findBykeyword(String keyword);

	@Query("select n from NearBySearch n where n.searchPlaceId =:x")
	List<NearBySearch> findBysearchPlaceId(@Param("x") String searchPlaceId);

	List<NearBySearch> findBysearchPlaceIdAndKeyword(String placeid, String keyword2);

}
