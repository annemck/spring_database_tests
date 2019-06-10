package com.codeclan.example.PirateService.controllers;

import com.codeclan.example.PirateService.models.Pirate;
import com.codeclan.example.PirateService.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//this tells java this is a rest controller
@RestController
//this tells the controller what the start of the route is
@RequestMapping(value = "/pirates")
public class PirateController {

    @Autowired
    PirateRepository pirateRepository;

//    this is the route for getting all the pirates
//    list is an implementation of arrayList in java
//    the annotation tells it when this will be implemented and that it's listening for get requests
//    you can give it a value if you wish to give it a route like /pirates/getAllPirates
//    you would just put value = "/getAllPirates"
    @GetMapping
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }

    @GetMapping(value = "{id}")
//    optional is because it may be a pirate or may be null (depending on if the id exists)
//    pathvariable gives us access to the param {id} in the value
    public Optional<Pirate> getPirate(@PathVariable Long id){
        return pirateRepository.findById(id);
    }

}
