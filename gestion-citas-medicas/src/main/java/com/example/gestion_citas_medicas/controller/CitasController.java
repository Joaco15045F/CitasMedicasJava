package com.example.gestion_citas_medicas.controller;

import com.example.gestion_citas_medicas.model.Cita;
import com.example.gestion_citas_medicas.model.Especialidad;
import com.example.gestion_citas_medicas.service.CitaService;
import com.example.gestion_citas_medicas.service.EspecialidadService;
import com.example.gestion_citas_medicas.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitasController {

    private final CitaService citaService;
    private final MedicoService medicoService;
    private final EspecialidadService especialidadService;

    public CitasController(CitaService citaService, MedicoService medicoService,
            EspecialidadService especialidadService) {
        this.citaService = citaService;
        this.medicoService = medicoService;
        this.especialidadService = especialidadService;
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

        // Obtener la lista de especialidades desde el servicio
        List<Especialidad> especialidades = especialidadService.obtenerEspecialidades();
        model.addAttribute("especialidades", especialidades);

        return "formulario_cita"; // Nombre de la plantilla Thymeleaf para el formulario
    }

    @PostMapping("/nueva")
    @ResponseBody
    public ResponseEntity<String> guardarCita(@ModelAttribute("cita") Cita cita) {
        // Tomar el nombre de la especialidad elegida por el paciente y guardarlo en la
        // cita
        String especialidadNombre = cita.getEspecialidadNombre();
        cita.setEspecialidadNombre(especialidadNombre);

        // Limpiar el campo especialidad para que no se guarde en la tabla cita
        // cita.setEspecialidad(null); // Eliminar esta línea

        // Validar y guardar la nueva cita en la base de datos
        citaService.guardarCita(cita);

        // Devolver un mensaje de confirmación como respuesta JSON
        return ResponseEntity.ok("Cita reservada con éxito.");
    }

    @GetMapping("/medicos-por-especialidad")
    @ResponseBody
    public ResponseEntity<List<String>> obtenerMedicosPorEspecialidad(
            @RequestParam("especialidad") String especialidad) {
        List<String> medicos = medicoService.obtenerMedicosPorEspecialidad(especialidad);
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/buscar-por-medico")
    public String buscarPorMedico(Model model, @RequestParam("medicoNombre") String medicoNombre) {
        List<Cita> citas = citaService.findByMedicoNombre(medicoNombre);
        model.addAttribute("citas", citas);
        return "lista_de_pacientes"; // Devuelve el nombre de la plantilla Thymeleaf para mostrar los resultados
    }

    @GetMapping("/tiene-cita")
    @ResponseBody
    public ResponseEntity<Boolean> tieneCita(@RequestParam("pacienteNombre") String pacienteNombre) {
        boolean tieneCita = citaService.tieneCitaPendiente(pacienteNombre);
        return ResponseEntity.ok(tieneCita);
    }

    @GetMapping("/cita-medica")
    public String mostrarCitaMedica(Model model, @RequestParam("pacienteNombre") String pacienteNombre) {
        // Obtener la cita médica del paciente (asumiendo que solo hay una cita
        // pendiente)
        List<Cita> citas = citaService.findByPacienteNombre(pacienteNombre);
        if (!citas.isEmpty()) {
            Cita citaMedica = citas.get(0); // Tomamos la primera cita (asumiendo una implementación básica)
            model.addAttribute("citaMedica", citaMedica);
            return "cita_medica"; // Nombre de la plantilla Thymeleaf para mostrar la cita médica
        } else {
            // Manejo de error si el paciente no tiene citas
            model.addAttribute("mensaje", "No se encontraron citas médicas para el paciente.");
            return "error"; // Página de error personalizada
        }
    }
}
