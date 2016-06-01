/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class InterfazPrincipal {
    private final JFrame FRAME;
    private final JPanel PANEL;
    private final JButton BOTON_CONECTAR;
    private final JButton BOTON_REGISTRAR;
    private final JLabel NOMBRE;
    private final JLabel CONTRASENNA;
    private final JLabel PREGUNTA;
    private final JLabel BLANCO;
    private final JTextField TNOMBRE;
    private final JPasswordField TCONTRASENNA;
    private final String SERVIDOR = "jdbc:mysql://localhost/";
    private final String BD = "baseprogramacion";
    private final String USUARIO = "user";
    private final String CONTRASENIA = "1234";
    private  conexion db = new conexion();

    public InterfazPrincipal() {
        FRAME = new JFrame();
        PANEL = new JPanel();
        NOMBRE = new JLabel("Nombre");
        CONTRASENNA = new JLabel("Contraseña");
        TNOMBRE = new JTextField(15);
        TCONTRASENNA = new JPasswordField(15);
        PREGUNTA = new JLabel("           ¿No tienes cuenta?");
        BLANCO = new JLabel("");
        BOTON_CONECTAR = new JButton("Conectarse");
        BOTON_REGISTRAR= new JButton("Registrarse");
        PANEL.setLayout(new GridLayout(4,2,5,5));
        
        PREGUNTA.setForeground(java.awt.Color.red);
        
        PANEL.add(NOMBRE);
        PANEL.add(TNOMBRE);
        PANEL.add(CONTRASENNA);
        PANEL.add(TCONTRASENNA);
        PANEL.add(BLANCO);
        PANEL.add(PREGUNTA);
        PANEL.add(BOTON_CONECTAR);
        PANEL.add(BOTON_REGISTRAR);
        FRAME.add(PANEL);

        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FRAME.pack();
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
    }

    
    public void addCalcularListener(ActionListener escucharBoton){
        BOTON_REGISTRAR.addActionListener(escucharBoton);
        BOTON_CONECTAR.addActionListener(escucharBoton);
        
    }
    
    

    /**
     * @return the botonConectar
     */
    public JButton getBotonConectar() {
        return BOTON_CONECTAR;
    }

    /**
     * @return the botonRegistrar
     */
    public JButton getBotonRegistrar() {
        return BOTON_REGISTRAR;
    }

    /**
     * @return the Tnombre
     */
    public JTextField getTnombre() {
        return TNOMBRE;
    }

    /**
     * @return the Tcontrasenia
     */
    public JPasswordField getTcontrasenia() {
        return TCONTRASENNA;
    }

    /**
     * @return the FRAME
     */
    public JFrame getFRAME() {
        return FRAME;
    }
}
