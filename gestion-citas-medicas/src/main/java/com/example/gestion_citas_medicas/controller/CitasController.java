package com.example.gestion_citas_medicas.controller;

import com.example.gestion_citas_medicas.model.Cita;
import com.example.gestion_citas_medicas.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/nueva")
    public String mostrarFormularioNuevaCita(Model model) {
        model.addAttribute("cita", new Cita());
        return "formulario_cita"; // Nombre de la plantilla Thymeleaf para el formulario
    }

    @PostMapping("/nueva")
    public String guardarCita(@ModelAttribute("cita") Cita cita) {
        // Aquí puedes validar y guardar la nueva cita en la base de datos
        citaService.guardarCita(cita);
        return "redirect:/citas/listar-pacientes"; // Redirige a la lista de citas después de guardar
    }

    @GetMapping("/sacarficha")
    public String sacarficha(Model model) {
        List<Cita> citas = citaService.getAllCitas();
        model.addAttribute("citas", citas);
        return "sacarficha"; // Devuelve el nombre de la plantilla Thymeleaf
    }

    @GetMapping("/buscar-por-medico")
    public String buscarPorMedico(Model model, @RequestParam("medicoNombre") String medicoNombre) {
        List<Cita> citas = citaService.findByMedicoNombre(medicoNombre);
        model.addAttribute("citas", citas);
        return "lista_de_pacientes"; // Devuelve el nombre de la plantilla Thymeleaf para mostrar los resultados

    }
} 
