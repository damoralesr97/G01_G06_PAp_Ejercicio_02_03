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
import modelo.Urbanizacion;
import vista.VentanaUrbanizacion;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaUrbanizacion implements ActionListener {
    private VentanaUrbanizacion ventanaUrbanizacion;

    public EventoVentanaUrbanizacion(VentanaUrbanizacion ventanaUrbanizacion) {
        this.ventanaUrbanizacion = ventanaUrbanizacion;
    }

    public VentanaUrbanizacion getVentanaUrbanizacion() {
        return ventanaUrbanizacion;
    }

    public void setVentanaUrbanizacion(VentanaUrbanizacion ventanaUrbanizacion) {
        this.ventanaUrbanizacion = ventanaUrbanizacion;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String codigo,nombre,telefono,direccion;
        
            codigo=this.ventanaUrbanizacion.getTxtList().get(0).getText();
            nombre=this.ventanaUrbanizacion.getTxtList().get(1).getText().toUpperCase();
            telefono=this.ventanaUrbanizacion.getTxtList().get(2).getText();
            direccion=this.ventanaUrbanizacion.getTxtList().get(3).getText().toUpperCase();
            
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            Urbanizacion urbanizacion=new Urbanizacion(Integer.parseInt(codigo),nombre,telefono,direccion);
        
            for(int i=0;i<nombre.length();i++){
                if(nombre.charAt(i)<64 || nombre.charAt(i)>91){
                    throw new ExcepcionSoloLetras("Solo letras");
                }
            }
            if(telefono.length()==10 || telefono.length()==7){
                for(int i=0;i<telefono.length();i++){
                    if(telefono.charAt(i)<47 || telefono.charAt(i)>58){
                       throw new ExcepcionTelefono("Telefono Incorrecta");
                    }
                }  
            } else{
                throw new ExcepcionTelefono("Telefono Incorrecta");
            }
            if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
                File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
                archivo.createNewFile();
                ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaUrbanizacion.getgD());
                if(this.ventanaUrbanizacion.getgD().getUrbanizacionList().size()==0){
                    this.ventanaUrbanizacion.getgD().leerUrbanizacion(archivo);
                    boolean bandera=eD.verificarUrbanizacion(urbanizacion);
                    if(bandera==true){
                        this.ventanaUrbanizacion.getgD().addUrbanizacion(urbanizacion);
                        this.ventanaUrbanizacion.getgD().escribirUrbanizacion(archivo, urbanizacion);
                        JOptionPane.showMessageDialog(null, "Urbanizacion Registrada en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaUrbanizacion.cargaDatosTabla(this.ventanaUrbanizacion.getgD().getUrbanizacionList().size(), 4);
                        this.ventanaUrbanizacion.setDatos(datosTabla);
                        this.ventanaUrbanizacion.getModeloTabla().setDataVector(this.ventanaUrbanizacion.getDatos(),this.ventanaUrbanizacion.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Urbanizacion Registrada");
                    }
                
                }else{
                    boolean bandera1=eD.verificarUrbanizacion(urbanizacion);
                    if(bandera1==true){
                        this.ventanaUrbanizacion.getgD().addUrbanizacion(urbanizacion);
                        this.ventanaUrbanizacion.getgD().escribirUrbanizacion(archivo, urbanizacion);
                        JOptionPane.showMessageDialog(null, "Urbanizacion Registrada en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaUrbanizacion.cargaDatosTabla(this.ventanaUrbanizacion.getgD().getUrbanizacionList().size(), 4);
                        this.ventanaUrbanizacion.setDatos(datosTabla);
                        this.ventanaUrbanizacion.getModeloTabla().setDataVector(this.ventanaUrbanizacion.getDatos(),this.ventanaUrbanizacion.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Urbanizacion Registrada");
                    }
                    
                }       
            }else{
                JOptionPane.showMessageDialog(null, "Se cancelo su registro", "CANCELADO", JOptionPane.CANCEL_OPTION);
            }
        }
        catch(ExcepcionSoloLetras e){
            JOptionPane.showMessageDialog(null, "Ingresar solo letras", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ex) {
            Logger.getLogger(EventoVentanaDueño.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ExcepcionDuplicados e){
            JOptionPane.showMessageDialog(null, "La urbanizacion ya esta registrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingresar un codigo valido(numeros)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionTelefono e){
            JOptionPane.showMessageDialog(null, "Ingresar un telefono valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
