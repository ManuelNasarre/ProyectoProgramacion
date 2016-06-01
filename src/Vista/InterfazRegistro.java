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
public class InterfazRegistro {

    private final JFrame FRAME;
    private final JPanel PANEL;
    private final JButton BOTON_CANCELAR;
    private final JButton BOTON_REGISTRAR;
    private final JLabel NOMBRE;
    private final JLabel APELLIDO;
    private final JLabel CONTRASENNA;
    private final JLabel CATEGORIA;
    private final JLabel CONTRASENNA2;
    private final JTextField TNOMBRE;
    private final JPasswordField TCONTRASENIA;
    private final JTextField TAPELLIDO;
    private final JPasswordField TCONTRASENIA2;
    private final JComboBox TCATEGORIA;
    private String[] categorias = new String[2];
    private String servidor = "jdbc:mysql://localhost/";
    private String bd = "BD";
    private String usuario = "user";
    private String contrasenia = "1234";
    private conexion db = new conexion();

    public InterfazRegistro() {
        categorias[0] = "Presidente";
        categorias[1] = "Director Comercial";
        TCATEGORIA = new JComboBox(getCategorias());
        FRAME = new JFrame();
        PANEL = new JPanel();
        NOMBRE = new JLabel("Nombre");
        APELLIDO = new JLabel("Apellido");
        CATEGORIA = new JLabel("Categoria");
        CONTRASENNA = new JLabel("Contraseña");
        CONTRASENNA2 = new JLabel("Confirmar contraseña");
        TNOMBRE = new JTextField(15);
        TAPELLIDO = new JTextField(15);
        TCONTRASENIA = new JPasswordField(15);
        TCONTRASENIA2 = new JPasswordField(15);
        BOTON_CANCELAR = new JButton("Cancelar");
        BOTON_REGISTRAR = new JButton("Registrar");
        PANEL.setLayout(new GridLayout(6, 2, 5, 5));

        PANEL.add(NOMBRE);
        PANEL.add(TNOMBRE);
        PANEL.add(APELLIDO);
        PANEL.add(TAPELLIDO);
        PANEL.add(CATEGORIA);
        PANEL.add(TCATEGORIA);
        PANEL.add(CONTRASENNA);
        PANEL.add(TCONTRASENIA);
        PANEL.add(CONTRASENNA2);
        PANEL.add(TCONTRASENIA2);
        PANEL.add(BOTON_REGISTRAR);
        PANEL.add(BOTON_CANCELAR);
        FRAME.add(PANEL);

        FRAME.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        FRAME.pack();
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
    }

    public void addCalcularListener(ActionListener escucharBoton) {
        getBOTONREGISTRAR().addActionListener(escucharBoton);
        getBOTONCANCELAR().addActionListener(escucharBoton);

    }

    /**
     * @return the botonCancelar
     */
    public JButton getBOTONCANCELAR() {
        return BOTON_CANCELAR;
    }

    /**
     * @return the botonRegistrar
     */
    public JButton getBOTONREGISTRAR() {
        return BOTON_REGISTRAR;
    }

    /**
     * @return the Tnombre
     */
    public JTextField getTNOMBRE() {
        return TNOMBRE;
    }

    /**
     * @return the Tcontrasenia
     */
    public JPasswordField getTCONTRASENIA() {
        return TCONTRASENIA;
    }

    /**
     * @return the Tapellido
     */
    public JTextField getTAPELLIDO() {
        return TAPELLIDO;
    }

    /**
     * @return the Tcategoria
     */
    public JComboBox getTCATEGORIA() {
        return TCATEGORIA;
    }

    /**
     * @return the categorias
     */
    public String[] getCategorias() {
        return categorias;
    }

    /**
     * @return the FRAME
     */
    public JFrame getFRAME() {
        return FRAME;
    }

    /**
     * @return the TCONTRASENIA2
     */
    public JPasswordField getTCONTRASENIA2() {
        return TCONTRASENIA2;
    }
}
