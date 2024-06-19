package com.example.gestion_citas_medicas.service;

import com.example.gestion_citas_medicas.model.Cita;
import com.example.gestion_citas_medicas.repository.CitaRepository;
import org.springframework.stereotype.Service;

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
    public List<Cita> findByMedicoNombre(String medicoNombre){
        return citaRepository.findByMedicoNombre(medicoNombre);
    }
}
