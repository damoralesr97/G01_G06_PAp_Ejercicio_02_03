/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaPrincipal;
import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author paulo
 */
public class VentanaPrincipal extends JFrame
{
    private JDesktopPane escritorio;
    private JMenuBar barramenu;
    private List<JMenu> menuList;
    private List<JMenuItem> menuItemList;
    private VentanaCasa ventanacasa;
    private VentanaDueño VentanaDueño;
    private VentanaLote VentanaLote;
    private VentanaUrbanizacion ventanaUrbanizacion;
    private GestionDato gd;
    
     public VentanaPrincipal(String titulo, int ancho, int alto, GestionDato gd) {
        super(titulo);
        this.setSize(ancho, alto);
        this.gd=gd;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciaComponentes();
        this.setVisible(true);
    }
     public void iniciaComponentes()
    {
        this.escritorio = new JDesktopPane();
        this.barramenu = new JMenuBar();
        
        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Resgistra Casa"));
        this.menuItemList.add(new JMenuItem("Registra Dueño"));
        this.menuItemList.add(new JMenuItem("Registra Lote")); 
        this.menuItemList.add(new JMenuItem("Registra Urbanizacion")); 
      
            
        this.menuList = new ArrayList<JMenu>();
        this.menuList.add(new JMenu("Registro"));

      
        this.setContentPane(this.escritorio);
        this.setJMenuBar(barramenu);
        
        //agrega los menu a la barra
        this.barramenu.add(this.menuList.get(0));

        
        this.menuList.get(0).add(this.menuItemList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(1));
        this.menuList.get(0).add(this.menuItemList.get(2));   
        this.menuList.get(0).add(this.menuItemList.get(3));
        
      
        this.menuItemList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(2).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(3).addActionListener(new EventoVentanaPrincipal(this));
        
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarramenu() {
        return barramenu;
    }

    public void setBarramenu(JMenuBar barramenu) {
        this.barramenu = barramenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public VentanaCasa getVentanacasa() {
        return ventanacasa;
    }

    public void setVentanacasa(VentanaCasa ventanacasa) {
        this.ventanacasa = ventanacasa;
    }

    public VentanaDueño getVentanaDueño() {
        return VentanaDueño;
    }

    public void setVentanaDueño(VentanaDueño VentanaDueño) {
        this.VentanaDueño = VentanaDueño;
    }

    public VentanaLote getVentanaLote() {
        return VentanaLote;
    }

    public void setVentanaLote(VentanaLote VentanaLote) {
        this.VentanaLote = VentanaLote;
    }

    public VentanaUrbanizacion getVentanaUrbanizacion() {
        return ventanaUrbanizacion;
    }

    public void setVentanaUrbanizacion(VentanaUrbanizacion ventanaUrbanizacion) {
        this.ventanaUrbanizacion = ventanaUrbanizacion;
    }

    public GestionDato getGd() {
        return gd;
    }

    public void setGd(GestionDato gd) {
        this.gd = gd;
    }
     
}
