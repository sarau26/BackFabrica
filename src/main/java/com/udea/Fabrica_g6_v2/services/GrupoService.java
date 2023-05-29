package com.udea.Fabrica_g6_v2.services;


import com.udea.Fabrica_g6_v2.models.Grupo;
import com.udea.Fabrica_g6_v2.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {
    @Autowired
    GrupoRepository grupoRepository;
    public List<Grupo> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return grupoRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Grupo> save(@RequestBody Grupo grupo){

        //guardar
        Grupo result= grupoRepository.save(grupo);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Grupo> findById(@PathVariable String id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Grupo> optionalGrupo= grupoRepository.findById(id);
        if(optionalGrupo.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalGrupo.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<Grupo> delete(@PathVariable String id){

        if (!grupoRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        grupoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<Grupo> update(@RequestBody Grupo grupo){
        if(grupo.getId_grupo()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!grupoRepository.existsById(grupo.getId_grupo())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Grupo result= grupoRepository.save(grupo);
        return ResponseEntity.ok(result);


    }


}
