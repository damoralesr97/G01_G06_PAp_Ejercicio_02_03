/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Casa;
import modelo.Dueño;
import modelo.Lote;
import modelo.Urbanizacion;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Casa> casaList = new ArrayList<Casa>();
        List<Dueño> dueñoList = new ArrayList<Dueño>();
        List<Lote> LoteList = new ArrayList<Lote>();
        List<Urbanizacion> UrbanizacionList = new ArrayList<Urbanizacion>();
        
        GestionDato gD = new GestionDato(casaList,dueñoList,LoteList,UrbanizacionList);
        VentanaPrincipal vP = new VentanaPrincipal("REGISTRO DE VIVIENDAS",600,600,gD);
        vP.setVisible(true);
    }
    
}
