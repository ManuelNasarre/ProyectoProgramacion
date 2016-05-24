/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alumno
 */
public class Entrada {
    private int id_entrada;
    private int id_equipo;
    private String estadio;
    private float precio;
    
    public Entrada(int i,String e){
        this.id_equipo=i;
        this.estadio=e;
    }

    /**
     * @return the id_entrada
     */
    public int getId_entrada() {
        return id_entrada;
    }

    /**
     * @param id_entrada the id_entrada to set
     */
    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    /**
     * @return the id_equipo
     */
    public int getId_equipo() {
        return id_equipo;
    }

    /**
     * @param id_equipo the id_equipo to set
     */
    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * @return the estadio
     */
    public String getEstadio() {
        return estadio;
    }

    /**
     * @param estadio the estadio to set
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}

