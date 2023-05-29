package com.udea.Fabrica_g6_v2.controllers;


import com.udea.Fabrica_g6_v2.models.Grupo;
import com.udea.Fabrica_g6_v2.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    GrupoService grupoService;

    @GetMapping("/find-all")
    public List<Grupo> findAll(){
        return grupoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Grupo> save(@RequestBody Grupo grupo){
        return grupoService.save(grupo);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Grupo> findById(@PathVariable String id){
        return grupoService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Grupo> delete(@PathVariable String id){
        return grupoService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Grupo> update(@RequestBody Grupo grupo){
        return grupoService.update(grupo);
    }
}
