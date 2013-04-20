package Bodeguita;

/**
 *
 * @author Luis H. Marin
 */
public class TOperacion {

    private int  tipo; // 0: venta, 1: compra
    private float precio;
    private int  stock;

    public TOperacion()
    {
        this.tipo = 0;
        this.precio=0;
        this.stock=0;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

   
}
