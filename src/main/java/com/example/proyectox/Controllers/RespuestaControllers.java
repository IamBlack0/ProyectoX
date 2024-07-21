package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Respuesta;
import com.example.proyectox.Service.RespuestaDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Collections;

@RestController
public class RespuestaControllers {

    @GetMapping("/respuestas/all")
    public List<Respuesta> ObtenerTodosRespuesta() {
        try {
            List<Respuesta> respuestas = new RespuestaDB().ObtenerRespuestas();
            System.out.println("Respuestas obtenidas: " + respuestas);
            return respuestas;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Retorna una lista vacía en caso de error
        }
    }
}
