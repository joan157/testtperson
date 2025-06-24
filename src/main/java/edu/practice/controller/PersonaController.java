package edu.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

    //http://localhost:8081/api/v1/persona/edades?edadMenor=15&edadMayor=22
    @GetMapping("/edades")
    public List<PersonaEntity> listarangoedades(@RequestParam Integer edadMenor, @RequestParam Integer edadMayor){
        return personaService.listarEntreRangeEdades(edadMenor, edadMayor);
    }
    @GetMapping("/solonames")
    public List<String> listaSoloNames(){
        return personaService.listaSoloNames();
    }
    @GetMapping("/sumatoria")
    public Integer sumatoria(){
        return personaService.sumatorioEdades();
    }
    @GetMapping("/sumatoriaJson")
    public Map<String, Integer> sumatoriaJson(){
        Map<String,Integer> valor = new HashMap<>();
        valor.put("Sumatoria",personaService.sumatorioEdades());
        return valor;
    }
    @GetMapping("/promedioedades")
    public Object promedioedades(){
        Map<String,Double> valor = new HashMap<>();
        valor.put("Promedio",personaService.promedioEdades());
        return valor;
    }

    @GetMapping("/losmenores")
    public List<PersonaEntity> listarsolomenores(){
        return personaService.listarMasJoven();
    }

    @GetMapping("/{idpersona}")
    public PersonaEntity obtenerPersona(@PathVariable Integer idpersona){
        return personaService.obtenerPersona(idpersona);
    }
    //http://localhost:8081/api/v1/persona/namebuscar?namess=joan
    @GetMapping("/namebuscar")
    public List<PersonaEntity> personasxNombres(@RequestParam String namess){
        System.out.println("Nombre recibido: " + namess); // VERIFICA QUÉ LLEGA
        return personaService.litsarxNombre(namess);
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
