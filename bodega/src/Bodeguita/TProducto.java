package Bodeguita;
import edatos.*;
/**
 *
 * @author Luis H. Marin
 */
public class TProducto {
    private String descripcion;
    private long   codigo;
    private float  precio;
    private int stock;
    private TLista operaciones;
    
    public TProducto()
    {
    	operaciones = new TListaP();
	codigo = 0;
	precio = 0;
        stock = 0;
        descripcion="";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TLista getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(TLista operaciones) {
        this.operaciones = operaciones;
    }

}
