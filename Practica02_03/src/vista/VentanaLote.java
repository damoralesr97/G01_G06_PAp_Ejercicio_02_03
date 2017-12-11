/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Lote;
import modelo.Urbanizacion;

/**
 *
 * @author paulo
 */
public class VentanaLote extends JInternalFrame
{
   private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JComboBox combo;
    private JButton boton;
    private JPanel panelPrincipal;
    private GestionDato gD; 
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    
    public VentanaLote(GestionDato gD) {
        super("Registrar Revista",true,true,true,true);
        this.gD=gD;
        this.iniciaComponente();
        this.setSize(300, 300);
    }
      
    public void iniciaComponente(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Codigo"));
        this.etiList.add(new JLabel("Area"));
        this.etiList.add(new JLabel("Precio"));
        this.etiList.add(new JLabel("Urbanizacion"));
        
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.combo= new JComboBox(this.cargarCombo());
        this.boton = new JButton("Guardar");
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(5,2);
        JPanel panelSup = new JPanel(disenioSup);
        panelSup.add(this.etiList.get(0));
        panelSup.add(this.txtList.get(0));
        panelSup.add(this.etiList.get(1));
        panelSup.add(this.txtList.get(1));
        panelSup.add(this.etiList.get(2));
        panelSup.add(this.txtList.get(2));

        panelSup.add(this.etiList.get(3));
        panelSup.add(this.combo);
        
        
        panelSup.add(this.boton);
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        
        this.encabezado = new Object[4];
        this.encabezado[0] = "Codigo";
        this.encabezado[1] = "Area";
        this.encabezado[2] = "Precio";
        this.encabezado[3] = "Urbanizacion";
        
        this.datos = this.cargaDatosTabla((this.gD.getLoteList()).size(), 4);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
       // this.boton.addActionListener(new EventoVentanaArticulo(this));
        
        this.add(this.panelPrincipal);
        
    }
     public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Lote l:this.gD.getLoteList())
        {
            
                retorno[i][0]=l.getCodigo();
                retorno[i][1]=l.getArea();
                retorno[i][2]=l.getPrecio();
                retorno[i][3]=l.getUrbanizacion();

            i++;
            
        }        
        return retorno;
    }
    
    public String[] cargarCombo(){
        String[] retorno = new String[this.gD.getUrbanizacionList().size()];
        int i=0;
        for(Urbanizacion u:this.gD.getUrbanizacionList()){
            retorno[i]=u.getNombre();
            i++;
        }
        return retorno;
    }
}
