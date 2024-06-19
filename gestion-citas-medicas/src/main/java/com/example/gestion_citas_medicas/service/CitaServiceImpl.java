package com.example.gestion_citas_medicas.service;

import com.example.gestion_citas_medicas.model.Cita;
import com.example.gestion_citas_medicas.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }
    
    @Override
    public void guardarCita(Cita cita) {
        citaRepository.save(cita);
    }
    
    @Override
    public List<Cita> findByMedicoNombre(String medicoNombre) {
        return citaRepository.findByMedicoNombre(medicoNombre);
    }

    @Override
    public boolean tieneCitaPendiente(String pacienteNombre) {
        // Implementación para verificar si el paciente tiene cita pendiente
        List<Cita> citas = citaRepository.findByPacienteNombreAndFechaHoraAfter(pacienteNombre, LocalDateTime.now());
        return !citas.isEmpty();
    }
    
    @Override
    public List<Cita> findByPacienteNombre(String pacienteNombre) {
        return citaRepository.findByPacienteNombre(pacienteNombre);
    }
}
