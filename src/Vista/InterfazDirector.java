/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */
public class InterfazDirector {

    private final JFrame FRAME;
    private final JLabel NOMBRE_EQUIPO;
    private final JComboBox TNOMBRE_EQUIPO;
    private final JLabel FECHA;
    private final JDateChooser TFECHA;
    private final JLabel PRECIO;
    private final JLabel TPRECIO;
    private final JPanel PANEL;

    public InterfazDirector() {

        FRAME = new JFrame();
        PANEL = new JPanel();
        NOMBRE_EQUIPO = new JLabel("nombre equipo");
        TNOMBRE_EQUIPO = new JComboBox();
        FECHA = new JLabel("Fecha");
        TFECHA = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        PRECIO = new JLabel("precio");
        TPRECIO = new JLabel("");

        PANEL.setLayout(new GridLayout(5, 2, 5, 5));

        PANEL.add(NOMBRE_EQUIPO);
        PANEL.add(TNOMBRE_EQUIPO);
        PANEL.add(FECHA);
        PANEL.add(TFECHA);
        PANEL.add(PRECIO);
        FRAME.add(PANEL);
        
        FRAME.setSize(200,200);
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);

    }

}
