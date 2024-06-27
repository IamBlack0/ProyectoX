package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Historia;
import com.example.proyectox.Service.HistoriaDB;
import com.example.proyectox.Service.UsuarioDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoriaControllers {

    @GetMapping("/historias/all")
    public List<Historia> ObtenerTodosHistoria(){
        return new HistoriaDB().ObtenerHistorias();
    }
}
