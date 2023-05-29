package com.udea.Fabrica_g6_v2.services;

import com.udea.Fabrica_g6_v2.models.Decano;
import com.udea.Fabrica_g6_v2.models.Docente;
import com.udea.Fabrica_g6_v2.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {
    @Autowired
    DocenteRepository docenteRepository;

    public List<Docente> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return docenteRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Docente> save(@RequestBody Docente docente){

        //guardar
        Docente result= docenteRepository.save(docente);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Docente> findById(@PathVariable Long id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Docente> optionalDocente= docenteRepository.findById(id);
        if(optionalDocente.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalDocente.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<Docente> delete(@PathVariable Long id){

        if (!docenteRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        docenteRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<Docente> update(@RequestBody Docente docente){
        if(docente.getId()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!docenteRepository.existsById(docente.getId())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Docente result= docenteRepository.save(docente);
        return ResponseEntity.ok(result);


    }


}
