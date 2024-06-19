package com.example.gestion_citas_medicas.controller;

import com.example.gestion_citas_medicas.model.Usuario;
import com.example.gestion_citas_medicas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String correo, @RequestParam String contraseña, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.authenticate(correo, contraseña);
        if (usuario != null) {
            // Autenticación exitosa, redirigir según el tipo de usuario
            switch (usuario.getTipo()) {
                case admin:
                    return "redirect:/admin";
                case medico:
                redirectAttributes.addAttribute("nombreMedico", usuario.getNombre());
                    return "redirect:/medico";
                case paciente:
                    return "redirect:/paciente";
                default:
                    return "redirect:/error";
            }
        } else {
            // Autenticación fallida, redirigir de vuelta al formulario con mensaje de error
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
            return "redirect:/";
        }
    }

}