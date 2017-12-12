/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaCasa;
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
import modelo.Casa;
import modelo.Dueño;
import modelo.Lote;

/**
 *
 * @author paulo
 */
public class VentanaCasa extends JInternalFrame
{
     private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JComboBox combo;
    private JComboBox combo2;
    private JButton boton;
    private JPanel panelPrincipal;
    private GestionDato gD; 
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    
   public VentanaCasa(GestionDato gD) {
        super("Registrar Casa",true,true,true,true);
        this.gD=gD;
        this.iniciaComponente();
        this.setSize(500, 500);
    }
      public void iniciaComponente(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Codigo"));
        this.etiList.add(new JLabel("numero de casa"));
        this.etiList.add(new JLabel("telefono"));
        this.etiList.add(new JLabel("Lote"));
        this.etiList.add(new JLabel("Dueño"));
        
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.combo= new JComboBox(this.cargarCombo());
        this.combo2= new JComboBox(this.cargarCombo2());
        this.boton = new JButton("Guardar");
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(6,2);
        JPanel panelSup = new JPanel(disenioSup);
        panelSup.add(this.etiList.get(0));
        panelSup.add(this.txtList.get(0));
        panelSup.add(this.etiList.get(1));
        panelSup.add(this.txtList.get(1));
        panelSup.add(this.etiList.get(2));
        panelSup.add(this.txtList.get(2));
        
        panelSup.add(this.etiList.get(3));
        panelSup.add(this.combo);
        //
        panelSup.add(this.etiList.get(4));
        panelSup.add(this.combo2);
        
        
        panelSup.add(this.boton);
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        
        this.encabezado = new Object[5];
        this.encabezado[0] = "Codigo";
        this.encabezado[1] = "Numero de casa";
        this.encabezado[2] = "Telefono";
        this.encabezado[3] = "Lote";
        this.encabezado[4] = "Dueño";
        
        this.datos = this.cargaDatosTabla(this.gD.getCasaList().size(), 5);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
        this.boton.addActionListener(new EventoVentanaCasa(this));
        
        this.add(this.panelPrincipal);
        
    }
    
    public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Casa c:this.gD.getCasaList())
        {
            
                retorno[i][0]=c.getCodigo();
                retorno[i][1]=c.getNumeroCasa();
                retorno[i][2]=c.getTelefono();
                retorno[i][3]=c.getLote();
                retorno[i][4]=c.getDueño().getNombre()+" "+c.getDueño().getApellido();

            i++;
            
        }        
        return retorno;
    }
    
    public String[] cargarCombo(){
        String[] retorno = new String[this.gD.getLoteList().size()];
        int i=0;
        for(Lote c:this.gD.getLoteList()){
            retorno[i]=c.getUrbanizacion().getNombre();
            i++;
        }
        return retorno;
    }
     public String[] cargarCombo2(){
        String[] retorno = new String[this.gD.getDueñoList().size()];
        int i=0;
        for(Dueño d:this.gD.getDueñoList()){
            retorno[i]=d.getNombre()+ " " + d.getApellido();
            i++;
        }
        return retorno;
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public JComboBox getCombo2() {
        return combo2;
    }

    public void setCombo2(JComboBox combo2) {
        this.combo2 = combo2;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
    
     
    
}
