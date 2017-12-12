/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private List<Lote> loteList;
    private List<Urbanizacion> urbanizacionList;

    public GestionDato(List<Casa> casaList, List<Dueño> dueñoList, List<Lote> loteList, List<Urbanizacion> urbanizacionList) {
        this.casaList = casaList;
        this.dueñoList = dueñoList;
        this.loteList = loteList;
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
        return loteList;
    }

    public void setLoteList(List<Lote> loteList) {
        this.loteList = loteList;
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
        return this.loteList.add(l);
    }
     public boolean addUrbanizacion(Urbanizacion u){
        return this.urbanizacionList.add(u);
    }
     
     public boolean escribirDueno(File archivo, Dueño dueño){
        try{
            FileOutputStream ae = new FileOutputStream(archivo.getAbsolutePath(),true);
            DataOutputStream escritura = new DataOutputStream(ae);
            
            escritura.writeInt(dueño.getCodigo());
            escritura.writeUTF(dueño.getNombre());
            escritura.writeUTF(dueño.getApellido());
            escritura.writeUTF(dueño.getCedula());
            escritura.close();
            return true;
        }
        catch(IOException e1){
            return false;
        }
    }
    
    public boolean escribirUrbanizacion(File archivo, Urbanizacion urbanizacion){
        try{
            FileOutputStream ae = new FileOutputStream(archivo.getAbsolutePath(),true);
            DataOutputStream escritura = new DataOutputStream(ae);
            
            escritura.writeInt(urbanizacion.getCodigo());
            escritura.writeUTF(urbanizacion.getNombre());
            escritura.writeUTF(urbanizacion.getTelefono());
            escritura.writeUTF(urbanizacion.getDireccion());
            escritura.close();
            return true;
        }
        catch(IOException e1){
            return false;
        }
    }
    
    public boolean escribirLote(File archivo, Lote lote){
        try{
            FileOutputStream ae = new FileOutputStream(archivo.getAbsolutePath(),true);
            DataOutputStream escritura = new DataOutputStream(ae);
            
            escritura.writeInt(lote.getCodigo());
            escritura.writeInt(lote.getArea());
            escritura.writeDouble(lote.getPrecio());
            escritura.writeInt(lote.getUrbanizacion().getCodigo());
            escritura.close();
            return true;
        }
        catch(IOException e1){
            return false;
        }
    }
    
    public boolean escribirCasa(File archivo, Casa casa){
        try{
            FileOutputStream ae = new FileOutputStream(archivo.getAbsolutePath(),true);
            DataOutputStream escritura = new DataOutputStream(ae);
            
            escritura.writeInt(casa.getCodigo());
            escritura.writeInt(casa.getDueño().getCodigo());
            escritura.writeUTF(casa.getNumeroCasa());
            escritura.writeUTF(casa.getTelefono());
            escritura.writeInt(casa.getLote().getCodigo());
            escritura.close();
            return true;
        }
        catch(IOException e1){
            return false;
        }
    }
    
    public Urbanizacion buscarUrbanizacion(String nombre){
        for(Urbanizacion ur:this.urbanizacionList){
            if(ur.getNombre()==nombre){
                return ur;
            }
        }
        return null;
    }
    
    public Urbanizacion buscarUrbanizacion(int codigo){
        for(Urbanizacion ur:this.urbanizacionList){
            if(ur.getCodigo()==codigo){
                return ur;
            }
        }
        return null;
    }
    
    public Dueño buscarDueno(int codigo){
        for(Dueño du:this.dueñoList){
            if(du.getCodigo()==codigo){
                return du;
            }
        }
        return null;
    }
    
    public Dueño buscarDueno(String nombre){
        for(Dueño du:this.dueñoList){
            if((du.getNombre()+" "+du.getApellido()).equals(nombre)){
                return du;
            }
        }
        return null;
    }
    
    public Lote buscarLote(int codigo){
        for(Lote lo:this.loteList){
            if(lo.getCodigo()==codigo){
                return lo;
            }
        }
        return null;
    }
    
    public Lote buscarLote(String mensaje){
        for(Lote lo:this.loteList){
            if(lo.getUrbanizacion().getNombre()==mensaje){
                return lo;
            }
        }
        return null;
    }
    
    
    
    public void leerDueño(File archivo) throws FileNotFoundException, IOException{
        try{
            FileInputStream ae = new FileInputStream(archivo.getAbsolutePath());
            DataInputStream lectura = new DataInputStream(ae);
        
            while(true){
                int c = lectura.readInt();
                String n = lectura.readUTF();
                String a = lectura.readUTF();
                String ce = lectura.readUTF();
                Dueño d = new Dueño(c,n,a,ce);
                this.dueñoList.add(d);
            }
        } catch(EOFException e){
            
        }
    }
    
    public void leerUrbanizacion(File archivo) throws FileNotFoundException, IOException{
        try{
            FileInputStream ae = new FileInputStream(archivo.getAbsolutePath());
            DataInputStream lectura = new DataInputStream(ae);
        
            while(true){
                int c = lectura.readInt();
                String n = lectura.readUTF();
                String t = lectura.readUTF();
                String d = lectura.readUTF();
                Urbanizacion u = new Urbanizacion(c,n,t,d);
                this.urbanizacionList.add(u);
            }
        } catch(EOFException e){
            
        }
    }
    
    public void leerLote(File archivo) throws FileNotFoundException, IOException{
        try{
            FileInputStream ae = new FileInputStream(archivo.getAbsolutePath());
            DataInputStream lectura = new DataInputStream(ae);
        
            while(true){
                int c = lectura.readInt();
                int a = lectura.readInt();
                double p = lectura.readDouble();
                int u = lectura.readInt();
                Lote l = new Lote(c,a,p,this.buscarUrbanizacion(u));
                this.loteList.add(l);
            }
        } catch(EOFException e){
            
        }
    }
    
    public void leerCasa(File archivo) throws FileNotFoundException, IOException{
        try{
            FileInputStream ae = new FileInputStream(archivo.getAbsolutePath());
            DataInputStream lectura = new DataInputStream(ae);
        
            while(true){
                int c = lectura.readInt();
                int d = lectura.readInt();
                String n = lectura.readUTF();
                String t = lectura.readUTF();
                int l = lectura.readInt();
                Casa ca = new Casa(c,this.buscarDueno(d),n,t,this.buscarLote(l));
                this.casaList.add(ca);
            }
        } catch(EOFException e){
            
        }
    }
     
}
