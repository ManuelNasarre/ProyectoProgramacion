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
    
    private int id;
    private String nombre;
    private String apellido;
    private String categoria;
    private String contrasenia;
    
    
    public Persona(String nombre,String apellido, String categoria,String contrasenia){
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.contrasenia = contrasenia;
        
        
    }
    /**
     * Constructor de la clase persona para logear
     * @param nombre nombre de la persona
     * @param contrasenia contraseña de la persona
     */
    public Persona(String nombre, String contrasenia){
        this.nombre = nombre;
        this.contrasenia = contrasenia;
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
