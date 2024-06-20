package com.example.gestion_citas_medicas.service;

import com.example.gestion_citas_medicas.model.Especialidad;
import com.example.gestion_citas_medicas.repository.EspecialidadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> obtenerEspecialidades() {
        return especialidadRepository.findAll();
    }
}
