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
import modelo.Dueño;
import vista.VentanaDueño;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaDueño implements ActionListener {
    private VentanaDueño ventanaDueño;

    public EventoVentanaDueño(VentanaDueño ventanaDueño) {
        this.ventanaDueño = ventanaDueño;
    }

    public VentanaDueño getVentanaDueño() {
        return ventanaDueño;
    }

    public void setVentanaDueño(VentanaDueño ventanaDueño) {
        this.ventanaDueño = ventanaDueño;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String codigo,nombre,apellido,cedula;
        
            codigo=this.ventanaDueño.getTxtList().get(0).getText();
            nombre=this.ventanaDueño.getTxtList().get(1).getText().toUpperCase();
            apellido=this.ventanaDueño.getTxtList().get(2).getText().toUpperCase();
            cedula=this.ventanaDueño.getTxtList().get(3).getText();
            
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            Dueño dueño=new Dueño(Integer.parseInt(codigo),nombre,apellido,cedula);
        
            for(int i=0;i<nombre.length();i++){
                if(nombre.charAt(i)<64 || nombre.charAt(i)>91){
                    throw new ExcepcionSoloLetras("Solo letras");
                }
            }
            for(int i=0;i<apellido.length();i++){
                if(apellido.charAt(i)<64 || apellido.charAt(i)>91){
                    throw new ExcepcionSoloLetras("Solo letras");
                }
            }
            if(cedula.length()==10){
                for(int i=0;i<cedula.length();i++){
                    if(cedula.charAt(i)<47 || cedula.charAt(i)>58){
                       throw new ExcepcionCedula("Cedula Incorrecta");
                    }
                }  
            } else{
                throw new ExcepcionCedula("Cedula Incorrecta");
            }
            if(guardar.showSaveDialog(boton)==JFileChooser.APPROVE_OPTION){
                File archivo=new File(guardar.getSelectedFile().getAbsolutePath());
                archivo.createNewFile();
                ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaDueño.getgD());
                if(this.ventanaDueño.getgD().getDueñoList().size()==0){
                    this.ventanaDueño.getgD().leerDueño(archivo);
                    boolean bandera=eD.verificarDueño(dueño);
                    if(bandera==true){
                        this.ventanaDueño.getgD().addDueño(dueño);
                        this.ventanaDueño.getgD().escribirDueno(archivo, dueño);
                        JOptionPane.showMessageDialog(null, "Usuario Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaDueño.cargaDatosTabla(this.ventanaDueño.getgD().getDueñoList().size(), 4);
                        this.ventanaDueño.setDatos(datosTabla);
                        this.ventanaDueño.getModeloTabla().setDataVector(this.ventanaDueño.getDatos(),this.ventanaDueño.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Usuario Registrado");
                    }
                
                }else{
                    boolean bandera1=eD.verificarDueño(dueño);
                    if(bandera1==true){
                        this.ventanaDueño.getgD().addDueño(dueño);
                        this.ventanaDueño.getgD().escribirDueno(archivo, dueño);
                        JOptionPane.showMessageDialog(null, "Usuario Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaDueño.cargaDatosTabla(this.ventanaDueño.getgD().getDueñoList().size(), 4);
                        this.ventanaDueño.setDatos(datosTabla);
                        this.ventanaDueño.getModeloTabla().setDataVector(this.ventanaDueño.getDatos(),this.ventanaDueño.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Usuario Registrado");
                    }
                    
                }       
            }else{
                JOptionPane.showMessageDialog(null, "Se cancelo su registro", "CANCELADO", JOptionPane.CANCEL_OPTION);
            }
        }
        catch(ExcepcionSoloLetras e){
            JOptionPane.showMessageDialog(null, "Ingresar solo letras", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionCedula e){
            JOptionPane.showMessageDialog(null, "Ingresar cedula valida", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        catch (IOException ex) {
            Logger.getLogger(EventoVentanaDueño.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ExcepcionDuplicados e){
            JOptionPane.showMessageDialog(null, "El dueno ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingresar un codigo valido(numeros)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
