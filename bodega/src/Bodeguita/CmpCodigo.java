package Bodeguita;
import edatos.*;
/**
 *
 * @author Luis H. Marin
 */
public class CmpCodigo implements TComparar {

    public int Compara(Object a, Object b)
	{
		TProducto e1 = (TProducto)a;
		TProducto e2 = (TProducto)b;
		if ( e1.getCodigo() == e2.getCodigo() )
                          return 0;
		else
			if ( e1.getCodigo() < e2.getCodigo() )
				return -1;
			else
				return 1;
	}

}
