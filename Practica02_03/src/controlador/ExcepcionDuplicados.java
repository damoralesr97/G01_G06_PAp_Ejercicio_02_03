/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import modelo.Casa;
import modelo.Dueño;
import modelo.Lote;
import modelo.Urbanizacion;

/**
 *
 * @author DavidMorales
 */
public class ExcepcionDuplicados extends Exception {

    private GestionDato gD;
    
    public ExcepcionDuplicados(GestionDato gD) {
        this.gD=gD;
    }

    public ExcepcionDuplicados(String string) {
        super(string);
    }
    
    public boolean verificarDueño(Dueño d){
        for(Dueño du:this.gD.getDueñoList()){
            if(d.getCedula().equals(du.getCedula()) || d.getCodigo()==du.getCodigo()){
                return false;
            }
        }
    return true;
    }
    
    public boolean verificarUrbanizacion(Urbanizacion u){
        for(Urbanizacion ur:this.gD.getUrbanizacionList()){
            if(u.getCodigo()==ur.getCodigo()){
                return false;
            }
        }
    return true;
    }
    
    public boolean verificarLote(Lote l){
        for(Lote lo:this.gD.getLoteList()){
            if(lo.getCodigo()==l.getCodigo()){
                return false;
            }
        }
    return true;
    }
    
    public boolean verificarCasa(Casa c){
        for(Casa ca:this.gD.getCasaList()){
            if(ca.getCodigo()==c.getCodigo()){
                return false;
            }
        }
    return true;
    }
}
