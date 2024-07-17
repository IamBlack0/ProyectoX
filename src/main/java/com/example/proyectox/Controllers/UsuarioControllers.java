package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Usuarios;
import com.example.proyectox.Service.UsuarioDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://192.168.0.12:8080")
@RestController
public class UsuarioControllers {
    @PostMapping("/usuarios/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuarios usuario) {
        UsuarioDB db = new UsuarioDB();

        if (db.existeCorreo(usuario.getCorreo_usuario())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Correo ya registrado\", \"field\": \"correo_usuario\"}");
        }

        if (db.existeNombreUsuario(usuario.getNombre_usuario())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Nombre de usuario ya registrado\", \"field\": \"nombre_usuario\"}");
        }

        Usuarios registrado = db.registrarUsuario(usuario);
        if (registrado != null) {
            return ResponseEntity.ok(registrado);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Error al registrar el usuario\"}");
        }
    }

    @PostMapping("/usuarios/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody Usuarios usuario) {
        UsuarioDB db = new UsuarioDB();
        Usuarios usuarioLogueado = db.iniciarSesion(usuario.getCorreo_usuario(), usuario.getContra_usuario());
        if (usuarioLogueado != null) {
            // Devolver nombre_usuario y rol_usuario en la respuesta JSON
            return ResponseEntity.ok(usuarioLogueado);
        } else {
            if (!db.existeCorreo(usuario.getCorreo_usuario())) {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("{\"error\": \"Correo no registrado\", \"field\": \"correo_usuario\"}");
            }
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Contraseña incorrecta\", \"field\": \"contra_usuario\"}");
        }
    }

}