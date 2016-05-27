/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuelnasarre_basededatos_eval3;

import Controlador.*;
import Modelo.*;
import Vista.*;

/**
 *
 * @author Alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conection = new Conexion();
        
        
        InterfazPrincipal i = new InterfazPrincipal();
        controladorInterfazPrincipal cip = new controladorInterfazPrincipal(i);
        
      
        
    }
    
}
