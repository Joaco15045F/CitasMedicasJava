package com.example.gestion_citas_medicas.repository;

import com.example.gestion_citas_medicas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByMedicoNombre(String medicoNombre);
    List<Cita> findByPacienteNombre(String pacienteNombre);
    List<Cita> findByPacienteNombreAndFechaHoraAfter(String pacienteNombre, LocalDateTime fechaHora);
}

