/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class ControladorInterfazPresidente {
    
    private Vista.InterfazPresidente ipre;
    
    
    
    public ControladorInterfazPresidente(Vista.InterfazPresidente ipre){
        
        this.ipre = ipre;
        
        
        this.ipre.addCalcularListener(new CalcularListener());
    }
    
    public class CalcularListener implements ActionListener{
        Object obj;

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            comportamiento(ae,obj);
        }
        
        public void comportamiento(ActionEvent ae, Object obj){
            obj = ae.getSource();
            
            
            if(obj == ipre.getBtnaniadir()){
                //obtenemos los valores que ha introducido en los campos.
                String nombrePresidente = String.valueOf(ipre.getTpresidenteAlta().getSelectedItem());
                String nombreDirector = String.valueOf(ipre.getTdirector().getSelectedItem());
                String nombreEquipo = ipre.getTnombre().getText();
                int telefono = Integer.parseInt(ipre.getTtelefono().getText());
                int presidente = PersonaConexion.obtenerId(nombrePresidente,"Presidente");
                int director = PersonaConexion.obtenerId(nombreDirector, "Director Comercial");
                float precio = Integer.parseInt(ipre.getTprecio().getText());
                Equipo equipo = new Equipo(nombreEquipo,telefono,director,presidente,precio);
                PersonaConexion.insertarEquipo(equipo);
                
            }
        }
        
    }
    
}
