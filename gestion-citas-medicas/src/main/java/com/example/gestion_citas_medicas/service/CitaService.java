package com.example.gestion_citas_medicas.service;

import com.example.gestion_citas_medicas.model.Cita;

import java.util.List;

public interface CitaService {
    List<Cita> getAllCitas();
    void guardarCita(Cita cita);
    List<Cita> findByMedicoNombre(String medicoNombre);
    
    // Nuevo método para verificar si un paciente tiene una cita pendiente
    boolean tieneCitaPendiente(String pacienteNombre);
    // Nuevo método para encontrar citas por nombre de paciente
    List<Cita> findByPacienteNombre(String pacienteNombre);
}
