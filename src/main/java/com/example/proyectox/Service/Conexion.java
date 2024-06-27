package com.example.proyectox.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Datos de conexión
    private static final String URL = "jdbc:mariadb://localhost:3306/proyectox";
    private static final String USER = "root";
    private static final String PASSWORD = "heidi1234";


    public Connection abrirDB(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
            return null;
        }
    }
}
