package edatos;

public class TListaA implements TLista
{
	private Object elem[];
	private int cantidad;
	private int max;
	
	public TListaA()
	{
		cantidad=0;
		max=0;
		elem=null;
	}
	
	private void Crecer()
	{
		Object aux[];
		max += 50; // sug. que sea un porcentaje
		aux = new Object[max];
		for (int i = 0; i < cantidad; i++ )
			aux[i] = elem[i];
		elem = aux;
	}
	
	public void Adicionar(Object dato)
	{
		if ( cantidad == max )
			Crecer();
		cantidad++;
		elem[cantidad-1] = dato;
	}

	public void Insertar(Object dato, int pos)
	{
		if ( pos >= 0 && pos <= cantidad ) {
			if ( cantidad == max )
			   Crecer();
			cantidad++;
			for (int i = cantidad-1; i > pos; i--)
		       elem[i] = elem[i-1];
			elem[pos] = dato;
		}
	}

	public void Eliminar(int pos)
	{
		if ( pos >= 0 && pos < cantidad ) {
			for (int i = pos; i < cantidad-1; i++ )
				elem[i] = elem[i+1];
			cantidad--;
		}
	}
	
	public int Cantidad()
	{
		return cantidad;
	}
	
	public boolean Vacia()
	{
		return cantidad == 0;
	}
	
	public Object Obtener(int pos)
	{
		if ( pos < 0 || pos >= cantidad )
			pos = 0;
		return elem[pos];
	}

	public void Modificar(Object dato, int pos)
	{
		if ( pos < 0 || pos >= cantidad )
			pos = 0;
		elem[pos] = dato;
	}
	
	public int Buscar(Object dato)
	{
		int encontrado = -1;
		for ( int i=0; i < cantidad && encontrado == -1; i++ )
			if ( elem[i].equals( dato ) )
              encontrado = i;
		return encontrado;
	}
	
	public int Buscar(Object dato, TComparar cmp)
	{
		int encontrado = -1;
		for ( int i=0; i < cantidad && encontrado == -1; i++ )
			if ( cmp.Compara(elem[i],dato) == 0 )
              encontrado = i;
		return encontrado;
	}
	
}
