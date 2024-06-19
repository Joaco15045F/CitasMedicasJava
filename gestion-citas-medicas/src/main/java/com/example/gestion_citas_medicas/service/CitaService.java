package com.example.gestion_citas_medicas.service;

import com.example.gestion_citas_medicas.model.Cita;

import java.util.List;

public interface CitaService {
    List<Cita> getAllCitas();


    void guardarCita(Cita cita);

    List<Cita> findByMedicoNombre(String medicoNombre);

}
