package com.example.gestion_citas_medicas.repository;

import com.example.gestion_citas_medicas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByEspecialidadNombre(String especialidad);
}
