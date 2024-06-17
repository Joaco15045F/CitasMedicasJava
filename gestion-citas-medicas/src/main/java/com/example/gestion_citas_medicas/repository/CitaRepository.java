package com.example.gestion_citas_medicas.repository;

import com.example.gestion_citas_medicas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
