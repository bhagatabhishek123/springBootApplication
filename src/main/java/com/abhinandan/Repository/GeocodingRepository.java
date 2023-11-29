package com.abhinandan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhinandan.Entity.Geocoding;
import com.abhinandan.Request.Filterrequest;

@Repository
public interface GeocodingRepository extends JpaRepository<Geocoding, Long>{

	Geocoding save(Filterrequest filterrequest);

}
