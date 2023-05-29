package com.udea.Fabrica_g6_v2.controllers;


import com.udea.Fabrica_g6_v2.models.Docente;
import com.udea.Fabrica_g6_v2.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes")
public class DocenteController {
    @Autowired
    DocenteService docenteService;

    @GetMapping("/find-all")
    public List<Docente> findAll() {
        return docenteService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Docente> findById(@PathVariable Long id) {
        return docenteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Docente> delete(@PathVariable Long id) {
        return docenteService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Docente> update(@RequestBody Docente docente) {
        return docenteService.update(docente);
    }
}