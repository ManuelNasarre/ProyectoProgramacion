/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Modelo.*;

/**
 *
 * @author Alumno
 */
/**
 *
 * @author Alumno
 */
public class Interfaz2 {
    JFrame frame;
    JPanel panel;
    JButton botonCancelar;
    JButton botonRegistrar;
    JLabel nombre;
    JLabel apellido;
    JLabel contrasenna;
    JLabel categoria;
    JLabel contrasenna2;
    JTextField Tnombre;
    JPasswordField Tcontrasenia;
    JTextField Tapellido;
    JPasswordField Tcontrasenia2;
    JComboBox Tcategoria;
    public String [] categorias = new String[2];
    String servidor = "jdbc:mysql://localhost/";
    String bd = "BD";
    String usuario = "user";
    String contrasenia = "1234";
    conexion db = new conexion();

    public Interfaz2() {
        categorias[0] = "Presidente";
        categorias[1] = "Director Comercial";
        Tcategoria = new JComboBox(categorias);
        frame = new JFrame();
        panel = new JPanel();
        nombre = new JLabel("Nombre");
        apellido = new JLabel("Apellido");
        categoria = new JLabel("Categoria");
        contrasenna = new JLabel("Contraseña");
        contrasenna2 = new JLabel("Confirmar contraseña");
        Tnombre = new JTextField(15);
        Tapellido = new JTextField(15);
        Tcontrasenia = new JPasswordField(15);
        Tcontrasenia2 = new JPasswordField(15);
        botonCancelar = crearBoton("Cancelar");
        botonRegistrar= crearBoton("Registrar");
        panel.setLayout(new GridLayout(6,2,5,5));
        
        panel.add(nombre);
        panel.add(Tnombre);
        panel.add(apellido);
        panel.add(Tapellido);
        panel.add(categoria);
        panel.add(Tcategoria);
        panel.add(contrasenna);
        panel.add(Tcontrasenia);
        panel.add(contrasenna2);
        panel.add(Tcontrasenia2);
        panel.add(botonRegistrar);
        panel.add(botonCancelar);
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void comportamiento(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == botonCancelar) {
            
        }
        else if(obj == botonRegistrar){
            //Interfaz3 i3= new Interfaz3();
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
