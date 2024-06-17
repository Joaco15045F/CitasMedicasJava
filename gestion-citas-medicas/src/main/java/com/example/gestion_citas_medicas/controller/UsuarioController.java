package com.example.gestion_citas_medicas.controller;

import com.example.gestion_citas_medicas.model.Usuario;
import com.example.gestion_citas_medicas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "lista_usuarios"; // Nombre de la plantilla Thymeleaf
    }
}
