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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class ControladorInterfazRegistro {

    private Vista.InterfazRegistro ip;
    private conexion conexion = new conexion();

    public ControladorInterfazRegistro(Vista.InterfazRegistro ip) {
        this.ip = ip;
        this.ip.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object obj;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, obj);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == ip.getBOTONCANCELAR()) {

            } else {
                if (obj == ip.getBOTONREGISTRAR()) {
                    if (!datosRellenos()) {
                        JOptionPane.showMessageDialog(ip.getFRAME(), "no has rellenado todos los campos", "error de registro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (!contraseniasIguales()) {
                            JOptionPane.showMessageDialog(ip.getFRAME(), "las contraseñas no coinciden", "error de registro", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (!contraseniaCorrecta()) {
                                JOptionPane.showMessageDialog(ip.getFRAME(), "las contraseñas no cumple el patron", "error de registro", JOptionPane.ERROR_MESSAGE);

                            } else {
                                if (!datosCorrectos()) {
                                    JOptionPane.showMessageDialog(ip.getFRAME(), "los datos no son correctos", "error de registro", JOptionPane.ERROR_MESSAGE);

                                } else {

                                    String nombre = ip.getTNOMBRE().getText();
                                    String apellido = ip.getTAPELLIDO().getText();
                                    String pass = new String(ip.getTCONTRASENIA().getPassword());
                                    String categoria = String.valueOf(ip.getTCATEGORIA().getSelectedItem());
                                    Persona persona = new Persona(nombre, apellido, categoria, pass);
                                    PersonaConexion.insertarPersona(persona);
                                }

                            }
                        }
                    }

                }
            }

        }

    }

    public boolean datosRellenos() {
        boolean correcto = false;
        String nombre = ip.getTNOMBRE().getText();
        String apellido = ip.getTAPELLIDO().getText();
        String pass = new String(ip.getTCONTRASENIA().getPassword());
        String categoria = String.valueOf(ip.getTCATEGORIA().getSelectedItem());
        if (nombre.equalsIgnoreCase("") || apellido.equalsIgnoreCase("")
                || pass.equalsIgnoreCase("") || categoria.equalsIgnoreCase("")) {
            correcto = false;
        } else {
            correcto = true;
        }
        return correcto;

    }

    public boolean contraseniasIguales() {
        boolean iguales = false;
        String contrasenia1 = new String(ip.getTCONTRASENIA().getPassword());
        String contrasenia2 = new String(ip.getTCONTRASENIA2().getPassword());
        if (contrasenia1.equalsIgnoreCase(contrasenia2)) {
            iguales = true;
        }
        return iguales;
    }

    public boolean contraseniaCorrecta() {
        boolean correcta = false;
        String contrasenia = new String(ip.getTCONTRASENIA().getPassword());
        String expresionRegular = "[A-Z]+[a-z]{2,}\\w*\\d{2,}\\$";
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher mat = patron.matcher(contrasenia);
        if (mat.matches() && contrasenia.length()>=8) {
            correcta = true;
        }
        return correcta;
    }

    public boolean datosCorrectos() {
        boolean correctos = false;
        String expresionNombre = "\\w*";
        String expresionApellido = "\\w*";
        String nombre = ip.getTNOMBRE().getText();
        String apellido = ip.getTAPELLIDO().getText();

        Pattern patronNombre = Pattern.compile(expresionNombre);
        Pattern patronApellido = Pattern.compile(expresionApellido);

        Matcher matNombre = patronNombre.matcher(nombre);
        Matcher matApellido = patronApellido.matcher(apellido);

        if (matNombre.matches() && matApellido.matches()) {
            correctos = true;

        }

        return correctos;
    }

}
