package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Usuarios;
import com.example.proyectox.Service.UsuarioDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioControllers {

    @GetMapping("/usuarios/all")
    public List<Usuarios> ObtenerTodoUsuarios(){
        return new UsuarioDB().ObtenerUsuarios();
    }
}
