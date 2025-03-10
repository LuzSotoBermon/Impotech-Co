package com.impotechco;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexion = ConexionMySQL.conectar();
        if (conexion == null) {
            System.out.println("No se pudo establecer la conexión.");
        } else {
            System.out.println("¡Conexión exitosa a MySQL!");
        }
    }
}
