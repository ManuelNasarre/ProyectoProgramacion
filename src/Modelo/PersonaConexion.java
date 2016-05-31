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
import java.util.ArrayList;

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

    public static String[] obtenerPresidentes() {
        CallableStatement cs;
        ResultSet rs;
        String[] nombresPresidentes = null;
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call obtenerPresidentes(?)}");
            cs.setString(1, "Presidente");

            rs = cs.executeQuery();
            rs.last();
            nombresPresidentes = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next() || i < rs.getRow()) {

                String nombre = rs.getString(2);
                nombresPresidentes[i] = nombre;
                i++;

            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return nombresPresidentes;
    }

    public static String[] obtenerEquipos() {

        CallableStatement cs;
        ResultSet rs;
        String[] nombresEquipos = null;
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call obtenerEquipos()}");

            rs = cs.executeQuery();
            rs.last();
            nombresEquipos = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next() || i < rs.getRow()) {

                String nombre = rs.getString(1);
                nombresEquipos[i] = nombre;
                i++;

            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return nombresEquipos;

    }

    public static String[] obtenerDirectores() {

        CallableStatement cs;
        ResultSet rs;
        String[] nombresDirectores = null;
        String director = "Director Comercial";
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call obtenerDirectores(?)}");
            cs.setString(1, director);
            rs = cs.executeQuery();
            rs.last();
            nombresDirectores = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next() || i < rs.getRow()) {

                String nombre = rs.getString(1);
                nombresDirectores[i] = nombre;
                i++;

            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return nombresDirectores;
    }

    public static int obtenerId(String nombre, String categoria) {

        CallableStatement cs;
        ResultSet rs;
        conection.abrirConexion();
        int id = 0;
        try {

            cs = conection.getConexion().prepareCall("{call obtenerIdPersona(?,?)}");
            cs.setString(1, nombre);
            cs.setString(2, categoria);
            rs = cs.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return id;
    }

    public static void insertarEquipo(Equipo equipo) {

        CallableStatement cs;
        conection.abrirConexion();

        try {

            cs = conection.getConexion().prepareCall("{call insertarEquipo(?,?,?,?,?)}");
            cs.setString(1, equipo.getNombre());
            cs.setInt(2, equipo.getTelefono());
            cs.setInt(3, equipo.getPresidente());
            cs.setInt(4, equipo.getDirectorMarketing());
            cs.setFloat(5, equipo.getPrecio());
            cs.execute();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();

    }

    public static float obtenerPrecio(String nombre) {
        CallableStatement cs;
        ResultSet rs;
        conection.abrirConexion();
        float precio = 0;
        try {

            cs = conection.getConexion().prepareCall("{call obtenerPrecioEquipo(?)}");
            cs.setString(1, nombre);
            rs = cs.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                precio = rs.getFloat(1);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return precio;

    }

}
