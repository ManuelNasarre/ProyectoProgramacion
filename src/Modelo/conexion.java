/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author Alumno
 */
public class conexion {
   
    //atributos de la conexion
    String bd = "baseprogramacion";
    private String usuario= "user";
    private String contrasenia= "1234";
    private String servidor="jdbc:mysql://localhost/";
    private Connection conexion;
    ResultSet rs;
    
    
    /*
    *Construimos la conexion a la base de datos
    *@param bd - nombre de la base de datos
    *@param usuario - nombre del usuario
    *@param contrasenia - contraseña del usuario
    *@param servidor - nombre del servidor donde esta alojada la base de datos
    */
    public conexion() {

    }
    /*
    *Método que abre la conexion.
    *@return true si se a conectado correctamente
    */
    public boolean abrirConexion() {
        boolean estado = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor + bd, usuario, contrasenia);
            estado = true;
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println("Error en la conexion");
        }
        return estado;
    }
    
    
    /*Método que cierra la conexion
    *@return true si se ha cerrado correctamente.
    */
    public boolean cerraConexion() {
        boolean estado = false;

        try {
            conexion.close();
            estado = true;

        } catch (SQLException se) {
            System.out.println("Error al cerrar la conexión");
        }

        return estado;

    }
    
    
    public Connection getConexion(){
        
        return conexion;
    }

}
