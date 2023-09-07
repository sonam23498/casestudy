package com.springboot.couchbase.repository;


import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.couchbase.entity.Doctor;


//couchbase annotations
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "doctor")
//spring annotation
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {

	
}
