package com.example.EvaluacionEduTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EvaluacionEduTech.Model.Opcion;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Long>{

    Opcion findByTextoOpcion (String opcion);
    boolean existsByTextoOpcion(String textoOpcion);

}
