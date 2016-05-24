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
public class Persona {
    
    
    private String nombre;
    private String categoria;
    private String contrasenia;
    
    
    public Persona(){
        
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contrasenna
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * @param contrasenna the contrasenna to set
     */
    public void setContrasenia(String contrasenna) {
        this.contrasenia = contrasenna;
    }
    
    
    public String getCategoria(){
        
        return this.categoria;
    }
}
