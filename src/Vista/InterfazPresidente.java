/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class InterfazPresidente {

    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JTabbedPane pestañas;

    public InterfazPresidente() {
        frame = new JFrame();

        //creamos la pestaña 1
        panel1 = crearPestaña1();

        //creamos la pestaña 2
        panel2 = crearPestaña2();

        //creamos la pestaña 3
        panel3 = crearPestaña3();

        //creamos la pestaña 4
        panel4 = crearPestaña4();

        //creamos el contenedor de las pestañas
        pestañas = new JTabbedPane(2);

        //creamos las imagenes de las pestañas
        ImageIcon escudo = new ImageIcon("fotoEscudo.gif");
        ImageIcon escudoTachado = new ImageIcon("fotoEscudoTachado.gif");
        ImageIcon fotoTicket = new ImageIcon("fotoEntrada.gif");
        ImageIcon fotoDirector = new ImageIcon("fotoDirector.gif");
        //añadimos las pestañas al contenedor
        pestañas.addTab("Alta equipo", escudo, panel1);
        pestañas.addTab("Baja equipo", escudoTachado, panel2);
        pestañas.addTab("Vender entrada",fotoTicket, panel3);
        pestañas.addTab("Modificar director",fotoDirector, panel4);
        
        //añadimos el contenedor al frame
        frame.add(pestañas);
        
        //modificamos el frame
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Metodo que crea la pestaña del alta de equipo
     *
     * @return panel donde esta la vista de dar de alta.
     */
    public JPanel crearPestaña1() {

        JLabel nombre;
        JTextField Tnombre;
        JLabel telefono;
        JTextField Ttelefono;
        JLabel presidente;
        JComboBox Tpresidente;
        JLabel director;
        JComboBox Tdirector;
        JButton btnaniadir;
        JButton btncancelar;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        nombre = new JLabel("Nombre");
        Tnombre = new JTextField(15);
        telefono = new JLabel("Telefono");
        Ttelefono = new JTextField(15);
        presidente = new JLabel("Presidente");
        Tpresidente = new JComboBox();
        director = new JLabel("Director de Marketing");
        Tdirector = new JComboBox();
        btnaniadir = new JButton("Añadir");
        btncancelar = new JButton("Cancelar");

        panel.add(nombre);
        panel.add(Tnombre);
        panel.add(telefono);
        panel.add(Ttelefono);
        panel.add(presidente);
        panel.add(Tpresidente);
        panel.add(director);
        panel.add(Tdirector);
        panel.add(btnaniadir);
        panel.add(btncancelar);

        return panel;
    }

    /**
     * Método que crea la pestaña de baja de equipo
     *
     * @return panel de la vista de dar de baja
     */
    public JPanel crearPestaña2() {

        JLabel equipo;
        JComboBox Tequipo;
        JButton btnaceptarEquipo;

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        equipo = new JLabel("Elegir equipo: ");
        Tequipo = new JComboBox();
        btnaceptarEquipo = new JButton("Aceptar");

        panel.add(equipo);
        panel.add(Tequipo);
        panel.add(btnaceptarEquipo);

        return panel;
    }

    /**
     * Método que crea la pestaña de venta de entradas
     *
     * @return panel de la vista de vender entrada.
     */
    public JPanel crearPestaña3() {

        JLabel nombreEquipo;
        JComboBox TnombreEquipo;
        JLabel fecha;
        JDateChooser Tfecha;
        JLabel precio;
        JLabel Tprecio;
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        nombreEquipo = new JLabel("Nombre equipo");
        TnombreEquipo = new JComboBox();
        Tfecha = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        fecha = new JLabel("Fecha");
        precio = new JLabel("Precio");
        panel.add(nombreEquipo);
        panel.add(TnombreEquipo);
        panel.add(fecha);
        panel.add(Tfecha);

        return panel;
    }

    public JPanel crearPestaña4() {
        JLabel director;
        JComboBox Tdirector;
        JButton btnaceptarDirector;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        director = new JLabel("Elegir director: ");
        Tdirector = new JComboBox();
        btnaceptarDirector = new JButton("Aceptar");

        panel.add(director);
        panel.add(Tdirector);
        panel.add(btnaceptarDirector);

        return panel;
    }
}
