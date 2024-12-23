package ListaDoble;

public class NodoDoble {
public Catalogo dato;
NodoDoble anterior;
NodoDoble siguiente;
public NodoDoble(Catalogo dato){
	this.dato = dato;
	this.siguiente = null;
	this.anterior = null;
}//constructor si la lista esta vacia
public NodoDoble(Catalogo dato, NodoDoble siguiente, NodoDoble anterior) {
	this.dato = dato;
	this.anterior = anterior;
	this.siguiente = siguiente;
}//constructor si la lista no esta vacia

}//fin de la lista
