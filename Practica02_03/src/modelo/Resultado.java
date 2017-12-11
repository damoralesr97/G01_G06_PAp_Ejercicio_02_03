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
public class Resultado {
    
    private Eleccion eleccion;
    private String codigo;
    private int numeroVotos;
    private int numeroVotosNulos;
    private int numeroVotosValidos;
    private int numeroVotosBlanco;

    public Resultado(Eleccion eleccion, String codigo, int numeroVotos, int numeroVotosNulos, int numeroVotosValidos, int numeroVotosBlanco) {
        this.eleccion = eleccion;
        this.codigo = codigo;
        this.numeroVotos = numeroVotos;
        this.numeroVotosNulos = numeroVotosNulos;
        this.numeroVotosValidos = numeroVotosValidos;
        this.numeroVotosBlanco = numeroVotosBlanco;
    }

    public Eleccion getEleccion() {
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroVotos(int numeroVotos) {
        this.numeroVotos = numeroVotos;
    }

    public int getNumeroVotosNulos() {
        return numeroVotosNulos;
    }

    public void setNumeroVotosNulos(int numeroVotosNulos) {
        this.numeroVotosNulos = numeroVotosNulos;
    }

    public int getNumeroVotosValidos() {
        return numeroVotosValidos;
    }

    public void setNumeroVotosValidos(int numeroVotosValidos) {
        this.numeroVotosValidos = numeroVotosValidos;
    }

    public int getNumeroVotosBlanco() {
        return numeroVotosBlanco;
    }

    public void setNumeroVotosBlanco(int numeroVotosBlanco) {
        this.numeroVotosBlanco = numeroVotosBlanco;
    }

    @Override
    public String toString() {
        return "Resultado{" + "eleccion=" + eleccion + ", codigo=" + codigo + ", numeroVotos=" + numeroVotos + ", numeroVotosNulos=" + numeroVotosNulos + ", numeroVotosValidos=" + numeroVotosValidos + ", numeroVotosBlanco=" + numeroVotosBlanco + '}';
    }
    
    
    
    
    
    
    
}
