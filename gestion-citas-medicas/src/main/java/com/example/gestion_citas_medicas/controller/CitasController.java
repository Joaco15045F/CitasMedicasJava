package com.example.gestion_citas_medicas.controller;

import com.example.gestion_citas_medicas.model.Cita;
import com.example.gestion_citas_medicas.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitasController {

    private final CitaService citaService;

    public CitasController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/listar-pacientes")
    public String listarPacientes(Model model) {
        List<Cita> citas = citaService.getAllCitas();
        model.addAttribute("citas", citas);
        return "lista"; // Devuelve el nombre de la plantilla Thymeleaf
    }

    
}
