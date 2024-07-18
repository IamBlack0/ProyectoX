package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Usuarios;
import com.example.proyectox.Service.UsuarioDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://192.168.0.12:8080")
@RestController
public class UsuarioControllers {

    private final UsuarioDB db = new UsuarioDB();

    @PostMapping("/usuarios/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuarios usuario) {
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

        // Asignar una imagen predeterminada si no se proporciona
        if (usuario.getImg_usuario() == null || usuario.getImg_usuario().isEmpty()) {
            usuario.setImg_usuario("https://res.cloudinary.com/dso6sh6tb/image/upload/v1721333020/dnmayd8bhnm69i8yhv2b.png");
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
        Usuarios usuarioLogueado = db.iniciarSesion(usuario.getCorreo_usuario(), usuario.getContra_usuario());
        if (usuarioLogueado != null) {
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

    @PutMapping("/usuarios/{idUsuario}/imagen")
    public ResponseEntity<?> actualizarImagenPerfil(@PathVariable int idUsuario, @RequestBody String nuevaImagen) {
        boolean actualizado = db.actualizarImagenUsuario(idUsuario, nuevaImagen);
        if (actualizado) {
            return ResponseEntity.ok("{\"mensaje\": \"Imagen actualizada exitosamente\"}");
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Error al actualizar la imagen\"}");
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuarios>> obtenerUsuarios() {
        List<Usuarios> usuarios = db.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int idUsuario) {
        boolean eliminado = db.eliminarUsuario(idUsuario);
        if (eliminado) {
            return ResponseEntity.ok("{\"mensaje\": \"Usuario eliminado exitosamente\"}");
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Error al eliminar el usuario\"}");
        }
    }

    @PutMapping("/usuarios")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuarios usuario) {
        boolean actualizado = db.actualizarUsuario(usuario);
        if (actualizado) {
            return ResponseEntity.ok("{\"mensaje\": \"Usuario actualizado exitosamente\"}");
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Error al actualizar el usuario\"}");
        }
    }
}
