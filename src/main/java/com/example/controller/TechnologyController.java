package com.example.controller;

import com.example.dao.TechnologyDAO;
import com.example.entity.*;

import com.example.exception.ResourceNotFoundException;
import com.example.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tech")
public class TechnologyController {

    @Autowired
    private TechnologyRepository tech_repository;

    @Autowired
    private TechnologyDAO tech_dao;


    //TODO logic insert a new record
    @PostMapping("/create")
    public TechnologyModel createTech( @RequestBody TechnologyModel tech)
    {
        tech.setStatus("Active");
        return tech_dao.save(tech);
    }

    //TODO logic Get all records
    @GetMapping("/technologyGetAll")
    public List<TechnologyModel> getAllTech()
    {
        return tech_repository.findAll();
    }


    //TODO logic Get a records by ID
    @GetMapping("/tectId/{id}")
    public ResponseEntity<TechnologyModel> getUserById(
            @PathVariable(value = "id") Long tech_id) throws ResourceNotFoundException {
        TechnologyModel tech = tech_repository.findById(tech_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + tech_id));
        return ResponseEntity.ok().body(tech);
    }



    //TODO logic update a record
    @PutMapping("/tech/{tech_id}")
    public ResponseEntity<TechnologyModel> updateTech(
            @PathVariable(value = "tech_id") Long tech_id,
            @Valid @RequestBody TechnologyModel techDetails) throws ResourceNotFoundException {
        TechnologyModel t = tech_repository.findById(tech_id)
                .orElseThrow(() -> new ResourceNotFoundException("Technolpgy not found :: " + tech_id));

        t.setTech_name(techDetails.getTech_name());
        t.setUpdatedAt(new Date());
        final TechnologyModel updatedUser = tech_repository.save(t);
        return ResponseEntity.ok(updatedUser);
    }


    //TODO logic delete a record
    @PutMapping("/techdelete/{tech_id}")
    public ResponseEntity<TechnologyModel> deletetech(
            @PathVariable(value = "tech_id") Long tech_id,
            @Valid @RequestBody TechnologyModel cityDetails) throws ResourceNotFoundException {
        TechnologyModel c = tech_repository.findById(tech_id)
                .orElseThrow(() -> new ResourceNotFoundException("Technolpgy not found :: " + tech_id));

        c.setStatus("Inactive");
        c.setUpdatedAt(new Date());
        final TechnologyModel updatedUser = tech_repository.save(c);
        return ResponseEntity.ok(updatedUser);
    }







}
