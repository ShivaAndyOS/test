package com.invia.serveasy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invia.serveasy.exception.ResourceNotFoundException;
import com.invia.serveasy.model.Manufacture;
import com.invia.serveasy.model.Vehicle;
import com.invia.serveasy.repository.ManufactureRepository;
import com.invia.serveasy.repository.VehicleRepository;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleRepository repository;
    
    @GetMapping("/vehicle")
    public List<Vehicle>  getAllList(){
    	return repository.findAll();
    }

    @PostMapping("/vehicle")
    public Vehicle create(@Valid @RequestBody Vehicle note) {
        return repository.save(note);
    }
    
    @GetMapping("/vehicle/{id}")
    public Vehicle  getManufactureById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacture", "id", id));
    }
}
