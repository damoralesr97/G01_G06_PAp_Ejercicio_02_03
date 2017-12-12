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
import modelo.Casa;
import modelo.Lote;
import vista.VentanaCasa;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaCasa implements ActionListener {
    private VentanaCasa ventanaCasa;

    public EventoVentanaCasa(VentanaCasa ventanaCasa) {
        this.ventanaCasa = ventanaCasa;
    }

    public VentanaCasa getVentanaCasa() {
        return ventanaCasa;
    }

    public void setVentanaCasa(VentanaCasa ventanaCasa) {
        this.ventanaCasa = ventanaCasa;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String codigo,dueno,numCasa,telefono,lote;
        
            codigo=this.ventanaCasa.getTxtList().get(0).getText();
            dueno=this.ventanaCasa.getCombo2().getSelectedItem().toString();
            numCasa=this.ventanaCasa.getTxtList().get(1).getText();
            telefono=this.ventanaCasa.getTxtList().get(2).getText();
            lote=this.ventanaCasa.getCombo().getSelectedItem().toString();
            System.out.println(lote);
            
            JFileChooser guardar=new JFileChooser();
            JButton boton=new JButton();
            Casa casa = new Casa(Integer.parseInt(codigo),this.ventanaCasa.getgD().buscarDueno(dueno),numCasa,telefono,this.ventanaCasa.getgD().buscarLote(lote));
            
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
                ExcepcionDuplicados eD= new ExcepcionDuplicados(this.ventanaCasa.getgD());
                if(this.ventanaCasa.getgD().getCasaList().size()==0){
                    this.ventanaCasa.getgD().leerCasa(archivo);
                    boolean bandera=eD.verificarCasa(casa);
                    if(bandera==true){
                        this.ventanaCasa.getgD().addCasa(casa);
                        this.ventanaCasa.getgD().escribirCasa(archivo, casa);
                        JOptionPane.showMessageDialog(null, "Casa Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaCasa.cargaDatosTabla(this.ventanaCasa.getgD().getCasaList().size(), 5);
                        this.ventanaCasa.setDatos(datosTabla);
                        this.ventanaCasa.getModeloTabla().setDataVector(this.ventanaCasa.getDatos(),this.ventanaCasa.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Casa Registrado");
                    }
                
                }else{
                    boolean bandera1=eD.verificarCasa(casa);
                    if(bandera1==true){
                        this.ventanaCasa.getgD().addCasa(casa);
                        this.ventanaCasa.getgD().escribirCasa(archivo, casa);
                        JOptionPane.showMessageDialog(null, "Casa Registrado en: "+guardar.getSelectedFile().getAbsolutePath(), "EXITO", JOptionPane.DEFAULT_OPTION);
                        Object[][] datosTabla=this.ventanaCasa.cargaDatosTabla(this.ventanaCasa.getgD().getCasaList().size(), 5);
                        this.ventanaCasa.setDatos(datosTabla);
                        this.ventanaCasa.getModeloTabla().setDataVector(this.ventanaCasa.getDatos(),this.ventanaCasa.getEncabezado());
                    }else{
                        throw new ExcepcionDuplicados("Casa Registrado");
                    }
                    
                }       
            }else{
                JOptionPane.showMessageDialog(null, "Se cancelo su registro", "CANCELADO", JOptionPane.CANCEL_OPTION);
            }
        } catch (IOException ex) {
            Logger.getLogger(EventoVentanaCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ExcepcionDuplicados e){
            JOptionPane.showMessageDialog(null, "La casa ya esta registrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionTelefono e){
            JOptionPane.showMessageDialog(null, "Ingresar un telefono valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
