package com.udea.Fabrica_g6_v2.services;


import com.udea.Fabrica_g6_v2.models.ViceDecano;
import com.udea.Fabrica_g6_v2.repository.ViceDecanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ViceDecanoService {
    @Autowired
    ViceDecanoRepository viceDecanoRepository;

    public List<ViceDecano> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return viceDecanoRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<ViceDecano> save(@RequestBody ViceDecano viceDecano){

        //guardar
        ViceDecano result= viceDecanoRepository.save(viceDecano);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<ViceDecano> findById(@PathVariable Long id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<ViceDecano> optionalViceDecano= viceDecanoRepository.findById(id);
        if(optionalViceDecano.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalViceDecano.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<ViceDecano> delete(@PathVariable Long id){

        if (!viceDecanoRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        viceDecanoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<ViceDecano> update(@RequestBody ViceDecano viceDecano){
        if(viceDecano.getIdPersona()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!viceDecanoRepository.existsById(viceDecano.getIdPersona())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        ViceDecano result= viceDecanoRepository.save(viceDecano);
        return ResponseEntity.ok(result);


    }


}
