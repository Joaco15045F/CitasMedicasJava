package com.example.gestion_citas_medicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // nombre de la plantilla Thymeleaf para la página de inicio
    }
}
