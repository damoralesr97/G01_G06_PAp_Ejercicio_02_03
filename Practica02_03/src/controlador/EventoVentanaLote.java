/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Lote;
import vista.VentanaLote;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaLote implements ActionListener {
    private VentanaLote ventanaLote;

    public EventoVentanaLote(VentanaLote ventanaLote) {
        this.ventanaLote = ventanaLote;
    }

    public VentanaLote getVentanaLote() {
        return ventanaLote;
    }

    public void setVentanaLote(VentanaLote ventanaLote) {
        this.ventanaLote = ventanaLote;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String codigo,area,precio,urbanizacion;
        
            codigo=this.ventanaLote.getTxtList().get(0).getText();
            area=this.ventanaLote.getTxtList().get(1).getText();
            precio=this.ventanaLote.getTxtList().get(2).getText();
            urbanizacion=this.ventanaLote.getCombo().getSelectedItem().toString();
            
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            Lote lote=new Lote(Integer.parseInt(codigo),Integer.parseInt(area),Double.parseDouble(precio),this.ventanaLote.getgD().buscarUrbanizacion(urbanizacion));
        
            if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
                File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
                archivo.createNewFile();
                ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaLote.getgD());
                if(this.ventanaLote.getgD().getLoteList().size()==0){
                    this.ventanaLote.getgD().leerLote(archivo);
                    boolean bandera=eD.verificarLote(lote);
                    if(bandera==true){
                        this.ventanaLote.getgD().addLote(lote);
                        this.ventanaLote.getgD().escribirLote(archivo, lote);
                        JOptionPane.showMessageDialog(null, "Lote Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaLote.cargaDatosTabla(this.ventanaLote.getgD().getLoteList().size(), 4);
                        this.ventanaLote.setDatos(datosTabla);
                        this.ventanaLote.getModeloTabla().setDataVector(this.ventanaLote.getDatos(),this.ventanaLote.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Lote Registrado");
                    }
                
                }else{
                    boolean bandera1=eD.verificarLote(lote);
                    if(bandera1==true){
                        this.ventanaLote.getgD().addLote(lote);
                        this.ventanaLote.getgD().escribirLote(archivo, lote);
                        JOptionPane.showMessageDialog(null, "Lote Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaLote.cargaDatosTabla(this.ventanaLote.getgD().getLoteList().size(), 4);
                        this.ventanaLote.setDatos(datosTabla);
                        this.ventanaLote.getModeloTabla().setDataVector(this.ventanaLote.getDatos(),this.ventanaLote.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Lote Registrado");
                    }
                    
                }       
            }else{
                JOptionPane.showMessageDialog(null, "Se cancelo su registro", "CANCELADO", JOptionPane.CANCEL_OPTION);
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(EventoVentanaLote.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ExcepcionDuplicados e){
            JOptionPane.showMessageDialog(null, "El lote ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese un area o precio correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
