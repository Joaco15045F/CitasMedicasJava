package com.example.gestion_citas_medicas.service;

import java.util.List;

public interface MedicoService {
    List<String> obtenerMedicosPorEspecialidad(String especialidad);
}
