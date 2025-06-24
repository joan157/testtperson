package edu.practice.service.Impl;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.practice.entity.PersonaEntity;
import edu.practice.repository.PersonaRepository;
import edu.practice.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{


    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> listarPersona() {
       return personaRepository.listarPersona();
    }

    @Override
    public PersonaEntity obtenerPersona(Integer idpersona) {

        return personaRepository.listarPersona().stream().
                filter(lista -> lista.getIdpersona()==idpersona)
                        .toList().get(0); // lista inmutable

    }

    @Override
    public List<PersonaEntity> listarPersonaxpares() {
        return  personaRepository.listarPersona().stream()
                .filter(entidad ->
                        entidad.getIdpersona()%2==0)
                .collect(Collectors.toList()); //lista mutable

    }
    @Override
    public List<PersonaEntity> listarPersonasMenoresque(String valor) {
       List<PersonaEntity> newperson= personaRepository.listarPersona()
               .stream()
               .filter(entidad -> entidad.getEdad()<valorValitaion(valor))
               .collect(Collectors.toList());
       if(newperson.isEmpty()){
           System.out.println("No hay información");
           return newperson;
       }else{
           return newperson;
       }
    }

    @Override
    public List<PersonaEntity> litsarxNombre(String namess) {
       return personaRepository.listarPersona().stream()
               .filter(lista -> lista.getNombre().equalsIgnoreCase(namess))
               .toList();
    }

    @Override
    public Integer valorValitaion(String datoIngresado) {
        for(int i = 0; i<datoIngresado.length();i++){
           if(!Character.isDigit(datoIngresado.charAt(i))){
               return -1;
           }
        }
        return Integer.parseInt(datoIngresado);
    }



    //.peek(p -> p.setIdpersona(p.getIdpersona() * p.getEdad())) para modificacion del objecto
    @Override
    public List<PersonaEntity> listarEntreRangeEdades(Integer edadMenor, Integer edadMayor) {
       return personaRepository.listarPersona().stream()
                .filter(listado ->
                        listado.getEdad()>=edadMenor && listado.getEdad()<=edadMayor )
               .map(listadoRange -> {
                           listadoRange.setIdpersona(listadoRange.getIdpersona() * listadoRange.getEdad());
                           return listadoRange;
                       }
                    )
               .toList();




    }
    // .map(Persona::getNombre)
    //    .collect(Collectors.joining(", "));
    @Override
    public List<String> listaSoloNames() {
       return personaRepository.listarPersona()
               .stream()
               .map( listado ->{
                  return listado.getNombre()+" "+listado.getApellido();
               }).toList();
    }

    @Override
    public Integer sumatorioEdades() {
        return personaRepository.listarPersona()
                .stream()
                .mapToInt(listado -> {return listado.getEdad();})
                .sum();
    }

    @Override
    public Double promedioEdades() {
        return personaRepository.listarPersona()
                .stream()
                .mapToInt(PersonaEntity::getEdad)
                .average().orElse(0.0); // puede retornar un numerico o
                // El metodo .orElse(0.0) no se usa solo cuando el valor es nulo, sino cuando el resultado del
                // .average() es un OptionalDouble vacío, es decir, cuando no hay datos para calcular el promedio.
    }

    @Override
    public List<PersonaEntity> listarMasJoven() {
        /*OptionalInt edadminima= personaRepository.listarPersona()
                .stream()
                .mapToInt(PersonaEntity::getEdad)
                .min();*/
        return personaRepository.listarPersona()
                .stream()
                .filter(listado -> listado.getEdad()==personaRepository.listarPersona()
                        .stream()
                        .mapToInt(PersonaEntity::getEdad)
                        .min().orElse(0))
                .toList();
    }

}
