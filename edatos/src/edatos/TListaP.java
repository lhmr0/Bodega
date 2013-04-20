package edatos;

public class TListaP implements TLista
{
        //TLista mediante Listas
        //Simplemente Enlazadas utiliza
        //punteross para enlazar cada
        //elemento(nodo). En este caso cada nodo contiene un
        //un campo elem : y un campo prox
	private class TNodoSEP {
                //almacena la informacion del
                //elemento de la lista
		Object elem;
                //apunta al siguiente elemento
                //en la lista
		TNodoSEP prox;
	}

        //La lista en si (L) seria un objeto
        //tipo TNodoSEP el cual representaria el
        //primer elemento de la lista
	private TNodoSEP L;

        //Constructor (operacion Crear) le asigna
        //null al inicio de la lista
	public TListaP()
	{
		L=null;
	}

        //Se obtiene recorriendo toda la lista
        //y contando cada nodo. Se usa una variable
        //auxiliar(aux) para recorrer la lista,
        //para evitar modificar a L,que es el
        //que representa el inicio de la lista.
	public int Cantidad()
	{
		int cantidad;
		TNodoSEP aux;

		cantidad=0;
                //inicio de la lista
                //asignando a variable aux.
		aux=L;
		while(aux!=null) {
			cantidad++;
                        //avanzando a siguiente nodo
			aux=aux.prox;
		}
		return (cantidad);
	}

        //metodo que permite adicionar un nuevo
        //nodo al final de la lista
	public void Adicionar(Object dato)
	{
		TNodoSEP nuevo, aux;

                //primer lugar se crea un nodo nuevo
		nuevo = new TNodoSEP();
                //y se asigna valores a sus campos
		nuevo.elem = dato;
		nuevo.prox = null;

                //se verifica no sea vacia
		if ( L != null ) {
                       //se asigna L a variable
                       //aux , para no modificar L
			aux = L;
                        //se recorre hasta llegar
                        //al ultimo nodo
                        //(el que posee null en su
                        //campo prox)
			while( aux.prox != null )
			    aux = aux.prox;
                        //asignamos a ese campo
                        //la direccion del nuevo nodo
			aux.prox = nuevo;
		}
		else
                        //si la lista es vacia , solo hay
                       //que situar como inicio de la lista
                       //al nuevo nodo
			L = nuevo;	
	}
	
	//Este metodo inserta un nuevo elemento en
        //una posicion determinada de la lista
        public void Insertar(Object dato, int pos)
	{
		TNodoSEP nuevo, aux;
		int i;

		nuevo = new TNodoSEP();
		nuevo.elem = dato;

                //en el chequeo de la posicion verificamos
                //que la posicion indicada sea negativa.
                //En este caso optamos por insertar en la
                //posicion O(CERO).
		if( pos <= 0 ) {
			nuevo.prox = L;
			L = nuevo;
		}
                //Si posicion es mayor a CERO, se recorre
                //la lista hasta llegar al nodo que esta
                //antes de la posicion a insertar, usando
                //la sentencia for
		else {
                       //Asignamos L a variable aux.
			aux = L;
                        //recorriendo  la lista
			for( i=0; i < pos-1 && aux != null; i++)
                                //apuntando al siguiente nodo
				aux=aux.prox;
                        //verificamos que se encontro ese nodo
                        //ya que es posible que la posicion
                        //indicada sea mayor que el tamaño de
                        //la lista
			if ( aux != null ) {
                               //si se encontro
                               //el campo prox del nuevo elemento
                               //apuntara al prox del anterior
                               // a la posicion a insertar-
                               //con esto se enlazael nuevo
                               //nodo con el resto de la lista
				nuevo.prox = aux.prox;
                                //solo queda hacer que el campo prox
                                //de aux(nodo anterior a la posicion
                                //donde se inserta) apunte al nuevo nodo
                                //con esto queda completamente enlazada
                                //la lista
				aux.prox = nuevo;
			}
			else
                                //Si la posicion
                                //indicada sea mayor que el tamaño de
                                //la lista
				;//delete nuevo;
		}
	}
	
