/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.PersonaConexion;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    //nombre del equipo para dar de alta.
    private JTextField Tnombre;
    //telefono del equipo para dar de alta.
    private JTextField Ttelefono;
    //nombre del presidente que ha elegido para el equipo.
    private JComboBox TpresidenteAlta;
    //nombre del director que ha elegido para el equipo.
    private JComboBox Tdirector;
    //precio de entrada del equipo
    private JTextField tprecio;
    private JButton btnaniadir = new JButton("Añadir");
    private JButton btncancelar = new JButton("Cancelar");
    private JButton btnaceptarEquipo = new JButton("Aceptar");
    private JButton btnVender = new JButton("Vender");
    private JButton btnaceptarDirector = new JButton("Aceptar");

    public InterfazPresidente() {
        frame = new JFrame();

        //creamos la pestaña 1
        panel1 = crearPestañaAltaEquipo();

        //creamos la pestaña 2
        panel2 = crearPestañaBajaEquipo();

        //creamos la pestaña 3
        panel3 = crearPestañaVentaEntrada();

        //creamos la pestaña 4
        panel4 = crearPestañaModificarDirector();

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
        pestañas.addTab("Vender entrada", fotoTicket, panel3);
        pestañas.addTab("Modificar director", fotoDirector, panel4);

        //añadimos el contenedor al frame
        frame.add(pestañas);

        //modificamos el frame
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addCalcularListener(ActionListener escucharBoton) {

        getBtnaniadir().addActionListener(escucharBoton);
        getBtncancelar().addActionListener(escucharBoton);
        getBtnaceptarEquipo().addActionListener(escucharBoton);
        getBtnVender().addActionListener(escucharBoton);
        getBtnaceptarDirector().addActionListener(escucharBoton);

    }

    /**
     * Metodo que crea la pestaña del alta de equipo
     *
     * @return panel donde esta la vista de dar de alta.
     */
    public JPanel crearPestañaAltaEquipo() {

        String[] nombrePresidentes = PersonaConexion.obtenerPresidentes();
        String[] nombreDirectores = PersonaConexion.obtenerDirectores();

        JLabel nombre;
        JLabel telefono;
        JLabel presidente;
        JLabel director;
        JLabel precio;
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));
        nombre = new JLabel("Nombre");
        Tnombre = new JTextField(15);
        telefono = new JLabel("Telefono");
        Ttelefono = new JTextField(15);
        presidente = new JLabel("Presidente");
        TpresidenteAlta = new JComboBox(nombrePresidentes);
        director = new JLabel("Director de Marketing");
        Tdirector = new JComboBox(nombreDirectores);
        precio = new JLabel("precio Entrada");
        tprecio = new JTextField(15);

        panel.add(nombre);
        panel.add(getTnombre());
        panel.add(telefono);
        panel.add(getTtelefono());
        panel.add(presidente);
        panel.add(TpresidenteAlta);
        panel.add(director);
        panel.add(getTdirector());
        panel.add(precio);
        panel.add(getTprecio());
        panel.add(getBtnaniadir());
        panel.add(getBtncancelar());

        return panel;
    }

    /**
     * Método que crea la pestaña de baja de equipo
     *
     * @return panel de la vista de dar de baja
     */
    public JPanel crearPestañaBajaEquipo() {

        JLabel equipo;
        String [] nombreEquipos = PersonaConexion.obtenerEquipos();
        JComboBox Tequipo;
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        equipo = new JLabel("Elegir equipo: ");
        Tequipo = new JComboBox(nombreEquipos);

        panel.add(equipo);
        panel.add(Tequipo);
        panel.add(getBtnaceptarEquipo());

        return panel;
    }

    /**
     * Método que crea la pestaña de venta de entradas
     *
     * @return panel de la vista de vender entrada.
     */
    public JPanel crearPestañaVentaEntrada() {

        JLabel nombreEquipo;
        String [] nombreEquipos = PersonaConexion.obtenerEquipos();
        JComboBox TnombreEquipo;
        JLabel fecha;
        JDateChooser Tfecha;
        JLabel precio;
        JLabel Tprecio;
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        nombreEquipo = new JLabel("Nombre equipo");
        TnombreEquipo = new JComboBox(nombreEquipos);
        Tfecha = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        fecha = new JLabel("Fecha");
        precio = new JLabel("Precio");
        Tprecio = new JLabel("");
        panel.add(nombreEquipo);
        panel.add(TnombreEquipo);
        panel.add(fecha);
        panel.add(Tfecha);
        panel.add(precio);
        String nombreEquipoPrecio = String.valueOf(TnombreEquipo.getSelectedItem());
        String valor = String.valueOf(PersonaConexion.obtenerPrecio(nombreEquipoPrecio));
        Tprecio.setText(valor + "€");
        panel.add(Tprecio);

        return panel;
    }

    public JPanel crearPestañaModificarDirector() {
        JLabel director;
        JLabel equipo;
        String [] nombreEquipos = PersonaConexion.obtenerEquipos();
        JComboBox cbEquipo;
        String [] nombreDirectores = PersonaConexion.obtenerDirectores();
        JComboBox Tdirector;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        equipo = new JLabel("Elegir equipo");
        cbEquipo = new JComboBox(nombreEquipos);
        director = new JLabel("Elegir director: ");
        Tdirector = new JComboBox(nombreDirectores);
        
        panel.add(equipo);
        panel.add(cbEquipo);
        panel.add(director);
        panel.add(Tdirector);
        panel.add(getBtnaceptarDirector());

        return panel;
    }

    /**
     * @return the btnaniadir
     */
    public JButton getBtnaniadir() {
        return btnaniadir;
    }

    /**
     * @return the btncancelar
     */
    public JButton getBtncancelar() {
        return btncancelar;
    }

    /**
     * @return the btnaceptarEquipo
     */
    public JButton getBtnaceptarEquipo() {
        return this.btnaceptarEquipo;
    }

    /**
     * @return the btnVender
     */
    public JButton getBtnVender() {
        return this.btnVender;
    }

    /**
     * @return the btnaceptarDirector
     */
    public JButton getBtnaceptarDirector() {
        return this.btnaceptarDirector;
    }

    /**
     * @return the Tnombre
     */
    public JTextField getTnombre() {
        return this.Tnombre;
    }

    /**
     * @return the Ttelefono
     */
    public JTextField getTtelefono() {
        return this.Ttelefono;
    }

    /**
     * @return the Tpresidente
     */
    public JComboBox getTpresidenteAlta() {
        return this.TpresidenteAlta;
    }

    /**
     * @return the Tdirector
     */
    public JComboBox getTdirector() {
        return this.Tdirector;
    }

    /**
     * @return the tprecio
     */
    public JTextField getTprecio() {
        return this.tprecio;
    }
}
