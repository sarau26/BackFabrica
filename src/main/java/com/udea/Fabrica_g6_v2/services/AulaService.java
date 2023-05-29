package com.udea.Fabrica_g6_v2.services;

import com.udea.Fabrica_g6_v2.models.Aula;
import com.udea.Fabrica_g6_v2.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    AulaRepository aulaRepository;
    public List<Aula> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return aulaRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Aula> save(@RequestBody Aula aula){

        //guardar
        Aula result=aulaRepository.save(aula);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Aula> findById(@PathVariable String id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Aula> optionalAula=aulaRepository.findById(id);
        if(optionalAula.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalAula.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<Aula> delete(@PathVariable String id){

        if (!aulaRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        aulaRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<Aula> update(@RequestBody Aula aula){
        if(aula.getId()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!aulaRepository.existsById(aula.getId())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Aula result=aulaRepository.save(aula);
        return ResponseEntity.ok(result);


    }


}
