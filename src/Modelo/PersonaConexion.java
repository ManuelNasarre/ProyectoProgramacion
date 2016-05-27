/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class PersonaConexion {

    static Conexion conection = new Conexion();

    public static int obtenerIdPersona(Persona persona) {
        CallableStatement cs;
        ResultSet rs = null;
        int id = 0;
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call buscarPersona_in(?,?)}");
            cs.setString(1, persona.getNombre());
            cs.setString(2, persona.getContrasenia());

            rs = cs.executeQuery();
            if (rs == null) {
                id = 0;
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        conection.cerraConexion();
        return id;
    }

    public static String obtenerCategoria(int id) {
        CallableStatement cs;
        ResultSet rs;
        String categoria = "";
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call obtenerCategoria(?)}");
            cs.setInt(1, id);

            rs = cs.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                categoria = rs.getString(1);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return categoria;
    }

    public static void insertarPersona(Persona persona) {
        CallableStatement cs;
        conection.abrirConexion();

        try {

            cs = conection.getConexion().prepareCall("{call insertarPersona(?,?,?,?)}");
            cs.setString(1, persona.getNombre());
            cs.setString(2, persona.getApellido());
            cs.setString(3, persona.getCategoria());
            cs.setString(4, persona.getContrasenia());

            cs.execute();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
    }
}
