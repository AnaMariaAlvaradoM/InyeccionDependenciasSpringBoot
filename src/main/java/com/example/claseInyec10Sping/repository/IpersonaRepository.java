package com.example.claseInyec10Sping.repository;

import com.example.claseInyec10Sping.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpersonaRepository  extends JpaRepository<Persona, Long> {

}








//public interface IpersonaRepository {
//    List<Persona> findAll();
//    Persona findById(Long id);
//    void save (Persona persona);
//}