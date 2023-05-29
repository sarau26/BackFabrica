package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.dto.MateriaIdNameDto;
import com.udea.Fabrica_g6_v2.models.Materia;
import com.udea.Fabrica_g6_v2.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("localhost:5173/") //Puerto del front-end
@RestController
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    MateriaService materiaService;

    @GetMapping("/find-all")
    public List<Materia> findAll(){
        return materiaService.findAll();
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Materia> findById(@PathVariable Integer id){
        return materiaService.findById(id);
    }

    @GetMapping("find-all-ids-and-names")
    public ResponseEntity<List<MateriaIdNameDto>> getAllIdAndNames(){
        return materiaService.getAllIdsNames();
    }

    @PostMapping("/save")
    public ResponseEntity<Materia> save(@RequestBody Materia materia){
        return materiaService.save(materia);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Materia> delete(@PathVariable Integer id){
        return materiaService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Materia> update(@RequestBody Materia materia){
        return materiaService.update(materia);
    }
}

