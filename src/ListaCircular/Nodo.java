package ListaCircular;

public class Nodo {
	Catalogo dato;
	Nodo siguiente;
	public Nodo(Catalogo dato){
		this.dato = dato;
		siguiente = this;
	}//fin del constructor
	
	public Nodo(){}
}//fin de la clase
