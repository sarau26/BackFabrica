package com.udea.Fabrica_g6_v2.controllers;


import com.udea.Fabrica_g6_v2.models.Horario;
import com.udea.Fabrica_g6_v2.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    @GetMapping("/find-all")
    public List<Horario> findAll(){
        return horarioService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Horario> save(@RequestBody Horario horario){
        return horarioService.save(horario);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Horario> findById(@PathVariable String id){
        return horarioService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Horario> delete(@PathVariable String id){
        return horarioService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Horario> update(@RequestBody Horario horario){
        return horarioService.update(horario);
    }
}


