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
    private Candidato candidato;
    private Resultado resultado;
   

    public Eleccion(String fecha, int numeroCandidatos, String codigo, Resultado resultado, Candidato candidato) {
        this.fecha = fecha;
        this.numeroCandidatos = numeroCandidatos;
        this.codigo = codigo;
        this.resultado = resultado;
        this.candidato = candidato;
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

    public void setNumeroCandidatos(int numeroCandidatos) {
        this.numeroCandidatos = numeroCandidatos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public String toString() {
        return "Eleccion{" + "fecha=" + fecha + ", numeroCandidatos=" + numeroCandidatos + ", codigo=" + codigo + ", resultado=" + resultado + ", candidato=" + candidato + '}';
    }
    
    

    
}
