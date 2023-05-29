package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.dto.CursoDto;
import com.udea.Fabrica_g6_v2.dto.MateriaProgramaVersionDto;
import com.udea.Fabrica_g6_v2.models.Curso;
import com.udea.Fabrica_g6_v2.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("localhost:5173/") //Puerto del front-end
@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping("/find-all")
    public List<Curso> findAll(){
        return cursoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Curso> save(@RequestBody CursoDto cursoDto){
        return cursoService.save(cursoDto);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id){
        return cursoService.findById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Curso> delete(@RequestBody MateriaProgramaVersionDto dto){
        return cursoService.delete(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<Curso> update(@RequestBody CursoDto dto){
        return cursoService.update(dto);
    }

    @GetMapping("/get-id")
    public ResponseEntity<Integer> getId(@RequestBody MateriaProgramaVersionDto dto) {
        return cursoService.getId(dto);
    }
}
