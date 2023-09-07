package com.springboot.couchbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.couchbase.entity.Doctor;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

//lombok annotation
@Slf4j
//spring annotations
@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorService service;

    //URL - http://localhost:9300/api/doctors
    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctors() {
        return service.getDoctors();
    }

    //URL - http://localhost:9300/api/doctor/<eid>
    //Example - http://localhost:9300/api/doctor/73a02968-70a8-426a-b6d8-deaa96a597df
    @GetMapping("/doctor/{eid}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctorById(@PathVariable String eid)
            throws EntityNotFound {
        return service.getDoctor(eid);
    }

    //URL - http://localhost:9300/api/doctor/<work_department>
    //Example - http://localhost:9300/api/doctors/Health
   
    //URL - http://localhost:9300/api/doctors/count
    @GetMapping("/doctors/count")
    @ResponseStatus(HttpStatus.OK)
    public long getTotalDoctors() {
        return service.count();
    }
    
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Doctor registerDoctor(@RequestBody Doctor doctor) throws EntityNotFound {
        return service.insertDoctor(doctor);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Doctor updateDoctor(@RequestBody Doctor doctor) throws EntityNotFound {
        return service.updateDoctor(doctor);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteDoctor(@PathVariable("id") String id) throws EntityNotFound {
        service.deleteDoctor(id);
        
        return "Doctor deleted successfully";
    }
}
