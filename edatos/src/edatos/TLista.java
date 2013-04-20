package edatos;

public interface TLista
{
	void	Adicionar(Object dato);
	void	Insertar(Object dato, int pos);
	void	Eliminar(int pos);
	
	int		Cantidad();
	boolean Vacia();
	Object	Obtener(int pos);
	void	Modificar(Object dato, int pos);
	int		Buscar(Object dato);
	int		Buscar(Object dato, TComparar cmp);
}
