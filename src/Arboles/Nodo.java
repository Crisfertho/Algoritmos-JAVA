package Arboles;

public class Nodo {
	Catalogo datos;
	int dato;
	public Nodo izquierda,derecha;
	public Nodo(Catalogo c,int dato){
		this.datos = c;
		this.dato = dato;
		this.izquierda = null;
		this.derecha = null;
	}//fin del constructor
}//fin de la clase
