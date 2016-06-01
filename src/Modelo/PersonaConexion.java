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

    /**
     * Metodo que devuelve el id de una persona.
     *
     * @param persona de la que queremos saber el id.
     * @return id de esa persona.
     */
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

    /**
     * Metodo que obtiene la categoria de una persona
     *
     * @param id de la persona
     * @return nombre de la categoria
     */
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

    /**
     * Metodo que inserta una persona en la base de datos.
     *
     * @param persona que queremos insertar.
     */
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

    /**
     * Metodo que devuelve el nombre de todas las personas con categoria
     * Director Comercial
     *
     * @return Array de nombres.
     */
    public static String[] obtenerDirectores() {

        CallableStatement cs;
        ResultSet rs;
        String[] directores = null;
        int i = 0;
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call obtenerDirectores(?)}");
            cs.setString(1, "Director Comercial");

            rs = cs.executeQuery();
            rs.last();
            directores = new String[rs.getRow()];
            rs.beforeFirst();
            while (rs.next()) {
                directores[i] = rs.getString(1);
                i++;
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return directores;

    }
    
    public static void insertarEquipo(Equipo equipo) {
        CallableStatement cs;
        conection.abrirConexion();

        try {

            cs = conection.getConexion().prepareCall("{call insertarEquipo(?,?,?,?,?)}");
            cs.setString(1, equipo.getNombre());
            cs.setString(2, equipo.getTelefono());
            cs.setInt(3, equipo.getPresidente());
            cs.setInt(4, equipo.getDirectorMarketing());
            cs.setInt(5, equipo.getPrecio());

            cs.execute();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
    }

    
    /**
     * Metodo que nos devuelve el nombre de todos los equipos.
     * @return Array de nombres de equipos.
     */
    public static String[] obtenerEquipos() {

        CallableStatement cs;
        ResultSet rs;
        String[] equipos = null;
        int i = 0;
        conection.abrirConexion();
        try {
            cs = conection.getConexion().prepareCall("{call obtenerEquipos()}");

            rs = cs.executeQuery();
            rs.last();
            equipos = new String[rs.getRow()];
            rs.beforeFirst();
            while (rs.next()) {
                equipos[i] = rs.getString(1);
                i++;
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        conection.cerraConexion();
        return equipos;

    }
}
