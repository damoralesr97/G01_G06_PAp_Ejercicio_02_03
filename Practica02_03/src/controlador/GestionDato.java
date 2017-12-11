/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Casa;
import modelo.Dueño;
import modelo.Lote;
import modelo.Urbanizacion;

/**
 *
 * @author Usuario
 */
public class GestionDato {
    private List<Casa> casaList;
    private List<Dueño> dueñoList;
    private List<Lote> LoteList;
    private List<Urbanizacion> urbanizacionList;

    public GestionDato(List<Casa> casaList, List<Dueño> dueñoList, List<Lote> LoteList, List<Urbanizacion> urbanizacionList) {
        this.casaList = casaList;
        this.dueñoList = dueñoList;
        this.LoteList = LoteList;
        this.urbanizacionList = urbanizacionList;
    }

    public List<Casa> getCasaList() {
        return casaList;
    }

    public void setCasaList(List<Casa> casaList) {
        this.casaList = casaList;
    }

    public List<Dueño> getDueñoList() {
        return dueñoList;
    }

    public void setDueñoList(List<Dueño> dueñoList) {
        this.dueñoList = dueñoList;
    }

    public List<Lote> getLoteList() {
        return LoteList;
    }

    public void setLoteList(List<Lote> LoteList) {
        this.LoteList = LoteList;
    }

    public List<Urbanizacion> getUrbanizacionList() {
        return urbanizacionList;
    }

    public void setUrbanizacionList(List<Urbanizacion> urbanizacionList) {
        this.urbanizacionList = urbanizacionList;
    }
    
      public boolean addCasa(Casa c){
        return this.casaList.add(c);
    }
 
    public boolean addDueño(Dueño d){
        return this.dueñoList.add(d);
    }
    
    public boolean addLote(Lote l){
        return this.LoteList.add(l);
    }
     public boolean addUrbanizacion(Urbanizacion u){
        return this.urbanizacionList.add(u);
    }
}
