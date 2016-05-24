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
    JFrame frame;
    JPanel panel;
    JButton botonConectar;
    JButton botonRegistrar;
    JLabel nombre;
    JLabel contrasenna;
    JLabel pregunta;
    JLabel blanco;
    JTextField Tnombre;
    JPasswordField Tcontrasenia;
    String servidor = "jdbc:mysql://localhost/";
    String bd = "BD";
    String usuario = "user";
    String contrasenia = "1234";
    conexion db = new conexion();

    public InterfazPrincipal() {
        frame = new JFrame();
        panel = new JPanel();
        nombre = new JLabel("Nombre");
        contrasenna = new JLabel("Contraseña");
        Tnombre = new JTextField(15);
        Tcontrasenia = new JPasswordField(15);
        pregunta = new JLabel("           ¿No tienes cuenta?");
        blanco = new JLabel("");
        botonConectar = crearBoton("Conectarse");
        botonRegistrar= crearBoton("Registrarse");
        panel.setLayout(new GridLayout(4,2,5,5));
        
        pregunta.setForeground(java.awt.Color.red);
        
        panel.add(nombre);
        panel.add(Tnombre);
        panel.add(contrasenna);
        panel.add(Tcontrasenia);
        panel.add(blanco);
        panel.add(pregunta);
        panel.add(botonConectar);
        panel.add(botonRegistrar);
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void comportamiento(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == botonConectar) {
            /*if(){
                Interfaz3 i3 = new Interfaz3();
            }else{
                Interfaz4 i4 = new Interfaz4();
            }*/
        }
        else if(obj == botonRegistrar){
            Interfaz2 i2= new Interfaz2();
        }
        
    }
    public JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);

        boton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        comportamiento(e);
                    }
                }
        );
        return boton;
    }
}