	//Elimina un elemento de la lista dada su posicion
        public void Eliminar(int pos)
	{
		TNodoSEP elim;//nodo a eliminar
		TNodoSEP aux;
		int i;

                //primero verifica que hayga elmentos en la
                //lista L
		if( L != null ) {
                        //se trata el caso especial
                        //cuando la posicion a eliminar
                        //es la CERO(0), ya que implica
                        //un cambio en el inicio de la lista
			if ( pos <= 0 ) {
                                //cuando se elimina el primer
                                //elemento (posicion =0)
				elim = L;
                                //el inicio de la lista pasa al segundo
                                //elemento (campo prox de L)
				L = L.prox;
				//delete elim;
			}
                        //para el caso de que la posicion sea
                        //mayor que CERO(0) el analisis es parecido
                        //a la INSERCION, ese necesario llegar
                        //hasta el elemento anterior a la posicion
                        //para reajustar adecuadamente los punteros.
			else {
				//asignamos L a variable aux
                                //recuerden en aux se hace el recorrido
                                aux = L;

				//recorriendo la lista aux, hasta
                                //el elemento anterior a la posicion
                                //a eleminar
                                for(i=0; i < pos-1 && aux != null; i++)
					aux = aux.prox;
                                //verificamos que la posicion se haya encontrado
                                //al igual que en la insercion,pero ademas
                                //de eso verficamos que la posicion dada no
                                //sea la del ultimo elemento mas uno(null)
				if ( aux != null && aux.prox != null ) {
					elim = aux.prox;
					aux.prox = elim.prox;
					//delete elim;
				}
			}
		}
	}
		

        //Retorna true(verdadero) si la lista esta vacia
        //o sea , cuando el puntero al incio de la lista
        //es null. Si L no es NULL significa que existen datos
        //en la lista y por tanto se retorna falso
	public boolean Vacia()
	{
		return L == null;
	}

        //Los metodos obtener y modificar, obtienen y
        //modifican  el elemento de la lista que se quiere
        //acceder mediante su posicion
	public Object Obtener(int pos)
	{
		TNodoSEP aux;
		int i;

		aux = L;
		for( i=0; i < pos && aux != null; i++ )
			aux = aux.prox;

		if ( aux != null )
			return aux.elem;
		else
			return null;
	}
	
	
	public void Modificar(Object dato, int pos)
	{
		TNodoSEP aux;
		int i;

		aux = L;
		for( i=0; i < pos && aux != null; i++ )
			aux = aux.prox;

		if ( aux != null )
			aux.elem = dato;
	}

        //Al igual que en la implementacion con arreglos
        //la comparacion del dato a buscar con cada elemento
        //de la lista se realiza llamando al metodo equals
        //(primera implementacion)o la funcion de comparacion
        //recibida como parametro(segunda implementacion). La
        //busqueda del dato se reduce a buscar un elemento de formar
        //secuencial. durante el recorrido de la lista enlazada.
	public int Buscar(Object dato)
	{
		TNodoSEP aux;
		int encontrado = -1;

		aux = L;
		for( int i=0; aux != null && encontrado == -1 ; i++ )
      	{
			if ( aux.elem.equals( dato )  )
				encontrado = i;
			else
				aux = aux.prox;
      	}
     	return encontrado;
	}
	
	public int Buscar(Object dato, TComparar cmp)
	{
		TNodoSEP aux;
		int encontrado = -1;

		aux = L;
		for( int i=0; aux != null && encontrado == -1 ; i++ )
      	{
			if ( cmp.Compara(aux.elem, dato ) == 0  )
				encontrado = i;
			else
				aux = aux.prox;
      	}
     	return encontrado;
	}
}
