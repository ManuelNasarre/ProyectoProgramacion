/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */
public class InterfazInformacion {
    
    private final JFrame FRAME;
    private final JPanel PANEL;
    private final JLabel LINEA0;
    private final JLabel LINEA1;
    private final JLabel LINEA2;
    private final JLabel LINEA3;
    private final JLabel LINEA4;
    private final JLabel LINEA5;
    
    
    
    
    public InterfazInformacion(){
        FRAME = new JFrame();
        PANEL = new JPanel();
        LINEA0 = new JLabel("Informacion de la contraseña");
        LINEA1 = new JLabel("1.-debe comenzar con 1 o varias Mayusculas");
        LINEA2 = new JLabel("2.-debe continuar con dos minusculas");
        LINEA3 = new JLabel("3.-debe continuar con 0 o mas caracteres alfanumericos");
        LINEA4 = new JLabel("4.-debe continuar con 2 o mas digitos");
        LINEA5 = new JLabel("5.-debe terminar con el simbolo de dolar");
        
        
        PANEL.add(LINEA0);
        PANEL.add(LINEA1);
        PANEL.add(LINEA2);
        PANEL.add(LINEA3);
        PANEL.add(LINEA4);
        PANEL.add(LINEA5);
        
        FRAME.add(PANEL);
        FRAME.setSize(400,200);
        FRAME.setVisible(true);
        FRAME.setLocationRelativeTo(null);
    }
    
}
