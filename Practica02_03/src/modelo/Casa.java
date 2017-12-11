
package modelo;

/**
 *
 * @author Tatiana
 */
public class Casa {
    
    private int codigo;
    private Dueño dueño;
    private String numeroCasa;
    private String telefono;
    private Lote lote;

    public Casa(int codigo, Dueño dueño, String numeroCasa, String telefono, Lote lote) {
        this.codigo = codigo;
        this.dueño = dueño;
        this.numeroCasa = numeroCasa;
        this.telefono = telefono;
        this.lote = lote;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "Casa{" + "codigo=" + codigo + ", due\u00f1o=" + dueño + ", numeroCasa=" + numeroCasa + ", telefono=" + telefono + ", lote=" + lote + '}';
    }
    
    
    
    
}
