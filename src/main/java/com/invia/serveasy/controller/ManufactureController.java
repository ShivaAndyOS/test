package com.invia.serveasy.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invia.serveasy.exception.ResourceNotFoundException;
import com.invia.serveasy.model.Manufacture;
import com.invia.serveasy.repository.ManufactureRepository;

@RestController
@RequestMapping("/api")
public class ManufactureController {

    @Autowired
    ManufactureRepository manufactureRepository;
    
    @GetMapping("/manufacture")
    public List<Manufacture>  getAllList(){
    	return manufactureRepository.findAll();
    }

    @PostMapping("/add-manufactures")
    public Manufacture create(@Valid @RequestBody Manufacture note) {
        return manufactureRepository.save(note);
    }
    
    @PostMapping("/manufacture")
    public List<Manufacture> createList(@Valid @RequestBody List<Manufacture> note) {
    	List<Manufacture> manufactures =new ArrayList<Manufacture>();
    	for(Manufacture m : note){
    		manufactures.add(manufactureRepository.save(m));
    	}
        return manufactures;
    }
    
    @GetMapping("/manufacture/{id}")
    public Manufacture  getManufactureById(@PathVariable(value = "id") Long id) {
        return manufactureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacture", "id", id));
    }

    @PutMapping("/manufacture/{id}")
    public Manufacture update(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Manufacture manufacture) {

    	Manufacture manu = manufactureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("manufacture", "id", id));

    	manu.setManufacture_name( manufacture.getManufacture_name());
    	Manufacture updatedNote = manufactureRepository.save(manu);
        return updatedNote;
    }

    @DeleteMapping("/manufacture/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
    	Manufacture note = manufactureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("manufacture", "id", id));

        manufactureRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
