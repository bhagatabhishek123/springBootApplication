package com.abhinandan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinandan.Entity.Testdata;

public interface TestdataRepository extends JpaRepository<Testdata, Long>{

}
