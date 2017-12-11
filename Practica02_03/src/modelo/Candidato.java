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
public class Candidato {
    
    private String nombre;
    private String apellido;
    private String codigo;
    private Eleccion eleccion;

    public Candidato(String nombre, String apellido, String codigo, Eleccion eleccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.eleccion = eleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Eleccion getEleccion() {
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    @Override
    public String toString() {
        return "Candidato{" + "nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + ", eleccion=" + eleccion + '}';
    }
    
    
    
    
    
    
    
}
