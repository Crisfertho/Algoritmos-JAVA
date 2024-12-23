package ListaSimple;

public class Nodo {
public int dato;
public Nodo Siguiente;

public Nodo(int dato){//contructor para insertar al final
	this.dato=dato;
	this.Siguiente=null;
}//fin del constructor
public Nodo(int dato, Nodo Siguiente){//constructor para insertar al inicio
	this.dato=dato;
	this.Siguiente=Siguiente;
}//fin del constructor
}//fin de la clase
