package edu.practice.service;

import java.util.List;

import edu.practice.entity.PersonaEntity;

public interface PersonaService {
    
    public List<PersonaEntity> listarPersona();

    public List<PersonaEntity> listarPersonaxpares();
    public List<PersonaEntity> listarPersonasMenoresque(String valor);

    public Integer valorValitaion(String datoingresado);

}
