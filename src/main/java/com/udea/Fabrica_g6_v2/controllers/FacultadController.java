package com.udea.Fabrica_g6_v2.controllers;


import com.udea.Fabrica_g6_v2.models.Facultad;
import com.udea.Fabrica_g6_v2.services.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades")
public class FacultadController {
    //atributos
    @Autowired
    FacultadService facultadService;
    //recordemos que el service(-->repository) es quien contiene las cualidades se aplicarsele "QUERYS" por ende lo nesesitamos para poder "usarlos"
//CRUD sobre la entidad

    @GetMapping("/find-all")
    public List<Facultad> findAll(){
        return facultadService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Facultad> save(@RequestBody Facultad facultad){
        return facultadService.save(facultad);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Facultad> findById(@PathVariable Long id){
        return facultadService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Facultad> delete(@PathVariable Long id){
        return facultadService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Facultad> update(@RequestBody Facultad facultad){
        return facultadService.update(facultad);
    }
}

