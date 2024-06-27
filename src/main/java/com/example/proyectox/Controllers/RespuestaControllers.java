package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Respuesta;
import com.example.proyectox.Service.RespuestaDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RespuestaControllers {
    @GetMapping("/respuestas/all")
    public List<Respuesta> ObtenerTodosRespuesta(){
        return new RespuestaDB().ObtenerRespuestas();
    }
}
