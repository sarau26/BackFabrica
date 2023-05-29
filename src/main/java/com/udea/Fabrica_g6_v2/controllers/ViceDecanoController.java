package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.models.ViceDecano;
import com.udea.Fabrica_g6_v2.services.ViceDecanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viceDecanos")
public class ViceDecanoController {
    //atributos
    @Autowired
    ViceDecanoService viceDecanoService;
    //recordemos que el service(-->repository) es quien contiene las cualidades se aplicarsele "QUERYS" por ende lo nesesitamos para poder "usarlos"
//CRUD sobre la entidad

    @GetMapping("/find-all")
    public List<ViceDecano> findAll(){
        //capturar y enviar los libros de la bas de datos
        return viceDecanoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<ViceDecano> save(@RequestBody ViceDecano viceDecano) {
        return viceDecanoService.save(viceDecano);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ViceDecano> findById(@PathVariable Long id){
        return viceDecanoService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ViceDecano> delete(@PathVariable Long id){
        return viceDecanoService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ViceDecano> update(@RequestBody ViceDecano viceDecano){
        return viceDecanoService.update(viceDecano);
    }
}

