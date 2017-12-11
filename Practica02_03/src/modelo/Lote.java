/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Lote {
 
    private int codigo;
    private int area;
    private double precio;
    private Urbanizacion urbanizacion;

    public Lote(int codigo, int area, double precio, Urbanizacion urbanizacion) {
        this.codigo = codigo;
        this.area = area;
        this.precio = precio;
        this.urbanizacion = urbanizacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Urbanizacion getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(Urbanizacion urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    @Override
    public String toString() {
        return "Lote{" + "codigo=" + codigo + ", area=" + area + ", precio=" + precio + ", urbanizacion=" + urbanizacion + '}';
    }
    
    
    

}
