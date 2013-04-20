package Bodeguita;

import java.io.*;
import edatos.*;

/**
 *
 * @author Luis H. Marin
 */
public class Main {

    static BufferedReader br;

    public static int ReadInt() throws IOException {
        return Integer.valueOf(br.readLine()).intValue();
    }

    public static float ReadFloat() throws IOException {
        return Float.valueOf(br.readLine()).floatValue();
    }

    public static double ReadDouble() throws IOException {
        return Double.valueOf(br.readLine()).doubleValue();
    }

    public static long ReadLong() throws IOException {
        return Long.valueOf(br.readLine()).longValue();
    }

    public static String ReadString() throws IOException {
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        TLista L;
        int opc, pos, i, j;
        String o;
        TProducto pro;
        TOperacion op;
        float precio;
        int stock;

        ///En esta lista se almacenara los Objetos tipo TPersona
        L = new TListaP();
        do {
            System.out.println("\n1.-Nuevo Producto ");
            System.out.println("2.-Listar todos");
            System.out.println("3.-Realizar compra");
            System.out.println("4.-Realizar venta");
            System.out.println("5.-Listar operaciones de un producto");
            System.out.println("6.-Listar operaciones de todos los productos ");
            System.out.println("0.-Salir");
            System.out.print("\n   Ingrese la opcion: ");
            o = br.readLine();
            opc = Integer.valueOf(o).intValue();
            switch (opc) {
                case 1://Crear productos
                    pro = new TProducto();
                    System.out.println("\n");
                    System.out.print("Descripcion: ");
                    o = br.readLine();
                    pro.setDescripcion(o);
                    System.out.print("Codigo: ");
                    o = br.readLine();
                    pro.setCodigo(Long.valueOf(o).longValue());
                    System.out.print("Precio: ");
                    precio = Float.parseFloat(br.readLine());
                    pro.setPrecio(precio);
                    System.out.print("Stock: ");
                    stock = Integer.parseInt(br.readLine());
                    pro.setStock(stock);
                    L.Adicionar(pro);
                    break;

                case 2: // Listar todas los clientes
                    System.out.println("");
                    for (i = 0; i < L.Cantidad(); i++) {
                        pro = (TProducto) L.Obtener(i);
                        System.out.println("\n" + (i + 1));
                        System.out.println("Descripcion : " + pro.getDescripcion());
                        System.out.println("Codigo: " + pro.getCodigo());
                        System.out.println("Precio: " + pro.getPrecio());
                        System.out.println("Stock: " + pro.getStock());

                    }
                    break;

                case 3: // Realizar compra
                    pro = new TProducto();
                    System.out.println("Codigo del producto a comprar: ");
                    o = br.readLine();

                    pro.setCodigo(Long.valueOf(o).longValue());
                    pos = L.Buscar(pro, new CmpCodigo());
                    if (pos >= 0) {
                        pro = (TProducto) L.Obtener(pos);
                        System.out.print("Descripcion del producto: ");
                        System.out.println(pro.getDescripcion());
                        System.out.print("Precio: ");
                        System.out.println(pro.getPrecio());
                        System.out.print("Stock: ");
                        System.out.println(pro.getStock());

                        System.out.print("\n¿Cuantos desea comprar? ");
                        o = br.readLine();
                        stock = Integer.valueOf(o).intValue();
                        op = new TOperacion();
                        op.setTipo(0); // venta
                        op.setStock(stock);
                        pro.setStock(pro.getStock() + stock);
                        pro.getOperaciones().Adicionar(op);
                    } else {
                        System.out.println("Codigo no encontrado");
                    }
                    break;


                case 4: // Realizar venta
                    pro = new TProducto();
                    System.out.println("Codigo del producto a vender: ");
                    o = br.readLine();
                    pro.setCodigo(Long.valueOf(o).longValue());
                    pos = L.Buscar(pro, new CmpCodigo());

                    if (pos >= 0) {
                        pro = (TProducto) L.Obtener(pos);
                        System.out.print("Descripcion del producto: ");
                        System.out.println(pro.getDescripcion());
                        System.out.print("Precio: ");
                        System.out.println(pro.getPrecio());
                        System.out.print("Stock Disponible: ");
                        System.out.println(pro.getStock());
                        System.out.print("¿Cuanto va a vender? ");
                        o = br.readLine();
                        stock = Integer.valueOf(o).intValue();
                        if (stock <= pro.getStock()) {
                            op = new TOperacion();
                            op.setTipo(1);//venta
                            op.setStock(stock);
                            pro.setStock(pro.getStock() - stock);
                            pro.getOperaciones().Adicionar(op);
                        } else {
                            System.out.println("NO EXISTE SALDO SUFICIENTE");
                        }
                    } else {
                        System.out.println("CODIGO NO ENCONTRADO");
                    }
                    break;

                case 5: // Listar operaciones de un producto
                    pro = new TProducto();
                    System.out.println("Codigo del producto a buscar operaciones: ");
                    o = br.readLine();
                    pro.setCodigo(Long.valueOf(o).longValue());
                    pos = L.Buscar(pro, new CmpCodigo());
                    if (pos >= 0) {
                        pro = (TProducto) L.Obtener(pos);
                        System.out.println("Descripcion: "+pro.getDescripcion());
                        System.out.println("Precio : "+pro.getPrecio());
                        System.out.println("Stock:  "+pro.getStock());


                        if (pro.getOperaciones().Cantidad() > 0) {
                            System.out.println("Operaciones realizadas:");
                            for (j = 0; j < pro.getOperaciones().Cantidad(); j++) {
                                op = (TOperacion) pro.getOperaciones().Obtener(j);
                                 System.out.println(op.getTipo() == 0 ? "Compra: " : "Venta: ");
                         System.out.println(+op.getStock());
                            }
                        }

                    }
                    break;
                
                
                case 6:
                    for (i = 0; i < L.Cantidad(); i++) {
                        pro = new TProducto();
                    
                    pro = (TProducto) L.Obtener(i);
                        System.out.println("Descripcion :"+pro.getDescripcion());
                        System.out.println("Precio : "+pro.getPrecio());
                        System.out.println("Stock:  "+pro.getStock());
                    for (j = 0; j < pro.getOperaciones().Cantidad(); j++) {
                        op = (TOperacion) pro.getOperaciones().Obtener(j);

                        System.out.println(op.getTipo() == 0 ? "Compra: " : "Venta: ");
                         System.out.println(+op.getStock());
                    }
                    }
                    break;





            }

        } while (opc != 0);

    }
}
