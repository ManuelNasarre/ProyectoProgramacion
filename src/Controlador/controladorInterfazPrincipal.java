/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class controladorInterfazPrincipal {
    
    private Vista.InterfazPrincipal ip;
    private Vista.InterfazRegistro i2;

    
    
    
    public controladorInterfazPrincipal (Vista.InterfazPrincipal ip){
        this.ip = ip;

        this.ip.addCalcularListener(new CalcularListener());

    }
    
    public class CalcularListener implements ActionListener{
        Object obj;
        
        public void actionPerformed(ActionEvent ae){
            
            comportamiento(ae,obj);
        }
        
        
        
        public void comportamiento(ActionEvent ae, Object obj){
            
            obj = ae.getSource();
            
            if(obj == ip.getBotonConectar()){
                //llamamos a la consulta que nos devuelve la persona con ese nombre y contraseña
                
                String nombre = ip.getTnombre().getText();
                String contrasenia = new String(ip.getTcontrasenia().getPassword());
                Persona persona = new Persona(nombre,contrasenia);
                int id = PersonaConexion.obtenerIdPersona(persona);
                if(id==0){
                    
                    JOptionPane.showMessageDialog(ip.getFRAME(),"no estas registrado en la base de datos","error de logeo",JOptionPane.ERROR_MESSAGE);
                }else{
                    if(PersonaConexion.obtenerCategoria(id).equalsIgnoreCase("Presidente")){
                        InterfazPresidente ipresi = new InterfazPresidente();
                        ControladorInterfazPresidente cipresi = new ControladorInterfazPresidente(ipresi);
                    }else{
                        InterfazDirector idirec = new InterfazDirector();
                        ControladorInterfazDirector cidirec = new ControladorInterfazDirector();
                        
                    }
                }
                
                
            }else{
                if(obj == ip.getBotonRegistrar()){
                    InterfazRegistro i2 = new InterfazRegistro();
                    ControladorInterfazRegistro ci2 = new ControladorInterfazRegistro(i2);
                }
            }
            
        }
        
    }
    
   
    
}
