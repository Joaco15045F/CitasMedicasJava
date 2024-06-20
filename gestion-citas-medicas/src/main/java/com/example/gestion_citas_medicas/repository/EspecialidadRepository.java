package com.example.gestion_citas_medicas.repository;

import com.example.gestion_citas_medicas.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    // Puedes definir métodos adicionales aquí si necesitas consultas personalizadas
}
