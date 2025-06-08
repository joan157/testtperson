package edu.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.practice.entity.PersonaEntity;
import edu.practice.repository.PersonaRepository;
import edu.practice.service.PersonaService;

@RestController
@RequestMapping("api/v1/persona")
public class PersonaController {
    

    @Autowired
    PersonaService personaService;

    @GetMapping
    public List<PersonaEntity> listarPersona(){
        return personaService.listarPersona();
    }

    @GetMapping("/pares")
    public List<PersonaEntity> listaridpares(){
        return personaService.listarPersonaxpares();
    }

    /*.ok()
    * .status()
    * badRequest().body("parametros invalidos") Devuelve una respuesta HTTP 400 Bad Request.
    * .notFound() : Devuelve una respuesta HTTP 404 Not Found.
    * .noContent().build(); Devuelve una respuesta HTTP 204 No Content.
    * .accepted().body("Solicitud en proceso"); Devuelve una respuesta HTTP 202 Accepted.
    * .internalServerError().body("Error en el servidor");
    *
    * Personalización con headers
    * ResponseEntity.ok().headers(headers).body("Con cabecera personalizada");
    * ResponseEntity.ok().build(); no necesitas enviar un cuerpo en la respuesta
    *
    *
    *
    *
    * */
    @GetMapping("/menosque/{inputedad}")
    public ResponseEntity<Object> listarmenoresque(@PathVariable String inputedad){
        if(!personaService.listarPersonasMenoresque(inputedad).isEmpty()){
            return ResponseEntity.ok(personaService.listarPersonasMenoresque(inputedad));
        }else{
            Map<String,String> resul = new HashMap<>();
            resul.put("valor","No hay datos");
            return ResponseEntity.ok(resul);
        }
    }


}
