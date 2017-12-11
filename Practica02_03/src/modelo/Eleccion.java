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
public class Eleccion {
    
    private String fecha;
    private int numeroCandidatos;
    private String codigo;

    public Eleccion(String fecha, int NumeroCandidatos, String codigo) {
        this.fecha = fecha;
        this.numeroCandidatos = NumeroCandidatos;
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroCandidatos() {
        return numeroCandidatos;
    }

    public void setNumeroCandidatos(int NumeroCandidatos) {
        this.numeroCandidatos = NumeroCandidatos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Eleccion{" + "fecha=" + fecha + ", NumeroCandidatos=" + numeroCandidatos + ", codigo=" + codigo + '}';
    }
    
    
    
    
}
