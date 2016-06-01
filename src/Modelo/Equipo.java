
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
public class Equipo {
    private int id_equipo;
    private String nombre;
    private String telefono;
    private int directorMarketing;
    private int presidente;
    private int precio;
    
    public Equipo(String n,String t,int id,int ip, int p){
        this.nombre=n;
        this.telefono=t;
        this.directorMarketing=id;
        this.presidente=ip;
        this.precio = p;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the directorMarketing
     */
    public int getDirectorMarketing() {
        return directorMarketing;
    }

    /**
     * @param directorMarketing the directorMarketing to set
     */
    public void setDirectorMarketing(int directorMarketing) {
        this.directorMarketing = directorMarketing;
    }

    /**
     * @return the presidente
     */
    public int getPresidente() {
        return presidente;
    }

    /**
     * @param presidente the presidente to set
     */
    public void setPresidente(int presidente) {
        this.presidente = presidente;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

