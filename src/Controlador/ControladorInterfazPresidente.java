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
public class ControladorInterfazPresidente {

    private Vista.InterfazPresidente ip;

    public ControladorInterfazPresidente(Vista.InterfazPresidente ip) {
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

            if (obj == ip.getBOTON_ANIADIR()) {

                String nombre = ip.getTEXT_NOMBRE().getText();
                int telefono = Integer.parseInt(ip.getTEXT_TELEFONO().getText());
                String nombreP = String.valueOf(ip.getCOMBO_PRESIDENTE().getSelectedItem());
                String nombreD = String.valueOf(ip.getCOMBO_DIRECTOR().getSelectedItem());
                int presidente = PersonaConexion.obtenerId(nombreP, "Presidente");
                int director = PersonaConexion.obtenerId(nombreD, "Director Comercial");
                int precio = Integer.parseInt(ip.getTEXT_PRECIO().getText());

                Equipo equipo = new Equipo(nombre, telefono, director, presidente, precio);

                PersonaConexion.insertarEquipo(equipo);
                ip.getCOMBO_EQUIPOB().addItem(PersonaConexion.obtenerEquipos()[PersonaConexion.obtenerEquipos().length - 1]);
                ip.getCOMBO_EQUIPO_VENTAS().addItem(PersonaConexion.obtenerEquipos()[PersonaConexion.obtenerEquipos().length - 1]);
                ip.getCOMBO_MODIFICAR_EQUIPO().addItem(PersonaConexion.obtenerEquipos()[PersonaConexion.obtenerEquipos().length - 1]);
                JOptionPane.showMessageDialog(ip.getFRAME(), "equipo introducido correctamente", "informacion de alta", JOptionPane.INFORMATION_MESSAGE);

            } else {
                if (obj == ip.getBOTON_CANCELAR()) {

                    ip.getTEXT_NOMBRE().setText("");
                    ip.getTEXT_TELEFONO().setText("");
                    ip.getTEXT_PRECIO().setText("");
                } else {
                    if (obj == ip.getBOTON_BAJA_EQUIPO()) {

                        String nombreEquipo = String.valueOf(ip.getCOMBO_EQUIPOB().getSelectedItem());

                        PersonaConexion.eliminarEquipo(nombreEquipo);
                        ip.getCOMBO_EQUIPO_VENTAS().removeItem(ip.getCOMBO_EQUIPOB().getSelectedItem());
                        ip.getCOMBO_MODIFICAR_EQUIPO().removeItem(ip.getCOMBO_EQUIPOB().getSelectedItem());
                        ip.getCOMBO_EQUIPOB().removeItem(ip.getCOMBO_EQUIPOB().getSelectedItem());
                        JOptionPane.showMessageDialog(ip.getFRAME(), "equipo eliminado correctamente", "informacion de eliminacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {

                        if (obj == ip.getBOTON_MODIFICAR_DIRECTOR()) {

                            String nombreDirector = String.valueOf(ip.getCOMBO_MODIFICAR_DIRECTOR().getSelectedItem());
                            String nombreEquipo = String.valueOf(ip.getCOMBO_MODIFICAR_EQUIPO().getSelectedItem());

                            PersonaConexion.modificarDirector(nombreDirector, "Director Comercial", nombreEquipo);
                            JOptionPane.showMessageDialog(ip.getFRAME(), "director modificado correctamente", "informacion de modificación", JOptionPane.INFORMATION_MESSAGE);

                        } else {

                        }
                    }

                }

            }

        }

    }

}
