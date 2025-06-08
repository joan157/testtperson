package edu.practice.service.Impl;

import java.util.List;
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
    public List<PersonaEntity> listarPersonaxpares() {
       return  personaRepository.listarPersona().stream()
                .filter(entidad ->
                        entidad.getIdpersona()%2==0)
               .collect(Collectors.toList());

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
    public Integer valorValitaion(String datoIngresado) {
        for(int i = 0; i<datoIngresado.length();i++){
           if(!Character.isDigit(datoIngresado.charAt(i))){
               return -1;
           }
        }
        return Integer.parseInt(datoIngresado);
    }

}
