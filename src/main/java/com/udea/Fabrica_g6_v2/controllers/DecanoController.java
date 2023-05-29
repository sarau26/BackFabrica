package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.models.Decano;
import com.udea.Fabrica_g6_v2.services.DecanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decanos")
public class DecanoController {
    //atributos
    @Autowired
    DecanoService decanoService;
    //recordemos que el service(-->repository) es quien contiene las cualidades se aplicarsele "QUERYS" por ende lo nesesitamos para poder "usarlos"
//CRUD sobre la entidad

    @GetMapping("/find-all")
    public List<Decano> findAll() {
        return decanoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Decano> save(@RequestBody Decano decano) {
        return decanoService.save(decano);
    }

    @GetMapping("/api/decanos/{id}")
    public ResponseEntity<Decano> findById(@PathVariable Long id) {
        return decanoService.findById(id);
    }

    @DeleteMapping("/find-by-id/{id}")
    public ResponseEntity<Decano> delete(@PathVariable Long id) {
        return decanoService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Decano> update(@RequestBody Decano decano) {
        return decanoService.update(decano);
    }
}

