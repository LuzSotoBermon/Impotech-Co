package com.impotechco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConexionMySQL {

    private static final String URL = "jdbc:mysql://localhost:3307/impotechco?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "LuzSoto1234";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL (opcional en versiones modernas de JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentar establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
}
