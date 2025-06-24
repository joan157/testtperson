package edu.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.practice.entity.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity,Integer>{
    
    @Query(value = "SELECT * FROM persona", nativeQuery = true)
    public List<PersonaEntity> listarPersona();


}
