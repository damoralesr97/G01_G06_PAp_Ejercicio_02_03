/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaCasa;
import vista.VentanaDueño;
import vista.VentanaUrbanizacion;
import vista.VentanaLote;
import vista.VentanaPrincipal;

/**
 *
 * @author paulo
 */
public class EventoVentanaPrincipal implements ActionListener
{
     private VentanaPrincipal ventanaPrincipal;

    public EventoVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

   

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
     
     
     
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(0))){
            VentanaCasa vC = new VentanaCasa(this.ventanaPrincipal.getGd());
            vC.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vC);
        }
        
       if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(1))){
            VentanaDueño vD = new VentanaDueño (this.ventanaPrincipal.getGd());
            vD.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vD);
        }
       if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(2))){
            VentanaLote vL = new VentanaLote (this.ventanaPrincipal.getGd());
            vL.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vL);
        }
              
        if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(3))){
            VentanaUrbanizacion vU = new VentanaUrbanizacion (this.ventanaPrincipal.getGd());
            vU.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vU);
        }
        
    }
}
