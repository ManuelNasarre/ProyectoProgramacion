/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alumno
 */
public class Venta {
    private int id_entrada;
    private int id_venta;
    private int dia;
    private int mes;
    private int anio;
    
    public Venta(int i,int d, int m,int a){
        this.id_entrada=i;
        this.dia=d;
        this.mes=m;
        this.anio=a;
    }

    /**
     * @return the id_entrada
     */
    public int getId_entrada() {
        return id_entrada;
    }

    /**
     * @param id_entrada the id_entrada to set
     */
    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    /**
     * @return the id_venta
     */
    public int getId_venta() {
        return id_venta;
    }

    /**
     * @param id_venta the id_venta to set
     */
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
}
