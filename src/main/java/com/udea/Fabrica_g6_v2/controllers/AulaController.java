package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.models.Aula;
import com.udea.Fabrica_g6_v2.models.Calendario;
import com.udea.Fabrica_g6_v2.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    @Autowired
    AulaService aulaService;

    @GetMapping("/find-all")
    public List<Aula> findAll(){
        return aulaService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Aula> save(@RequestBody Aula aula){
        return aulaService.save(aula);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Aula> findById(@PathVariable String id){
        return aulaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Aula> delete(@PathVariable String id){
        return aulaService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Aula> update(@RequestBody Aula aula){
        return aulaService.update(aula);
    }
}
