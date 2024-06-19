package com.example.gestion_citas_medicas.controller;

import com.example.gestion_citas_medicas.model.Usuario;
import com.example.gestion_citas_medicas.service.UsuarioService;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    // nombre de la plantilla Thymeleaf para la página de:
    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin"; 
    }
    @GetMapping("/medico")
    public String medico() {
        return "medico"; 
    }
    @GetMapping("/paciente")
    public String paciente() {
        return "paciente"; 
    }
    
   
    
    

    //
    /*@PostMapping("/login")
    public void login(@RequestParam String correo, @RequestParam String contrasenia, HttpServletResponse response) throws IOException {
        Usuario usuario = usuarioService.authenticate(correo, contrasenia);
        if (usuario != null) {
            if ("admin".equals(usuario.getTipo().toString())) {
                response.sendRedirect("/admin");
            } else {
                response.sendRedirect("/user"); // redirigir a otra página si no es admin
            }
        } else {
            response.sendRedirect("/?error"); // redirigir de vuelta al login en caso de fallo
        }
    }*/

}
