package edu.practice.service;

import java.util.List;

import edu.practice.entity.PersonaEntity;

public interface PersonaService {
    
    public List<PersonaEntity> listarPersona();
    public PersonaEntity obtenerPersona(Integer idpersona);
    public List<PersonaEntity> listarPersonaxpares();
    public List<PersonaEntity> listarPersonasMenoresque(String valor);
    public List<PersonaEntity> litsarxNombre(String name);
    public Integer valorValitaion(String datoingresado);
    public List<PersonaEntity> listarEntreRangeEdades(Integer edadMenor, Integer edadMayor);
    public List<String> listaSoloNames();
    public Integer sumatorioEdades();
    public Double promedioEdades();
    public List<PersonaEntity> listarMasJoven();
}
