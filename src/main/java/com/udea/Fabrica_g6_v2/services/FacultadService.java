package com.udea.Fabrica_g6_v2.services;


import com.udea.Fabrica_g6_v2.models.Facultad;
import com.udea.Fabrica_g6_v2.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {
    @Autowired
    FacultadRepository facultadRepository;

    public List<Facultad> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return facultadRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Facultad> save(@RequestBody Facultad facultad){

        //guardar
        Facultad result= facultadRepository.save(facultad);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Facultad> findById(@PathVariable Long id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Facultad> optionalFacultad= facultadRepository.findById(id);
        if(optionalFacultad.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalFacultad.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<Facultad> delete(@PathVariable Long id){

        if (!facultadRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        facultadRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<Facultad> update(@RequestBody Facultad facultad){
        if(facultad.getId()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!facultadRepository.existsById(facultad.getId())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Facultad result= facultadRepository.save(facultad);
        return ResponseEntity.ok(result);


    }


}
