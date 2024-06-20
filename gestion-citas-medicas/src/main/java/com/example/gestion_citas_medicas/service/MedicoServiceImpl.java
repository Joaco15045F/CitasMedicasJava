package com.example.gestion_citas_medicas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion_citas_medicas.model.Medico;
import com.example.gestion_citas_medicas.repository.MedicoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<String> obtenerMedicosPorEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidadNombre(especialidad)
                .stream()
                .map(Medico::getNombre)
                .collect(Collectors.toList());
    }
}
