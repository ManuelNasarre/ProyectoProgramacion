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
    
    //componenetes principales.
    private final JFrame FRAME;
    private final JPanel PANEL_ALTA;
    private final JPanel PANEL_BAJA;
    private final JPanel PANEL_VENTA;
    private final JPanel PANEL_MODIFICAR;
    private final JTabbedPane PESTANNAS;
    
    
    //componentes de alta de equipo
    private JButton BOTON_ANIADIR;
    private JButton BOTON_CANCELAR;
    private JComboBox COMBO_DIRECTOR;
    private JComboBox COMBO_PRESIDENTE;
    private JTextField TEXT_NOMBRE;
    private JTextField TEXT_TELEFONO;

    //componentes de baja de equipo
    private JComboBox COMBO_EQUIPOB;
    private JButton BOTON_BAJA_EQUIPO;
    
    //componentes venta de entradas
    private JComboBox COMBO_EQUIPO_VENTAS;
    private JDateChooser FECHA;
    private JLabel PRECIO;
    
    //componentes de modificar director
    private JComboBox COMBO_MODIFICAR_EQUIPO;
    private JComboBox COMBO_MODIFICAR_DIRECTOR;
    private JButton BOTON_MODIFICAR_DIRECTOR;

    /**
     * Constructor de la interfaz.
     */
    public InterfazPresidente() {
        FRAME = new JFrame();

        //creamos la pestaña 1
        PANEL_ALTA = crearPestañaAltaEquipo();

        //creamos la pestaña 2
        PANEL_BAJA = crearPestañaBajaEquipo();

        //creamos la pestaña 3
        PANEL_VENTA = crearPestañaVenta();

        //creamos la pestaña 4
        PANEL_MODIFICAR = crearPestañaModificarDirector();

        //creamos el contenedor de las pestañas
        PESTANNAS = new JTabbedPane(2);

        //creamos las imagenes de las pestañas
        ImageIcon escudo = new ImageIcon("fotoEscudo.gif");
        ImageIcon escudoTachado = new ImageIcon("fotoEscudoTachado.gif");
        ImageIcon fotoTicket = new ImageIcon("fotoEntrada.gif");
        ImageIcon fotoDirector = new ImageIcon("fotoDirector.gif");
        //añadimos las pestañas al contenedor
        PESTANNAS.addTab("Alta equipo", escudo, PANEL_ALTA);
        PESTANNAS.addTab("Baja equipo", escudoTachado, PANEL_BAJA);
        PESTANNAS.addTab("Vender entrada", fotoTicket, PANEL_VENTA);
        PESTANNAS.addTab("Modificar director", fotoDirector, PANEL_MODIFICAR);

        //añadimos el contenedor al frame
        FRAME.add(PESTANNAS);

        //modificamos el frame
        FRAME.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        FRAME.setSize(700, 300);
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
    }

    /**
     * Metodo que crea la pestaña del alta de equipo
     *
     * @return panel donde esta la vista de dar de alta.
     */
    public JPanel crearPestañaAltaEquipo() {

        JLabel nombre;
        JLabel telefono;
        JLabel presidente;
        JLabel director;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        nombre = new JLabel("Nombre");
        TEXT_NOMBRE = new JTextField(15);
        telefono = new JLabel("Telefono");
        TEXT_TELEFONO = new JTextField(15);
        presidente = new JLabel("Presidente");
        COMBO_PRESIDENTE = new JComboBox();
        director = new JLabel("Director de Marketing");
        COMBO_DIRECTOR = new JComboBox();
        BOTON_ANIADIR = new JButton("Añadir");
        BOTON_CANCELAR = new JButton("Cancelar");

        panel.add(nombre);
        panel.add(TEXT_NOMBRE);
        panel.add(telefono);
        panel.add(TEXT_TELEFONO);
        panel.add(presidente);
        panel.add(COMBO_PRESIDENTE);
        panel.add(director);
        panel.add(COMBO_DIRECTOR);
        panel.add(BOTON_ANIADIR);
        panel.add(BOTON_CANCELAR);

        return panel;
    }

    /**
     * Método que crea la pestaña de baja de equipo
     *
     * @return panel de la vista de dar de baja
     */
    public JPanel crearPestañaBajaEquipo() {

        JLabel equipo;
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        equipo = new JLabel("Elegir equipo: ");
        COMBO_EQUIPOB = new JComboBox();
        BOTON_BAJA_EQUIPO = new JButton("Aceptar");

        panel.add(equipo);
        panel.add(COMBO_EQUIPOB);
        panel.add(BOTON_BAJA_EQUIPO);

        return panel;
    }

    /**
     * Método que crea la pestaña de venta de entradas
     *
     * @return panel de la vista de vender entrada.
     */
    public JPanel crearPestañaVenta() {

        JLabel nombreEquipo;
        JLabel fecha;
        JLabel precio;
        
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        nombreEquipo = new JLabel("Nombre equipo");
        COMBO_EQUIPO_VENTAS = new JComboBox();
        FECHA = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        fecha = new JLabel("Fecha");
        precio = new JLabel("Precio");
        panel.add(nombreEquipo);
        panel.add(COMBO_EQUIPO_VENTAS);
        panel.add(fecha);
        panel.add(FECHA);

        return panel;
    }
    /**
     * Metodo que crea la pestaña de modificar director.
     * @return panel de modificacion de director
     */
    public JPanel crearPestañaModificarDirector() {
        JLabel director;       
        JLabel equipo;
        String [] nombreDirectores;
        String [] nombreEquipos;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        director = new JLabel("Elegir director: ");
        equipo = new JLabel("elige equipo");
        COMBO_MODIFICAR_DIRECTOR = new JComboBox();
        COMBO_MODIFICAR_EQUIPO = new JComboBox();
        BOTON_MODIFICAR_DIRECTOR = new JButton("Aceptar");
        

        panel.add(director);
        panel.add(COMBO_MODIFICAR_DIRECTOR);
        panel.add(BOTON_MODIFICAR_DIRECTOR);

        return panel;
    }
}
