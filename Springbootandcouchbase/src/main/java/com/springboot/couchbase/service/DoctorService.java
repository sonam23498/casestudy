package com.springboot.couchbase.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.couchbase.entity.Doctor;

import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.repository.DoctorRepository;

//spring annotation
@Service
public class DoctorService {

    @Autowired
    DoctorRepository repository;

   
    public void save(final Doctor e) {
        repository.save(e);
    }

   
    public long count() {
        return repository.count();
    }

    
    public List<Doctor> getDoctors() {
        final Iterable<Doctor> doctorIterable = repository.findAll();
        return StreamSupport.stream(doctorIterable.spliterator(), false).collect(Collectors.toList());
    }

   
    public Doctor getDoctor(final String did) throws EntityNotFound {
        return repository.findById(did).orElseThrow(EntityNotFound::new);
    }

  
    public Doctor insertDoctor(final Doctor doctor) throws EntityNotFound {
        return repository.save(doctor);
    }
    
 
    public Doctor updateDoctor(final Doctor doctor) throws EntityNotFound {
        return repository.save(doctor);
    }
    
  
    public void deleteDoctor(final String dId) throws EntityNotFound{
        repository.deleteById(dId);
    }
   
   
}
